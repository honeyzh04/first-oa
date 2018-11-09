package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.ProjectFormMap;
import com.first.mapper.ProjectMapper;
import com.first.service.system.ProjectService;
import com.first.util.Common;
import com.first.util.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 项目管理
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年6月2日
   @version 1.00
 */
@Controller
@RequestMapping("/project/")
public class ProjectController extends BaseController{
	@Inject
	private ProjectMapper projectMapper;
	@Inject
	private  ProjectService projectService;
	@RequestMapping("tablelist")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/project/tablelist";
	}
	@RequestMapping("maplist")
	public String maplistUI(Model model) throws Exception {
		/*projectservice.addproject();*/
		return Common.BACKGROUND_PATH + "/system/project/maplist";
	}
	/**
	 * 选择项目
	 * @return
	 */
	@RequestMapping("getProject")
	@ResponseBody
	public List<ProjectFormMap>  showProvince(){
		System.err.println("bumn");
		List<ProjectFormMap>  projectFormMap = projectMapper.getProject();
		System.err.println( "项目"+projectFormMap);
		System.err.println(JSONArray.fromObject(projectFormMap).toString());
		return   projectFormMap;
	}
	/**
	 * 项目列表
	 * @param request
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping("findByProject")
	public Object findByProject(HttpServletRequest request, int draw, int start, int length) throws Exception {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("projectName", request.getParameter("projectName"));
		searchMap.put("region", request.getParameter("region"));
		searchMap.put("type", request.getParameter("type"));
		
		System.err.println("dsa"+"".equals(request.getParameter("area")));
		if("".equals(request.getParameter("area"))) {
			searchMap.put("areas","");
			searchMap.put("areae","");
		}else{
			String a=request.getParameter("area").toString();
			String [] areas=a.split("-");
			for(int i=0;i<areas.length;i++) {
				
			}
			searchMap.put("areas",areas[0]);
			searchMap.put("areae",areas[1]);
			
		};
		if("".equals(request.getParameter("prices"))) {
			searchMap.put("pricess","");
			searchMap.put("pricese","");
		}else{
			String a=request.getParameter("prices").toString();
			String [] price=a.split("-");
			for(int i=0;i<price.length;i++) {
				
			}
			searchMap.put("pricess",price[0]);
			searchMap.put("pricese",price[1]);
			
		};
		
		System.err.println("阿萨达"+searchMap);
		PageHelper.startPage((start / length) + 1, length);
		List<ProjectFormMap>  p = projectMapper.findProject(searchMap);
		PageInfo<ProjectFormMap> pageinfo = new PageInfo<ProjectFormMap>(p);

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> data = new ArrayList<Object>();
		for (ProjectFormMap a : pageinfo.getList()) {
			data.add(a);
		}
		map.put("draw", draw);
		map.put("recordsTotal", pageinfo.getTotal());
		map.put("recordsFiltered", pageinfo.getTotal());
		map.put("data", data);
		System.err.println("lj"+map);
		return map;
	}


	/**
	 * 添加
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
		
		return Common.BACKGROUND_PATH + "/system/project/add";
	}

/*	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = "项目管理", methods = "项目管理-添加项目") // 凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly=false)//需要事务操作必须加入此注解
	public String addEntity() {
		System.err.println("项目添加1");
		try {
			ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
			System.err.println("oo"+projectFormMap);
			projectFormMap.put("createDate", new Date());
			projectservice.addEntity(projectFormMap);
		} catch (Exception e) {
			throw new SystemException("添加项目异常");
		}
		return "success";
	}
	*/
	/**
	 * 修改项目
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "editUI")
	public String editUI(Model model,@RequestParam("id") String id) throws Exception {
		//String id = getPara("id");
		System.err.println("asd" + id);
		if (Common.isNotEmpty(id)) {
			System.err.println("asd2" );
			ProjectFormMap mps=projectService.findbyProject(id);
			
			System.err.println("1"+mps);
			model.addAttribute("project", mps);
		}
		return Common.BACKGROUND_PATH + "/system/project/edit";
	}

/*	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "项目管理", methods = "项目管理-修改项目") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity(String txtGroupsSelect) throws Exception {
		ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
		
		 projectService.editEntity(projectFormMap);
	
		System.err.println("c测试2");

		return "success";
	}*/
	/**
	 * 删除项目
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "项目管理", methods = "项目管理-删除项目") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		System.err.println("cc");
		String Ids = getPara("ids");
		 String []ids=Ids.split(",");
		for (String id : ids) {
			projectService.deleteEntity(id);
			System.err.println("asd" + id);
		
		}
		return "success";
	}
	/**
	 * 手动更新项目
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("updateEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "项目管理", methods = "项目管理-更新项目") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String updateEntity() throws Exception {
			System.err.println("genx");
			projectService.addproject();
		
		return "success";
	}
	/**
	 * 自动更新项目
	 */

	@Scheduled(cron = "0 0 3,13 * * ?")
	public void  updateProject() throws UnsupportedEncodingException {


		projectService.addproject();

	}

	/**
	 * 楼盘详情
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "housedetail")
	public String housedetailUI(Model model,@RequestParam("id") String id,@RequestParam("state") String state){

		System.err.println("asd" + id+"DA"+state);
		if(state.equals("2")){
			state="在售";
		}else {
			state="停售";
		}
		System.err.println(state);
		model.addAttribute("IDs",id);
		model.addAttribute("state",state);
		return Common.BACKGROUND_PATH + "/system/project/housedetail";
	}


}









