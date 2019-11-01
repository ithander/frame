package org.ithang.system.userResource.service;

import java.util.List;
import java.util.Map;
import org.ithang.system.userResource.mapper.UserResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Page;
import org.ithang.tools.database.ModelDao;
import org.ithang.system.userResource.bean.UserResource;

/**
 *  服务
 * @author zyt
 *
 */
@Service
public class UserResourceService extends ModelDao<UserResource>{

    @Autowired
    private UserResourceMapper userResourceMapper;

    private Logger logger = Logger.getLogger(UserResourceService.class);
    
    public void add(UserResource userResource){
        userResourceMapper.add(userResource);
    }
    
    public UserResource get(Integer id){
        return userResourceMapper.get(id);
    }
    
    public int delete(Integer id){
        return userResourceMapper.delete(id);
    }
    
    public List<UserResource> list(Integer... ids){
    	return userResourceMapper.list(ids);
    }
    
    public List<UserResource> listByUser(Integer user_id){
    	return userResourceMapper.listByUser(user_id);
    }
    
    public List<UserResource> page(UserResource userResource,Page<UserResource> page){
        page.setBean(userResource);
    	return userResourceMapper.page(page);
    }
    
    public List<UserResource> query(Map<String,Object> conditions){
    	return userResourceMapper.query(conditions);
    }
    
    
}