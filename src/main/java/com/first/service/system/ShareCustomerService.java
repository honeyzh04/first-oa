/**
 * 
 */
package com.first.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.first.entity.CustomerFormMap;
import com.first.entity.ProjectFormMap;
import com.first.entity.UserFormMap;
/**
 * 共享客户
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年8月10日
   @version 1.00
 */
@Service
public interface ShareCustomerService {
	/**
	 * 个人查询客户
	 * @param userFormMap
	 * @return
	 */
	public List<CustomerFormMap> findShareCu( Map searchMapMap);

	/**
	 * 查看所有客户
	 * @param userFormMap
	 * @return
	 */
	public List<CustomerFormMap>  findDeShareCu( Map searchMapMap);
	/**
	 * 查看已共享销售
	 * 
	   @author zhaoh
	 * @date 2018年8月10日
	   @version 1.00
	 * @param searchMapMap
	 * @return
	 */
	public List<String> findOldUser(Map searchMapMap);
	/**
	 * 退出共享
	 * 
	 * 
	   @author zhaoh
	 * @date 2018年8月11日
	   @version 1.00
	 * @param id
	 */
	void outShareCustomer(String id,String userId);
	/**
	 * 查询客户共享人数
	 * 
	   @author zhaoh
	 * @date 2018年8月11日
	   @version 1.00
	 * @param id
	 * @return
	 */
	public List<String> findShareUser(String id);
	

}
