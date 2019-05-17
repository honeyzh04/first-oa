/**
 * 
 */
package com.first.service.system.impl;

import com.first.entity.ProjectShopsFormMap;
import com.first.mapper.ProjectShopsMapper;
import com.first.service.system.ProjectShopsService;
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
public class ProjectShopsServiceImpl implements ProjectShopsService {
	@Inject
	private ProjectShopsMapper projectShopsMapper;


	@Override
	public List<ProjectShopsFormMap> getProject() {
		return projectShopsMapper.getProject();
	}

	@Override
	public List<ProjectShopsFormMap> findProjectShops(Map searchMapMap) {
		return  projectShopsMapper.findProjectShops(searchMapMap);
	}

	@Override
	public List<ProjectShopsFormMap> findProjects(Map searchMapMap) {
		return  projectShopsMapper.findProjects(searchMapMap);
	}

	@Override
	public void addProjects(ProjectShopsFormMap formMap) {
		projectShopsMapper.addProjects(formMap);
	}

	@Override
	public ProjectShopsFormMap findbyProject(String id) {
		return  projectShopsMapper.findbyProject(id);
	}

	@Override
	public void editProject(ProjectShopsFormMap formMap) {
		projectShopsMapper.editProject(formMap);

	}

	@Override
	public void deleteEntity(String id) {
		projectShopsMapper.deleteEntity(id);
	}

	@Override
	public List<ProjectShopsFormMap> findcuProject(Map searchMapMap) {
		return  projectShopsMapper. findcuProject(searchMapMap);
	}

	@Override
	public List<ProjectShopsFormMap> findImg(Map imgForMap) {
		return  projectShopsMapper.findImg(imgForMap);
	}

	@Override
	public void addImg(HashMap imgFormMap) {
		projectShopsMapper.addImg(imgFormMap);
	}

	@Override
	public void deleteImg(String id) {
		projectShopsMapper.deleteImg(id);
	}

	@Override
	public void addShops(ProjectShopsFormMap formMap) {
		projectShopsMapper.addShops(formMap);
	}

	@Override
	public List<ProjectShopsFormMap> findShopsList(Map searchMap) {
		return  projectShopsMapper.findShopsList(searchMap);
	}

	@Override
	public ProjectShopsFormMap findShops(String id) {
		return  projectShopsMapper.findShops(id);
	}

	@Override
	public void editShops(ProjectShopsFormMap formMap) {
		projectShopsMapper.editShops(formMap);
	}

	@Override
	public void deleteShops(String id) {
		projectShopsMapper.deleteShops(id);
	}

	@Override
	public List<ProjectShopsFormMap> findShopsImg(String id) {
		return  projectShopsMapper.findShopsImg(id);
	}

	@Override
	public void addShopsImg(HashMap imgFormMap) {
		projectShopsMapper.addShopsImg(imgFormMap);
	}

	@Override
	public void deleteShopsImg(String id) {
		projectShopsMapper.deleteShopsImg(id);
	}

	@Override
	public List<ProjectShopsFormMap> findFeature() {
		return projectShopsMapper.findFeature();
	}

	@Override
	public List<HashMap> findProjectSearch(Map searchMap) {
		return  projectShopsMapper.findProjectSearch(searchMap);
	}

	@Override
	public List<HashMap> findProjectBusiness(Map searchMap) {

		return  projectShopsMapper.findProjectBusiness(searchMap);
	}


	//经纪人小程序接口
	@Override
	public List<ProjectShopsFormMap> findAgentProjects(Map searchMapMap) {
		return  projectShopsMapper.findAgentProjects(searchMapMap);
	}

	@Override
	public ProjectShopsFormMap findbyAgentProject(String id) {
		return projectShopsMapper.findbyAgentProject(id);
	}
	@Override
	public void addAgentProjects( HashMap formMap) {

			projectShopsMapper.addAgentProject(formMap);
	}
	@Override
	public void editAgentProject( HashMap formMap) {
		projectShopsMapper.editAgentProject(formMap);
	}

	@Override
	public void deleteAgentEntity(String id) {
		projectShopsMapper.deleteAgentProject(id);
	}

	@Override
	public List<ProjectShopsFormMap> findAgentImg(Map imgForMap) {
		return projectShopsMapper.findAgentImg(imgForMap);
	}

	@Override
	public void addAgentImg(HashMap imgFormMap) {
		projectShopsMapper.addShopsImg(imgFormMap);
	}

	@Override
	public void deleteAgentImg(String id) {
		projectShopsMapper.deleteAgentImg(id);
	}
}
	


	



