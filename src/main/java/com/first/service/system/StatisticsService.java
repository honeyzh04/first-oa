/**
 * 
 */
package com.first.service.system;

import java.util.List;
import java.util.Map;

import com.first.entity.StatisticsFormMap;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月24日
   @version 1.00
 */
public interface StatisticsService {

	/**
	 * 查看网络日报表
	 */
	List<StatisticsFormMap> findSumInday( Map searchMap);
	/**
	 * 查看网络周报表
	 * @param searchMap
	 * @return
	 */
	List<StatisticsFormMap> findSumInweek( Map searchMap);
	/**
	 * 查看网络月报表
	 */
	 List<StatisticsFormMap> findSumInmonth( Map searchMap);

	/**
	 * 竞价报表
	 * @param searchMap
	 * @return
	 */
	List<StatisticsFormMap> findByExtension( Map searchMap);

	/**
	 * 新增数据
	 * @param createDate
	 * @return
	 */
	Map<String, Object> findAddOther(String createDate);

	/**
	 * 带访数据
	 * @param createDate
	 * @return
	 */
	Integer findVis(String createDate);
	/**
	 * 成交数据
	 */
	Map<String, Object> findDea(String createDate);

	/**
	 * 添加竞价报表
	 * @param formMap
	 */
	void addEntity(Map formMap) ;

	/**
	 * 具体来源
	 * @param createDate
	 * @return
	 */
	Map<String, Object> findSource(String createDate);

}
