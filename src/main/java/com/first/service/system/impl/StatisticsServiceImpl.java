/**
 * 
 */
package com.first.service.system.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.first.entity.StatisticsFormMap;
import com.first.mapper.StatisticsMapper;
import com.first.service.system.ProjectService;
import com.first.service.system.StatisticsService;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月24日
   @version 1.00
 */
@Service("StatisticsService")
public class StatisticsServiceImpl implements StatisticsService  {
	@Inject
	private StatisticsMapper statisticsMapper;


	@Override
	public List<StatisticsFormMap> findSumInday(Map searchMap) {
		// TODO Auto-generated method stub
		return statisticsMapper.findSumInday(searchMap);
	}

	/* (non-Javadoc)
	 * @see com.first.service.system.StatisticsService#findSumItweek(java.util.Map)
	 */
	@Override
	public List<StatisticsFormMap> findSumInweek(Map searchMap) {
		// TODO Auto-generated method stub
		return statisticsMapper.findSumInweek(searchMap);
	}
	/**
	 * 网络日报表统计
	 */
	@Override
	public List<StatisticsFormMap> findSumInmonth(Map searchMap) {
		// TODO Auto-generated method stub
		return statisticsMapper.findSumInmonth(searchMap);
	}

	/**
	 * 竞价报表
	 * @param searchMap
	 * @return
	 */
	@Override
	public List<StatisticsFormMap> findByExtension(Map searchMap) {
		return statisticsMapper.findByExtension(searchMap);
	}

	@Override
	public Map<String, Object> findAddOther(String createDate) {
		return statisticsMapper.findAddOther(createDate);
	}

	@Override
	public Integer findVis(String createDate) {

			return statisticsMapper.findVis(createDate);
	}

	@Override
	public Map<String, Object> findDea(String createDate) {
		return statisticsMapper.findDea(createDate);
	}

	@Override
	public void addEntity(Map formMap) {
		statisticsMapper.addEntity(formMap);
	}

	@Override
	public Map<String, Object> findSource(String createDate) {
		return statisticsMapper.findSource(createDate);
	}
}
