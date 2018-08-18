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
	public List<StatisticsFormMap> findSumInday( Map searchMap);
	/**
	 * 查看网络周报表
	 * @param searchMap
	 * @return
	 */
	public  List<StatisticsFormMap> findSumInweek( Map searchMap);
	/**
	 * 查看网络月报表
	 */
	public List<StatisticsFormMap> findSumInmonth( Map searchMap);
}
