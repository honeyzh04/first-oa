/**
 * 
 */
package com.first.service.system.impl;

import com.first.entity.ProjectHomeFormMap;
import com.first.entity.ProjectHomeFormMap;
import com.first.entity.ProjectShopsFormMap;
import com.first.mapper.ProjectHomeMapper;
import com.first.service.system.ProjectHomeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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
public class ProjectHomeServiceImpl implements ProjectHomeService {
	@Inject
	private ProjectHomeMapper projectHomeMapper;


	@Override
	public List<ProjectHomeFormMap> getProject() {
		return projectHomeMapper.getProject();
	}

	@Override
	public List<ProjectHomeFormMap> findProjectHome(Map searchMapMap) {
		return  projectHomeMapper.findProjectHome(searchMapMap);
	}

	@Override
	public List<ProjectHomeFormMap> findProjects(Map searchMapMap) {
		return  projectHomeMapper.findProjects(searchMapMap);
	}

	@Override
	public void addProjects(ProjectHomeFormMap formMap) {
		projectHomeMapper.addProjects(formMap);
	}

	@Override
	public ProjectHomeFormMap findbyProject(String id) {
		return  projectHomeMapper.findbyProject(id);
	}

	@Override
	public void editProject(ProjectHomeFormMap formMap) {
		projectHomeMapper.editProject(formMap);
	}

	@Override
	public void deleteEntity(String id) {
		projectHomeMapper.deleteEntity(id);
	}

	@Override
	public List<ProjectHomeFormMap> findcuProject(Map searchMapMap) {
		return  projectHomeMapper. findcuProject(searchMapMap);
	}

	@Override
	public List<ProjectHomeFormMap> findImg(Map imgForMap) {
		return  projectHomeMapper.findImg(imgForMap);
	}

	@Override
	public void addImg(HashMap imgFormMap) {
		projectHomeMapper.addImg(imgFormMap);
	}

	@Override
	public void deleteImg(String id) {
		projectHomeMapper.deleteImg(id);
	}

	@Override
	public void addHome(ProjectHomeFormMap formMap) {
		projectHomeMapper.addHome(formMap);
	}

	@Override
	public List<ProjectHomeFormMap> findHomeList(Map searchMap) {
		return  projectHomeMapper.findHomeList(searchMap);
	}

	@Override
	public ProjectHomeFormMap findHome(String id) {
		return  projectHomeMapper.findHome(id);
	}

	@Override
	public void editHome(ProjectHomeFormMap formMap) {
		projectHomeMapper.editHome(formMap);
	}

	@Override
	public void deleteHome(String id) {
		projectHomeMapper.deleteHome(id);
	}

	@Override
	public List<ProjectHomeFormMap> findHomeImg(String id) {
		return  projectHomeMapper.findHomeImg(id);
	}

	@Override
	public void addHomeImg(HashMap imgFormMap) {
		projectHomeMapper.addHomeImg(imgFormMap);
	}

	@Override
	public void deleteHomeImg(String id) {
		projectHomeMapper.deleteHomeImg(id);
	}

	@Override
	public List<ProjectHomeFormMap> findFeature() {
		return projectHomeMapper.findFeature();
	}

	@Override
	public List<HashMap> findProjectSearch(Map searchMap) {
		return  projectHomeMapper.findProjectSearch(searchMap);
	}

	@Override
	public List<HashMap> findProjectBusiness(Map searchMap) {

		return  projectHomeMapper.findProjectBusiness(searchMap);
	}
	//经纪人小程序接口
	@Override
	public List<ProjectHomeFormMap> findAgentProjects(Map searchMapMap) {
		return  projectHomeMapper.findAgentProjects(searchMapMap);
	}

	@Override
	public ProjectHomeFormMap findbyAgentProject(String id) {
		return projectHomeMapper.findbyAgentProject(id);
	}
	@Override
	public void addAgentProjects(HashMap formMap) {

		projectHomeMapper.addAgentProject(formMap);
	}
	@Override
	public void editAgentProject(HashMap formMap) {
		projectHomeMapper.editAgentProject(formMap);
	}

	@Override
	public void deleteAgentEntity(String id) {
		projectHomeMapper.deleteAgentProject(id);
	}

	@Override
	public List<ProjectHomeFormMap> findAgentImg(Map imgForMap) {
		return projectHomeMapper.findAgentImg(imgForMap);
	}

	@Override
	public void addAgentImg(HashMap imgFormMap) {
		projectHomeMapper.addAgentImg(imgFormMap);
	}

	@Override
	public void deleteAgentImg(String id) {
		projectHomeMapper.deleteAgentImg(id);
	}
}
	


	



