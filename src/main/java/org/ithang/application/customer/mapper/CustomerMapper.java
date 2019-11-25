package org.ithang.application.customer.mapper;
import org.ithang.tools.model.Pager;
import org.ithang.application.customer.bean.Customer;
import org.ithang.application.customer.bean.Team;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户表信息 常用操作
 * @author zyt
 *
 */
public interface CustomerMapper{

    /**
	 * 新增
	 * @param customer
	 * @return
	 */
    public int add(Customer customer);

    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Customer get(@Param("id")Integer id);
    
    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Customer getByFromUser(@Param("fromUserID")Integer fromUserID);
    
    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Customer getByMobile(@Param("mobile")String mobile);
    
    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Customer getByCode(@Param("mycode")String mycode);
    
    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Customer getByName(@Param("uname")String uname);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<Customer> list(Integer...ids);
    
    /**
     * 分页查询
     * @param customer
     * @return
     */
    public List<Customer> page(@Param("page")Pager<Customer> page);
    
    /**
     * 分页查询团队人员
     * @param customer
     * @return
     */
    public List<Team> team(@Param("page")Pager<Customer> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<Customer> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param customer
     * @return
     */
    public int update(Customer customer);
    
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(@Param("id")Integer id);
    
     /**
     * 批量删除
     * @param ids
     * @return
     */
    public int batchDelete(@Param("ids")String[] ids);
    
}