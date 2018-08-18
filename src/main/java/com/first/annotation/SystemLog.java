package com.first.annotation;  
  
import java.lang.annotation.*;  

/**
 * 
 * 自定义注解 拦截Controller 
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月1日
   @version 1.00
 */
  
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public  @interface SystemLog {  
  
	String module()  default "";  //模块名称 系统管理-用户管理－列表页面
	String methods()  default "";  //新增用户
    String description()  default "";  //描述
  
  
}  
  
