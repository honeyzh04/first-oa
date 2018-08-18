/**
 * 
 */
package com.first.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 获取外部接口JSON数据
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月31日
   @version 1.00
 */
public class JsonInterface {

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      StringBuilder sb = new StringBuilder();
		  int cp;
		  while ((cp = rd.read()) != -1) {
		    sb.append((char) cp);
		  }
	      String jsonText = sb.toString();
	      System.err.println(jsonText);
	      JSONObject json = JSONObject.fromObject(jsonText);  
	      return json;
	    } finally {
	      is.close();
	    }
	  }

	  public static void main(String[] args) throws IOException, JSONException {
		/*
		  	String ip = "113.57.244.100";  
		    	String url = "http://win.firstjia.com/first-oa/TVreport/test.shtml";  
	 		    JSONObject json = JsonInterface.readJsonFromUrl(url);  
	 		    System.out.println(json.toString()); */
	 	
	 		 List<Map<String, Object>> x= JsonUtils.getListByUrl("http://win.firstjia.com/first-oa/TVreport/test1.shtml"); 
	 		 System.err.println("asd"+x);
	 		 for (Map b:x) {
	 			
	 			System.err.println(b);
	 		 }
		
	 	
	 			
	  }

}

