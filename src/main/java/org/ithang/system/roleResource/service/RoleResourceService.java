package org.ithang.system.roleResource.service;

import java.util.List;
import java.util.Map;
import org.ithang.system.roleResource.mapper.RoleResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Pager;
import org.ithang.tools.database.ModelDao;
import org.ithang.system.roleResource.bean.RoleResource;

/**
 *  服务
 * @author zyt
 *
 */
@Service
public class RoleResourceService extends ModelDao<RoleResource>{

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    private Logger logger = Logger.getLogger(RoleResourceService.class);
    
    public void add(RoleResource roleResource){
        roleResourceMapper.add(roleResource);
    }
    
    public RoleResource get(String resourceId){
        return roleResourceMapper.get(resourceId);
    }
    
    public int delete(String resourceId){
        return roleResourceMapper.delete(resourceId);
    }
    
    public List<RoleResource> list(String... ids){
    	return roleResourceMapper.list(ids);
    }
    
    public List<RoleResource> page(RoleResource roleResource,Pager<RoleResource> page){
        page.setBean(roleResource);
    	return roleResourceMapper.page(page);
    }
    
    public List<RoleResource> query(Map<String,Object> conditions){
    	return roleResourceMapper.query(conditions);
    }
    
    
}