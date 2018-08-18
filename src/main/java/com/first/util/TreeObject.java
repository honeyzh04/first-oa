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
public class TreeObject {
	
	private Integer id;
	private Integer parentId;
	private String name;
	private String parentName;
	private String resKey;
	private String resUrl;
	private Integer level;
	private String type;
	private String description;
	private String icon;
	private Integer ishide;
	private Date createDate;
	private List<TreeObject> children = new ArrayList<TreeObject>();
	
	public TreeObject() {
		
		
	}
	

	/**
	 * @param id
	 * @param parentId
	 * @param name
	 * @param parentName
	 * @param resKey
	 * @param resUrl
	 * @param level
	 * @param type
	 * @param description
	 * @param icon
	 * @param ishide
	 * @param createDate
	 * @param children
	 */
	public TreeObject(Integer id, Integer parentId, String name, String parentName, String resKey, String resUrl,
			Integer level, String type, String description, String icon, Integer ishide, Date createDate,
			List<TreeObject> children) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.parentName = parentName;
		this.resKey = resKey;
		this.resUrl = resUrl;
		this.level = level;
		this.type = type;
		this.description = description;
		this.icon = icon;
		this.ishide = ishide;
		this.createDate = createDate;
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
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}
	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * @return the resKey
	 */
	public String getResKey() {
		return resKey;
	}
	/**
	 * @param resKey the resKey to set
	 */
	public void setResKey(String resKey) {
		this.resKey = resKey;
	}
	/**
	 * @return the resUrl
	 */
	public String getResUrl() {
		return resUrl;
	}
	/**
	 * @param resUrl the resUrl to set
	 */
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the ishide
	 */
	public Integer getIshide() {
		return ishide;
	}
	/**
	 * @param ishide the ishide to set
	 */
	public void setIshide(Integer ishide) {
		this.ishide = ishide;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the children
	 */
	public List<TreeObject> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<TreeObject> children) {
		this.children = children;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TreeObject [id=" + id + ", parentId=" + parentId + ", name=" + name + ", parentName=" + parentName
				+ ", resKey=" + resKey + ", resUrl=" + resUrl + ", level=" + level + ", type=" + type + ", description="
				+ description + ", icon=" + icon + ", ishide=" + ishide + ", createDate=" + createDate + ", children="
				+ children + "]";
	}

	
	
	
	
	
}