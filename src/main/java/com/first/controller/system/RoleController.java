package com.first.controller.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.ResFormMap;
import com.first.entity.RoleFormMap;
import com.first.entity.RoleResFormMap;
import com.first.mapper.ResourcesMapper;
import com.first.mapper.RoleMapper;
import com.first.util.Common;
import com.first.util.TreeObject;
import com.first.util.TreeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 部门角色管理
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月4日
   @version 1.00
 */
@Controller
@RequestMapping("/role/")
public class RoleController extends BaseController {
	@Inject
	private RoleMapper roleMapper;
	@Inject
	private ResourcesMapper resourcesMapper;
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/role/list";
	}

	

	@ResponseBody
	@RequestMapping("findByPage")
	public Object findByPage(HttpServletRequest request,int draw, int start, int length) throws Exception {
		 Map<String, Object> searchMap = new HashMap<String, Object>(); 
		 searchMap.put("roleName",request.getParameter("roleName"));
		PageHelper.startPage((start/length)+1, length);
		List<RoleFormMap> p=roleMapper.findRloePage(searchMap);
		PageInfo<RoleFormMap>  pageinfo=new PageInfo<RoleFormMap>(p);
		
	        Map<String, Object> map = new HashMap<String, Object>();  
	        List<Object> data = new ArrayList<Object>(); 
	        for(RoleFormMap a: pageinfo.getList()) {
	        	data.add(a);
	        	  
	        }
	    
	        map.put("draw", draw);
	        map.put("recordsTotal", pageinfo.getTotal());  
	        map.put("recordsFiltered", pageinfo.getTotal()); 
	        map.put("data", data);   

	        return map; 
	        
	 
	}
	/**
	 * 添加职位
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/role/add";
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="组管理-新增组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		RoleFormMap roleFormMap = getFormMap(RoleFormMap.class);
		roleFormMap.put("trackDate",new Date());

		roleMapper.addEntity(roleFormMap);
		return "success";
	}

	/**
	 * 编辑职位
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
		String id = getPara("id");

		if(Common.isNotEmpty(id)){
			RoleFormMap mps = roleMapper.findbyeditUI(id);

		
			model.addAttribute("role", mps);
		}
		return Common.BACKGROUND_PATH + "/system/role/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="组管理-修改组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
		RoleFormMap roleFormMap = getFormMap(RoleFormMap.class);
		roleMapper.editEntity(roleFormMap);
		return "success";
	}
	/**
	 * 删除职位
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="组管理-删除组")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String Ids = getPara("id");

		 String []ids=Ids.split(",");
		 for (String id : ids) {
			 roleMapper.deleteEntity(id);//职位信息
			 roleMapper.deleteByRoRe(id);//职位信息关联表
         }  
	
		return "success";
	}
	/**
	 * 显示职位表
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selRole")
	public String seletRole(Model model) throws Exception {
		RoleFormMap roleFormMap = getFormMap(RoleFormMap.class);
	
		Object userId = roleFormMap.get("userId");

		if(null!=userId){
			List<RoleFormMap> list = roleMapper.seletUserRole(roleFormMap);

			String ugid = "";
			for (RoleFormMap ml : list) {
				ugid += ml.get("id")+",";
			}
			ugid = Common.trimComma(ugid);

			model.addAttribute("txtRoleSelect", ugid);
			model.addAttribute("userRole", list);
			if(StringUtils.isNotBlank(ugid)){
				roleFormMap.put("ugid", ugid);
				
			}
		}

		List<RoleFormMap> roles = roleMapper.findByWhere(roleFormMap);

		model.addAttribute("role", roles);
		
		return Common.BACKGROUND_PATH + "/system/user/roleSelect";
	}
	/**
	 * 权限分配页面
	 * 
	 * @author numberONe  date：2014-4-14
	 * @param model
	 * @return
	 */
	@RequestMapping("permissions")
	public String permissions(Model model) {

		ResFormMap resFormMap = gettFormMap(ResFormMap.class);
	
		List<ResFormMap> mps = resourcesMapper.findByWhere(resFormMap);
		
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : mps) {

			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}
		
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
		
		model.addAttribute("permissions", ns);
		return Common.BACKGROUND_PATH + "/system/role/permissions";
	}

	/**
	 * 获取该职位拥有权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findRes")
	public List<ResFormMap> findUserRes() {
		ResFormMap resFormMap = getFormMap(ResFormMap.class);

		List<ResFormMap> rs = resourcesMapper.findRoleRes(resFormMap);
		return rs;
	}
	
	/**
	 * 修改权限
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("addUserRes")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="职位管理-修改权限")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addUserRes() throws Exception {
		
		String roleId = getPara("roleId");
	

		 roleMapper.deleteByRoRe(roleId);
		 if (null != roleId && !Common.isEmpty(roleId.toString())) {

			
		
			String[] a = getParaValues("resId[]");


				for (String rid : a) {
					RoleResFormMap roleresFormMap = new RoleResFormMap();
					roleresFormMap.put("resId", rid);
					roleresFormMap.put("roleId",roleId);

					roleMapper.addRREntity(roleresFormMap);
					
				
				}
				
			}

		return "success";
	}
}