package org.ithang.application.account.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.ithang.application.account.bean.Account;
import org.ithang.application.account.mapper.AccountMapper;
import org.ithang.tools.database.ModelDao;
import org.ithang.tools.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户币种钱包 服务
 * @author zyt
 *
 */
@Service
public class AccountService extends ModelDao<Account>{

    @Autowired
    private AccountMapper accountMapper;

    private Logger logger = Logger.getLogger(AccountService.class);
    
    
    public void add(Account account){
        accountMapper.add(account);
    }
    
    public Account get(Integer id){
        return accountMapper.get(id);
    }
    
    public Account getByCustomer(Integer id){
        return accountMapper.getByCustomer(id);
    }
    
    public int delete(Integer id){
        return accountMapper.delete(id);
    }
    
    public int batchDelete(String[] ids){
    	return accountMapper.batchDelete(ids);
    }
    
    public List<Account> list(Integer... ids){
    	return accountMapper.list(ids);
    }
    
    public List<Account> page(Pager<Account> page){
    	return accountMapper.page(page);
    }
    
    public List<Account> query(Map<String,Object> conditions){
    	return accountMapper.query(conditions);
    }
    
    public int update(Account account){
    	return accountMapper.update(account);
    }
    
    
}