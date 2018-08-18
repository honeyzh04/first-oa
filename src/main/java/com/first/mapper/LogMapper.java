package com.first.mapper;

import java.util.List;

import com.first.entity.LogFormMap;

/**
 * 日志操作
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月19日
   @version 1.00
 */


public interface LogMapper {
	
	/**
	 * 1：传入继承FormMap的子类对象,返回是一个List<T>集合<br/>
	 * 2：调用findByPage接口,必须传入PageView对象! formMap.set("paging", pageView);<br/>
	 * 1：根据多字段分页查询 <br/>
	 * 3：如果是多个id,用","组成字符串. <br/>
	 * 4：formMap.put("id","xxx") 或 formMap.put("id","xxx,xxx,xxx") <br/>
	 * 5：formMap.put("name","xxx") 或 formMap.put("name","xxx,xxx,xxx") <br/>
	 * 6：兼容模糊查询。 formMap.put("name","用户%") 或 formMap.put("name","%用户%") <br/>
	 * 7：兼容排序查询 : formMap.put("$orderby","order by id desc");  
	 * @param formMap
	 * @return
	 */
	public  List<LogFormMap> findLogPage();

	/**
	 * 1：传入继承FormMap的子类对象 <br/>
	 * 2：保存数据,保存数据后返回子类对象的所有数据包括id..主建统一返回为id <br/>
	 * @param formMap
	 * @throws Exception
	 */
	public void addEntity(LogFormMap formMap) throws Exception;
}
