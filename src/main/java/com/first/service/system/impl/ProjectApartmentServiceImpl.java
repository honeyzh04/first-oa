/**
 * 
 */
package com.first.service.system.impl;

import com.first.entity.ProjectApartmentFormMap;
import com.first.entity.ProjectShopsFormMap;
import com.first.mapper.ProjectApartmentMapper;
import com.first.service.system.ProjectApartmentService;
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
public class ProjectApartmentServiceImpl implements ProjectApartmentService {
	@Inject
	private ProjectApartmentMapper projectApartmentMapper;


	@Override
	public List<ProjectApartmentFormMap> getProject() {
		return  projectApartmentMapper.getProject();
	}

	@Override
	public List<ProjectApartmentFormMap> findProjectApartment(Map searchMapMap) {
		return  projectApartmentMapper.findProjectApartment(searchMapMap);
	}

	@Override
	public List<ProjectApartmentFormMap> findProjects(Map searchMapMap) {
		return  projectApartmentMapper.findProjects(searchMapMap);
	}

	@Override
	public void addProjects(ProjectApartmentFormMap formMap) {
		projectApartmentMapper.addProjects(formMap);
	}

	@Override
	public ProjectApartmentFormMap findbyProject(String id) {
		return  projectApartmentMapper.findbyProject(id);
	}

	@Override
	public void editProject(ProjectApartmentFormMap formMap) {
		projectApartmentMapper.editProject(formMap);
	}

	@Override
	public void deleteEntity(String id) {
		projectApartmentMapper.deleteEntity(id);
	}

	@Override
	public List<ProjectApartmentFormMap> findcuProject(Map searchMapMap) {
		return  projectApartmentMapper. findcuProject(searchMapMap);
	}

	@Override
	public List<ProjectApartmentFormMap> findImg(Map imgForMap) {
		return  projectApartmentMapper.findImg(imgForMap);
	}

	@Override
	public void addImg(HashMap imgFormMap) {
		projectApartmentMapper.addImg(imgFormMap);
	}

	@Override
	public void deleteImg(String id) {
		projectApartmentMapper.deleteImg(id);
	}

	@Override
	public void addApartment(ProjectApartmentFormMap formMap) {
		projectApartmentMapper.addApartment(formMap);
	}

	@Override
	public List<ProjectApartmentFormMap> findApartmentList(Map searchMap) {
		return  projectApartmentMapper.findApartmentList(searchMap);
	}

	@Override
	public ProjectApartmentFormMap findApartment(String id) {
		return  projectApartmentMapper.findApartment(id);
	}

	@Override
	public void editApartment(ProjectApartmentFormMap formMap) {
		projectApartmentMapper.editApartment(formMap);
	}

	@Override
	public void deleteApartment(String id) {
		projectApartmentMapper.deleteApartment(id);
	}

	@Override
	public List<ProjectApartmentFormMap> findApartmentImg(String id) {
		return  projectApartmentMapper.findApartmentImg(id);
	}

	@Override
	public void addApartmentImg(HashMap imgFormMap) {
		projectApartmentMapper.addApartmentImg(imgFormMap);
	}

	@Override
	public void deleteApartmentImg(String id) {
		projectApartmentMapper.deleteApartmentImg(id);
	}

	@Override
	public List<ProjectApartmentFormMap> findFeature() {
		return projectApartmentMapper.findFeature();
	}

	@Override
	public List<HashMap> findProjectSearch(Map searchMap) {
		return  projectApartmentMapper.findProjectSearch(searchMap);
	}

	@Override
	public List<HashMap> findProjectBusiness(Map searchMap) {

		return  projectApartmentMapper.findProjectBusiness(searchMap);
	}

	//经纪人小程序接口
	@Override
	public List<ProjectApartmentFormMap> findAgentProjects(Map searchMapMap) {
		return  projectApartmentMapper.findAgentProjects(searchMapMap);
	}

	@Override
	public ProjectApartmentFormMap findbyAgentProject(String id) {
		return projectApartmentMapper.findbyAgentProject(id);
	}
	@Override
	public void addAgentProjects(HashMap formMap) {

		projectApartmentMapper.addAgentProject(formMap);
	}
	@Override
	public void editAgentProject(HashMap formMap) {
		projectApartmentMapper.editAgentProject(formMap);
	}

	@Override
	public void deleteAgentEntity(String id) {
		projectApartmentMapper.deleteAgentProject(id);
	}

	@Override
	public List<ProjectApartmentFormMap> findAgentImg(Map imgForMap) {
		return projectApartmentMapper.findAgentImg(imgForMap);
	}

	@Override
	public void addAgentImg(HashMap imgFormMap) {
		projectApartmentMapper.addApartmentImg(imgFormMap);
	}

	@Override
	public void deleteAgentImg(String id) {
		projectApartmentMapper.deleteAgentImg(id);
	}
}
	


	



