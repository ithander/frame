package org.ithang.system.resource.service;

import java.util.List;
import java.util.Map;
import org.ithang.system.resource.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Pager;
import org.ithang.tools.database.ModelDao;
import org.ithang.system.resource.bean.Resource;

/**
 *  服务
 * @author zyt
 *
 */
@Service
public class ResourceService extends ModelDao<Resource>{

    @Autowired
    private ResourceMapper resourceMapper;

    private Logger logger = Logger.getLogger(ResourceService.class);
    
    public void add(Resource resource){
        resourceMapper.add(resource);
    }
    
    public Resource get(String id){
        return resourceMapper.get(id);
    }
    
    public int delete(String id){
        return resourceMapper.delete(id);
    }
    
    public List<Resource> list(String... ids){
    	return resourceMapper.list(ids);
    }
    
    public List<Resource> page(Resource resource,Pager<Resource> page){
        page.setBean(resource);
    	return resourceMapper.page(page);
    }
    
    public List<Resource> query(Map<String,Object> conditions){
    	return resourceMapper.query(conditions);
    }
    
    
}