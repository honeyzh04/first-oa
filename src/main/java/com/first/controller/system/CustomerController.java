package com.first.controller.system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.first.entity.DepartmentFormMap;
import com.first.entity.ExtendFormMap;
import com.first.entity.UserFormMap;
import com.first.exception.SystemException;
import com.first.mapper.CustomerMapper;
import com.first.mapper.DepartMapper;
import com.first.service.system.ShareCustomerService;
import com.first.util.Common;
import com.first.util.TreeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 客户管理 Copyright (C), 2018-2022, ChengDu First Real estate agency
 * 
 * @author zhaoh
 * @date 2018年5月3日
 * @version 1.00
 */
@Controller
@RequestMapping("/customer/")
public class CustomerController extends BaseController {
	private static final String String = null;
	@Inject
	private CustomerMapper customerMapper;
	@Inject
	private DepartMapper departMapper;
	@Inject
	private ShareCustomerService shareCustomerService;

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
		return Common.BACKGROUND_PATH + "/system/customer/list";
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

		String depar = userFormMap.get("department").toString();
		int depId = Integer.parseInt(depar);
		System.err.println("ads" + depId);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("id", userFormMap.get("id"));
		searchMap.put("departmentId", userFormMap.get("department"));
		searchMap.put("customerName", request.getParameter("customerName"));
		searchMap.put("telephone", request.getParameter("telephone"));
		searchMap.put("followa", request.getParameter("followa"));
		searchMap.put("screateDate", request.getParameter("screateDate"));
		searchMap.put("ecreateDate", request.getParameter("ecreateDate"));
		searchMap.put("stotalPrice", request.getParameter("stotalPrice"));
		searchMap.put("etotalPrice", request.getParameter("etotalPrice"));
		searchMap.put("department", request.getParameter("department"));
		searchMap.put("userId", request.getParameter("userId"));
		searchMap.put("state", request.getParameter("state"));
		searchMap.put("intention", request.getParameter("intention"));

		/*
		 * String g= request.getParameter("purpose"); String[] strarr =g.split(",");
		 * System.err.println( "名单"+strarr );
		 */

		searchMap.put("purpose", request.getParameter("purpose"));
		searchMap.put("apartment", request.getParameter("apartment"));
		searchMap.put("cusource", request.getParameter("cusource"));
		searchMap.put("date", request.getParameter("date"));

		System.err.println(request.getParameter("choice"));
		String choice = request.getParameter("choice").toString();
		;
		searchMap.put("choice", choice);
		if (choice.equals("1")) {
			System.err.println("条件查询客户1" + searchMap);

			PageHelper.startPage((start / length) + 1, length);

			List<CustomerFormMap> p = customerMapper.findCustomerPage(searchMap);
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

		} else if (choice.equals("2")) {
			// 获取登录人部门及下属部门
			List<DepartmentFormMap> departmentFormMap = departMapper.getDepart();

			System.err.println("ada" + departmentFormMap);
			List<String> idss = new ArrayList<>();

			idss = TreeUtil.treeMenuList(departmentFormMap, depId);

			System.err.println(idss);

			idss.add(depar);
			searchMap.put("departments", idss);
			System.err.println(idss);

			System.err.println(searchMap);
			System.err.println("条件查询客户2" + searchMap);

			PageHelper.startPage((start / length) + 1, length);

			List<CustomerFormMap> p = customerMapper.finddCustomerPage(searchMap);
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
			idss.clear();
			return map;
		} else {
			System.err.println("条件查询客户3" + searchMap);

			PageHelper.startPage((start / length) + 1, length);

			List<CustomerFormMap> p = customerMapper.findaCustomerPage(searchMap);
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
	 * 添加
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addUI")
	public String addUI(HttpServletRequest request, Model model) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		System.err.println("dad" + userFormMap);
		model.addAttribute("user", userFormMap);
		return Common.BACKGROUND_PATH + "/system/customer/add";
	}

