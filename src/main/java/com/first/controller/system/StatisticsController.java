package com.first.controller.system;

import com.first.controller.index.BaseController;
import com.first.entity.StatisticsFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.DepartMapper;
import com.first.mapper.StatisticsMapper;
import com.first.service.system.StatisticsService;
import com.first.util.Common;
import com.first.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 客户报表统计 Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年6月26日
 */
@Controller
@RequestMapping("/statistics/")
public class StatisticsController extends BaseController {
    @Inject
    private StatisticsMapper statisticsMapper;
    @Inject
    private DepartMapper departMapper;
    @Inject
    private StatisticsService statisticsservice;

    /**
     * 获取销售部门
     */
    public    List<String> getdeIds(){
        List<String> deIds=departMapper.getcudeId();
        return deIds;
    }

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

        searchMap.put("deIds",getdeIds());
        PageHelper.startPage((start / length) + 1, length);
        List<StatisticsFormMap> p = statisticsMapper.findDeday(searchMap); //部门日报表

        PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        StatisticsFormMap SumDeday = statisticsMapper.findSumDeday(searchMap);



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



    private Map<String, Object> getWeek(String departweek){
        Map<String, Object> searchMap = new HashMap<String, Object>();
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

        return searchMap;
    }

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

        searchMap.putAll(getWeek(departweek));
        searchMap.put("deIds",getdeIds());
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

        if (ab == null || "".equals(ab)) {
            searchMap.put("choicemonth", new Date());
        } else {
            searchMap.put("choicemonth", ab + "-00");
        }
        searchMap.put("deIds",getdeIds());

        PageHelper.startPage((start / length) + 1, length);
        List<StatisticsFormMap> p = statisticsMapper.findDemonth(searchMap);

        PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        StatisticsFormMap SumDemonth = statisticsMapper.findSumDemonth(searchMap);
        for (StatisticsFormMap a : pageinfo.getList()) {

            data.add(a);

        }
        data.add(SumDemonth);

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
        searchMap.putAll(getWeek(departweek));

        searchMap.put("deId", deId);


        PageHelper.startPage((start / length) + 1, length);
        List<StatisticsFormMap> p = statisticsMapper.findpeweek(searchMap);

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


        PageHelper.startPage((start / length) + 1, length);
        List<StatisticsFormMap> p = statisticsservice.findSumInday(searchMap);

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

        searchMap.putAll(getWeek(departweek));

        PageHelper.startPage((start / length) + 1, length);
        List<StatisticsFormMap> p = statisticsservice.findSumInweek(searchMap);

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

        if (ab == null || "".equals(ab)) {
            searchMap.put("choicemonth", new Date());
        } else {
            searchMap.put("choicemonth", ab + "-00");
        }


        PageHelper.startPage((start / length) + 1, length);
        List<StatisticsFormMap> p = statisticsservice.findSumInmonth(searchMap);

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


        searchMap.put("departweeke", new Date());
        cal.add(Calendar.DAY_OF_YEAR, -week);
        Date dt1 = cal.getTime();
        String reStr = sdf.format(dt1);
        searchMap.put("departweeks", reStr);

