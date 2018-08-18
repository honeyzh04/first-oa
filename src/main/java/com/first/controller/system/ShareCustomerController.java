package com.first.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.CustomerFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.CustomerMapper;
import com.first.service.system.ShareCustomerService;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 客户共享 Copyright (C), 2018-2022, ChengDu First Real estate agency
 * 
 * @author zhaoh
 * @date 2018年8月9日
 * @version 1.00
 */
@Controller
@RequestMapping("/sharecustomer/")
public class ShareCustomerController extends BaseController {


	@Inject
	private  ShareCustomerService sharecustomerservice;
	/**
	 * 账号查询
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 **/
	@RequestMapping("listUI")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/shareCustomer/list";
	}

	/**
	 * 客户查看
	 * 
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findByPage")
	public Object findByPage(HttpServletRequest request, int draw, int start, int length) throws Exception {
		
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));
		searchMap.put("departmentId", userFormMap.get("department"));
		searchMap.put("customerName", request.getParameter("customerName"));
		searchMap.put("telephone", request.getParameter("telephone"));
		
		String choice = request.getParameter("choice").toString();
		
		searchMap.put("choice", choice);
		System.err.println("da" + searchMap);
		if (choice.equals("1")) {
			System.err.println("条件查询客户22" + searchMap);

			PageHelper.startPage((start / length) + 1, length);

			List<CustomerFormMap> p = sharecustomerservice.findShareCu(searchMap);
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

		}  else {
			System.err.println("条件查询客户33" + searchMap);

			PageHelper.startPage((start / length) + 1, length);

			List<CustomerFormMap> p = sharecustomerservice.findDeShareCu(searchMap);
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

	/**
	 * 退出共享
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("outEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	
	public String outShareCustomer() throws Exception {
		String userId=getuserId();
		String id = getPara("id");
		if (Common.isNotEmpty(id)) {
			System.err.println(userId+id);
			sharecustomerservice.outShareCustomer(id,userId);// 报备信息
		}
		return "success";
	}	
	/**
	 * 查看共享销售
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "shareUserUI")
	public String shareUserUI(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户" + id);
		if (Common.isNotEmpty(id)) {
			// int id = Integer.parseInt(iid);
			List<String> mps = sharecustomerservice.findShareUser(id);// 报备信息
			System.err.println("ce" + mps);

			model.addAttribute("customer", mps);
		}
		return Common.BACKGROUND_PATH + "/system/shareCustomer/shareUser";
		
	}
	
	
}