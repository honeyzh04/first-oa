package com.first.mapper;

import com.first.entity.TeamAwardFormMap;

import java.util.List;
import java.util.Map;

/**
 * 战队奖励
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年10月19日
   @version 1.00
 */
public interface TeamAwardMapper {


    /**
     * 查看战队列表
     * @return
     */
    public List<TeamAwardFormMap> findTeam(Map searchMapMap);

   void  addAward(Map searchMapMap);
}
