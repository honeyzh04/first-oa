package com.first.mapper;

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

	/**
	 * 添加项目
	 */
	public void addProject(Map formMap);

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

}
