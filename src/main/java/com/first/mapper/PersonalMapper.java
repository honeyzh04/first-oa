package com.first.mapper;

import com.first.entity.PersonalFormMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
     *个人主页
     * @ClassName:      PersonalMapper
     * @Description:
     * @Author:         zhaoh
     * @CreateDate:     2018/11/14 18:05
     * @UpdateDate:     2018/11/14 18:05
     * @Version:        1.0
     */
public interface PersonalMapper {


    /**
     * 当天销售数据
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap finddayreport(Map searchMapMap);


    /**
     * 当周销售数据
     * @param searchMapMap
     * @return
     */
    public  PersonalFormMap findweekreport(Map searchMapMap);
    /**
     * 当月销售数据
     * @param searchMapMap
     * @return
     */
    public  PersonalFormMap findmonthreport(Map searchMapMap);
    /**
     * 查看日计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap finddayadd(Map searchMapMap);
    /**
     * 查看明日日计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap findnextdayadd(Map searchMapMap);
    /**
     * 查看周计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap findweekadd(Map searchMapMap);
    /**
     * 查看月计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap findmonthadd(Map searchMapMap);
    /**
     * 查看部门日计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap finddedayadd(Map searchMapMap);
    /**
     * 查看部门明日日计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap finddenextdayadd(Map searchMapMap);

    /**
     * 查看部门周计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap finddeweekadd(Map searchMapMap);
    /**
     * 查看部门月计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap finddemonthadd(Map searchMapMap);
    void addDayPlan(PersonalFormMap formMap);
    void addWeekPlan(PersonalFormMap formMap);
    void addMonthPlan(PersonalFormMap formMap);
    void adddeDayPlan(PersonalFormMap formMap);
    void adddeWeekPlan(PersonalFormMap formMap);
    void adddeMonthPlan(PersonalFormMap formMap);
    /**
     * 当日部门销售数据
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap  finddedayreport(Map searchMapMap);
    /**
     * 当周部门销售数据
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap  finddeweekreport(Map searchMapMap);
    /**
     * 当月部门销售数据
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap  finddemonthreport(Map searchMapMap);
    /**
     * 当周所有销售数据
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap  findallweekreport(Map searchMapMap);
    /**
     * 当月所有销售数据
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap  findallmonthreport(Map searchMapMap);


    /**
     * 当天所有销售数据
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap  findalldayreport(Map searchMapMap);

    /**
     * 查看所有明日日计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap findallnextdayadd(Map searchMapMap);

    /**
     * 查看个人成交业绩
     * @param searchMapMap
     * @return
     */
    List<HashMap> peDealPerformance(Map searchMapMap);

}
