/**
 * 
 */
package com.first.service.system;

import com.first.entity.PersonalFormMap;
import com.first.entity.StatisticsFormMap;

import java.util.List;
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
    PersonalFormMap finddayrepart(Map searchMap);
    /**
     *当周销售数据
     * @param searchMap
     * @return
     */
    PersonalFormMap findweekrepart(Map searchMap);
    /**
     *当月销售数据
     * @param searchMap
     * @return
     */
    PersonalFormMap findmonthrepart(Map searchMap);

    /**
     * 查看日计划
     * @param searchMap
     * @return
     */
   PersonalFormMap finddayadd(Map searchMap);

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

    void addDayPlan(PersonalFormMap formMap);

    void addWeekPlan(PersonalFormMap formMap);

    void addMonthPlan(PersonalFormMap formMap);


}

