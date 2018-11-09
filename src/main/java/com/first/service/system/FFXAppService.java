/**
 * 
 */
package com.first.service.system;

import com.first.entity.CustomerFormMap;
import com.first.entity.StatisticsFormMap;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年10月10日
   @version 1.00
 */
public interface FFXAppService {

	/**
	 * 查看客户
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> findCustomerPage(Map searchMapMap);

}
