package com.first.mapper;

import com.first.entity.ProjectHomeFormMap;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目操作 Copyright (C), 2018-2022, ChengDu First Real estate agency
 * 
 * @author zhaoh
 * @date 2018年6月2日
 * @version 1.00
 */

public interface ProjectHomeMapper {

	List<ProjectHomeFormMap> getProject();
	/**
	 * 查看项目列表
	 *
	 * @return
	 */
	public List<ProjectHomeFormMap> findProjectHome(Map searchMapMap);

	/**
	 * 网站接口 查看项目列表
	 * @param searchMapMap
	 * @return
	 */
	public List<ProjectHomeFormMap> findProjects(Map searchMapMap);
	/**
	 * 添加项目
	 */
	public void addProjects(ProjectHomeFormMap formMap);
	/**
	 * 查看项目
	 *
	 * @return
	 */
	public ProjectHomeFormMap findbyProject(@Param("id") String id);

	/**
	 * 修改项目
	 */
	public void editProject(ProjectHomeFormMap formMap);

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
	public List<ProjectHomeFormMap> findcuProject(Map searchMapMap);


	/**
	 * 查看项目图片
	 *
	 * @return
	 */
	List<ProjectHomeFormMap> findImg(Map imgForMap);

	void addImg(HashMap imgFormMap);

	void deleteImg(String id);



	/**
	 * 查看项目销控
	 *
	 * @return
	 */

	void addHome(ProjectHomeFormMap formMap);
	List<ProjectHomeFormMap> findHomeList(Map searchMap);
	ProjectHomeFormMap findHome(String id);
	void editHome(ProjectHomeFormMap formMap);
	void deleteHome(String id);
	List<ProjectHomeFormMap> findHomeImg(String id);

	void addHomeImg(HashMap imgFormMap);

	void deleteHomeImg(String id);

	/**
	 *  查看项目特点
	 * @return
	 */
	List<ProjectHomeFormMap> findFeature();

	List<HashMap> findProjectSearch(Map searchMap);
	List<HashMap> findProjectBusiness(Map searchMap);
	//经纪人小程序项目接口

	/**
	 * 查看项目列表
	 * @param searchMapMap
	 * @return
	 */
	public List<ProjectHomeFormMap> findAgentProjects(Map searchMapMap);
	/**
	 * 添加项目
	 */
	public void addAgentProject( HashMap formMap);
	/**
	 * 查看项目
	 *
	 * @return
	 */
	public ProjectHomeFormMap findbyAgentProject(@Param("id") String id);

	/**
	 * 修改项目
	 */
	public void editAgentProject( HashMap formMap);

	/**
	 * 删除项目
	 *
	 * @param id
	 */
	public void deleteAgentProject(String id);


	List<ProjectHomeFormMap> findAgentImg(Map imgForMap);

	void addAgentImg(HashMap imgFormMap);

	void deleteAgentImg(String id);
}
