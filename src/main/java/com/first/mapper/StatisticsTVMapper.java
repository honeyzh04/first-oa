package com.first.mapper;

import java.util.List;

import com.first.entity.StatisticsFormMap;

/**
 * 部门操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年6月1日
   @version 1.00
 */


public interface StatisticsTVMapper {
	/**
	 * 部门当月当天报表
	 * @return
	 */
	public  List<StatisticsFormMap> findDeday();
	/**
	 * 部门当周报表
	 * @return
	 */
	public  List<StatisticsFormMap> findDeweek();
	
	/**
	 * 部门月报表
	 * @return
	 */
	public  List<StatisticsFormMap> findDe();
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
	 * 上月部门新增排行
	 * @return
	 */
	public  List<StatisticsFormMap> findlastdadd();
	/**
	 * 上月部门跟进排行
	 * @return
	 */
	public  List<StatisticsFormMap> findlastdfollow();
	/**
	 * 上月部门到访排行
	 * @return
	 */
	public  List<StatisticsFormMap> findlastdvis();
	/**
	 * 上月部门成交排行
	 * @return
	 */
	public  List<StatisticsFormMap> findlastddea();
	/**
	 * 上月个人新增排行
	 * @return
	 */
	public  List<StatisticsFormMap> findlastpadd();
	/**
	 *  上月个人新增排行
	 * @return
	 */
	public  List<StatisticsFormMap> findlastpfollow();
	/**
	 *  上月个人到访排行
	 * @return
	 */
	public  List<StatisticsFormMap> findlastpvis();
	/**
	 *  上月个人成交排行
	 * @return
	 */
	public  List<StatisticsFormMap> findlastpdea();
	/**
	 * 个人销冠
	 * @return
	 */
	public  List<StatisticsFormMap> findlastpchampion();
	/**
	 * 部门销冠
	 * @return
	 */
	public  List<StatisticsFormMap> findlastdchampion();

	/**
	 * 当月报表
	 * @return
	 */
	List<StatisticsFormMap> findMonthExtiension();

}
