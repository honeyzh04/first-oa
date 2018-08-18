package com.first.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.controller.index.BaseController;
import com.first.entity.UserLoginFormMap;
import com.first.mapper.UserLoginMapper;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月3日
   @version 1.00
 */
@Controller
@RequestMapping("/userlogin/")
public class UserLoginController extends BaseController {
	@Inject
	private UserLoginMapper userLoginMapper;
	/**
	 * 账号查询
	 * @param model
	 * @return
	 * @throws Exception
	 * **/
	@RequestMapping("listUI")
	public String listUI(Model model) throws Exception {
	
		return Common.BACKGROUND_PATH + "/system/userlogin/list";
	}


@ResponseBody
	@RequestMapping("findByPage")
	public Object findByPage(int draw, int start, int length) throws Exception {

		PageHelper.startPage((start/length)+1, length);
		
		List<UserLoginFormMap> p=userLoginMapper.findByPage();
		PageInfo<UserLoginFormMap>  pageinfo=new PageInfo<UserLoginFormMap>(p);
		
		 long total =  pageinfo.getTotal();     //获取总个数  
	        System.out.println("total:" + total); 
	        int pages = pageinfo.getPages();      //获取当前页  
	        System.out.println("pages:" + pages);  
	        int pageSize = pageinfo.getPageSize(); //每页个数  
	      
	        System.out.println("pageSize:" + pageSize); 
	        Map<String, Object> map = new HashMap<String, Object>();  
	        List<Object> data = new ArrayList<Object>(); 
	        for(UserLoginFormMap a: pageinfo.getList()) {
	        	data.add(a);
	        
	        }
	       
	        map.put("draw", draw);
	        map.put("recordsTotal", pageinfo.getTotal());  
	        map.put("recordsFiltered", pageinfo.getTotal()); 
	        map.put("data", data);  
	        System.err.println(map);
	        return map; 
	}

	
}