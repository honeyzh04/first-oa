/**
 * 
 */
package com.first.service.system.impl;

import com.first.entity.ProjectFormMap;
import com.first.mapper.ProjectMapper;
import com.first.service.system.ProjectService;
import com.first.util.JsonUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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
public class ProjectServiceImpl implements ProjectService  {
	@Inject
	private ProjectMapper projectMapper;




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

		deletesEntity();

		 for (Map b:x) {
			b= JsonUtils.nullToEmpty(b);

			// String c = new String(b.toString().getBytes("GBK"),"utf-8");
			// System.err.println("cxa3"+b);
			 addEntity(b);
			
			
		 }
	}

    @Override
    public void addprojects(ProjectFormMap formMap) {
        projectMapper.addProjects(formMap);
    }

    @Override
	public List<ProjectFormMap> findImg(Map searchMapMap) {
		return projectMapper.findImg(searchMapMap);
	}

	@Override
	public void addImg(HashMap imgForMap) {
		projectMapper.addImg(imgForMap);
	}

	@Override
	public void deleteImg(String id) {
		projectMapper.deleteImg(id);
	}

	@Override
	public List<ProjectFormMap> findFeature() {
			return projectMapper.findFeature();
	}

	@Override
	public List<ProjectFormMap> findProject(Map searchMapMap) {
			return 	projectMapper.findProject(searchMapMap);
	}
	@Override
	public List<ProjectFormMap> findProjects(Map searchMapMap) {
		return 	projectMapper.findProjects(searchMapMap);
	}
	@Override
	public void addShops(ProjectFormMap formMap) {
		projectMapper.addShops(formMap);
	}

	@Override
	public List<ProjectFormMap> findShopsList(Map searchMapMap) {

		return  projectMapper.findShopsList(searchMapMap);
	}

	@Override
	public ProjectFormMap findShops(String id) {
		return projectMapper.findShops(id);
	}

	@Override
	public void deleteShops(String id) {
		projectMapper.deleteShops(id);
	}

	@Override
	public List<ProjectFormMap> findShopsImg(String id) {
		return projectMapper.findShopsImg(id);
	}

	@Override
	public void addShopsImg(HashMap imgFormMap) {
		projectMapper.addShopsImg(imgFormMap);
	}

	@Override
	public void deleteShopsImg(String id) {
		projectMapper.deleteShopsImg(id);
	}

	@Override
	public void addApartment(ProjectFormMap formMap) {
		projectMapper.addApartment(formMap);
	}

	@Override
	public List<ProjectFormMap> findApartmentList(Map searchMapMap) {

		return  projectMapper.findApartmentList(searchMapMap);
	}

	@Override
	public ProjectFormMap findApartment(String id) {
		return projectMapper.findApartment(id);
	}

	@Override
	public void deleteApartment(String id) {
		projectMapper.deleteApartment(id);
	}

	@Override
	public List<ProjectFormMap> findApartmentImg(String id) {
		return  projectMapper.findApartmentImg(id);
	}

	@Override
	public void addApartmentImg(HashMap imgFormMap) {
		projectMapper.addApartmentImg(imgFormMap);
	}

	@Override
	public void deleteApartmentImg(String id) {
		projectMapper.deleteApartmentImg(id);
	}

	@Override
	public void addHome(ProjectFormMap formMap) {
		projectMapper.addHome(formMap);
	}

	@Override
	public List<ProjectFormMap> findHomeList(Map searchMapMap) {
		return  projectMapper.findHomeList(searchMapMap);
	}

	@Override
	public ProjectFormMap findHome(String id) {
		return projectMapper.findHome(id);
	}

	@Override
	public void deleteHome(String id) {
		projectMapper.deleteHome(id);
	}

	@Override
	public List<ProjectFormMap> findHomeImg(String id) {
		return  projectMapper.findHomeImg(id);
	}

	@Override
	public void addHomeImg(HashMap imgFormMap) {
			projectMapper.addHomeImg(imgFormMap);
	}

	@Override
	public void deleteHomeImg(String id) {
			projectMapper.deleteHomeImg(id);
	}

	@Override
	public List<HashMap> findProjectSearch(Map searchMap) {
		return projectMapper.findProjectSearch(searchMap);
	}

}
	


	



