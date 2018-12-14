package com.first.controller.index;

import java.util.Enumeration;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.first.entity.ResFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.ResourcesMapper;
import com.first.util.Common;
import com.first.util.FormMap;
import com.github.pagehelper.PageInfo;

/**
 * 基础控制器（重要）
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月3日
   @version 1.00
 */
public class BaseController {
	@Inject
	private ResourcesMapper resourcesMapper;

	
	/**
	 * 查找资源
	 * 获取返回某一页面的按扭组
	 * @return
	 */
	public List<ResFormMap> findByRes(){
		// 资源ID
		String id = getPara("id");
		// 获取request
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		// 通过工具类获取当前登录的bean
		UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);
		// 用户 id
		
		int userId = userFormMap.getInt("id");
		ResFormMap resQueryForm = new ResFormMap();
		resQueryForm.put("parentId", id);
		resQueryForm.put("userId", userId);
		List<ResFormMap> rse = resourcesMapper.findRes(resQueryForm);
		//List<ResFormMap> rse = resourcesMapper.findByAttribute("parentId", id, ResFormMap.class);
		for (ResFormMap resFormMap : rse) {
			Object o =resFormMap.get("description");
			if(o!=null&&!Common.isEmpty(o.toString())){
				resFormMap.put("description",Common.stringtohtml(o.toString()));
			}
		}
		return rse;
	}

	/**
	 * 获取操用户部门
	 * @return
	 */
	public String getdeId(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

		String  department  = userFormMap.get("department").toString();
		return department;

	}
	/**
	 *获取操作用户名
	 * @param key
	 * @return
	 */
	public String getuserName(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

		String  userName  = userFormMap.get("userName").toString();
		return userName;
		
	}
	/**
	 *获取操作用Id
	 * @param key
	 * @return
	 */
	public String getuserId(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

		String  userId  = userFormMap.get("id").toString();
		return  userId;
		
	}
	/**
	 * 获取页面传递的某一个参数值,
	 * @param key
	 * @return
	 */
	public String getPara(String key){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		return request.getParameter(key);
	}
	
	/**
	 * 获取页面传递的某一个数组值,
	 * @param key
	 * @return
	 */
	public String[] getParaValues(String key){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		return request.getParameterValues(key);
	}
	/**
	 * @ModelAttribute
	 * 这个注解作用.每执行controllor前都会先执行这个方法
	 */
	/*@ModelAttribute
	public void init(HttpServletRequest request){
		String path = Common.BACKGROUND_PATH;
		Object ep = request.getSession().getAttribute("basePath");
		if(ep!=null){
			if(!path.endsWith(ep.toString())){
				Common.BACKGROUND_PATH = "/WEB-INF/jsp/background"+ep;
			}
		}
		
	}*/
	
	/**
	 * 获取传递的所有参数,
	 * 反射实例化对象，再设置属性值
	 * 通过泛型回传对象.
	 * @param clazz
	 * @return
	 */
	public <T> T getFormMap(Class<T> clazz){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		Enumeration<String> en = request.getParameterNames();
		T t = null;
		try {
			//初始化一个类，生成一个实例的时候
			t = clazz.newInstance();
			@SuppressWarnings("unchecked")
			FormMap<String, Object> map = (FormMap<String, Object>) t;
			//测试此枚举是否包含更多的元素。
			while (en.hasMoreElements()) {
			
				//如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
				String nms = en.nextElement().toString();

				if(nms.endsWith("[]")){//测试此字符串是否以指定的后缀结束。
					String[] as = request.getParameterValues(nms);
					
					if(as!=null&&as.length!=0&&as.toString()!="[]"){
						//转为大写
						String mname = t.getClass().getSimpleName().toUpperCase();
						//startsWith方法测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
						if(nms.toUpperCase().startsWith(mname)){
							nms=nms.substring(nms.toUpperCase().indexOf(mname)+1);
							map.put( nms,as);
						}

					}
				}else{
				
					String as = request.getParameter(nms);
					if(!Common.isEmpty(as)){
						//转为大写
						String mname = t.getClass().getSimpleName().toUpperCase();
						
						if(nms.toUpperCase().startsWith(mname)){
							nms=nms.substring(mname.length()+1);
							map.put( nms, as);

						}
						
					}
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return  t;
	}
	public <T> T gettFormMap(Class<T> clazz){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
	Map<String, String[]> map = request.getParameterMap();
	System.err.println(map);
	if (map != null && !map.isEmpty()) {
	    for(Entry<String, String[]> entry : map.entrySet()){
	        System.out.println(entry.getKey());//entry.getKey() 参数名;
	        //entry.getValue();参数值，类型为数组
	     
	    }
	}
	return null;
	}
	/**
	 * 获取传递的所有参数,
	 * 再设置属性值
	 * 通过回传Map对象.
	 * @param clazz
	 * @return
	 */
	public <T> T findHasHMap(Class<T> clazz){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		Enumeration<String> en = request.getParameterNames();
		T t = null;
		try {
			t = clazz.newInstance();
			@SuppressWarnings("unchecked")
			FormMap<String, Object> map = (FormMap<String, Object>) t;
			while (en.hasMoreElements()) {//判断Enumeration对象中是否还有数据
				String nms = en.nextElement().toString();//获取Enumeration对象中的下一个数据
				if(!"_t".equals(nms)){
					if(nms.endsWith("[]")){//测试此字符串是否以指定的后缀结束。
						String[] as = request.getParameterValues(nms);
						if(as!=null&&as.length!=0&&as.toString()!="[]"){
							map.put( nms,as);
						}
					}else{
						String as = request.getParameter(nms);
						if(!Common.isEmpty(as)){
							map.put( nms, as);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	

}