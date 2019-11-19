package ${basePkg}.${beanName}.service;

import java.util.List;
import java.util.Map;
import ${basePkg}.${beanName}.mapper.${BeanName}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Pager;
import org.ithang.tools.database.ModelDao;
import ${basePkg}.${beanName}.bean.${BeanName};

/**
 * ${tabComment} 服务
 * @author zyt
 *
 */
@Service
public class ${BeanName}Service extends ModelDao<${BeanName}>{

    @Autowired
    private ${BeanName}Mapper ${beanName}Mapper;

    private Logger logger = Logger.getLogger(${BeanName}Service.class);
    
    public void add(${BeanName} ${beanName}){
        ${beanName}Mapper.add(${beanName});
    }
    
    public ${BeanName} get(${priKeyType!"String"} ${priKey!"id"}){
        return ${beanName}Mapper.get(${priKey!"id"});
    }
    
    public int delete(${priKeyType!"String"} ${priKey!"id"}){
        return ${beanName}Mapper.delete(${priKey!"id"});
    }
    
    public int batchDelete(String[] ids){
    	return ${beanName}Mapper.batchDelete(ids);
    }
    
    public List<${BeanName}> list(${priKeyType!"String"}... ids){
    	return ${beanName}Mapper.list(ids);
    }
    
    public List<${BeanName}> page(Pager<${BeanName}> page){
    	return ${beanName}Mapper.page(page);
    }
    
    public List<${BeanName}> query(Map<String,Object> conditions){
    	return ${beanName}Mapper.query(conditions);
    }
    
    public int update(${BeanName} ${beanName}){
    	return ${beanName}Mapper.update(${beanName});
    }
    
    
}