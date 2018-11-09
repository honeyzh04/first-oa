/**
 * 
 */
package com.first.service.system;

import com.first.entity.StatisticsFormMap;

import java.util.List;
import java.util.Map;

/**
 * 主页展示
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年10月19日
   @version 1.00
 */

public interface HomeService {
    /**
     * 查看本部门周报表
     * @param searchMap
     * @return
     */
    List<StatisticsFormMap> findpeweek(Map searchMap);
}

