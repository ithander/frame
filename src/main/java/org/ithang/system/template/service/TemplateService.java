package org.ithang.system.template.service;

import java.util.List;
import java.util.Map;
import org.ithang.system.template.mapper.TemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Page;
import org.ithang.tools.database.ModelDao;
import org.ithang.tools.lang.DateUtils;
import org.ithang.system.template.bean.Template;

/**
 * 模板 服务
 * @author zyt
 *
 */
@Service
public class TemplateService extends ModelDao<Template>{

    @Autowired
    private TemplateMapper templateMapper;

    private Logger logger = Logger.getLogger(TemplateService.class);
    
    public void add(Template template){
    	template.setCreate_time(DateUtils.getSysdate());
        templateMapper.add(template);
    }
    
    public Template get(String id){
        return templateMapper.get(id);
    }
    
    public int delete(String id){
        return templateMapper.delete(id);
    }
    
    public List<Template> list(String... ids){
    	return templateMapper.list(ids);
    }
    
    public List<Template> page(Template template,Page<Template> page){
        page.setBean(template);
    	return templateMapper.page(page);
    }
    
    public List<Template> query(Map<String,Object> conditions){
    	return templateMapper.query(conditions);
    }
    
    
}