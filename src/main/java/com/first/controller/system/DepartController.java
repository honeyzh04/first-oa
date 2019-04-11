package com.first.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.controller.index.BaseController;
import com.first.entity.DepartmentFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.DepartMapper;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 部门、人员二级联动
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年6月1日
   @version 1.00
 */
@Controller
@RequestMapping("/dict/")
public class DepartController extends BaseController {
	@Inject
	private DepartMapper dictMapper;
	
	/**
	 * 公司组织架构
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ogranlist")
	public String ogranlistUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());

		return Common.BACKGROUND_PATH + "/system/department/ogran_list";
	}
	
	/**
	 * 显示按钮
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());

		return Common.BACKGROUND_PATH + "/system/department/list";
	}
	
	/**
	 * 部门列表
	 *
	 * @return
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping("findByPage")
	public Object findByPage(HttpServletRequest request, int draw, int start, int length) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("departName", request.getParameter("departName"));
		PageHelper.startPage((start / length) + 1, length);
		List<DepartmentFormMap>   p =  dictMapper.findDepart(searchMap);
		PageInfo<DepartmentFormMap> pageinfo = new PageInfo<DepartmentFormMap>(p);

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		for (DepartmentFormMap a : pageinfo.getList()) {
			data.add(a);
		}
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);

		return map;
	}

	/**
	 * 选择部门
	 * @return
	 */
	@RequestMapping("showDepart")
	@ResponseBody
	public List<DepartmentFormMap>  showProvince(){

		List<DepartmentFormMap>   departmentFormMap =  dictMapper.getDepart();
		System.err.println(departmentFormMap);
		return  departmentFormMap;
	}
	/**
	 * 选择销售人员
	 * @return
	 */
	@RequestMapping("showUser")
	@ResponseBody
	public List<UserFormMap>  showUser(String departCode){

		List<UserFormMap>   userFormMap=null;
		if (Common.isNotEmpty( departCode)) {
		   userFormMap =  dictMapper.getUser(departCode);

		}
		return userFormMap;
	}
	/**
	 * 选择部门
	 * @return
	 */
	@RequestMapping("showcuDepart")
	@ResponseBody
	public List<DepartmentFormMap>  showcuDepart(){

		List<DepartmentFormMap>   departmentFormMap =  dictMapper.getcuDepart();

		return  departmentFormMap;
	}
	/**
	 * 选择所有销售人员
	 * @return
	 */
	@RequestMapping("allUser")
	@ResponseBody
	public List<UserFormMap>  allUser(){
		
		List<UserFormMap>   userFormMap =  dictMapper.getAlluser();

		return  userFormMap;
	}

}









