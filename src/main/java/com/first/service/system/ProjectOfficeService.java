/**
 * 
 */
package com.first.service.system;

import com.first.entity.ProjectOfficeFormMap;
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
public interface ProjectOfficeService {

	List<ProjectOfficeFormMap> getProject();
	/**
	 * 查看项目列表
	 *
	 * @return
	 */
	public List<ProjectOfficeFormMap> findProjectOffice(Map searchMapMap);

	/**
	 * 网站接口 查看项目列表
	 * @param searchMapMap
	 * @return
	 */
	public List<ProjectOfficeFormMap> findProjects(Map searchMapMap);
	/**
	 * 添加项目
	 */
	public void addProjects(ProjectOfficeFormMap formMap);
	/**
	 * 查看项目
	 *
	 * @return
	 */
	public ProjectOfficeFormMap findbyProject(@Param("id") String id);

	/**
	 * 修改项目
	 */
	public void editProject(ProjectOfficeFormMap formMap);

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
	public List<ProjectOfficeFormMap> findcuProject(Map searchMapMap);


	/**
	 * 查看项目图片
	 *
	 * @return
	 */
	List<ProjectOfficeFormMap> findImg(Map imgForMap);

	void addImg(HashMap imgFormMap);

	void deleteImg(String id);



	/**
	 * 查看项目销控
	 *
	 * @return
	 */

	void addOffice(ProjectOfficeFormMap formMap);
	List<ProjectOfficeFormMap> findOfficeList(Map searchMap);
	ProjectOfficeFormMap findOffice(String id);
	void editOffice(ProjectOfficeFormMap formMap);
	void deleteOffice(String id);
	List<ProjectOfficeFormMap> findOfficeImg(String id);

	void addOfficeImg(HashMap imgFormMap);

	void deleteOfficeImg(String id);

	/**
	 *  查看项目特点
	 * @return
	 */
	List<ProjectOfficeFormMap> findFeature();

	List<HashMap> findProjectSearch(Map searchMap);
	List<HashMap> findProjectBusiness(Map searchMap);


}
