package com.first.shiro.filter;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import com.first.entity.UserFormMap;
import com.first.mapper.UserMapper;
/**
 * url模式过滤的功能
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月25日
   @version 1.00
 */

public class SysUserFilter extends PathMatchingFilter {

	@Inject
	private UserMapper userMapper;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        UserFormMap userFormMap = new UserFormMap();
		userFormMap.put("accountName", "" + username + "");
        request.setAttribute("user", userMapper.findByNames(userFormMap));
        return true;
    }
}