/**
 * 
 */
package com.first.service.system;

import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.first.entity.ProjectFormMap;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月24日
   @version 1.00
 */
@Service
public interface ProjectService {

	/**
	 * 添加项目
	 * @param searchMap
	 * @return
	 */
	public void addEntity(Map formMap) ;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProjectFormMap findbyProject(String id) ;
	
	/**
	 * 修改项目
	 */
	public void editEntity(ProjectFormMap formMap) ;
	/**
	 * 修改项目
	 */
	public void deleteEntity(String id) ;
	/**
	 * 添加项目
	 * @param searchMap
	 * @return
	 */

	public void addproject() ;

	
}
