/**
 * 
 */
package com.first.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月20日
   @version 1.00
 */

public class Test {
public static void main(String[] args) throws Exception {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	   String str="20180720";
  Date dt=sdf.parse(str);
	Calendar cal = Calendar.getInstance();
	cal.setTime(dt);
	int week = cal.get(Calendar.DAY_OF_WEEK);
	if(week==1) {
		week=6;
	}else if(week==2) {
		week=7;
	}else {
		week=week-2;
	}
	System.err.println(week);
}


}
	
		
	

