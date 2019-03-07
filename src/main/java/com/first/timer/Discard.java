/**
 * 
 */
package com.first.timer;

import com.first.mapper.CustomerMapper;
import com.first.mapper.MonthStartMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * 客户跟进定时器任务
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年5月29日
   @version 1.00
 */

@Component  
public class Discard {  
	@Inject
	private CustomerMapper customerMapper; 
	@Inject
	private MonthStartMapper  monthstartMapper;

	
	/* @Scheduled(cron = "0/5 * * * * ?")
    public void show1(){  
        System.out.println("测试  每5s执行一次");  
    }  */
    /**
     * 调入部门公共池  
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */    
    @Scheduled(cron = "0 30 01 * * ? ")
    public void show() throws Exception{
        System.out.println("das");
		customerMapper.autobDiscard();
    }
    /**
     * 调入公司公共池  
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */ 
   @Scheduled(cron = "0  40 01 * * ?")
    public void show1() throws Exception{  
    	customerMapper.autoaDiscard(); 
    }  
    
    /**
     * 昨日跟进
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */ 
    @Scheduled(cron = "0  10 01 * * ?")
    public void show0() throws Exception{  
    	customerMapper.auto0Discard(); 
    } 
    /**
     * 一天未更
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */ 
    @Scheduled(cron = "0  12 01 * * ?")
    public void show2() throws Exception{  
    	customerMapper.auto1Discard(); 
    } 
    /**
     * 二天未更
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */ 
   @Scheduled(cron = "0  14 01 * * ?")
    public void show3() throws Exception{  
    	customerMapper.auto2Discard(); 
    } 
    /**
     * 三天未更
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */ 
   @Scheduled(cron = "0  16 01 * * ?")
    public void show4() throws Exception{  
    	customerMapper.auto3Discard(); 
    } 
    /**
     * 四天未更
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */ 
    @Scheduled(cron = "0  18 01 * * ?")
    public void show5() throws Exception{  
    	customerMapper.auto4Discard(); 
    } 
    /**
     * 五天未更
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */ 
    @Scheduled(cron = "0  20 01 * * ?")
    public void show6() throws Exception{  
    	customerMapper.auto5Discard(); 
    } 
    /**
     * 六天未更
     * 定时计算。每天凌晨1:00 执行一次  
     * @throws Exception 
     */ 
   @Scheduled(cron = "0  22 01 * * ?")
    public void show7() throws Exception{  
    	customerMapper.auto6Discard();
        customerMapper.auto6DiscardShare();
    }

    /**
     * 月初定时任务
     * @throws Exception
     */
 //   @Scheduled(cron = "0 00 02 1 * ?")
    public void showmonth() throws Exception{  
    	 monthstartMapper.addreportpsum();
    	 monthstartMapper.addreportdsum();
    } 
   
  //  @Scheduled(cron = "0 05 02 1 * ??")
    public void deletelogin() throws Exception{  
    	 monthstartMapper.deletelogin();
    	 monthstartMapper.deletelog();
    	 monthstartMapper.deletefollow();
    	 monthstartMapper.deleteadd();
    	
    }



}