package com.first.mapper;

import java.util.List;
import java.util.Map;

import com.first.entity.StatisticsFormMap;

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
	public  List<StatisticsFormMap> findDe(Map searchMapMap);
	/**
	 * 部门月报表t统计
	 * @return
	 */
	public StatisticsFormMap findSumDemonth( Map searchMapMap);
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
	
}
