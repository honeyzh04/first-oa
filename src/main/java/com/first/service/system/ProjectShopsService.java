/**
 * 
 */
package com.first.service.system;

import com.first.entity.ProjectFormMap;
import com.first.entity.ProjectShopsFormMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月24日
   @version 1.00
 */
@Service
public interface ProjectShopsService {


	List<ProjectShopsFormMap> getProject();

	/**
	 * 查看项目列表
	 *
	 * @return
	 */
	public List<ProjectShopsFormMap> findProjectShops(Map searchMapMap);

	/**
	 * 网站接口 查看项目列表
	 * @param searchMapMap
	 * @return
	 */
	public List<ProjectShopsFormMap> findProjects(Map searchMapMap);
	/**
	 * 添加项目
	 */
	public void addProjects(ProjectShopsFormMap formMap);
	/**
	 * 查看项目
	 *
	 * @return
	 */
	public ProjectShopsFormMap findbyProject(@Param("id") String id);

	/**
	 * 修改项目
	 */
	public void editProject(ProjectShopsFormMap formMap);

	/**
	 * 删除项目
	 *
	 * @param id
	 */
	public void deleteEntity(String id);

	/**
	 * 匹配项目
	 *
	 * @return
	 */
	public List<ProjectShopsFormMap> findcuProject(Map searchMapMap);


	/**
	 * 查看项目图片
	 *
	 * @return
	 */
	List<ProjectShopsFormMap> findImg(Map imgForMap);

	void addImg(HashMap imgFormMap);

	void deleteImg(String id);



	/**
	 * 查看项目销控
	 *
	 * @return
	 */

	void addShops(ProjectShopsFormMap formMap);
	List<ProjectShopsFormMap> findShopsList(Map searchMap);
	ProjectShopsFormMap findShops(String id);
	void editShops(ProjectShopsFormMap formMap);
	void deleteShops(String id);
	List<ProjectShopsFormMap> findShopsImg(String id);

	void addShopsImg(HashMap imgFormMap);

	void deleteShopsImg(String id);

	/**
	 *  查看项目特点
	 * @return
	 */
	List<ProjectShopsFormMap> findFeature();

	List<HashMap> findProjectSearch(Map searchMap);
	List<HashMap> findProjectBusiness(Map searchMap);


	//经纪人小程序项目接口

	/**
	 * 查看项目列表
	 * @param searchMapMap
	 * @return
	 */
	public List<ProjectShopsFormMap> findAgentProjects(Map searchMapMap);
	/**
	 * 添加项目
	 */
	public void addAgentProjects( HashMap formMap);
	/**
	 * 查看项目
	 *
	 * @return
	 */
	public ProjectShopsFormMap findbyAgentProject(@Param("id") String id);

	/**
	 * 修改项目
	 */
	public void editAgentProject( HashMap formMap);

	/**
	 * 删除项目
	 *
	 * @param id
	 */
	public void deleteAgentEntity(String id);


	List<ProjectShopsFormMap> findAgentImg(Map imgForMap);

	void addAgentImg(HashMap imgFormMap);

	void deleteAgentImg(String id);
}
