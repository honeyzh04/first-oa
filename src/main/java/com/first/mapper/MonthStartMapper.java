/**
 * 
 */
package com.first.mapper;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月31日
   @version 1.00
 */
public interface MonthStartMapper {
	/**
	 * 上月部门报表统计
	 * @throws Exception
	 */
	public void addreportpsum() throws Exception;
	/**
	 * 上月个报表统计
	 * @throws Exception
	 */
	public void addreportdsum() throws Exception;
	/**
	 * 删除一月前登陆信息
	 * @throws Exception
	 */
	public void deletelogin() throws Exception;
	/**
	 * 删除一月前操作
	 * @throws Exception
	 */
	public void deletelog() throws Exception;
	/**
	 * 删除三月前更进
	 * @throws Exception
	 */
	public void deletefollow() throws Exception;
	/**
	 * 删除三月前新增
	 * @throws Exception
	 */
	public void deleteadd() throws Exception;
	
}