	/**
	 * 添加
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addaUI")
	public String addaUI(HttpServletRequest request, Model model) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String dateStr = df.format(date);
		userFormMap.put("creatDate", dateStr.substring(0, 16));
		System.err.println("dad" + userFormMap);
		model.addAttribute("user", userFormMap);
		return Common.BACKGROUND_PATH + "/system/customer/add-a";
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = "客户管理", methods = "客户管理-添加客户") // 凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	public String addEntity() {

		try {
			CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);

			customerFormMap.put("createDate", new Date());
			customerFormMap.put("trackDate", new Date());
			customerFormMap.put("ntrackDate", new Date());

			customerMapper.addEntity(customerFormMap);// 新增后返回新增信息

			customerMapper.addFollow(customerFormMap);// 跟进客户
			customerMapper.addLFollow(customerFormMap);// 跟进客户长期保存

			customerMapper.addExtend(customerFormMap);// 扩展客户
			String source=customerFormMap.get("cusource").toString();
			System.out.println("AD"+source);
			if(source.equals("3")||source.equals("6")){
				System.err.println("fangfaxiankehu");
				customerMapper.addSource(customerFormMap);// 房发现客户具体来源
			}

			customerFormMap.put("source", "1");
			customerMapper.addCu(customerFormMap);// 新增客户统计
		} catch (Exception e) {
			throw new SystemException("添加客户异常");
		}
		return "success";
	}

	/**
	 * 跟进客户
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "editUI")
	public String editUI(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户" + id);
		if (Common.isNotEmpty(id)) {
			// int id = Integer.parseInt(iid);
			CustomerFormMap mps = customerMapper.findbyeditUI(id);
			String visproject= customerMapper.findbyproject(id);
			
			System.err.println("单独客户" + mps);

			model.addAttribute("customer", mps);
			model.addAttribute("visproject", visproject);
		}
		return Common.BACKGROUND_PATH + "/system/customer/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "客户管理", methods = "用户管理-跟进客户") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
		System.err.println(getuserName());
		CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
		customerFormMap.put("userName", getuserName());
		customerFormMap.put("userId", getuserId());
		System.err.println("客户跟进" + customerFormMap);
		Object ntrackDate = customerFormMap.get("ntrackDate");
		System.err.println(ntrackDate);
		if (ntrackDate == null) {
			customerFormMap.put("ntrackDate", new Date());
		}
		/*
		 * customerFormMap.put("visitprojectId", null);
		 * customerFormMap.put("dealprojectId", null);
		 */
		System.err.println("客户跟进" + customerFormMap);
		customerFormMap.put("trackDate", new Date());

		customerFormMap.put("trackremind", "0");
		customerMapper.editEntity(customerFormMap);// 修改客户

		customerMapper.addFollow(customerFormMap);// 跟进客户
		customerMapper.addLFollow(customerFormMap);// 跟进客户长期保存
		String state = customerFormMap.get("state").toString();
		Object visitprojectId = customerFormMap.get("visitprojectId");
		Object dealprojectId = customerFormMap.get("dealprojectId");

