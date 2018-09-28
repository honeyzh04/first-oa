package com.first.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.controller.index.BaseController;
import com.first.entity.ProjectFormMap;
import com.first.entity.StatisticsFormMap;
import com.first.mapper.ProjectMapper;
import com.first.mapper.StatisticsMapper;
import com.first.mapper.StatisticsTVMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 电视报表
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月10日
   @version 1.00
 */
@Controller
@RequestMapping("/TVreport/")
public class TVreportController extends BaseController {
	@Inject
	private StatisticsTVMapper statisticsMapper;
	@Inject
	private ProjectMapper projectMapper;
	/**
	 * 当月报表
	 * @param callback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("shows")
	 @ResponseBody
	public Object shows(String callback) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		 List<StatisticsFormMap> departday=statisticsMapper.findDeday();//部门当月当天报表
		 List<StatisticsFormMap> departMonth=statisticsMapper.findDe();//部门当月报表
		
		 List<StatisticsFormMap> dedays=statisticsMapper.findDedays();//部门当月每天的报表
		 List<StatisticsFormMap> denorth1days=new ArrayList<StatisticsFormMap>();//北一当月每天的报表
		 List<StatisticsFormMap> desouth1days=new ArrayList<StatisticsFormMap>();//南一当月每天的报表
		 List<StatisticsFormMap> desouth2days=new ArrayList<StatisticsFormMap>();//南二当月每天的报表
		 List<StatisticsFormMap> desouth3days=new ArrayList<StatisticsFormMap>();//南三当月每天的报表
		 List<StatisticsFormMap> deeast1days=new ArrayList<StatisticsFormMap>();//东一当月每天的报表
		 List<StatisticsFormMap> dewest1days=new ArrayList<StatisticsFormMap>();//x西一当月每天的报表

	
			for (StatisticsFormMap a : dedays) {
			
				String id=a.getStr("id");
			
				if(id.equals("20")) {
					 desouth1days.add(a);
				}else if(id.equals("21")) {
					 desouth2days.add(a);
				}else if(id.equals("26")) {
					 desouth3days.add(a);
				}else if(id.equals("24")) {
					denorth1days.add(a);
				}else if(id.equals("16")) {
					deeast1days.add(a);
				}else if(id.equals("18")) {
					dewest1days.add(a);
				}

			}

		
		 List<StatisticsFormMap> rankPerAddMonth=statisticsMapper.findRankPerAddMonth();//个人当月新增排行
		
		 List<StatisticsFormMap> rankPerFollowMonth=statisticsMapper.findRankPerFollowMonth();//个人当月跟进排行榜
		 
		 List<StatisticsFormMap> rankPerVisMonth=statisticsMapper.findRankPerVisMonth();//个人当月到访排行
		
		 List<StatisticsFormMap> rankPerDeaMonth=statisticsMapper.findRankPerDeaMonth();//个人月成交排行
		 
		 List<StatisticsFormMap> rankDeAddMonth=statisticsMapper.findRankDeAddMonth();//部门当月新增排行
		 
		 List<StatisticsFormMap> rankDeFollowMonth=statisticsMapper.findRankDeFollowMonth();//部门当月跟进排行榜
		
		 List<StatisticsFormMap> rankDeVisMonth=statisticsMapper.findRankDeVisMonth();//部门当月到访排行
		
		 List<StatisticsFormMap> rankDeDeaMonth=statisticsMapper.findRankDeDeaMonth();//部门当月成交新增排行
		List<StatisticsFormMap> monthExtiension=statisticsMapper.findMonthExtiension();//当月报表

	
		
		 List<ProjectFormMap>  projectFormMap = projectMapper.getProject(); //项目查看
		 System.err.println("9");
		 List<ProjectFormMap>  projectTVshows = new ArrayList<ProjectFormMap>();
		 for(ProjectFormMap a: projectFormMap) {
			 String latitude=a.getStr("latitude");
			 String []ids=latitude.split(",");
			 for(int i=0;i<ids.length;i++) {
				a.put("lng",ids[0]);
				a.put("lat",ids[1]);
			 }
			 projectTVshows.add(a);
			
		 }
		
		searchMap.put("departday", departday);
		searchMap.put("departMonth", departMonth);
		searchMap.put("denorth1days", denorth1days);
		searchMap.put("desouth1days", desouth1days);
		searchMap.put("desouth2days", desouth2days);
		searchMap.put("desouth3days", desouth3days);
		searchMap.put("deeast1days", deeast1days);
		searchMap.put("dewest1days", dewest1days);
		
		searchMap.put("rankPerAddMonth", rankPerAddMonth);
		searchMap.put("rankPerFollowMonth",rankPerFollowMonth);
		searchMap.put("rankPerVisMonth", rankPerVisMonth);
		searchMap.put("rankPerDeaMonth",rankPerDeaMonth);
		
		searchMap.put("rankDeAddMonth", rankDeAddMonth);
		searchMap.put("rankDeFollowMonth", rankDeFollowMonth);
		searchMap.put("rankDeVisMonth",  rankDeVisMonth);
		searchMap.put("rankDeDeaMonth", rankDeDeaMonth);
		searchMap.put("projectFormMap", projectTVshows);
		searchMap.put("monthExtiension", monthExtiension);
		
		
		if(callback==null||callback.equals("")) {
			callback="callback";
		}
		 JSONPObject jsonpObject = new JSONPObject(callback,searchMap) ;
	        return jsonpObject ;
	}
	
	/**
	 * RANK  接口
	 * @param callback
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("rank")
	 @ResponseBody
	public Object rank(String callback) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		 
		 List<StatisticsFormMap> lastdadd=statisticsMapper.findlastdadd();//上月部门新增排行
		 
		 List<StatisticsFormMap> lastdfollow=statisticsMapper.findlastdfollow();//上月部门更进排行
		
		 List<StatisticsFormMap> lastdvis=statisticsMapper.findlastdvis();//上月部门到访排行
		
		 List<StatisticsFormMap> lastddea=statisticsMapper.findlastddea();//上月部门成交排行
		
		 
		 List<StatisticsFormMap> lastpadd=statisticsMapper.findlastpadd();//上月个人新增排行
		
		 List<StatisticsFormMap> lastpfollow=statisticsMapper.findlastpfollow();//上月个人更进排行
		
		 List<StatisticsFormMap> lastpvis=statisticsMapper.findlastpvis();//上月个人到访排行
		 
		 List<StatisticsFormMap> lastpdea=statisticsMapper.findlastpdea();//上月个人成交排行
		 List<StatisticsFormMap> lastpchampion=statisticsMapper.findlastpchampion();//个人销冠
		 List<StatisticsFormMap> lastdchampion=statisticsMapper.findlastdchampion();//部门销冠
		
		 searchMap.put("lastdadd",lastdadd);
		 searchMap.put(" lastdfollow", lastdfollow);
		 searchMap.put("lastdvis",lastdvis);
		 searchMap.put("lastddea",lastddea);
		 
		 searchMap.put("lastpadd",lastpadd);
		 searchMap.put(" lastpfollow", lastpfollow);
		 searchMap.put("lastpvis",lastpvis);
		 searchMap.put("lastpdea",lastpdea);
		 searchMap.put("lastpchampion",lastpchampion);
		 searchMap.put("lastdchampion",lastdchampion);
		 
			if(callback==null||callback.equals("")) {
				callback="callback";
			}
			 JSONPObject jsonpObject = new JSONPObject(callback,searchMap) ;
		        return jsonpObject ; 
	}
	
	@RequestMapping("test")
	 @ResponseBody
	public Object test(String callback) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		 
		List<ProjectFormMap>  p = projectMapper.findProjecttest();

		
		 searchMap.put("projectadd",p);
		
		 
			
		        return searchMap ; 
	}
	@RequestMapping("test1")
	 @ResponseBody
	public Object test1(String callback) throws Exception {
	
		
		 
		List<ProjectFormMap>  p = projectMapper.findProjecttest();

		
		
		
		 
			
		        return p ; 
	}
	}
