package org.ithang.system.userRole.service;

import java.util.List;
import java.util.Map;
import org.ithang.system.userRole.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Page;
import org.ithang.tools.database.ModelDao;
import org.ithang.system.userRole.bean.UserRole;

/**
 *  服务
 * @author zyt
 *
 */
@Service
public class UserRoleService extends ModelDao<UserRole>{

    @Autowired
    private UserRoleMapper userRoleMapper;

    private Logger logger = Logger.getLogger(UserRoleService.class);
    
    public void add(UserRole userRole){
        userRoleMapper.add(userRole);
    }
    
    public UserRole get(Integer id){
        return userRoleMapper.get(id);
    }
    
    public int delete(Integer id){
        return userRoleMapper.delete(id);
    }
    
    public List<UserRole> list(Integer... ids){
    	return userRoleMapper.list(ids);
    }
    
    public List<UserRole> page(UserRole userRole,Page<UserRole> page){
        page.setBean(userRole);
    	return userRoleMapper.page(page);
    }
    
    public List<UserRole> query(Map<String,Object> conditions){
    	return userRoleMapper.query(conditions);
    }
    
    
}