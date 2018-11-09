package com.first.mapper;

import com.first.entity.StatisticsFormMap;

import java.util.List;
import java.util.Map;

/**
 * 主页
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年10月19日
   @version 1.00
 */
public interface HomeMapper {


    /**
     * 本部门个人周报表
     * @return
     */
    public List<StatisticsFormMap> findpeweek(Map searchMapMap);


}
