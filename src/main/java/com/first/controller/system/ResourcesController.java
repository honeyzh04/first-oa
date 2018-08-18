package com.first.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.ButtomFormMap;
import com.first.entity.Params;
import com.first.entity.ResFormMap;
import com.first.entity.ResUserFormMap;
import com.first.entity.UserRoleFormMap;
import com.first.mapper.ResourcesMapper;
import com.first.util.Common;
import com.first.util.TreeObject;
import com.first.util.TreeUtil;

/**
 * 权限控制，菜单管理
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月4日
   @version 1.00
 */
@Controller
@RequestMapping("/resources/")
public class ResourcesController extends BaseController {
	@Inject
	private ResourcesMapper resourcesMapper;
	/**
	 * 菜单显示栏
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/resources/list";
	}

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("treelists")
	public ResFormMap findByPage(Model model) {
	
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		List<ResFormMap> mps = resourcesMapper.findByNames(resFormMap);
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : mps) {
			System.err.println("asd117"+map);
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0);
		resFormMap = new ResFormMap();
		resFormMap.put("treelists", ns);
		return resFormMap;
	}

	@ResponseBody
	@RequestMapping("reslists")
	public List<TreeObject> reslists(Model model) throws Exception {
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		List<ResFormMap> mps = resourcesMapper.findByWhere(resFormMap);
		List<TreeObject> list = new ArrayList<TreeObject>();
		for (ResFormMap map : mps) {
			TreeObject ts = new TreeObject();
			Common.flushObject(ts, map);
			list.add(ts);
		}
		TreeUtil treeUtil = new TreeUtil();
		List<TreeObject> ns = treeUtil.getChildTreeObjects(list, 0, "　");
		return ns;
	}


	/**
	 * 跳转到修改界面
	 * 
	 * @param model
	 * @param resourcesId
	 *            修改菜单信息ID
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model) {
		String id = getPara("id");
		if(Common.isNotEmpty(id)){
			model.addAttribute("resources", resourcesMapper.findbyFrist("id", id, ResFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/resources/edit";
	}

	/**
	 * 跳转到新增界面
	 * 
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) {
		return Common.BACKGROUND_PATH + "/system/resources/add";
	}

	
	/**
	 * 添加菜单
	 * 
	 * @param resources
	 * @return Map
	 * @throws Exception
	 */
	@RequestMapping("addEntity")
	@ResponseBody
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="资源管理-新增资源")//凡需要处理业务逻辑的.都需要记录操作日志
	public String addEntity() throws Exception {
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		if("2".equals(resFormMap.get("type"))){
			resFormMap.put("description", Common.htmltoString(resFormMap.get("description")+""));
		}
		Object o = resFormMap.get("ishide");
		if(null==o){
			resFormMap.set("ishide", "0");
		}
		
		resourcesMapper.addEntity(resFormMap);
		return "success";
	}

	/**
	 * 更新菜单
	 * 
	 * @param model
	 * @param Map
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	@SystemLog(module="系统管理",methods="资源管理-修改资源")//凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity(Model model) throws Exception {
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		if("2".equals(resFormMap.get("type"))){
			resFormMap.put("description", Common.htmltoString(resFormMap.get("description")+""));
		}
		Object o = resFormMap.get("ishide");
		if(null==o){
			resFormMap.set("ishide", "0");
		}
		resourcesMapper.editEntity(resFormMap);
		return "success";
	}

	/**
	 * 根据ID删除菜单
	 * 
	 * @param model
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("deleteEntity")
	@SystemLog(module="系统管理",methods="资源管理-删除资源")//凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity(Model model) throws Exception {
		String[] ids = getParaValues("ids");
		for (String id : ids) {
			resourcesMapper.deleteByAttribute("id", id, ResFormMap.class);
		};
		return "success";
	}

	@RequestMapping("sortUpdate")
	@ResponseBody
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String sortUpdate(Params params) throws Exception {
		List<String> ids = params.getId();
		List<String> es = params.getRowId();
		List<ResFormMap> maps = new ArrayList<ResFormMap>();
		for (int i = 0; i < ids.size(); i++) {
			ResFormMap map = new ResFormMap();
			map.put("id", ids.get(i));
			map.put("level", es.get(i));
			maps.add(map);
		}
		resourcesMapper.updateSortOrder(maps);
		return "success";
	}


	@ResponseBody
	@RequestMapping("findByButtom")
	public List<ButtomFormMap> findByButtom(){
		return resourcesMapper.findByWhere(new ButtomFormMap());
	}
	
	/**
	 * 验证菜单是否存在
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(String name,String resKey) {
		ResFormMap resFormMap = getFormMap(ResFormMap.class);
		List<ResFormMap> r = resourcesMapper.findByNames(resFormMap);
		if (r.size()==0) {
			return true;
		} else {
			return false;
		}
	}
}