package com.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.first.entity.RoleFormMap;
import com.first.entity.RoleResFormMap;
import com.first.entity.UserFormMap;

/**
 * 角色操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月4日
   @version 1.00
 */
public interface RoleMapper {
	/**
	 * 查询职位
	 * @param map
	 * @return
	 */
	public List<RoleFormMap> seletUserRole(RoleFormMap map);
	
	public void deleteById(RoleFormMap map);
	/**
	 * 职位列表显示
	 * @param map
	 * @return
	 */
	public List<RoleFormMap> findRloePage(Map map);

	/**
	 * 职位添加
	 * @param formMap
	 * @throws Exception
	 */
	public void addEntity(RoleFormMap formMap) throws Exception;
	
	public void addRREntity(RoleResFormMap formMap) throws Exception;
	/**
	 * 职位删除
	 * @param id
	 */
	public void deleteEntity(@Param("id")String id ) ;

	/**
	 * 1：根据某个字段查询数据，返回一个对象，如果返回多个值，则异常 <br/>
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	public <T> T findbyFrist(String key,String value,Class<T> clazz);
	/**
	 * 修改职位表
	 * @param formMap
	 * @throws Exception
	 */
	public void editEntity(RoleFormMap formMap) throws Exception;

	/**
	 * 1：自定义where查询条件，传入继承FormMap的子类对象,返回是一个List<T>集合<br/>
	 * 2：返回查询条件数据,如不传入.则返回所有数据..如果附加条件.如下 <br/>
	 * 3：formMap.put('where","id=XX and name= XX order by XX") <br/>
	 * @param formMap
	 * @return
	 */
	public <T> List<T> findByWhere(T formMap);
	/**
	 * 1：获取表字段存在放缓存 <br/>
	 * @param formMap
	 * @return
	 */
	public <T> List<T> initTableField(T formMap);
	/**
	 * 根据某个字段查询数据，返回一个对象，如果返回多个值，则异常 <br/>
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	public RoleFormMap findbyeditUI(@Param("id")String id );
	
	/**
	 * 清空职位权限
	 * @param id
	 */
	public void  deleteByRoRe(@Param("roleId")String roleId );

}
