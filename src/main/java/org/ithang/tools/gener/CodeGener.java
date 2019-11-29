package org.ithang.tools.gener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.ithang.tools.lang.StrUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 代码生成器
 * @author ithang
 *
 */
public class CodeGener {

	private static String projectDir="H:/crm/frame/src/main/java";
	private JdbcTemplate jdbcTemplate;
	
	private final static Configuration configuration = new Configuration(Configuration.getVersion());
	
	private Logger logger=Logger.getLogger(CodeGener.class);
	
	
	private String saveDir;
	private String basePkg;
	private boolean action;
	private boolean service;
	private boolean mapper;
	private boolean xmlMapper;
	private boolean page;
	
	private String gsql;//关联SQL，用于查询数据带用left join
	private ColumnExpress columnExpress;//字段列表达式，如  name like '%name%'
	private GenField genField;//新增关联表的字段
	
	static{
		
		 try {
			    configuration.setDefaultEncoding("UTF-8");
			    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			    configuration.setLogTemplateExceptions(false);
			    configuration.setDirectoryForTemplateLoading(new File(CodeGener.class.getResource("ftl").getFile()));
			    
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public CodeGener(DataSource dataSource){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	public CodeGener(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public CodeGener(String url,String uname,String upass){
		try{
		    SimpleDriverDataSource ds=new SimpleDriverDataSource(new com.mysql.jdbc.Driver(), url, uname, upass);
		    jdbcTemplate=new JdbcTemplate(ds);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据表结构生成 对应的Bean,Mapper,Service
	 * @param jdbcTemplate
	 * @param tableNames 如果为null或长度为0,则全库表都生成一遍
	 */
	public void gener(String... tableNames){
		
		if(null==tableNames||0==tableNames.length){//如果没传表名，则默认根据所有表信息生成代码
			List<String> tabs=jdbcTemplate.queryForList("show tables", String.class);
			if(null!=tabs&&tabs.size()>0){
				tableNames=tabs.toArray(new String[]{});
			}else{//如果库中没有表则返回
				logger.warn("数据库中没有表!");
				return;
			}
		}
		
		List<TableInfo> tableInfos=DBInfoUtils.tables(jdbcTemplate, tableNames);
		
		Map<String,Object> data=new HashMap<>();
		
		for(TableInfo tab:tableInfos){
			data.clear();
			List<ColumnInfo> cos=tab.getColumns();
			if(null!=cos&&!cos.isEmpty()){
				for(ColumnInfo ci:cos){
					if(null!=ci.getColumn_key()&&!"".equals(ci.getColumn_key().trim())&&"pri".equalsIgnoreCase(ci.getColumn_key())){
						data.put("priKey", StrUtils.dropUnderline(ci.getColumn_name()));
						data.put("priKeyType", ci.getJavaType());
						data.put("priKeyColumn", ci.getColumn_name());
					}
				}
			}
			
						
			String beanName=StrUtils.dropUnderline(tab.getTable_name());
			String BeanName=StrUtils.headUpper(StrUtils.dropUnderline(tab.getTable_name()));
			data.put("tableName", tab.getTable_name());
			data.put("BeanName", BeanName);
			data.put("beanName", beanName);
			if(null!=getColumnExpress()){
				data.put("columnExpress", getColumnExpress().toArray());
			}
			if(null!=getGenField()){
				data.put("genField", getGenField().toArray());
			}
			if(null!=getGsql()){
				data.put("gsql", getGsql());
			}
			
			data.put("tabComment", tab.getTable_comment());
			data.put("basePkg", null==basePkg?"org.ithang.system":basePkg);
			data.put("fields", tab.getColumns());
			saveDir=(null==saveDir?projectDir:saveDir);
			data.put("beanFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/bean/%s.java",beanName,BeanName));
			data.put("mapperFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/mapper/%sMapper.java",beanName,BeanName));
			data.put("xmlmapperFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/mapper/%sMapper.xml",beanName,BeanName));
			data.put("zmapperFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/mapper/Z%sMapper.java",beanName,BeanName));
			data.put("zxmlmapperFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/mapper/Z%sMapper.xml",beanName,BeanName));
			data.put("serviceFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/service/%sService.java",beanName,BeanName));
			data.put("actionFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/%sAction.java",beanName,BeanName));
			data.put("formFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/form.html",beanName));
			data.put("listFileName", saveDir+String.format("/"+basePkg.replaceAll("\\.", "/")+"/%s/list.html",beanName));
			
