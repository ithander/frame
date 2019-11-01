package org.ithang.system.user.service;

import java.util.List;
import java.util.Map;
import org.ithang.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Page;
import org.ithang.tools.database.ModelDao;
import org.ithang.system.user.bean.User;

/**
 * 用户表信息 服务
 * @author zyt
 *
 */
@Service
public class UserService extends ModelDao<User>{

    @Autowired
    private UserMapper userMapper;

    private Logger logger = Logger.getLogger(UserService.class);
    
    public void add(User user){
        userMapper.add(user);
    }
    
    public User get(Integer id){
        return userMapper.get(id);
    }
    
    public User getByMobile(String mobile){
    	return userMapper.getByMobile(mobile);
    }
    
    public User getByName(String uname){
    	return userMapper.getByName(uname);
    }
    
    public int delete(Integer id){
        return userMapper.delete(id);
    }
    
    public List<User> list(Integer... ids){
    	return userMapper.list(ids);
    }
    
    public List<User> page(User user,Page<User> page){
        page.setBean(user);
    	return userMapper.page(page);
    }
    
    public List<User> query(Map<String,Object> conditions){
    	return userMapper.query(conditions);
    }
    
    public int update(User user){
    	return userMapper.update(user);
    }
    
    
}