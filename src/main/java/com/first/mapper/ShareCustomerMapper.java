package com.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.first.entity.CustomerFormMap;
import com.first.entity.UserFormMap;

/**
 * 共享客户操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年8月10日
   @version 1.00
 */

public interface ShareCustomerMapper {

	/**
	 * 
	   @author zhaoh
	 * @date 2018年8月10日
	   @version 1.00
	 * @param searchMapMap
	 * @return
	 */
	List<CustomerFormMap> findShareCu(Map searchMapMap);

	/**
	 * 
	   @author zhaoh
	 * @date 2018年8月10日
	   @version 1.00
	 * @param searchMapMap
	 * @return
	 */
	List<CustomerFormMap> findDeShareCu(Map searchMapMap);
	/**
	 * 查询客户共享人数
	 * 
	   @author zhaoh
	 * @date 2018年8月11日
	   @version 1.00
	 * @param id
	 * @return
	 */
	List<String> findShareUser(@Param("id")String id);
	
	/**
	 * 查询已共享经纪人
	 */
	List<String> findOldUser(Map searchMapMap);
	/**
	 * 退出共享
	 * 
	   @author zhaoh
	 * @date 2018年8月11日
	   @version 1.00
	 * @param id
	 * @param userId
	 */
	void outShareCustomer(@Param("id")String id,@Param("userId")String userId);
}
