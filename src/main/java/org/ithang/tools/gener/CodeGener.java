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
			data.put("tabComment", tab.getTable_comment());
			data.put("basePkg", "org.ithang.application");
			data.put("fields", tab.getColumns());
			data.put("beanFileName", projectDir+String.format("/org/ithang/application/%s/bean/%s.java",BeanName,BeanName));
			data.put("mapperFileName", projectDir+String.format("/org/ithang/application/%s/mapper/%sMapper.java",BeanName,BeanName));
			data.put("xmlmapperFileName", projectDir+String.format("/org/ithang/application/%s/mapper/%sMapper.xml",BeanName,BeanName));
			data.put("serviceFileName", projectDir+String.format("/org/ithang/application/%s/service/%sService.java",BeanName,BeanName));
			data.put("actionFileName", projectDir+String.format("/org/ithang/application/%s/%sAction.java",BeanName,BeanName));
			generBean(data);
			generMapper(data);
			generXMLMapper(data);
			generService(data);
			generAction(data);
		}
	}
	
	
	/**
	 * 生成业务实体Bean
	 * @param table
	 */
	protected void generBean(Map<String,Object> data) {
		try {
			File f=new File(String.valueOf(data.get("beanFileName")));
			System.out.println("file path="+f.getAbsolutePath());
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("Bean.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
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
			System.out.println("file path="+f.getAbsolutePath());
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("Mapper.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
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
			System.out.println("file path="+f.getAbsolutePath());
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("XMLMapper.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
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
			System.out.println("file path="+f.getAbsolutePath());
			f.getParentFile().mkdirs();
			FileOutputStream fout=new FileOutputStream(f);
			Template temp = configuration.getTemplate("Service.ftl");
			Writer out = new OutputStreamWriter(fout);
			temp.process(data, out);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
}
