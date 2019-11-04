package ${basePkg}.${beanName}.mapper;
import org.ithang.tools.model.Pager;
import ${basePkg}.${beanName}.bean.${BeanName};
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * ${tabComment} 常用操作
 * @author zyt
 *
 */
public interface ${BeanName}Mapper{

    /**
	 * 新增
	 * @param ${beanName}
	 * @return
	 */
    public int add(${BeanName} ${beanName});

    /**
     * 获取指定记录
     * @param ${priKey!"id"}
     * @return
     */
    public ${BeanName} get(@Param("${priKey!"id"}")${priKeyType!"String"} ${priKey!"id"});
    
    /**
     * 查询所有记录
     * @return
     */
    public List<${BeanName}> list(${priKeyType!"String"}...ids);
    
    /**
     * 分页查询
     * @param ${beanName}
     * @return
     */
    public List<${BeanName}> page(@Param("pager")Pager<${BeanName}> pager);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<${BeanName}> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param ${beanName}
     * @return
     */
    public int update(${BeanName} ${beanName});
    
    /**
     * 删除
     * @param ${priKey!"id"}
     * @return
     */
    public int delete(@Param("${priKey!"id"}")${priKeyType!"String"} ${priKey!"id"});
    
     /**
     * 批量删除
     * @param ids
     * @return
     */
    public int batchDelete(@Param("ids")String[] ids);
    
}