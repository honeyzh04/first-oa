package com.first.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.first.entity.ProjectFormMap;

/**
 * 项目操作 Copyright (C), 2018-2022, ChengDu First Real estate agency
 * 
 * @author zhaoh
 * @date 2018年6月2日
 * @version 1.00
 */

public interface ProjectMapper {
	/**
	 * 查看项目
	 * 
	 * @return
	 */
	public List<ProjectFormMap> getProject();

	/**
	 * 查看项目
	 * 
	 * @return
	 */
	public List<ProjectFormMap> findProject(Map searchMapMap);

	public List<ProjectFormMap> findProjects(Map searchMapMap);
	/**
	 * 添加项目
	 */
	public void addProject(Map formMap);
    /**
     * 添加项目
     */
    public void addProjects(ProjectFormMap formMap);
	/**
	 * 查看项目
	 * 
	 * @return
	 */
	public ProjectFormMap findbyProject(@Param("id")String id);

	/**
	 * 修改项目
	 */
	public void editProject(ProjectFormMap formMap);

	/**
	 * 删除项目
	 * 
	 * @param id
	 */
	public void deleteEntity(String id);
	/**
	 * 删除所有项目
	 *
	 *
	 */
	public void deletesEntity();
	
	/**
	 * 匹配项目
	 * 
	 * @return
	 */
	public List<ProjectFormMap> findcuProject(Map searchMapMap);
	public List<ProjectFormMap> findProjecttest();
	/**
	 * 查询项目最大id
	 */
	public String findMaxId();

	/**
	 * 查看项目图片
	 *
	 * @return
	 */
	 List<ProjectFormMap> findImg(Map imgForMap);

	void addImg(HashMap imgFormMap);

	void deleteImg(String id);

	List<ProjectFormMap> findFeature();

	void addShops(ProjectFormMap formMap);
	List<ProjectFormMap> findShopsList(Map searchMap);
	ProjectFormMap findShops(String id);
	void editShops(ProjectFormMap formMap);
	void deleteShops(String id);
	List<ProjectFormMap> findShopsImg(String id);

	void addShopsImg(HashMap imgFormMap);

	void deleteShopsImg(String id);

	void addApartment(ProjectFormMap formMap);
	List<ProjectFormMap> findApartmentList(Map searchMap);
	ProjectFormMap findApartment(String id);
	void editApartment(ProjectFormMap formMap);
	void deleteApartment(String id);
	List<ProjectFormMap> findApartmentImg(String id);

	void addApartmentImg(HashMap imgFormMap);

	void deleteApartmentImg(String id);

	void addHome(ProjectFormMap formMap);
	List<ProjectFormMap> findHomeList(Map searchMap);
	ProjectFormMap findHome(String id);
	void editHome(ProjectFormMap formMap);
	void deleteHome(String id);
	List<ProjectFormMap> findHomeImg(String id);

	void addHomeImg(HashMap imgFormMap);

	void deleteHomeImg(String id);

	List<HashMap> findProjectSearch(Map searchMap);
	List<HashMap> findProjectBusiness(Map searchMap);

}
