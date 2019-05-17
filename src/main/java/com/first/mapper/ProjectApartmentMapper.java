package com.first.mapper;

import com.first.entity.ProjectApartmentFormMap;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公寓项目操作 Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @date 2018年6月2日
 * @version 1.00
 */

public interface ProjectApartmentMapper {

	List<ProjectApartmentFormMap> getProject();
	/**
	 * 查看项目列表
	 *
	 * @return
	 */
	public List<ProjectApartmentFormMap> findProjectApartment(Map searchMapMap);

	/**
	 * 网站接口 查看项目列表
	 * @param searchMapMap
	 * @return
	 */
	public List<ProjectApartmentFormMap> findProjects(Map searchMapMap);
    /**
     * 添加项目
     */
    public void addProjects(ProjectApartmentFormMap formMap);
	/**
	 * 查看项目
	 *
	 * @return
	 */
	public ProjectApartmentFormMap findbyProject(@Param("id") String id);

	/**
	 * 修改项目
	 */
	public void editProject(ProjectApartmentFormMap formMap);

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
	public List<ProjectApartmentFormMap> findcuProject(Map searchMapMap);


	/**
	 * 查看项目图片
	 *
	 * @return
	 */
	 List<ProjectApartmentFormMap> findImg(Map imgForMap);

	void addImg(HashMap imgFormMap);

	void deleteImg(String id);



	/**
	 * 查看项目销控
	 *
	 * @return
	 */

	void addApartment(ProjectApartmentFormMap formMap);
	List<ProjectApartmentFormMap> findApartmentList(Map searchMap);
	ProjectApartmentFormMap findApartment(String id);
	void editApartment(ProjectApartmentFormMap formMap);
	void deleteApartment(String id);
	List<ProjectApartmentFormMap> findApartmentImg(String id);

	void addApartmentImg(HashMap imgFormMap);

	void deleteApartmentImg(String id);

	/**
	 *  查看项目特点
	 * @return
	 */
	List<ProjectApartmentFormMap> findFeature();

	List<HashMap> findProjectSearch(Map searchMap);
	List<HashMap> findProjectBusiness(Map searchMap);
	//经纪人小程序项目接口

	/**
	 * 查看项目列表
	 * @param searchMapMap
	 * @return
	 */
	public List<ProjectApartmentFormMap> findAgentProjects(Map searchMapMap);
	/**
	 * 添加项目
	 */
	public void addAgentProject( HashMap formMap);
	/**
	 * 查看项目
	 *
	 * @return
	 */
	public ProjectApartmentFormMap findbyAgentProject(@Param("id") String id);

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


	List<ProjectApartmentFormMap> findAgentImg(Map imgForMap);

	void addAgentImg(HashMap imgFormMap);

	void deleteAgentImg(String id);
}
