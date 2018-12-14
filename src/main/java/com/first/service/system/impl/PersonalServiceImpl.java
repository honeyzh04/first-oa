/**
 *
 */
package com.first.service.system.impl;

import com.first.entity.DepartmentFormMap;
import com.first.entity.PersonalFormMap;
import com.first.mapper.DepartMapper;
import com.first.mapper.PersonalMapper;
import com.first.service.system.PersonalService;
import com.first.util.DateUtil;
import com.first.util.SendWeChat;
import com.first.util.TreeUtil;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年10月19日
 */
@Service
public class PersonalServiceImpl implements PersonalService {
    @Inject
    private PersonalMapper personalMapper;
    @Inject
    private DepartMapper departMapper;

    @Override
    public  PersonalFormMap finddayreport(Map searchMap) {
        return personalMapper.finddayreport(searchMap);
    }

    @Override
    public  PersonalFormMap findweekreport(Map searchMap) {
        return personalMapper.findweekreport(searchMap);
    }

    @Override
    public  PersonalFormMap findmonthreport(Map searchMap) {
        return personalMapper.findmonthreport(searchMap);
    }

    @Override
    public PersonalFormMap finddayadd(Map searchMap) {
        return personalMapper.finddayadd(searchMap);
    }

    @Override
    public PersonalFormMap findnextdayadd(Map searchMap) {
        return personalMapper.findnextdayadd(searchMap);
    }

    @Override
    public PersonalFormMap findweekadd(Map searchMap) {
        return personalMapper.findweekadd(searchMap);
    }

    @Override
    public PersonalFormMap findmonthadd(Map searchMap) {
        return personalMapper.findmonthadd(searchMap);
    }

    @Override
    public PersonalFormMap finddedayadd(Map searchMap) {

            return personalMapper.finddedayadd(searchMap);
    }

    @Override
    public PersonalFormMap finddenextdayadd(Map searchMap) {
        return personalMapper.finddenextdayadd(searchMap);
    }

    @Override
    public PersonalFormMap finddeweekadd(Map searchMap) {
        return personalMapper.finddeweekadd(searchMap);
    }

    @Override
    public PersonalFormMap finddemonthadd(Map searchMap) {
        return personalMapper.finddemonthadd(searchMap);
    }

    @Override
    public void addDayPlan(PersonalFormMap formMap) {
        personalMapper.addDayPlan(formMap);
    }

    @Override
    public void addWeekPlan(PersonalFormMap formMap) {
        personalMapper.addWeekPlan(formMap);
    }

    @Override
    public void addMonthPlan(PersonalFormMap formMap) {
        personalMapper.addMonthPlan(formMap);
    }

    @Override
    public void adddeDayPlan(PersonalFormMap formMap) {
        personalMapper.adddeDayPlan(formMap);
    }

    @Override
    public void adddeWeekPlan(PersonalFormMap formMap) {
        personalMapper.adddeWeekPlan(formMap);
    }

    @Override
    public void adddeMonthPlan(PersonalFormMap formMap) {
            personalMapper.adddeMonthPlan(formMap);
    }

    @Override
    public PersonalFormMap finddedayreport(Map searchMap) {
        return personalMapper.finddedayreport(searchMap);
    }
    @Override
    public PersonalFormMap finddeweekreport(Map searchMap) {
        return personalMapper.finddeweekreport(searchMap);
    }
    @Override
    public PersonalFormMap finddemonthreport(Map searchMap) {
        return personalMapper.finddemonthreport(searchMap);
    }

    @Override
    public void delayedSendWeChat () throws ParseException {
       // String info = "消息内容\n第二行内容\n第三行内容"; //消息体内容
        String corpsecret = "48rFxvrkK_2gVzQ3Uwvlg9aPAbd7nPM2JiqVEzfn18g"; //部门应用id
        String agentid = "1000020";//部门分组id
        System.err.println("定时任务");
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("userId","1");
        String depar ="1";
        int depId = Integer.parseInt(depar);
        List<DepartmentFormMap> departmentFormMap = departMapper.getDepart();
        List<String> idss = new ArrayList<>();
        TreeUtil.treeMenuList(idss,departmentFormMap, depId);
        idss.add(depar);
        searchMap.put("departments", idss);
        PersonalFormMap daylisR = finddedayreport(searchMap); //日数据
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1 = formater.format(new Date());
        Date date = formater.parse(date1);
        Date a = DateUtil.getThisWeekTuesday(date);
        Date b = DateUtil.getNextWeekTuesday(date);
        searchMap.put("screateDate", a);
        searchMap.put("ecreateDate", b);

        PersonalFormMap weeklisR = finddeweekreport(searchMap);//周数据

        PersonalFormMap monthlisR = finddemonthreport(searchMap);//月数据

        String info = "公司日报表\n\n"+  date1 + "工作情况：\n新增总数：" +daylisR.get("addw") + "组,\n电话新增："  +daylisR.get("adddh") + "组,\n网络新增："  +daylisR.get("addwl") + "(安居客：" +daylisR.get("addwla") + "，58：" +daylisR.get("addwl5") + "，房发现：" +daylisR.get("addwlf") + ")组,\n其他新增："  +daylisR.get("addqt") +
                "组,\n今日带看数："+daylisR.get("visit") + "组,\n今天带看项目：" +daylisR.get("visitproject") + ",\n今日成交价格："  +daylisR.get("price") + "万元,\n今日成交佣金：" +daylisR.get("commission") + "万元,\n今天成交项目："  +daylisR.get("dealproject") + "\n\n" +
                "本周工作情况：\n新增总数："+weeklisR.get("addw") +"组,\n网络新增："+weeklisR.get("addwl") + "(安居客：" +weeklisR.get("addwla") + "，58：" +weeklisR.get("addwl5") + "，房发现：" +weeklisR.get("addwlf") + ")组;\n到访项目：" +weeklisR.get("visit") +
                "组,\n成交佣金："+weeklisR.get("commission") + "万元,\n成交价格："+weeklisR.get("price") + "万元,\n成交详情："+weeklisR.get("dealproject") + ";\n \n本月工作情况：\n新增总数：" +monthlisR.get("addw") + "组,\n网络新增：" +monthlisR.get("addwl") +
                "(安居客：" +monthlisR.get("addwla") + "，58：" +monthlisR.get("addwl5") + "，房发现：" +monthlisR.get("addwlf")+")组;\n到访项目：" +monthlisR.get("addwlf") + "组,\n成交佣金：" +monthlisR.get("commission") + "万元\n成交价格：" + monthlisR.get("price") + "万元,\n成交详情：" + monthlisR.get("dealproject");


        SendWeChat sendWeChat=new SendWeChat();
        boolean is_send = sendWeChat.send_info(corpsecret, agentid,info);
        if (is_send){
            System.err.println("发送成功");
        }else {
            System.err.println("发送失败");
        }
    }
}
	


	



