package org.ithang.system.userResource.mapper;
import org.ithang.tools.model.Pager;
import org.ithang.system.userResource.bean.UserResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 *  常用操作
 * @author zyt
 *
 */
public interface UserResourceMapper{

    /**
	 * 新增
	 * @param userResource
	 * @return
	 */
    public int add(UserResource userResource);

    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public UserResource get(Integer id);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<UserResource> list(Integer...ids);
    
    
    /**
     * 根据user_id查询所有记录
     * @return
     */
    public List<UserResource> listByUser(@Param("user_id")Integer user_id);
    
    /**
     * 分页查询
     * @param userResource
     * @return
     */
    public List<UserResource> page(@Param("page")Pager<UserResource> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<UserResource> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param userResource
     * @return
     */
    public int update(UserResource userResource);
    
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);
    
}