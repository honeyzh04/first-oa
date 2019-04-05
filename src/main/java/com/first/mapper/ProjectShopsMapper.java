package com.first.mapper;

import com.first.entity.ProjectOfficeFormMap;
import com.first.entity.ProjectShopsFormMap;
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

public interface ProjectShopsMapper {

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

}
