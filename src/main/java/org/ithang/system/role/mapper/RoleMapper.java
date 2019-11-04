package org.ithang.system.role.mapper;
import org.ithang.tools.model.Pager;
import org.ithang.system.role.bean.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 *  常用操作
 * @author zyt
 *
 */
public interface RoleMapper{

    /**
	 * 新增
	 * @param role
	 * @return
	 */
    public int add(Role role);

    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Role get(String id);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<Role> list(String...ids);
    
    /**
     * 分页查询
     * @param role
     * @return
     */
    public List<Role> page(@Param("page")Pager<Role> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<Role> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param role
     * @return
     */
    public int update(Role role);
    
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);
    
}