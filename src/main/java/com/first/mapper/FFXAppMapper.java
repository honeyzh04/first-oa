package com.first.mapper;

import com.first.entity.CustomerFormMap;
import com.first.entity.ExtendFormMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 房发现app接口
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年10月10日
   @version 1.00
 */
public interface FFXAppMapper {

	/**
	 * 查看客户
	 * @param searchMapMap
	 * @return
	 */
	public List<CustomerFormMap> findCustomerPage( Map searchMapMap);

}
