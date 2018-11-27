/**
 * 
 */
package com.first.service.system;

import com.first.entity.TeamAwardFormMap;

import java.util.List;
import java.util.Map;

/**
 * 战队展示
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年10月19日
   @version 1.00
 */

public interface TeamAwardService {
    /**
     * 查看战队展示
     * @param searchMap
     * @return
     */
    List<TeamAwardFormMap> findTeam(Map searchMap);

    void addAward(Map searchMap);
}

