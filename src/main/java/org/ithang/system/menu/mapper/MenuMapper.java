package org.ithang.system.menu.mapper;

import java.util.List;

import org.ithang.system.menu.bean.Menu;
import org.ithang.tools.model.Pager;

public interface MenuMapper {

	
	public Menu get(int id);
	
	public List<Menu> list(Pager<Menu> page);
	
}
