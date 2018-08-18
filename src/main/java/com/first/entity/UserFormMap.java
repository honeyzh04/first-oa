package com.first.entity;

import com.first.annotation.TableSeg;
import com.first.util.FormMap;



/**
 * User实体表
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月4日
   @version 1.00
 */
@TableSeg(tableName = "ogMemberInfo", id="UserID")
public class UserFormMap extends FormMap<String,Object>{

	
	private static final long serialVersionUID = 1L;

}
