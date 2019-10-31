package org.ithang.system.user.mapper;
import org.ithang.tools.model.Page;
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
    public User get(Integer id);
    
    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public User getByName(String uname);
    
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
    public List<User> page(@Param("page")Page<User> page);
    
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
    
}