			if(basePkg.contains("system")){
				data.put("path", "sys");
				data.put("pathDir", "system");
			}else{
				data.put("path", "app");
				data.put("pathDir", "app");
			}
			
			generBean(data);
			
			if(mapper){
				generMapper(data);	
			}
			
			if(xmlMapper){
				generXMLMapper(data);	
			}
			if(service){
				generService(data);	
			}
			if(action){
				generAction(data);	
			}
			if(page){
				generFormPage(data);
				generListPage(data);
			}
			
			if(null!=gsql){
				generZMapper(data);
				generZXMLMapper(data);
			}
			
		}
	}
	
	
	/**
	 * 生成业务实体Bean
	 * @param table
	 */
	protected void generBean(Map<String,Object> data) {
		try {
			File f=new File(String.valueOf(data.get("beanFileName")));
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("Bean.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 生成Mapper
	 * @param tab
	 */
	protected void generMapper(Map<String,Object> data){
		try {
			File f=new File(String.valueOf(data.get("mapperFileName")));
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("Mapper.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void generZMapper(Map<String,Object> data){
		try {
			File f=new File(String.valueOf(data.get("zmapperFileName")));
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("ZMapper.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成XMLMapper
	 * @param tab
	 */
	protected void generXMLMapper(Map<String,Object> data){
		try {
			File f=new File(String.valueOf(data.get("xmlmapperFileName")));
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("XMLMapper.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成XMLMapper
	 * @param tab
	 */
	protected void generZXMLMapper(Map<String,Object> data){
		try {
			File f=new File(String.valueOf(data.get("zxmlmapperFileName")));
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("ZXMLMapper.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成Service
	 * @param tab
	 */
	protected void generService(Map<String,Object> data){
		try {
			File f=new File(String.valueOf(data.get("serviceFileName")));
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("Service.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成Service
	 * @param tab
	 */
	protected void generAction(Map<String,Object> data){
		try {
			File f=new File(String.valueOf(data.get("actionFileName")));
			System.out.println("file path="+f.getAbsolutePath());
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("Action.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成form，list页面
	 * @param data
	 */
	protected void generFormPage(Map<String,Object> data){
		try {
			File f=new File(String.valueOf(data.get("formFileName")));
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("form.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成form，list页面
	 * @param data
	 */
	protected void generListPage(Map<String,Object> data){
		try {
			File f=new File(String.valueOf(data.get("listFileName")));
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("list.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
			out.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	public String getSaveDir() {
		return saveDir;
	}

	public void setSaveDir(String saveDir) {
		this.saveDir = saveDir;
	}

	public String getBasePkg() {
		return basePkg;
	}

	public void setBasePkg(String basePkg) {
		this.basePkg = basePkg;
	}

	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	public boolean isService() {
		return service;
	}

	public void setService(boolean service) {
		this.service = service;
	}

	public boolean isMapper() {
		return mapper;
	}

	public void setMapper(boolean mapper) {
		this.mapper = mapper;
	}

	public boolean isXmlMapper() {
		return xmlMapper;
	}

	public void setXmlMapper(boolean xmlMapper) {
		this.xmlMapper = xmlMapper;
	}

	public boolean isPage() {
		return page;
	}

	public void setPage(boolean page) {
		this.page = page;
	}

	public ColumnExpress getColumnExpress() {
		return columnExpress;
	}

	public void setColumnExpress(ColumnExpress columnExpress) {
		this.columnExpress = columnExpress;
	}

	public GenField getGenField() {
		return genField;
	}

	public void setGenField(GenField genField) {
		this.genField = genField;
	}

	public String getGsql() {
		return gsql;
	}

	public void setGsql(String gsql) {
		this.gsql = gsql;
	}
    
	
}

