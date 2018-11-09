package com.first.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.controller.index.BaseController;
import com.first.entity.UserFormMap;
import com.first.mapper.UserMapper;
import com.first.util.Common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 个人信息展示
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月3日
   @version 1.00
 */
@Controller
@RequestMapping("/personal/")
public class PersonalController extends BaseController {
	@Inject
	private UserMapper userMapper;
	/**
	 * 个人主页展示
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public String listUI(HttpServletRequest request,Model model) throws Exception {
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
		model.addAttribute("personal",userFormMap);
		return Common.BACKGROUND_PATH + "/system/personal/list";
	}

	/**
	 * 个人周报表
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("weekstatistics")
	@ResponseBody
	public Object weekstatistics() throws Exception {
		getuserId();

		return null;
	}

	/**
	 * 修改密码
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updatePassword")
	public String updatePasswordUI(Model model) throws Exception {
		
		return Common.BACKGROUND_PATH + "/system/personal/updatePassword";
	}
	/**
	 * 个人形象展示接口
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("shows")
	 @ResponseBody
	public Object shows(String callback) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		List<UserFormMap> p = userMapper.findshows();
		
	
		/*JSONObject json = new JSONObject();*/
		searchMap.put("shows", p);
		/*String a=JSONArray.fromObject( searchMap).toString();
		System.err.println("DSAsa"+a);*/
		if(callback==null||callback.equals("")) {
			callback="callback";
		}
		 JSONPObject jsonpObject = new JSONPObject(callback,searchMap) ;
	        return jsonpObject ;
	}
	}
