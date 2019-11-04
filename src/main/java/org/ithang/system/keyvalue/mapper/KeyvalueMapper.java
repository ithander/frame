package org.ithang.system.keyvalue.mapper;
import org.ithang.tools.model.Pager;
import org.ithang.system.keyvalue.bean.Keyvalue;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 字典表 常用操作
 * @author zyt
 *
 */
public interface KeyvalueMapper{

    /**
	 * 新增
	 * @param keyvalue
	 * @return
	 */
    public int add(Keyvalue keyvalue);

    /**
     * 获取指定记录
     * @param key
     * @return
     */
    public Keyvalue get(@Param("key")String key);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<Keyvalue> list(String...ids);
    
    /**
     * 分页查询
     * @param keyvalue
     * @return
     */
    public List<Keyvalue> page(@Param("bean")Keyvalue keyvalue,@Param("pager")Pager<Keyvalue> pager);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<Keyvalue> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param keyvalue
     * @return
     */
    public int update(Keyvalue keyvalue);
    
    /**
     * 删除
     * @param key
     * @return
     */
    public int delete(@Param("key")String key);
    
    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int batchDelete(@Param("ids")String[] ids);
    
    
}