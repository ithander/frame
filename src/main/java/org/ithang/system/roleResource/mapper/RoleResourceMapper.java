package org.ithang.system.roleResource.mapper;
import org.ithang.tools.model.Page;
import org.ithang.system.roleResource.bean.RoleResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 *  常用操作
 * @author zyt
 *
 */
public interface RoleResourceMapper{

    /**
	 * 新增
	 * @param roleResource
	 * @return
	 */
    public int add(RoleResource roleResource);

    /**
     * 获取指定记录
     * @param resourceId
     * @return
     */
    public RoleResource get(String resourceId);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<RoleResource> list(String...ids);
    
    /**
     * 分页查询
     * @param roleResource
     * @return
     */
    public List<RoleResource> page(@Param("page")Page<RoleResource> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<RoleResource> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param roleResource
     * @return
     */
    public int update(RoleResource roleResource);
    
    /**
     * 删除
     * @param resourceId
     * @return
     */
    public int delete(String resourceId);
    
}