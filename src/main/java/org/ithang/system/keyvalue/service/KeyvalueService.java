package org.ithang.system.keyvalue.service;

import java.util.List;
import java.util.Map;
import org.ithang.system.keyvalue.mapper.KeyvalueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.ithang.tools.model.Pager;
import org.ithang.tools.database.ModelDao;
import org.ithang.system.keyvalue.bean.Keyvalue;

/**
 * 字典表 服务
 * @author zyt
 *
 */
@Service
public class KeyvalueService extends ModelDao<Keyvalue>{

    @Autowired
    private KeyvalueMapper keyvalueMapper;

    private Logger logger = Logger.getLogger(KeyvalueService.class);
    
    public void add(Keyvalue keyvalue){
        keyvalueMapper.add(keyvalue);
    }
    
    public Keyvalue get(String key){
        return keyvalueMapper.get(key);
    }
    
    public int delete(String key){
        return keyvalueMapper.delete(key);
    }
    
    public int batchDelete(String[] ids){
    	return keyvalueMapper.batchDelete(ids);
    }
    
    public List<Keyvalue> list(String... ids){
    	return keyvalueMapper.list(ids);
    }
    
    public List<Keyvalue> page(Keyvalue keyvalue,Pager<Keyvalue> page){
    	page.setBean(keyvalue);
    	return keyvalueMapper.page(keyvalue,page);
    }
    
    public List<Keyvalue> query(Map<String,Object> conditions){
    	return keyvalueMapper.query(conditions);
    }
    
    public int update(Keyvalue keyvalue){
    	return keyvalueMapper.update(keyvalue);
    }
    
    
}