package com.first.controller.system;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.PersonalFormMap;
import com.first.entity.StatisticsFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.UserMapper;
import com.first.service.system.PersonalService;
import com.first.util.Common;
import com.first.util.DateWeek;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 个人信息展示
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年7月3日
 */
@Controller
@RequestMapping("/personal/")
public class PersonalController extends BaseController {
    @Inject
    private UserMapper userMapper;
    @Inject
    private PersonalService personalService;

    /**
     * 个人主页展示
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public String listUI(HttpServletRequest request, Model model) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("createDate", new Date());
        searchMap.put("userId", getuserId());
        PersonalFormMap daylis = personalService.finddayadd(searchMap);
        System.err.println("1"+daylis);


        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1 = formater.format(new Date());
        Date date = formater.parse(date1);
        Date a = DateWeek.getThisWeekTuesday(date);
        Date b = DateWeek.getNextWeekTuesday(date);

        searchMap.put("screateDate", a);
        searchMap.put("ecreateDate", b);
        PersonalFormMap weeklis = personalService.findweekadd(searchMap);
        System.err.println("2"+weeklis);

        PersonalFormMap monthlis = personalService.findmonthadd(searchMap);
        System.err.println("3"+monthlis);


        model.addAttribute("res", findByRes());
        model.addAttribute("personal", userFormMap);
        model.addAttribute("dayplan", daylis);
        model.addAttribute("weekplan", weeklis);
        model.addAttribute("monthplan", monthlis);
        return Common.BACKGROUND_PATH + "/system/personal/list";
    }

    /**
     * 个人周报表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("weekstatistics")
    @ResponseBody
    public Object weekstatistics() throws Exception {
        getuserId();

        return null;
    }

    /**
     * 个人报表审核
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("pereportUI")
    public String pereportUI(HttpServletRequest request, Model model) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("createDate", new Date());
        searchMap.put("userId", getuserId());
        PersonalFormMap daylisP = personalService.finddayadd(searchMap);//日计划
        PersonalFormMap daylisR = personalService.finddayrepart(searchMap); //日数据

        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1 = formater.format(new Date());
        Date date = formater.parse(date1);
        Date a = DateWeek.getThisWeekTuesday(date);
        Date b = DateWeek.getNextWeekTuesday(date);
        searchMap.put("screateDate", a);
        searchMap.put("ecreateDate", b);
        PersonalFormMap weeklisP = personalService.findweekadd(searchMap); //周计划
        PersonalFormMap weeklisR = personalService.findweekrepart(searchMap);//周数据
        System.err.println("2"+weeklisP);
        PersonalFormMap monthlisP = personalService.findmonthadd(searchMap);   //月计划
        PersonalFormMap monthlisR = personalService.findmonthrepart(searchMap);//月数据

        model.addAttribute("personal", userFormMap);
        model.addAttribute("dayplan", daylisP);
        model.addAttribute("weekplan", weeklisP);
        model.addAttribute("monthplan", monthlisP);
        model.addAttribute("dayreality", daylisR);
        model.addAttribute("weekreality", weeklisR);
        model.addAttribute("monthreality", monthlisR);

        return Common.BACKGROUND_PATH + "/system/personal/pereport";
    }

    @RequestMapping("pereport")
    @ResponseBody
    public Object pereport() throws Exception {
        getuserId();

        return null;
    }

    /**
     * 修改密码
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("updatePassword")
    public String updatePasswordUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/personal/updatePassword";
    }

    /**
     * 添加个人日计划
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("dayaddUI")
    public String dayaddUI(HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("userName", getuserName());
        return Common.BACKGROUND_PATH + "/system/personal/dayadd";
    }

    @RequestMapping("dayadd")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-日计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String dayadd() throws Exception {
        getuserId();
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        System.err.println(personalFormMap);
        personalFormMap.put("userId", getuserId());
        personalService.addDayPlan(personalFormMap);
        return "success";
    }

    /**
     * 添加个人周计划
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("weekaddUI")
    public String weekaddUI(HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("userName", getuserName());
        return Common.BACKGROUND_PATH + "/system/personal/weekadd";
    }

    @RequestMapping("weekadd")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-周计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String weekadd() throws Exception {
        getuserId();
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        System.err.println(personalFormMap);
        personalFormMap.put("userId", getuserId());
        personalService.addWeekPlan(personalFormMap);
        return "success";
    }

    /**
     * 添加个人月计划
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("monthaddUI")
    public String monthaddUI(HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("userName", getuserName());
        return Common.BACKGROUND_PATH + "/system/personal/monthadd";
    }

    @RequestMapping("monthadd")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-月计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String monthadd() throws Exception {
        getuserId();
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        System.err.println(personalFormMap);
        personalFormMap.put("userId", getuserId());
        personalService.addMonthPlan(personalFormMap);
        return "success";

    }

    /**
     * 验证计划是否存在
     *
     * @param
     * @return
     */
    @RequestMapping("isExist")
    @ResponseBody
    public boolean isExist(String createDate, String type) throws Exception {

        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("createDate", createDate);
        searchMap.put("userId", getuserId());
        PersonalFormMap lis = null;

        if (type.equals("dayadd")) {
            lis = personalService.finddayadd(searchMap);
            System.err.println("31" + lis);
        } else if (type.equals("weekadd")) {
            SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
            String date1 = formater.format(new Date());
            Date date = formater.parse(date1);
            Date a = DateWeek.getThisWeekTuesday(date);
            Date b = DateWeek.getNextWeekTuesday(date);

            searchMap.put("screateDate", a);
            searchMap.put("ecreateDate", b);
            lis = personalService.findweekadd(searchMap);
            System.err.println("123" + lis);
        } else if (type.equals("monthadd")) {
            lis = personalService.findmonthadd(searchMap);
            System.err.println("1234" + lis);
        }
        System.err.println("3" + lis);
        if (lis == null) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 电视个人形象展示接口
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("shows")
    @ResponseBody
    public Object shows(String callback) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        List<UserFormMap> p = userMapper.findshows();


        /*JSONObject json = new JSONObject();*/
        searchMap.put("shows", p);
		/*String a=JSONArray.fromObject( searchMap).toString();
		System.err.println("DSAsa"+a);*/
        if (callback == null || callback.equals("")) {
            callback = "callback";
        }
        JSONPObject jsonpObject = new JSONPObject(callback, searchMap);
        return jsonpObject;
    }
}