		if (state.equals("2") && visitprojectId != null) {

			System.err.println("s");
			customerMapper.addVisit(customerFormMap);// 到访客户
			// &&dealprojectId !=null
		} else if (state.equals("4") && dealprojectId != null) {
			customerMapper.addVisit1(customerFormMap);//到访客户
			customerMapper.addDeal(customerFormMap);// 成交客户
		}
		return "success";
	}

	/**
	 * 客户扩展
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "extendUI")
	public String extendUI(Model model) throws Exception {
		String id = getPara("id");
		String customerName = getPara("customerName");
		System.err.println("客户" + id + "min" + customerName);
		if (Common.isNotEmpty(id)) {
			// int id = Integer.parseInt(iid);
			ExtendFormMap mps = customerMapper.findbyExtend(id);
			mps.put("customerName", customerName);
			System.err.println("ce" + mps);

			model.addAttribute("customer", mps);
		}
		return Common.BACKGROUND_PATH + "/system/customer/extend";
	}

	@ResponseBody
	@RequestMapping("extendEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "客户管理", methods = "客户管理-客户扩展") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String extendEntity() throws Exception {
		ExtendFormMap extendFormMap = getFormMap(ExtendFormMap.class);
		extendFormMap.put("createDate", new Date());
		System.err.println("C" + extendFormMap);

		customerMapper.editExtend(extendFormMap);
		System.err.println("c测试1");

		return "success";
	}

	/**
	 * 转让客户
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "transferUI")
	public String transferUI(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户" + id);
		if (Common.isNotEmpty(id)) {
			// int id = Integer.parseInt(iid);
			CustomerFormMap mps = new CustomerFormMap();
			mps.put("id", id);
			model.addAttribute("customer", mps);
		}
		return Common.BACKGROUND_PATH + "/system/customer/transfer";
	}

	@ResponseBody
	@RequestMapping("transferEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "客户管理", methods = "客户管理-转让客户") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String transferEntity() throws Exception {
		CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
		String Ids = customerFormMap.get("id").toString();
		if (null != Ids && !Common.isEmpty(Ids.toString())) {
			String[] ids = Ids.split(",");
			for (String id : ids) {

				customerFormMap.put("id", id);
				customerMapper.discardEntity(customerFormMap);
				customerFormMap.put("source", "3");
				customerFormMap.put("createDate", new Date());
				System.err.println("zhua" + customerFormMap);
				customerMapper.addCu(customerFormMap);// 新增客户统计
			}

		}
		return "success";
	}

	/**
	 * 丢弃公共池
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "discardUI")
	public String discardUI(Model model) throws Exception {
		String id = getPara("id");

		System.err.println("客户" + id);

		if (Common.isNotEmpty(id)) {
			// int id = Integer.parseInt(iid);
			CustomerFormMap mps = new CustomerFormMap();
			mps.put("id", id);
			model.addAttribute("customer", mps);
		}
		return Common.BACKGROUND_PATH + "/system/customer/discard";
	}

	@ResponseBody
	@RequestMapping("discardEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "客户管理", methods = "客户管理-放入公共池") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String discardEntity() throws Exception {
		CustomerFormMap cutomerFormMap = getFormMap(CustomerFormMap.class);

		cutomerFormMap.put("trackremind", "7");
		System.err.println("放入公共池" + cutomerFormMap);
		customerMapper.discardEntity(cutomerFormMap);

		return "success";
	}

	/**
	 * 客户报备
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "preparationUI")
	public String preUI(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户" + id);
		if (Common.isNotEmpty(id)) {
			// int id = Integer.parseInt(iid);
			CustomerFormMap mps = customerMapper.findbyeditUI(id);
			System.err.println("ce" + mps);

			model.addAttribute("customer", mps);
		}
		return Common.BACKGROUND_PATH + "/system/customer/preparation";
	}

	@ResponseBody
	@RequestMapping("preparationEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "客户管理", methods = "客户管理-客户报备") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String preEntity() throws Exception {
		CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
		System.err.println("客户报备" + customerFormMap);

		customerMapper.addpreEntity(customerFormMap);
		System.err.println("c测试1");

		return "success";
	}

	/**
	 * 删除客户
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "客户管理", methods = "客户管理-客户删除") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String id = getPara("id");
		if (Common.isNotEmpty(id)) {

			customerMapper.deleteEntity(id);// 基本信息
			customerMapper.deleteFollow(id);// 跟进信息
			customerMapper.deletExtend(id);// 扩展信息
			customerMapper.deletePreparation(id);// 报备信息
		}
		return "success";
	}

	/**
	 * 客户共享
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "shareUI")
	public String shareUI(Model model) throws Exception {
		String id = getPara("id");
		System.err.println("客户" + id);
		if (Common.isNotEmpty(id)) {
			// int id = Integer.parseInt(iid);
			CustomerFormMap mps = customerMapper.findbyeditUI(id);
			System.err.println("ce" + mps);

			model.addAttribute("customer", mps);
		}
		return Common.BACKGROUND_PATH + "/system/customer/share";
	}

	@ResponseBody
	@RequestMapping("shareEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "客户管理", methods = "客户管理-客户共享") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String shareEntity() throws Exception {
		CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
		customerFormMap.put("createDate", new Date());
		customerFormMap.put("state", "1");
		System.err.println(customerFormMap);
		List<String> list = new ArrayList<String>();
		list = shareCustomerService.findOldUser(customerFormMap);
		String userId = customerFormMap.get("userId").toString();
		// String str=String.join(",", list);
		// System.err.println(str);
		String Ids = customerFormMap.get("userIds").toString() + "," + userId;
		System.err.println(Ids);
		if (null != Ids && !Common.isEmpty(Ids.toString())) {
			String[] ids = Ids.split(",");
			for (String id : ids) {
				if (!list.contains(id)) {
					customerFormMap.put("userId", id);
					//System.err.println(customerFormMap);
					customerMapper.shareEntity(customerFormMap);
				}

			}

		}
		return "success";
	}

	/**
	 * 房发现客户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("fangfaxianlistUI")
	public String fangfaxianlistUI() throws Exception {

		return Common.BACKGROUND_PATH + "/system/customer/ffxlist";
	}

	@ResponseBody
	@RequestMapping("findByffxCustomer")
	public Object findByffxCustomer(HttpServletRequest request, int draw, int start, int length) throws Exception {

		Map<String, Object> searchMap = new HashMap<String, Object>();

		searchMap.put("customerName", request.getParameter("customerName"));
		searchMap.put("telephone", request.getParameter("telephone"));
		searchMap.put("screateDate", request.getParameter("screateDate"));
		searchMap.put("ecreateDate", request.getParameter("ecreateDate"));
		System.err.println("查询3213" + searchMap);
		PageHelper.startPage((start / length) + 1, length);

		List<CustomerFormMap> p = customerMapper.findffxCustomerPage(searchMap);

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