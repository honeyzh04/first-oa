package com.first.mapper;
import java.util.List;

import com.first.entity.UserLoginFormMap;

/**
 * 
 * 登陆操作
 *
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月19日
   @version 1.00
 */
public interface UserLoginMapper{
	
	/**
	 * 登陆记录
	 * @param formMap
	 * @throws Exception
	 */
	public void addEntity(UserLoginFormMap userLogin) throws Exception;
	/**
	 * 查询登陆记录
	 * @return
	 */
	public  List<UserLoginFormMap> findByPage();

}
