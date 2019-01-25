package com.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.first.entity.DepartmentFormMap;
import com.first.entity.UserFormMap;

/**
 * 部门操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年6月1日
   @version 1.00
 */


public interface DepartMapper {
	/**
	 * 查找销售部
	 * @return
	 */
	public  List<DepartmentFormMap> getcuDepart();

	List<String> getcudeId();

	/**
	 * 查看全部部门
	 * @return
	 */
	public  List<DepartmentFormMap> getDepart();
	/**
	 * 查询销售人员
	 * @param userFormMap
	 * @return
	 */
	public List<UserFormMap> getUser(@Param("departCode")String id);
	/**
	 * 查看全部部门
	 * @return
	 */
	public  List<DepartmentFormMap> findDepart(Map  searchMap);
	
	/**
	 * 查询所有销售人员
	 * @param userFormMap
	 * @return
	 */
	public List<UserFormMap> getAlluser();
}
