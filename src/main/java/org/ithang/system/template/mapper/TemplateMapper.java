package org.ithang.system.template.mapper;
import org.ithang.tools.model.Pager;
import org.ithang.system.template.bean.Template;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * 模板 常用操作
 * @author zyt
 *
 */
public interface TemplateMapper{

    /**
	 * 新增
	 * @param template
	 * @return
	 */
    public int add(Template template);

    /**
     * 获取指定记录
     * @param id
     * @return
     */
    public Template get(String id);
    
    /**
     * 查询所有记录
     * @return
     */
    public List<Template> list(String...ids);
    
    /**
     * 分页查询
     * @param template
     * @return
     */
    public List<Template> page(@Param("page")Pager<Template> page);
    
    /**
     * 分页查询
     * @param conditions
     * @return
     */
    public List<Template> query(Map<String,Object> conditions);
    
    /**
     * 修改
     * @param template
     * @return
     */
    public int update(Template template);
    
    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);
    
}