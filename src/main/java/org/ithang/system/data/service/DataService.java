package org.ithang.system.data.service;

import org.ithang.system.data.bean.SysInfo;
import org.ithang.system.data.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

	@Autowired
	private DataMapper dataMapper;
	
	public SysInfo lastInfo(){
		if(0==dataMapper.isInstall()){
			SysInfo info=new SysInfo();
			info.setId(0);
			info.setVersion("0");
			info.setCreateTime("");
			return info;
		}else{
			return dataMapper.lastInfo();
		}
	}
	
}
