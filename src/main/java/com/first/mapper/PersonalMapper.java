package com.first.mapper;

import com.first.entity.PersonalFormMap;
import com.first.entity.StatisticsFormMap;

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
    public PersonalFormMap finddayrepart(Map searchMapMap);
    /**
     * 当周销售数据
     * @param searchMapMap
     * @return
     */
    public  PersonalFormMap findweekrepart(Map searchMapMap);
    /**
     * 当月销售数据
     * @param searchMapMap
     * @return
     */
    public  PersonalFormMap findmonthrepart(Map searchMapMap);
    /**
     * 查看日计划
     * @param searchMapMap
     * @return
     */
    public PersonalFormMap finddayadd(Map searchMapMap);

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

    void addDayPlan(PersonalFormMap formMap);
    void addWeekPlan(PersonalFormMap formMap);
    void addMonthPlan(PersonalFormMap formMap);
}
