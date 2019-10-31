package org.ithang.system.resource.mapper;
import org.ithang.tools.model.Page;
import org.ithang.system.resource.bean.Resource;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 *  常用操作
 * @author zyt
 *
 */
public interface ResourceMapper{

    /**
	 * 新增
	 * @param resource
	 * @return
	 */
    public int add(Resource resource);

    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Resource get(String id);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<Resource> list(String...ids);
    
    /**
     * 分页查询
     * @param resource
     * @return
     */
    public List<Resource> page(@Param("page")Page<Resource> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<Resource> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param resource
     * @return
     */
    public int update(Resource resource);
    
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);
    
}