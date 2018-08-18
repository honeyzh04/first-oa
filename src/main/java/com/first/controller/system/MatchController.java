package com.first.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.controller.index.BaseController;
import com.first.entity.CustomerFormMap;
import com.first.entity.ProjectFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.CustomerMapper;
import com.first.mapper.ProjectMapper;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 项目匹配系统
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年8月2日
   @version 1.00
 */
@Controller
@RequestMapping("/match/")
public class MatchController extends BaseController{
	@Inject
	private CustomerMapper customerMapper;
	@Inject
	private ProjectMapper projectMapper;
	
	/**
	 * 房发现客户
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("customermatchtUI")
	public String fangfaxianlistUI() throws Exception {
		
		System.err.println("23");
		return Common.BACKGROUND_PATH + "/system/match/prmatch";
	}
	
	@ResponseBody
	@RequestMapping("findcumatch")
	public Object findByffxCustomer(HttpServletRequest request, int draw, int start, int length) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		System.err.println("22");
		 Map<String, Object> searchMap = new HashMap<String, Object>(); 
		
		 searchMap.put("id",userFormMap.get("id") );
		
		 searchMap.put("telephone",request.getParameter("telephone"));	
		 System.err.println(searchMap);
		 CustomerFormMap b=null;
			List<CustomerFormMap> x=customerMapper.findcumatch(searchMap);
			System.err.println("查询"+x);
			 for(int i=0;i<x.size();i++) {
				b=x.get(0);
			 }
		System.err.println("查询3213"+b);
		PageHelper.startPage((start/length)+1, length);
		
		List<ProjectFormMap>  p = projectMapper.findcuProject(b);
		
		PageInfo<ProjectFormMap>  pageinfo=new PageInfo<ProjectFormMap>(p);
	        Map<String, Object> map = new HashMap<String, Object>();  
	        List<Object> data = new ArrayList<Object>(); 
	        for(ProjectFormMap a: pageinfo.getList()) {

	        	data.add(a);
	        	
	        }
	     
	        map.put("draw", draw);
	        map.put("recordsTotal", pageinfo.getTotal());  
	        map.put("recordsFiltered", pageinfo.getTotal()); 
	        map.put("data", data);  
	       
	        return map; 
	}
}









