package org.ithang.system.userRole.mapper;
import org.ithang.tools.model.Page;
import org.ithang.system.userRole.bean.UserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 *  常用操作
 * @author zyt
 *
 */
public interface UserRoleMapper{

    /**
	 * 新增
	 * @param userRole
	 * @return
	 */
    public int add(UserRole userRole);

    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public UserRole get(Integer id);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<UserRole> list(Integer...ids);
    
    /**
     * 分页查询
     * @param userRole
     * @return
     */
    public List<UserRole> page(@Param("page")Page<UserRole> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<UserRole> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param userRole
     * @return
     */
    public int update(UserRole userRole);
    
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);
    
}