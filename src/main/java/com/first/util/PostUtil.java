package com.first.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 添加房发现账号
 * @Title: PostUtil
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/10/3014:02
 */

public class PostUtil {

    public static String httpPost(String urlStr, Map<String, String> params) {
        URL connect;
        StringBuffer data = new StringBuffer();
        try {
            long c=  new Date().getTime();
            String a ="api.fangfaxianFFXfangfaxianFFX"+c;
             String b= SHAUtil.shaEncode(a);

            connect = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) connect.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);//post不能使用缓存
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("Com-AppKey",b+"."+c );
            connection.setRequestProperty("Com-AppId","api.fangfaxian" );
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            OutputStreamWriter paramout = new OutputStreamWriter(
                    connection.getOutputStream(), "UTF-8");
            String paramsStr = "";   //拼接Post 请求的参数
            for (String param : params.keySet()) {
                paramsStr += "&" + param + "=" + params.get(param);
            }
            if (!paramsStr.isEmpty()) {
                paramsStr = paramsStr.substring(1);
            }
            paramout.write(paramsStr);
            paramout.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }

            paramout.close();
            reader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data.toString();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("CreatID", "1");
        map.put("OAID", "500");
        map.put("LoginName", "zhangsan");
        map.put("MemberName", "zhangsan");
        String url = "http://api.fangfaxian.com/api/OGMember";
        System.out.println(httpPost(url, map));

    }

}
