package org.ithang.system.user.mapper;
import org.ithang.tools.model.Pager;
import org.ithang.system.user.bean.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户表信息 常用操作
 * @author zyt
 *
 */
public interface UserMapper{

    /**
	 * 新增
	 * @param user
	 * @return
	 */
    public int add(User user);

    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public User get(@Param("id")Integer id);
    
    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public User getByMobile(@Param("mobile")String mobile);
    
    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public User getByName(@Param("uname")String uname);
    
    
    /**
     * 查询所有记录
     * @return
     */
    public List<User> list(Integer...ids);
    
    /**
     * 分页查询
     * @param user
     * @return
     */
    public List<User> page(@Param("bean")User bean,@Param("page")Pager<User> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<User> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param user
     * @return
     */
    public int update(User user);
    
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);
    
    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int batchDelete(@Param("ids")String[] ids);
    
}