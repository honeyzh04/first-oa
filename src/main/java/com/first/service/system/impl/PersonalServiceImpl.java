/**
 *
 */
package com.first.service.system.impl;

import com.first.entity.PersonalFormMap;
import com.first.mapper.PersonalMapper;
import com.first.service.system.PersonalService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Map;

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
}
	


	



