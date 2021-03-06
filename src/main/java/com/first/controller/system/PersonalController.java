package com.first.controller.system;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.*;
import com.first.mapper.DepartMapper;
import com.first.mapper.UserMapper;
import com.first.service.system.PersonalService;
import com.first.service.system.StatisticsService;
import com.first.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Inject
    private DepartMapper departMapper;
    @Inject
    private StatisticsService statisticsservice;
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
        List<ResFormMap> resAll=findByRes();
       ResFormMap deadd =new ResFormMap();
        List<ResFormMap> reres=new ArrayList<ResFormMap>();
        if (resAll.size()==5){
            for(int i=0;i<resAll.size();i++){
                if (i==0||i==1){
                    reres.add(resAll.get(i));
                }

                deadd.put("deadd"+i,resAll.get(i));

            }
            model.addAttribute("reres", reres);
            model.addAttribute("deres", deadd);
        }else if (resAll!=null){
            model.addAttribute("reres", resAll);

        }




        model.addAttribute("personal", userFormMap);

        return Common.BACKGROUND_PATH + "/system/personal/list";
    }


    /**
     * 个人报表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("showPlan")
    @ResponseBody
    public  Map<String,PersonalFormMap> showPlan() throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();

        searchMap.put("createDate", new Date());
        searchMap.put("userId", getuserId());
        searchMap.put("nexteDate",DateUtil.getnNext());
        PersonalFormMap daylis = personalService.finddayadd(searchMap);
        PersonalFormMap daynextlis = personalService.findnextdayadd(searchMap);
        System.err.println("1"+daylis);
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1 = formater.format(new Date());
        Date date = formater.parse(date1);
        Date a = DateUtil.getThisWeekTuesday(date);
        Date b = DateUtil.getNextWeekTuesday(date);

        searchMap.put("screateDate", a);
        searchMap.put("ecreateDate", b);
        PersonalFormMap weeklis = personalService.findweekadd(searchMap);
        System.err.println("2"+weeklis);

        PersonalFormMap monthlis = personalService.findmonthadd(searchMap);

        System.err.println("3"+monthlis);
        Map<String,PersonalFormMap>  personalPlan= new HashMap<>();
        personalPlan.put("dayplan",daylis);
        personalPlan.put("nextplan",daynextlis);
        personalPlan.put("weekplan",weeklis);
        personalPlan.put("monthplan",monthlis);
        return personalPlan;
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
        searchMap.put("nexteDate",DateUtil.getnNext());
        PersonalFormMap daynextP = personalService.findnextdayadd(searchMap);
        PersonalFormMap daylisR = personalService.finddayreport(searchMap); //日数据
        System.err.println(daylisR);
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1 = formater.format(new Date());
        Date date = formater.parse(date1);
        Date a = DateUtil.getThisWeekTuesday(date);
        Date b = DateUtil.getNextWeekTuesday(date);
        searchMap.put("screateDate", a);
        searchMap.put("ecreateDate", b);
        PersonalFormMap weeklisP = personalService.findweekadd(searchMap); //周计划
        PersonalFormMap weeklisR = personalService.findweekreport(searchMap);//周数据
        System.err.println("2"+weeklisP);
        PersonalFormMap monthlisP = personalService.findmonthadd(searchMap);   //月计划
        PersonalFormMap monthlisR = personalService.findmonthreport(searchMap);//月数据

        model.addAttribute("personal", userFormMap);
        model.addAttribute("dayplan", daynextP);
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
     * 部门报表审核
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("dereportUI")
    public String dereportUI(HttpServletRequest request, Model model) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("createDate", new Date());
        searchMap.put("userId", getuserId());
        searchMap.put("deId", userFormMap.get("department"));
        searchMap.put("nexteDate",DateUtil.getnNext());

        String depar = userFormMap.get("department").toString();
        int depId = Integer.parseInt(depar);
        List<DepartmentFormMap> departmentFormMap = departMapper.getDepart();
        List<String> idss = new ArrayList<>();
        TreeUtil.treeMenuList(idss,departmentFormMap, depId);
        idss.add(depar);
        searchMap.put("departments", idss);

        PersonalFormMap daynextP = personalService.finddenextdayadd(searchMap);
        PersonalFormMap daylisR = personalService.finddedayreport(searchMap); //日数据
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1 = formater.format(new Date());
        Date date = formater.parse(date1);
        Date a = DateUtil.getThisWeekTuesday(date);
        Date b = DateUtil.getNextWeekTuesday(date);
        searchMap.put("screateDate", a);
        searchMap.put("ecreateDate", b);
        PersonalFormMap weeklisP = personalService.finddeweekadd(searchMap); //周计划
        PersonalFormMap weeklisR = personalService.finddeweekreport(searchMap);//周数据
        System.err.println("周数据"+ weeklisR);
        PersonalFormMap monthlisP = personalService.finddemonthadd(searchMap);   //月计划
        PersonalFormMap monthlisR = personalService.finddemonthreport(searchMap);//月数据
        System.err.println("月数据"+monthlisR);

        model.addAttribute("dayplan", daynextP);
        model.addAttribute("weekplan", weeklisP);
        model.addAttribute("monthplan", monthlisP);
        model.addAttribute("personal", userFormMap);
        model.addAttribute("dayreality", daylisR);
        model.addAttribute("weekreality", weeklisR);
        model.addAttribute("monthreality", monthlisR);


        return Common.BACKGROUND_PATH + "/system/personal/dereport";
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
    @SystemLog(module = "计划制定", methods = "计划制定-部门日计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String dayadd() throws Exception {
        getuserId();
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        personalFormMap.put("userId", getuserId());
        personalService.addDayPlan(personalFormMap);
        return  "success";
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
            Date a = DateUtil.getThisWeekTuesday(date);
            Date b = DateUtil.getNextWeekTuesday(date);

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
     * 添加部门日计划
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("dedayaddUI")
    public String dedayaddUI(HttpServletRequest request, Model model) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        model.addAttribute("userFormMap", userFormMap);
        System.err.println(userFormMap);
        return Common.BACKGROUND_PATH + "/system/personal/dedayadd";
    }

    @RequestMapping("dedayadd")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-部门日计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String dedayadd() throws Exception {
        getuserId();
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        System.err.println("部门日计划");
        personalFormMap.put("userId", getuserId());
        personalService.adddeDayPlan(personalFormMap);
        return "success";
    }

    /**
     * 添加部门周计划
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("deweekaddUI")
    public String deweekaddUI(HttpServletRequest request, Model model) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        model.addAttribute("userFormMap", userFormMap);
        return Common.BACKGROUND_PATH + "/system/personal/deweekadd";
    }
    @RequestMapping("deweekadd")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-部门周计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deweekadd() throws Exception {
        getuserId();
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        System.err.println("部门周计划");
        personalFormMap.put("userId", getuserId());
        personalService.adddeWeekPlan(personalFormMap);
        return "success";
    }

    /**
     * 添加部门月计划
     *
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("demonthaddUI")
    public String demonthaddUI(HttpServletRequest request, Model model) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        model.addAttribute("userFormMap", userFormMap);
        return Common.BACKGROUND_PATH + "/system/personal/demonthadd";
    }

    @RequestMapping("demonthadd")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-部门月计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String demonthadd() throws Exception {
        getuserId();
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        System.err.println("部门月计划");
        personalFormMap.put("userId", getuserId());
        personalService.adddeMonthPlan(personalFormMap);
        return "success";

    }

    /**
     * 验证部门计划是否存在
     *
     * @param
     * @return
     */
    @RequestMapping("deisExist")
    @ResponseBody
    public boolean deisExist(String createDate,String deId, String type) throws Exception {
        System.err.println("部门验证"+type);
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("createDate", createDate);
        searchMap.put("deId", deId);
        PersonalFormMap lis = null;
        System.err.println("部门验证1"+searchMap);
        if (type.equals("dedayadd")) {
            lis = personalService.finddedayadd(searchMap);
        } else if (type.equals("deweekadd")) {
            SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
            String date1 = formater.format(new Date());
            Date date = formater.parse(date1);
            Date a = DateUtil.getThisWeekTuesday(date);
            Date b = DateUtil.getNextWeekTuesday(date);
            searchMap.put("screateDate", a);
            searchMap.put("ecreateDate", b);
            lis = personalService.finddeweekadd(searchMap);
        } else if (type.equals("demonthadd")) {
            lis = personalService.finddemonthadd(searchMap);

        }

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

    /**
     * 发送微信
     * @return
     * @throws Exception
     */
    @RequestMapping("sendWeChat")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-发送计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String sendWeChat(String corpsecret, String agentid,String info) throws Exception {
        String success="";
        System.err.println("发送微信");
        SendWeChat sendWeChat=new SendWeChat();
        List<String> b= SplitString.getStrList(info,600);

        for(String c:b){
            boolean is_send = sendWeChat.send_info(corpsecret, agentid,c);
            if (is_send){
                success= "success";
            }else {
                success= "0";
            }
        }

       return  success;

    }

    /**
     * 定时发送微信
     */
      @Scheduled(cron = "0 30 22 * * ? ")
    public void delayedSendWeChat () {
        try {
            personalService.delayedSendWeChat();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    /**
     * 个人业绩
     * @return
     * @throws Exception
     */
    @RequestMapping("perfUI")
    public String perfUI() {
        return Common.BACKGROUND_PATH + "/system/personal/perflist";
    }


    @ResponseBody
    @RequestMapping("peDealPerformance")
    public Object  peDealPerformance(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("customerName", request.getParameter("customerName"));
        searchMap.put("telephone", request.getParameter("telephone"));
        searchMap.put("screateDate", request.getParameter("screateDate"));
        searchMap.put("ecreateDate", request.getParameter("ecreateDate"));
        searchMap.put("userId",getuserId());
        PageHelper.startPage((start / length) + 1, length);
        List<HashMap> p = personalService.peDealPerformance(searchMap);
        PageInfo<HashMap> pageinfo = new PageInfo<HashMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (HashMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);

        return map;
    }

    /**
     * 个人当月每天数据
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findPedays")
    public List  findPedays() throws Exception {

       String userId=getuserId();

        List<StatisticsFormMap> p =statisticsservice.findPedays(userId);

        return p;
    }


    /**
     * 个人当周每天数据
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findPeweeks")
    public List  findPeweeks() throws Exception {
        HashMap searchMap= new HashMap();
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1 = formater.format(new Date());

        Date date = formater.parse(date1);
        Date a = DateUtil.getThisWeekTuesday(date);
        Date b = DateUtil.getNextWeekTuesday(date);
        searchMap.put("departweeks", a);
        searchMap.put("departweeke", b);
        searchMap.put("userId",getuserId());
        List<StatisticsFormMap> p =statisticsservice.findPeweeks(searchMap);
        System.err.println(p);

        return p;
    }
}
