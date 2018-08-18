package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.first.entity.InterlocutionFormMap;

/**
 * 销售白问
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月4日
   @version 1.00
 */

public interface InterlocutionMapper {
	/*
	 * 销售白问查找问题
	 */
	public  List<InterlocutionFormMap> findQuestions(@Param("que")String que);
	/**
	 * 展开更多问题
	 * @param id
	 * @return
	 */
	public  List<InterlocutionFormMap> findanswer(@Param("id")String id);
	/**
	 *所有问题
	 * @param id
	 * @return
	 */
	public  List<InterlocutionFormMap> findanswers(@Param("id")String id);
	
	/*
	 * 添加问题
	 */
	public  InterlocutionFormMap 	findbyquestion(@Param("id")String id);

	
	/**
	 * 录入问题
	 * @param formMap
	 * @throws Exception
	 */
	public void addquestion(Object formMap) throws Exception;
	/**
	 * 录入回答
	 * @param formMap
	 * @throws Exception
	 */
	public void addanswer(Object formMap) throws Exception;
	/*
	 * 完善问题
	 */
	public  InterlocutionFormMap 	findbyanswer(@Param("id")String id);
	/**
	 * 修改问题
	 * @param formMap
	 * @throws Exception
	 */
	public void editanswer(Object formMap) throws Exception;
	/**
	 * 删除答案
	 * @param id
	 */
	public  void	deleteanswer(@Param("aId")String aId);
	
	
}
