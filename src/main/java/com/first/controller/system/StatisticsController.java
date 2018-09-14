package com.first.controller.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.controller.index.BaseController;
import com.first.entity.StatisticsFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.StatisticsMapper;
import com.first.service.system.StatisticsService;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 客户报表统计 Copyright (C), 2018-2022, ChengDu First Real estate agency
 * 
 * @author zhaoh
 * @date 2018年6月26日
 * @version 1.00
 */
@Controller
@RequestMapping("/statistics/")
public class StatisticsController extends BaseController {
	@Inject
	private StatisticsMapper statisticsMapper;
	@Inject
	private StatisticsService statisticsservice;

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {

		return Common.BACKGROUND_PATH + "/system/statistics/list";
	}

	/**
	 * 图形报表
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("echartslist")
	public String echartslistUI(Model model) throws Exception {

		return Common.BACKGROUND_PATH + "/system/statistics/echarts_list";
	}

	/**
	 * 部门日报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findBydepartday")
	public Object findBydepartday(HttpServletRequest request, int draw, int start, int length) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));
		String ab = request.getParameter("choiceday");
		if (ab == null || "".equals(ab)) {
			searchMap.put("choiceday", new Date());
		} else {
			searchMap.put("choiceday", ab);
		}

		System.err.println(searchMap);

		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsMapper.findDeday(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		StatisticsFormMap SumDeday = statisticsMapper.findSumDeday(searchMap);
		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}
		data.add(SumDeday);
		System.err.println("s12" + data);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 部门周报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findBydepartweek")
	public Object findBydepartweek(HttpServletRequest request, int draw, int start, int length) throws Exception {

		Map<String, Object> searchMap = new HashMap<String, Object>();

		String departweek = request.getParameter("departweek");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if (week == 1) {
			week = 5;
		} else if (week == 2) {
			week = 6;
		} else {
			week = week - 3;
		}
		System.err.println("，阿达" + week);
		if (departweek.equals("1")) {
			searchMap.put("departweeke", new Date());
			cal.add(Calendar.DAY_OF_YEAR, -week);
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeks", reStr);
		} else if (departweek.equals("2")) {
			cal.add(Calendar.DAY_OF_YEAR, -week);
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeke", reStr);
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_YEAR, -(week + 7));
			Date dt2 = cal.getTime();
			String reStr2 = sdf.format(dt2);
			searchMap.put("departweeks", reStr2);
		} else {
			cal.add(Calendar.DAY_OF_YEAR, -(week + 7));
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeke", reStr);
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_YEAR, -(week + 14));
			Date dt2 = cal.getTime();
			String reStr2 = sdf.format(dt2);
			searchMap.put("departweeks", reStr2);
		}
		System.err.println("查询" + searchMap);

		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsMapper.findDeweek(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		StatisticsFormMap SumDeday = statisticsMapper.findSumDeweek(searchMap);
		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}
		data.add(SumDeday);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 部门月报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findBydepartMonth")
	public Object findBydepartMonth(HttpServletRequest request, int draw, int start, int length) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));
		String ab = request.getParameter("choicemonth");
		System.err.println("das" + ab);
		if (ab == null || "".equals(ab)) {
			searchMap.put("choicemonth", new Date());
		} else {
			searchMap.put("choicemonth", ab + "-00");
		}

		System.err.println(searchMap);
		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsMapper.findDe(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		StatisticsFormMap SumDemonth = statisticsMapper.findSumDemonth(searchMap);
		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}
		data.add(SumDemonth);
		System.err.println("s11" + data);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 查看各部门个人日报表
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pedaylist")
	public String pedaylistUI(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户" + id);
		model.addAttribute("deId", id);
		return Common.BACKGROUND_PATH + "/system/statistics/pedaylist";
	}

	/**
	 * 部门日报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findBypeday")
	public Object findBypeday(HttpServletRequest request, int draw, int start, int length) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));
		String ab = request.getParameter("choiceday");
		String deId = request.getParameter("deId");
		if (ab == null || "".equals(ab)) {
			searchMap.put("choiceday", new Date());
		} else {
			searchMap.put("choiceday", ab);
		}
		searchMap.put("deId", deId);
		System.err.println("adsa" + searchMap);

		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsMapper.findpeday(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		StatisticsFormMap SumDeday = statisticsMapper.findSumDeday(searchMap);
		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}
		// data.add(SumDeday);
		System.err.println("s12" + data);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 查看各部门个人周报表
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("peweeklist")
	public String peweeklistUI(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户" + id);
		model.addAttribute("deId", id);
		return Common.BACKGROUND_PATH + "/system/statistics/peweeklist";
	}

	/**
	 * 查看各部门个人周报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findBypeweek")
	public Object findBypeweek(HttpServletRequest request, int draw, int start, int length) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();

		String deId = request.getParameter("deId");

		String departweek = request.getParameter("peweek");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if (week == 1) {
			week = 5;
		} else if (week == 2) {
			week = 6;
		} else {
			week = week - 3;
		}
		System.err.println("，阿达" + week);
		if (departweek.equals("1")) {
			searchMap.put("departweeke", new Date());
			cal.add(Calendar.DAY_OF_YEAR, -week);
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeks", reStr);
		} else if (departweek.equals("2")) {
			cal.add(Calendar.DAY_OF_YEAR, -week);
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeke", reStr);
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_YEAR, -(week + 7));
			Date dt2 = cal.getTime();
			String reStr2 = sdf.format(dt2);
			searchMap.put("departweeks", reStr2);
		} else {
			cal.add(Calendar.DAY_OF_YEAR, -(week + 7));
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeke", reStr);
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_YEAR, -(week + 14));
			Date dt2 = cal.getTime();
			String reStr2 = sdf.format(dt2);
			searchMap.put("departweeks", reStr2);
		}
		searchMap.put("deId", deId);
		System.err.println("查询" + searchMap);

		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsMapper.findpeweek(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();

		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}

		System.err.println("s12" + data);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 查看各部门个人月报表
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pemonthlist")
	public String pemonthlistUI(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户1" + id);
		model.addAttribute("deId", id);
		return Common.BACKGROUND_PATH + "/system/statistics/pemonthlist";
	}

	/**
	 * 查看各部门个人月报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findBypemonth")
	public Object findBypemonth(HttpServletRequest request, int draw, int start, int length) throws Exception {
		System.err.println("sdasdapp");
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));
		String ab = request.getParameter("choicemonth");
		String deId = request.getParameter("deId");
		if (ab == null || "".equals(ab)) {
			searchMap.put("choicemonth", new Date());
		} else {
			searchMap.put("choicemonth", ab + "-00");
		}
		searchMap.put("deId", deId);
		System.err.println("adsa" + searchMap);

		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsMapper.findpemonth(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		// StatisticsFormMap SumDeday = statisticsMapper.findSumDeday(searchMap);

		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}
		// data.add(SumDeday);
		System.err.println("s12" + data);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 网络部报表
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("internetlist")
	public String internetlistUI(Model model) throws Exception {

		return Common.BACKGROUND_PATH + "/system/statistics/internetlist";
	}

	/**
	 * 网络日报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findByinternextday")
	public Object findByinternextday(HttpServletRequest request, int draw, int start, int length) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));
		String ab = request.getParameter("choiceday");
		if (ab == null || "".equals(ab)) {
			searchMap.put("choiceday", new Date());
		} else {
			searchMap.put("choiceday", ab);
		}

		System.err.println(searchMap);

		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsservice.findSumInday(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();

		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}

		System.err.println("s12" + data);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 网络周报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findByinternextweek")
	public Object findByinternextweek(HttpServletRequest request, int draw, int start, int length) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();

		String departweek = request.getParameter("departweek");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if (week == 1) {
			week = 5;
		} else if (week == 2) {
			week = 6;
		} else {
			week = week - 3;
		}
		System.err.println("，阿达" + week);
		if (departweek.equals("1")) {
			searchMap.put("departweeke", new Date());
			cal.add(Calendar.DAY_OF_YEAR, -week);
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeks", reStr);
		} else if (departweek.equals("2")) {
			cal.add(Calendar.DAY_OF_YEAR, -week);
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeke", reStr);
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_YEAR, -(week + 7));
			Date dt2 = cal.getTime();
			String reStr2 = sdf.format(dt2);
			searchMap.put("departweeks", reStr2);
		} else {
			cal.add(Calendar.DAY_OF_YEAR, -(week + 7));
			Date dt1 = cal.getTime();
			String reStr = sdf.format(dt1);
			searchMap.put("departweeke", reStr);
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_YEAR, -(week + 14));
			Date dt2 = cal.getTime();
			String reStr2 = sdf.format(dt2);
			searchMap.put("departweeks", reStr2);
		}
		System.err.println("查询" + searchMap);

		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsservice.findSumInweek(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();

		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}

		System.err.println("s12" + data);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 网络月报表
	 *
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findByinternextmonth")
	public Object findByinternextmonth(HttpServletRequest request, int draw, int start, int length) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));
		String ab = request.getParameter("choicemonth");
		System.err.println("das" + ab);
		if (ab == null || "".equals(ab)) {
			searchMap.put("choicemonth", new Date());
		} else {
			searchMap.put("choicemonth", ab + "-00");
		}
		System.err.println(searchMap);

		PageHelper.startPage((start / length) + 1, length);
		List<StatisticsFormMap> p = statisticsservice.findSumInmonth(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();

		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}

		System.err.println("s13" + data);
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	;

	/**
	 * 个人周报表
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findBypersonweek")
	public Object findBypersonweek(HttpServletRequest request) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if (week == 1) {
			week = 5;
		} else if (week == 2) {
			week = 6;
		} else {
			week = week - 3;
		}
		System.err.println("，阿达" + week);

		searchMap.put("departweeke", new Date());
		cal.add(Calendar.DAY_OF_YEAR, -week);
		Date dt1 = cal.getTime();
		String reStr = sdf.format(dt1);
		searchMap.put("departweeks", reStr);
		System.err.println("，阿达" + searchMap);
		return null;

	}

	;

	/**
	 * 竞价报表
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("extensionUI")
	public String extensionUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/statistics/extension";
	}

	@ResponseBody
	@RequestMapping("findByExtension")
	public Object findByExtension(HttpServletRequest request, int draw, int start, int length) throws Exception {

		Map<String, Object> searchMap = new HashMap<String, Object>();

		String ab = request.getParameter("monthDate");
		if (ab == null || "".equals(ab)) {
			searchMap.put("monthDate", new Date());
		} else {
			searchMap.put("monthDate", ab + "-00");
		}
		System.err.println("查询32131" + searchMap);
		PageHelper.startPage((start / length) + 1, length);

		List<StatisticsFormMap> p = statisticsservice.findByExtension(searchMap);

		PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		for (StatisticsFormMap a : pageinfo.getList()) {

			data.add(a);

		}

		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	/**
	 * 具体来源
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sourceUI")
	public String sourceUI(Model model) {
		String createDate = getPara("createDate");
		System.err.println("项目1" +createDate);
		String format = "yyyy-MM-dd";

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String c=sdf.format(new Date(Long.valueOf(createDate)));
		model.addAttribute("createDate",c );

		return Common.BACKGROUND_PATH + "/system/statistics/source";
	}
	@ResponseBody
	@RequestMapping("Source")
	public Map<String, Object> Source(HttpServletRequest request) throws Exception {
		String createDate = getPara("createDate");


		System.out.println("DA1"+ createDate);
		Map<String, Object> source =statisticsservice.findSource(createDate);
		return source;
	}
	/**
	 * 添加报表
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/statistics/add";
	}

	@ResponseBody
	@RequestMapping("addOther")
	public Map<String, Object> addOther(HttpServletRequest request) throws Exception {
		String createDate=request.getParameter("createDate");
		System.err.println("SJ"+createDate);
		Map<String, Object> sourceMap=statisticsservice.findAddOther(createDate);
		int vis=statisticsservice.findVis(createDate);
		Map<String, Object> deaMap=statisticsservice.findDea(createDate);
		sourceMap.put("vis",vis);
		sourceMap.putAll(deaMap);
		System.err.println(sourceMap);
		System.out.println("ASD"+sourceMap);
		System.out.println("ASD"+vis);
		System.out.println("ASD"+deaMap);
		return sourceMap;
	}
    @ResponseBody
    @RequestMapping("addEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    public String addEntity() throws Exception {
        StatisticsFormMap  statisticsFormMap = getFormMap(StatisticsFormMap.class);
		System.out.println(statisticsFormMap);
        statisticsservice.addEntity( statisticsFormMap);
        return "success";
    }

}
