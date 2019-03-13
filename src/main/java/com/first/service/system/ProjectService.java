/**
 * 
 */
package com.first.service.system;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
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
	 * 删除项目
	 */
	public void deleteEntity(String id) ;

	/**
	 * 删除所有
	 */
	public void deletesEntity();
	/**
	 * 添加项目
	 * @return
	 */

	public void addproject() throws UnsupportedEncodingException;
    public void addprojects(ProjectFormMap formMap) ;
    //项目图片操作
	List<ProjectFormMap> findImg(Map imgForMap);

	void addImg(HashMap imgFormMap);

	void deleteImg(String id);
	//查看项目特点
	List<ProjectFormMap> findFeature();
	List<ProjectFormMap> findProject(Map searchMapMap);

	List<ProjectFormMap> findProjects(Map searchMapMap);

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
