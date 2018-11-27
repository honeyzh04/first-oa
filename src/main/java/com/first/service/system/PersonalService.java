/**
 * 
 */
package com.first.service.system;

import com.first.entity.PersonalFormMap;

import java.util.Map;

/**
 * 个人主页
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年10月19日
   @version 1.00
 */

public interface PersonalService {
    /**
     *当天销售数据
     * @param searchMap
     * @return
     */
    PersonalFormMap finddayreport(Map searchMap);
    /**
     *当周销售数据
     * @param searchMap
     * @return
     */
    PersonalFormMap findweekreport(Map searchMap);
    /**
     *当月销售数据
     * @param searchMap
     * @return
     */
    PersonalFormMap findmonthreport(Map searchMap);

    /**
     * 查看日计划
     * @param searchMap
     * @return
     */
   PersonalFormMap finddayadd(Map searchMap);

    /**
     * 查看明日计划
     * @param searchMap
     * @return
     */
    PersonalFormMap findnextdayadd(Map searchMap);

    /**
     * 查看周计划
     * @param searchMap
     * @return
     */
    PersonalFormMap findweekadd(Map searchMap);

    /**
     * 查看月计划
     * @param searchMap
     * @return
     */
    PersonalFormMap findmonthadd(Map searchMap);
    /**
     * 查看部门日计划
     * @param searchMap
     * @return
     */
    PersonalFormMap finddedayadd(Map searchMap);

    /**
     * 查看部门明日计划
     * @param searchMap
     * @return
     */
    PersonalFormMap finddenextdayadd(Map searchMap);

    /**
     * 查看部门周计划
     * @param searchMap
     * @return
     */
    PersonalFormMap finddeweekadd(Map searchMap);

    /**
     * 查看部门月计划
     * @param searchMap
     * @return
     */
    PersonalFormMap finddemonthadd(Map searchMap);
    void addDayPlan(PersonalFormMap formMap);

    void addWeekPlan(PersonalFormMap formMap);

    void addMonthPlan(PersonalFormMap formMap);


    void adddeDayPlan(PersonalFormMap formMap);

    void adddeWeekPlan(PersonalFormMap formMap);

    void adddeMonthPlan(PersonalFormMap formMap);
    /**
     *当天部门销售数据
     * @param searchMap
     * @return
     */
    PersonalFormMap finddedayreport(Map searchMap);
    /**
     *当周部门销售数据
     * @param searchMap
     * @return
     */
    PersonalFormMap finddeweekreport(Map searchMap);
    /**
     *当月部门销售数据
     * @param searchMap
     * @return
     */
    PersonalFormMap finddemonthreport(Map searchMap);
}

