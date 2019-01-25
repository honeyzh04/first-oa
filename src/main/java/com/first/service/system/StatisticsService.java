/**
 * 
 */
package com.first.service.system;

import com.first.entity.StatisticsFormMap;

import java.util.List;
import java.util.Map;

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
	List<StatisticsFormMap> findPeweeks( Map searchMap);

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
	 List<StatisticsFormMap> findPedays(String userId);
	List<StatisticsFormMap> findDedays();
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
	/**
	 * 房发现新增周报表
	 * @param searchMap
	 * @return
	 */
	List<StatisticsFormMap> findWeekAdds( Map searchMap);
	/**
	 * 房发现带访周报表
	 * @param searchMap
	 * @return
	 */
	List<StatisticsFormMap> findWeekVisit( Map searchMap);

	/**
	 * 房发现成交周报表
	 * @param searchMap
	 * @return
	 */
	List<StatisticsFormMap> findWeekDeal( Map searchMap);

	/**
	 * 房发现去重周报表
	 * @param searchMap
	 * @return
	 */
	StatisticsFormMap findWeekFilter( Map searchMap);

	/**
	 * 退单周报表
	 * @param searchMap
	 * @return
	 */
	  StatisticsFormMap findWeekRefund( Map searchMap);

	/**
	 * 添加竞价周报表
	 */
	void addWeekReport(Map formMap);

}
