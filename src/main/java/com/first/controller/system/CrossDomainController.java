/**
 * 
 */
package com.first.controller.system;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.controller.index.BaseController;
import com.first.entity.UserFormMap;
import com.first.mapper.UserMapper;
import com.first.util.Common;

/**
 * 跨域用户验证
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年8月7日
   @version 1.00
 */
@Controller
@RequestMapping("/crossdomain/")
public class CrossDomainController  extends BaseController {
	@Inject
	private UserMapper userMapper;



	@RequestMapping("fangfaxian")
	 @ResponseBody
	public Object shows(String callback,String username, String password) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		System.err.println("fas"+username);
		
		
			System.err.println("fas"+username);
			UserFormMap userFormMap = new UserFormMap();
		
			userFormMap.put("accountName", "" + username + "");
			UserFormMap userFormMaps = userMapper.findByUser(userFormMap);
			try {
			
				if (Common.isEmpty(username) || Common.isEmpty(password)) {
					searchMap.put("error", "用户名或密码不能为空！");
					
				}
				Subject user = SecurityUtils.getSubject();
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
					
					try {
						user.login(token);
						searchMap.put("user",userFormMaps);
						searchMap.put("message","登录成功");
						searchMap.put("status","OK");
					} catch (LockedAccountException lae) {
						
						searchMap.put("message", "用户已经被锁定不能登录，请与管理员联系！");
						searchMap.put("status","OK");
					} catch (ExcessiveAttemptsException e) {
						
						searchMap.put("message", "账号：" + username + " 登录失败次数过多,锁定10分钟!");
						searchMap.put("status","OK");
					} catch (AuthenticationException e) {
						
						searchMap.put("message", "用户或密码不正确！");
						searchMap.put("status","OK");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					searchMap.put("message", "登录异常，请联系管理员！");
					searchMap.put("status","OK");
				}
			
			// 想要得到 SecurityUtils.getSubject()　的对象．．访问地址必须跟ｓｈｉｒｏ的拦截地址内．不然后会报空指针
					
		if(callback==null||callback.equals("")) {
			callback="callback";
		}
		 JSONPObject jsonpObject = new JSONPObject(callback,searchMap) ;
	        return jsonpObject ;

}
	
	@RequestMapping("project")
	 @ResponseBody
	public Object project(String callback,String username, String password) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		System.err.println("fas"+username);
		
		
			System.err.println("fas"+username);
			UserFormMap userFormMap = new UserFormMap();
		
			userFormMap.put("accountName", "" + username + "");
			UserFormMap userFormMaps = userMapper.findByUser(userFormMap);
			try {
			
				if (Common.isEmpty(username) || Common.isEmpty(password)) {
					searchMap.put("error", "用户名或密码不能为空！");
					
				}
				Subject user = SecurityUtils.getSubject();
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
					
					try {
						user.login(token);
						searchMap.put("user",userFormMaps);
						searchMap.put("message","登录成功");
						searchMap.put("status","OK");
					} catch (LockedAccountException lae) {
						
						searchMap.put("message", "用户已经被锁定不能登录，请与管理员联系！");
						searchMap.put("status","OK");
					} catch (ExcessiveAttemptsException e) {
						
						searchMap.put("message", "账号：" + username + " 登录失败次数过多,锁定10分钟!");
						searchMap.put("status","OK");
					} catch (AuthenticationException e) {
						
						searchMap.put("message", "用户或密码不正确！");
						searchMap.put("status","OK");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					searchMap.put("message", "登录异常，请联系管理员！");
					searchMap.put("status","OK");
				}
			
			// 想要得到 SecurityUtils.getSubject()　的对象．．访问地址必须跟ｓｈｉｒｏ的拦截地址内．不然后会报空指针
					
		if(callback==null||callback.equals("")) {
			callback="callback";
		}
		 JSONPObject jsonpObject = new JSONPObject(callback,searchMap) ;
	        return jsonpObject ;

}

	}

