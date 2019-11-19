package org.ithang.tools.schedule;

import org.apache.log4j.Logger;
import org.ithang.system.keyvalue.service.KeyvalueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling  
public class SampleSchedule {

	
	@Autowired
	private KeyvalueService keyvalueService;
	
	private Logger logger=Logger.getLogger(SampleSchedule.class);
	
	
	/**
	 * 静态分润
	 */
	@Scheduled(cron = "0 */3 * * * ?")
	//@Scheduled(cron=" 0 0 9 * * ?")
     private void staticBonus() {
		logger.info("running...");
     }
	 
	
	
}
