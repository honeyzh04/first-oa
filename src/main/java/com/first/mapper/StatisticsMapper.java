package com.first.mapper;

import com.first.entity.StatisticsFormMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 部门操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年6月1日
   @version 1.00
 */


public interface StatisticsMapper {
	/**
	 * 部门日报表
	 * @return
	 */
	public  List<StatisticsFormMap> findDeday( Map searchMapMap);
	/**
	 * 部门日报表t统计
	 * @return
	 */
	public  StatisticsFormMap findSumDeday( Map searchMapMap);
	
	/**
	 * 部门当周报表
	 * @return
	 */
	public  List<StatisticsFormMap> findDeweek( Map searchMapMap);
	/**
	 * 部门日报表t统计
	 * @return
	 */
	public StatisticsFormMap findSumDeweek( Map searchMapMap);
	/**
	 * 部门月报表
	 * @return
	 */
	public  List<StatisticsFormMap> findDemonth(Map searchMapMap);
	/**
	 * 部门月报表t统计
	 * @return
	 */
	public StatisticsFormMap findSumDemonth( Map searchMapMap);
	/**
	 * 个人当月每天报表
	 * @return
	 */
	public  List<StatisticsFormMap> findPedays(@Param("userId") String userId);
	/**
	 * 部门当月每天报表
	 * @return
	 */
	public  List<StatisticsFormMap> findDedays();

	/**
	 * 个人当月新增排行
	 * @return
	 */
	public  List<StatisticsFormMap> findRankPerAddMonth();
	/**
	 * 个人当月跟进排行榜
	 * @return
	 */
	public  List<StatisticsFormMap> findRankPerFollowMonth();
	/**
	 * 个人当月到访排行
	 * @return
	 */
	public  List<StatisticsFormMap> findRankPerVisMonth();
	/**
	 * 个人当月成交排行
	 * @return
	 */
	public  List<StatisticsFormMap> findRankPerDeaMonth();
	/**
	 * /部门当月新增排行
	 * @return
	 */
	public  List<StatisticsFormMap> findRankDeAddMonth();
	/**
	 * 部门当月跟进排行榜
	 * @return
	 */
	public  List<StatisticsFormMap> findRankDeFollowMonth();
	/**
	 * 部门当月到访排行
	 * @return
	 */
	public  List<StatisticsFormMap> findRankDeVisMonth();
	/**
	 * 部门当月成交排行
	 * @return
	 */
	public  List<StatisticsFormMap> findRankDeDeaMonth();
	/**
	 * 部门个人日报表
	 * @return
	 */
	public  List<StatisticsFormMap> findpeday( Map searchMapMap);
	
	/**
	 * 部门个人周报表
	 * @return
	 */
	public  List<StatisticsFormMap> findpeweek( Map searchMapMap);
	/**
	 * 部门个人月报表
	 * @return
	 */
	public  List<StatisticsFormMap> findpemonth( Map searchMapMap);
	/**
	 * 网络日报表
	 * @param searchMapMap
	 * @return
	 */
	public  List<StatisticsFormMap> findSumInday( Map searchMapMap);
	/**
	 * 网络周报表
	 * @param searchMapMap
	 * @return
	 */
	public  List<StatisticsFormMap> findSumInweek( Map searchMapMap);
	/**
	 * 网络月报表
	 * @param searchMapMap
	 * @return
	 */
	public  List<StatisticsFormMap> findSumInmonth( Map searchMapMap);

	/**
	 * 竞价报表
	 * @param searchMapMap
	 * @return
	 */
	public  List<StatisticsFormMap> findByExtension( Map searchMapMap);

	/**
	 * 查找当日竞价数据
	 */
	Map<String, Object> findAddOther(@Param("createDate") String createDate);
	Integer findVis(@Param("createDate") String createDate);
	Map<String, Object> findDea(@Param("createDate") String createDate);

	/**
	 * 添加竞价报表
	 */
	void addEntity(Map formMap);

	/**
	 * 查看具体来源
	 * @param createDate
	 * @return
	 */
	Map<String, Object> findSource(@Param("createDate") String createDate);

	/**
	 * 竞价周报表
	 * @param searchMapMap
	 * @return
	 */
	List<StatisticsFormMap> findWeekExtension( Map searchMapMap);

    /**
     * 竞价周报表统计
     * @param searchMapMap
     * @return
     */
    StatisticsFormMap findWeekSum(Map searchMapMap);
	/**
	 * 房发现新增周报表
	 * @param searchMapMap
	 * @return
	 */
	List<StatisticsFormMap> findWeekAdds( Map searchMapMap);
	/**
	 * 房发现带访周报表
	 * @param searchMapMap
	 * @return
	 */
	List<StatisticsFormMap> findWeekVisit( Map searchMapMap);

	/**
	 * 房发现成交周报表
	 * @param searchMapMap
	 * @return
	 */
	List<StatisticsFormMap> findWeekDeal( Map searchMapMap);
    /**
     * 房发现退单周报表
     * @param searchMap
     * @return
     */
    StatisticsFormMap findWeekRefund( Map searchMap);

    /**
     * 房发现去重周报表
     * @param searchMap
     * @return
     */
  StatisticsFormMap findWeekFilter( Map searchMap);

	/**
	 * 添加竞价周报表
	 */
	void addWeekReport(Map formMap);


}
