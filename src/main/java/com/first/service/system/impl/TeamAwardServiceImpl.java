/**
 *
 */
package com.first.service.system.impl;

import com.first.entity.StatisticsFormMap;
import com.first.entity.TeamAwardFormMap;
import com.first.mapper.HomeMapper;
import com.first.mapper.TeamAwardMapper;
import com.first.service.system.HomeService;
import com.first.service.system.TeamAwardService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年10月19日
 */
@Service
public class TeamAwardServiceImpl implements TeamAwardService {
    @Inject
    private TeamAwardMapper teamAwardMapper;
    @Override
    public List<TeamAwardFormMap> findTeam(Map searchMap) {

            return teamAwardMapper.findTeam(searchMap);
    }

    @Override
    public void addAward(Map searchMap) {
        teamAwardMapper.addAward(searchMap);
    }
}
	


	



