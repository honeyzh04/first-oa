/**
 * 
 */
package com.first.service.system.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.first.entity.ProjectFormMap;
import com.first.mapper.ProjectMapper;
import com.first.service.system.ProjectService;
import com.first.util.JsonUtils;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月24日
   @version 1.00
 */
@Service
public class ProjectServiceImpl implements ProjectService  {
	@Inject
	private ProjectMapper projectMapper;

	/* (non-Javadoc)
	 * @see com.first.service.system.ProjectService#addEntity(com.first.entity.ProjectFormMap)
	 */
	@Override
	public void addEntity(Map formMap) {
		projectMapper.addProject(formMap);
		
	}

	
	@Override
	public ProjectFormMap findbyProject(String id) {
		
		return projectMapper.findbyProject(id);
	}


	@Override
	public void editEntity(ProjectFormMap formMap) {
		projectMapper.editProject(formMap);
		
	}


	/**
	 * 删除项目
	 */
	@Override
	public void deleteEntity(String id) {
		projectMapper.deleteEntity(id);
		
	}
	/**
	 * 删除所有项目
	 */
	@Override
	public void deletesEntity() {
		projectMapper.deletesEntity();

	}



	
	public void addproject() {


		 List<Map<String, Object>> x= JsonUtils.getListByUrl("http://bd.fangfaxian.com/PrDC/GetPrInfoList/");
		 System.err.println("cxa"+x);
		deletesEntity();
		System.out.println("a1");
		 for (Map b:x) {
			b= JsonUtils.nullToEmpty(b);

			// String c = new String(b.toString().getBytes("GBK"),"utf-8");
			 System.err.println("cxa3"+b);
			 addEntity(b);
			
			
		 }
	}
		
	}
	


	



