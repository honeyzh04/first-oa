package com.first.mapper;

import java.util.List;

import com.first.entity.ResFormMap;

/**
 * 菜单操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月9日
   @version 1.00
 */
public interface ResourcesMapper{
	/**
	 * 查找下级菜单
	 * @param map
	 * @return
	 */
	public List<ResFormMap> findChildlists(ResFormMap map);

	/*
	 * 查找可见菜单菜单
	 */
	public List<ResFormMap> findMenu(ResFormMap map);
	/**
	 * 查找资源
	 * @param map
	 * @return
	 */
	public List<ResFormMap> findRes(ResFormMap map);
	
	public List<ResFormMap> findRoleRes(ResFormMap map);
	public void updateSortOrder(List<ResFormMap> map);
	/**
	 * 查询用户权限
	 * @param userId
	 * @return
	 */
	public List<ResFormMap> findUserResourcess(String userId);
	
	/**
	 * 1：根据多字段查询
	 * 2：传入继承FormMap的子类对象 
	 * 3：如果是多个id,用","组成字符串. 
	 * 4：formMap.put("id","xxx") 或 formMap.put("id","xxx,xxx,xxx") 
	 * 5：formMap.put("name","xxx") 或 formMap.put("name","xxx,xxx,xxx") 
	 * 6：兼容模糊查询。 formMap.put("name","用户%") 或 formMap.put("name","%用户%") 
	 * 7：兼容排序查询 : formMap.put("$orderby","order by id desc");
	 * @param formMap
	 * @return
	 */
	public List<ResFormMap> findByNames(ResFormMap formMap);
	/**
	 * 1：自定义where查询条件，传入继承FormMap的子类对象,返回是一个List<T>集合<br/>
	 * 2：返回查询条件数据,如不传入.则返回所有数据..如果附加条件.如下 <br/>
	 * 3：formMap.put('where","id=XX and name= XX order by XX") <br/>
	 * @param formMap
	 * @return
	 */
	public <T> List<T> findByWhere(T formMap);

	/**
	 * 1：根据某个字段查询数据，返回一个对象，如果返回多个值，则异常 <br/>
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	public <T> T findbyFrist(String key,String value,Class<T> clazz);
	/**
	 * 1：更新数据<br/>
	 * 2：传入继承FormMap的子类对象<br/>
	 * @param formMap
	 * @throws Exception
	 */
	public void editEntity(Object formMap) throws Exception;
	/**
	 * 1：传入继承FormMap的子类对象 <br/>
	 * 2：保存数据,保存数据后返回子类对象的所有数据包括id..主建统一返回为id <br/>
	 * @param formMap
	 * @throws Exception
	 */
	public void addEntity(Object formMap) throws Exception;
	/**
	 * 1：根据某个字段删除数据 <br/>
	 * @param key
	 * @param value
	 * @param clazz
	 * @throws Exception
	 */
	public void deleteByAttribute(String key, String value, Class clazz) throws Exception;
	/**
	 * 1：根据某个字段查询数据 <br/>
	 * @param key
	 * @param value
	 * @param clazz
	 * @return
	 */
	public <T> List<T> findByAttribute(String key, String value, Class<T> clazz);
	/**
	 *  1：批量保存数据,如果是mysql,在驱动连接加上&allowMultiQueries=true这个参数 <br/>
	 * 2：传入继承FormMap的子类对象的一个list集合 <br/>
	 * @param formMap
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void batchSave(List formMap) throws Exception;
	/**
	 * 1：获取表字段存在放缓存 <br/>
	 * @param formMap
	 * @return
	 */
	public <T> List<T> initTableField(T formMap);

}
