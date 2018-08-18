/**
 * 
 */
package com.first.service.system.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.first.entity.CustomerFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.ShareCustomerMapper;
import com.first.service.system.ShareCustomerService;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月24日
   @version 1.00
 */
@Service("ShareCustomerService")
public class ShareCustomertServiceImpl implements ShareCustomerService  {
	@Inject
	private ShareCustomerMapper sharecustomerMapper;
	@Override
	public List<CustomerFormMap> findShareCu(Map searchMapMap) {
		
		return sharecustomerMapper.findShareCu(searchMapMap);
	}

	@Override
	public List<CustomerFormMap> findDeShareCu(Map searchMapMap) {
		return sharecustomerMapper.findDeShareCu(searchMapMap);
	}
	
	public List<String> findOldUser(Map searchMapMap) {
		return sharecustomerMapper.findOldUser(searchMapMap);
	}

	@Override
	public void outShareCustomer(String id,String userId) {
		 sharecustomerMapper.outShareCustomer(id,userId);
		
	}

	/**
	 * 查询客户共享人数
	 */
	@Override
	public List<String> findShareUser(String id) {
		
		return  sharecustomerMapper.findShareUser(id);
	}	
	}
	


	



