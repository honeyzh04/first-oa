/**
 *
 */
package com.first.service.system.impl;

import com.first.entity.CustomerFormMap;
import com.first.mapper.FFXAppMapper;
import com.first.service.system.FFXAppService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年10月10日
 */
@Service
public class FFXAppServiceImpl implements FFXAppService {
    @Inject
    private FFXAppMapper ffxAppMapper;


    @Override
    public List<CustomerFormMap> findCustomerPage(Map searchMapMap) {
        return ffxAppMapper.findCustomerPage(searchMapMap);
    }
}
	


	



