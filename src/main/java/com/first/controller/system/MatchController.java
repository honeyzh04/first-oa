package com.first.controller.system;

import com.first.controller.index.BaseController;
import com.first.entity.CustomerFormMap;
import com.first.entity.ProjectFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.CustomerMapper;
import com.first.mapper.ProjectMapper;
import com.first.service.system.ProjectService;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	@Inject
	private ProjectService projectService;

	/**
	 * 匹配项目
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("customermatchtUI")
	public String customerMatchtUI() throws Exception {
		

		return Common.BACKGROUND_PATH + "/system/match/prmatch";
	}
	
	@ResponseBody
	@RequestMapping("findcumatch")
	public Object findCuMatch(HttpServletRequest request, int draw, int start, int length) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

		 Map<String, Object> searchMap = new HashMap<String, Object>(); 
		
		 searchMap.put("id",userFormMap.get("id") );
		
		 searchMap.put("telephone",request.getParameter("telephone"));	

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

	/**
	 * 新增客户匹配项目
	 */
	@ResponseBody
	@RequestMapping("addcumatch")
	public Object addCumMtch( )  {
		CustomerFormMap b = customerMapper.addCumMtch(getuserId());
		System.err.println(b);
		List<ProjectFormMap> p = projectMapper.findcuProject(b);
		System.err.println(p);
		return p;
	}
	/**
	 *匹配客户
	 *
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("matchingCustomer")
	public String matchingCustomer(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户" + id);
		model.addAttribute("project",id);
		return Common.BACKGROUND_PATH + "/system/project/matchingCustomer";
	}
	@ResponseBody
	@RequestMapping("findPrMatch")
	public Object findPrMatch(HttpServletRequest request, int draw, int start, int length) throws Exception {
		String userId=getuserId();
		String id=request.getParameter("projectId");
		ProjectFormMap mps=projectService.findbyProject(id);
		System.err.println(mps);
		mps.put("userId",userId);
		PageHelper.startPage((start/length)+1, length);

		List<CustomerFormMap> p = customerMapper.findMatchCustomer(mps);

		PageInfo<CustomerFormMap> pageinfo = new PageInfo<CustomerFormMap>(p);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		for (CustomerFormMap a : pageinfo.getList()) {

			data.add(a);

		}

		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}
}