        return null;

    }



    /**
     * 竞价日报表
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

        String format = "yyyy-MM-dd";

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String c = sdf.format(new Date(Long.valueOf(createDate)));

        model.addAttribute("createDate", c);

        return Common.BACKGROUND_PATH + "/system/statistics/source";
    }

    @ResponseBody
    @RequestMapping("Source")
    public Map<String, Object> Source(HttpServletRequest request) throws Exception {
        String createDate = getPara("createDate");



        Map<String, Object> source = statisticsservice.findSource(createDate);
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
        String createDate = request.getParameter("createDate");

        Map<String, Object> sourceMap = statisticsservice.findAddOther(createDate);
        int vis = statisticsservice.findVis(createDate);
        Map<String, Object> deaMap = statisticsservice.findDea(createDate);
        sourceMap.put("vis", vis);
        sourceMap.putAll(deaMap);

        return sourceMap;
    }

    @ResponseBody
    @RequestMapping("addEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    public String addEntity() throws Exception {
        StatisticsFormMap statisticsFormMap = getFormMap(StatisticsFormMap.class);

        statisticsservice.addEntity(statisticsFormMap);
        return "success";
    }


    /**
     * 竞价周报表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("weekextensionUI")
    public String weekExtensionUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/statistics/weekextension";
    }

    @ResponseBody
    @RequestMapping("findByWeekExtension")
    public Object findByWeekExtension(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        String screateDate = request.getParameter("screateDate");
        String ecreateDate = request.getParameter("ecreateDate");
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1= formater.format(new Date());
        Date date = formater.parse( date1);
        if (screateDate == null || "".equals(screateDate)) {
           Date a= DateUtil.geLastWeekTuesday(date);

            searchMap.put("screateDate", a);
        } else {
            searchMap.put("screateDate", screateDate);
        }
        if (ecreateDate == null || "".equals(ecreateDate)) {
            Date b= DateUtil.getThisWeekTuesday(date);
            searchMap.put("ecreateDate", b);

        } else {
            searchMap.put("ecreateDate", ecreateDate);
        }


        PageHelper.startPage((start / length) + 1, length);
        List<StatisticsFormMap> p = statisticsMapper.findWeekExtension(searchMap); //周竞价数据
        PageInfo<StatisticsFormMap> pageinfo = new PageInfo<StatisticsFormMap>(p);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (StatisticsFormMap a : pageinfo.getList()) {

            data.add(a);

        }
        StatisticsFormMap SumDeday = statisticsMapper.findWeekSum(searchMap);//查看周报表和
        if (SumDeday.get("consume") != null) {



            List<StatisticsFormMap> weekDeal = statisticsservice.findWeekDeal(searchMap);//房发现成交周报表

            for (StatisticsFormMap c : weekDeal) {
                SumDeday.put("dea" + c.get("department"), c.get("dea"));

		/*	for (Map.Entry entry : c.entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
			for (Object value : c.values()) {
				System.out.println("Value = " + value);
			}*/
            }
            List<StatisticsFormMap> weekVisit = statisticsservice.findWeekVisit(searchMap);//房发现带访周报表
            for (StatisticsFormMap c : weekVisit) {
                SumDeday.put("visit" + c.get("department"), c.get("visit"));
            }

            List<StatisticsFormMap> weekAdds = statisticsservice.findWeekAdds(searchMap);// 房发现新增周报表
            for (StatisticsFormMap c : weekAdds) {
                SumDeday.put("adds" + c.get("department"), c.get("adds"));
            }

            StatisticsFormMap weekFilter = statisticsservice.findWeekFilter(searchMap);//去重新增

            SumDeday.put("filter_add", weekFilter.get("filter_add"));
            SumDeday.put("filter_visit", weekFilter.get("filter_visit"));
            SumDeday.put("filter_deal", weekFilter.get("filter_deal"));
            SumDeday.put("commission", weekFilter.get("commission"));

            double consume = Double.parseDouble(SumDeday.get("consume").toString());

            double fiadd = Double.parseDouble(weekFilter.get("filter_add").toString());

            SumDeday.put("cost1", String.format("%.2f", consume / fiadd));

            StatisticsFormMap weekRefund = statisticsservice.findWeekRefund(searchMap);// 退单周报表

            SumDeday.put("commissionr", weekRefund.get("commission"));
            System.err.println(SumDeday);

            data.add(SumDeday);

        }



        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);

        return map;
    }

    /**
     * 添加周报表
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addwUI")
    public String addwUI(Model model) throws Exception {
        return Common.BACKGROUND_PATH + "/system/statistics/addweek";
    }

    @ResponseBody
    @RequestMapping("addWeekReports")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    public String addWeekReports() throws Exception {
        StatisticsFormMap statisticsFormMap = getFormMap(StatisticsFormMap.class);
        statisticsFormMap.put("create_date", new Date());
        statisticsservice.addWeekReport(statisticsFormMap);
        return "success";
    }
    /**
     * 个人当月每天数据
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findDedays")
    public List  findDedays() throws Exception {

        List<StatisticsFormMap> p =statisticsservice.findDedays();

        return p;
    }
}
