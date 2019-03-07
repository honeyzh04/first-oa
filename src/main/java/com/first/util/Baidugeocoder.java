/**
 * 
 */
package com.first.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取百度地图经纬度
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年7月27日
   @version 1.00
 */
public class Baidugeocoder {
	public static Map<String,String> getLatAndLngByAddress(String addr){
        String address = "";
        String lat = "";
        String lng = "";
        try {  
            address = java.net.URLEncoder.encode(addr,"UTF-8");  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } 
        String url = String.format("http://api.map.baidu.com/geocoder/v2/?"
        +"ak=x0baOoLE2m6N9QKwHcZv8e53&output=json&address=%s",address);
        URL myURL = null;
        URLConnection httpsConn = null;  
        //进行转码
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {

        }
        try {
            httpsConn = (URLConnection) myURL.openConnection();
            if (httpsConn != null) {
                InputStreamReader insr = new InputStreamReader(
                        httpsConn.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(insr);
                String data = null;
                if ((data = br.readLine()) != null) {
                    lat = data.substring(data.indexOf("\"lat\":") 
                    + ("\"lat\":").length(), data.indexOf("},\"precise\""));
                    lng = data.substring(data.indexOf("\"lng\":") 
                    + ("\"lng\":").length(), data.indexOf(",\"lat\""));
                }
                insr.close();
            }
        } catch (IOException e) {

        }
       /* Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        map.put("lat", new BigDecimal(lat));
        map.put("lng", new BigDecimal(lng));*/
        Map<String,String> map = new HashMap<String, String>();
        double lats=new Double(lat);
        double lngs=new Double(lng);
         DecimalFormat df = new DecimalFormat("#.000000");
        String a= df.format(lats);
        String b= df.format(lngs);
      // String b= String.format("%.2f",a);
        map.put("lat",a);
        map.put("lng", b);
        return map;
}
}
