package com.first.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  需要给两个值<br>
 * tableName = "表名"<br>
 * id = "表的主键"(如果是多个主建,默认为第一个)<br>
 * 
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月1日
   @version 1.00
 */

@Target({ ElementType.TYPE }) //用于描述类、接口(包括注解类型) 或enum声明
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TableSeg {
	/**
	 * 表名
	 * @return
	 */
	public String tableName();
	
	/**
	 * 表的主键,如果是多个主建,默认为第一个
	 * @return
	 */
	public String id();

}