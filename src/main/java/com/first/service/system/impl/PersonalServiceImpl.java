/**
 *
 */
package com.first.service.system.impl;

import com.first.entity.PersonalFormMap;
import com.first.entity.StatisticsFormMap;
import com.first.mapper.HomeMapper;
import com.first.mapper.PersonalMapper;
import com.first.service.system.HomeService;
import com.first.service.system.PersonalService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
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
    public  PersonalFormMap finddayrepart(Map searchMap) {
        return personalMapper.finddayrepart(searchMap);
    }

    @Override
    public  PersonalFormMap findweekrepart(Map searchMap) {
        return personalMapper.findweekrepart(searchMap);
    }

    @Override
    public  PersonalFormMap findmonthrepart(Map searchMap) {
        return personalMapper.findmonthrepart(searchMap);
    }

    @Override
    public PersonalFormMap finddayadd(Map searchMap) {
        return personalMapper.finddayadd(searchMap);
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
}
	


	



