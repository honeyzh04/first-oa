package com.first.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  这个是列表树形式显示的实体,
 * 这里的字段是在前台显示所有的,可修改
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月19日
   @version 1.00
 */
public class TreeDepartment {
	
	private Integer id;
	private Integer parentId;
	private String name;
	
	private List<TreeDepartment> children = new ArrayList<TreeDepartment>();
	
	public TreeDepartment() {
		
		
	}

	/**
	 * @param id
	 * @param parentId
	 * @param name
	 * @param children
	 */
	public TreeDepartment(Integer id, Integer parentId, String name, List<TreeDepartment> children) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.children = children;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the children
	 */
	public List<TreeDepartment> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<TreeDepartment> children) {
		this.children = children;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TreeDepartment [id=" + id + ", parentId=" + parentId + ", name=" + name + ", children=" + children
				+ "]";
	}
	


	
}