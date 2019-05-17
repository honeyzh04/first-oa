/**
 * 
 */
package com.first.service.system.impl;

import com.first.entity.ProjectOfficeFormMap;
import com.first.entity.ProjectShopsFormMap;
import com.first.mapper.ProjectOfficeMapper;
import com.first.service.system.ProjectOfficeService;
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
public class ProjectOfficeServiceImpl implements ProjectOfficeService {
	@Inject
	private ProjectOfficeMapper projectOfficeMapper;

	@Override
	public List<ProjectOfficeFormMap> getProject() {
		return projectOfficeMapper.getProject();
	}

	@Override
	public List<ProjectOfficeFormMap> findProjectOffice(Map searchMapMap) {
		return  projectOfficeMapper.findProjectOffice(searchMapMap);
	}

	@Override
	public List<ProjectOfficeFormMap> findProjects(Map searchMapMap) {
		return  projectOfficeMapper.findProjects(searchMapMap);
	}

	@Override
	public void addProjects(ProjectOfficeFormMap formMap) {
		projectOfficeMapper.addProjects(formMap);
	}

	@Override
	public ProjectOfficeFormMap findbyProject(String id) {
		return  projectOfficeMapper.findbyProject(id);
	}

	@Override
	public void editProject(ProjectOfficeFormMap formMap) {
		projectOfficeMapper.editProject(formMap);
	}

	@Override
	public void deleteEntity(String id) {
		projectOfficeMapper.deleteEntity(id);
	}

	@Override
	public List<ProjectOfficeFormMap> findcuProject(Map searchMapMap) {
		return  projectOfficeMapper. findcuProject(searchMapMap);
	}

	@Override
	public List<ProjectOfficeFormMap> findImg(Map imgForMap) {
		return  projectOfficeMapper.findImg(imgForMap);
	}

	@Override
	public void addImg(HashMap imgFormMap) {
		projectOfficeMapper.addImg(imgFormMap);
	}

	@Override
	public void deleteImg(String id) {
		projectOfficeMapper.deleteImg(id);
	}

	@Override
	public void addOffice(ProjectOfficeFormMap formMap) {
		projectOfficeMapper.addOffice(formMap);
	}

	@Override
	public List<ProjectOfficeFormMap> findOfficeList(Map searchMap) {
		return  projectOfficeMapper.findOfficeList(searchMap);
	}

	@Override
	public ProjectOfficeFormMap findOffice(String id) {
		return  projectOfficeMapper.findOffice(id);
	}

	@Override
	public void editOffice(ProjectOfficeFormMap formMap) {
		projectOfficeMapper.editOffice(formMap);
	}

	@Override
	public void deleteOffice(String id) {
		projectOfficeMapper.deleteOffice(id);
	}

	@Override
	public List<ProjectOfficeFormMap> findOfficeImg(String id) {
		return  projectOfficeMapper.findOfficeImg(id);
	}

	@Override
	public void addOfficeImg(HashMap imgFormMap) {
		projectOfficeMapper.addOfficeImg(imgFormMap);
	}

	@Override
	public void deleteOfficeImg(String id) {
		projectOfficeMapper.deleteOfficeImg(id);
	}

	@Override
	public List<ProjectOfficeFormMap> findFeature() {
		return projectOfficeMapper.findFeature();
	}

	@Override
	public List<HashMap> findProjectSearch(Map searchMap) {
		return  projectOfficeMapper.findProjectSearch(searchMap);
	}

	@Override
	public List<HashMap> findProjectBusiness(Map searchMap) {

		return  projectOfficeMapper.findProjectBusiness(searchMap);
	}

	//经纪人小程序接口
	@Override
	public List<ProjectOfficeFormMap> findAgentProjects(Map searchMapMap) {
		return  projectOfficeMapper.findAgentProjects(searchMapMap);
	}

	@Override
	public ProjectOfficeFormMap findbyAgentProject(String id) {
		return projectOfficeMapper.findbyAgentProject(id);
	}
	@Override
	public void addAgentProjects( HashMap formMap) {

		projectOfficeMapper.addAgentProject(formMap);
	}
	@Override
	public void editAgentProject( HashMap formMap) {
		projectOfficeMapper.editAgentProject(formMap);
	}

	@Override
	public void deleteAgentEntity(String id) {
		projectOfficeMapper.deleteAgentProject(id);
	}

	@Override
	public List<ProjectOfficeFormMap> findAgentImg(Map imgForMap) {
		return projectOfficeMapper.findAgentImg(imgForMap);
	}

	@Override
	public void addAgentImg(HashMap imgFormMap) {
		projectOfficeMapper.addAgentImg(imgFormMap);
	}

	@Override
	public void deleteAgentImg(String id) {
		projectOfficeMapper.deleteAgentImg(id);
	}
}
	


	



