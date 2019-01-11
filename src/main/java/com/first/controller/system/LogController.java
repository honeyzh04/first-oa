package com.first.controller.system;

import com.first.controller.index.BaseController;
import com.first.entity.LogFormMap;
import com.first.mapper.LogMapper;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志操作查询
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月3日
   @version 1.00
 */
@Controller
@RequestMapping("/log/")
public class LogController extends BaseController {
	@Inject
	private LogMapper logMapper;

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/log/list";
	}
	@RequestMapping("system_list")
	public String systemUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/log/system_list";
	}


		@ResponseBody
		@RequestMapping("findByPage")
		public Object findByPage(int draw, int start, int length) throws Exception {
			 
			PageHelper.startPage((start/length)+1, length);
			List<LogFormMap> p=logMapper.findLogPage();
			PageInfo<LogFormMap>  pageinfo=new PageInfo<LogFormMap>(p);
			
		        Map<String, Object> map = new HashMap<String, Object>();  
		        List<Object> data = new ArrayList<Object>(); 
		        for(LogFormMap a: pageinfo.getList()) {
		        	data.add(a);
		        	 
		        }
		    
		        map.put("draw", draw);
		        map.put("recordsTotal", pageinfo.getTotal());  
		        map.put("recordsFiltered", pageinfo.getTotal()); 
		        map.put("data", data);  

		        return map; 
		}
	}
