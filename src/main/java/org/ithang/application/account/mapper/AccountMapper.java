package org.ithang.application.account.mapper;
import org.ithang.tools.model.Pager;
import org.ithang.application.account.bean.Account;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 用户币种钱包 常用操作
 * @author zyt
 *
 */
public interface AccountMapper{

    /**
	 * 新增
	 * @param account
	 * @return
	 */
    public int add(Account account);

    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Account get(@Param("id")Integer id);
    
    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Account getByCustomer(@Param("customer_id")Integer customer_id);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<Account> list(Integer...ids);
    
    /**
     * 分页查询
     * @param account
     * @return
     */
    public List<Account> page(@Param("page")Pager<Account> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<Account> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param account
     * @return
     */
    public int update(Account account);
    
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