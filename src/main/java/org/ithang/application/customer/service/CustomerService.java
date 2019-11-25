package org.ithang.application.customer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.ithang.application.account.bean.Account;
import org.ithang.application.account.service.AccountService;
import org.ithang.application.customer.bean.Customer;
import org.ithang.application.customer.bean.Team;
import org.ithang.application.customer.mapper.CustomerMapper;
import org.ithang.system.keyvalue.service.KeyvalueService;
import org.ithang.tools.database.ModelDao;
import org.ithang.tools.lang.DateUtils;
import org.ithang.tools.lang.StrUtils;
import org.ithang.tools.model.Pager;
import org.ithang.tools.redis.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户表信息 服务
 * @author zyt
 *
 */
@Service
public class CustomerService extends ModelDao<Customer>{

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AccountService accountService;
    
    @Autowired
    private KeyvalueService keyvalueService;
    
    private Logger logger = Logger.getLogger(CustomerService.class);
    
    
    public void add(Customer customer){
        customerMapper.add(customer);
    }
    
    public Customer get(Integer id){
        return customerMapper.get(id);
    }
    
    public Customer getByFromUser(Integer fromUserID){
    	return customerMapper.getByFromUser(fromUserID);
    }
    
    public Customer getByMobile(String mobile){
    	return customerMapper.getByMobile(mobile);
    }
    
    public Customer getByCode(String code){
    	return customerMapper.getByCode(code);
    }
    
    public Customer getByName(String uname){
    	return customerMapper.getByName(uname);
    }
    
    public int delete(Integer id){
        return customerMapper.delete(id);
    }
    
    public int batchDelete(String[] ids){
    	return customerMapper.batchDelete(ids);
    }
    
    public List<Customer> list(Integer... ids){
    	return customerMapper.list(ids);
    }
    
    public List<Customer> page(Pager<Customer> page){
    	return customerMapper.page(page);
    }
    
    public List<Team> team(Pager<Customer> page){
    	return customerMapper.team(page);
    }
    
    public List<Customer> query(Map<String,Object> conditions){
    	return customerMapper.query(conditions);
    }
    
    public int update(Customer customer){
    	return customerMapper.update(customer);
    }
    
    
}