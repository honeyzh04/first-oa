package com.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.first.entity.UserFormMap;
import com.first.entity.UserRoleFormMap;

/**
 * 用户操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月9日
   @version 1.00
 */
public interface UserMapper {
	/**
	 * 查询用户
	 * @param userFormMap
	 * @return
	 */
	public List<UserFormMap> findUserPage(Map searchMap);

	
	/**
	 * 登录查询
	 * @param formMap
	 * @return
	 */
	public List<UserFormMap> findByNames(UserFormMap formMap);
	
	/**
	 *对外用户信息接口
	 * @param formMap
	 * @return
	 */
	public UserFormMap findByUser(UserFormMap formMap);
	/**
	 * 添加用户
	 * @param formMap
	 * @throws Exception
	 */
	public void addEntity(UserFormMap formMap) throws Exception;
	/**
	 * 添加用戶職位管理表
	 * @param formMap
	 * @throws Exception
	 */
	public void addUREntity(UserRoleFormMap formMap) throws Exception;
	/**
	 * 删除用户职位表
	 * @param key
	 * @param value
	 * @param clazz
	 * @throws Exception
	 */
	public void deleteByUR(UserFormMap formMap) throws Exception;
	/**
	 * 根据某个字段查询数据，返回一个对象，如果返回多个值，则异常 <br/>
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	public UserFormMap findbyFrist(UserFormMap formMap);
	/**
	 *跟新用户
	 * @param formMap
	 * @throws Exception
	 */
	public void editEntity(Object formMap) throws Exception;
	
	/**
	 * 根据某个字段查询数据，返回一个对象，如果返回多个值，则异常 <br/>
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	public UserFormMap findbyeditUI(@Param("id")String id );
	/**
	 * 员工形象展示
	 * @return
	 */
	public List<UserFormMap> findshows();

}
