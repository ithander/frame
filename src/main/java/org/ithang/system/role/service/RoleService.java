package org.ithang.system.role.service;

import java.util.List;
import java.util.Map;
import org.ithang.system.role.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Page;
import org.ithang.tools.database.ModelDao;
import org.ithang.system.role.bean.Role;

/**
 *  服务
 * @author zyt
 *
 */
@Service
public class RoleService extends ModelDao<Role>{

    @Autowired
    private RoleMapper roleMapper;

    private Logger logger = Logger.getLogger(RoleService.class);
    
    public void add(Role role){
        roleMapper.add(role);
    }
    
    public Role get(String id){
        return roleMapper.get(id);
    }
    
    public int delete(String id){
        return roleMapper.delete(id);
    }
    
    public List<Role> list(String... ids){
    	return roleMapper.list(ids);
    }
    
    public List<Role> page(Role role,Page<Role> page){
        page.setBean(role);
    	return roleMapper.page(page);
    }
    
    public List<Role> query(Map<String,Object> conditions){
    	return roleMapper.query(conditions);
    }
    
    
}