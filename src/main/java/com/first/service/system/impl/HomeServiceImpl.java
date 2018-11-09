/**
 *
 */
package com.first.service.system.impl;

import com.first.entity.StatisticsFormMap;
import com.first.mapper.HomeMapper;
import com.first.service.system.HomeService;
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
public class HomeServiceImpl implements HomeService {
    @Inject
    private HomeMapper homeMapper;
    @Override
    public List<StatisticsFormMap> findpeweek(Map searchMap) {
        return homeMapper.findpeweek(searchMap);
    }
}
	


	



