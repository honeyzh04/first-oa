package com.first.util;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jieyan
 */
public class SendWeChat {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        try {
            //发送信息需要两个配置信息  可配置到配置文件中读取
            //1 corpsecret  部门的应用ID
            //2 agentid     部门的分组ID


            // <数据中心配置信息>
//            String corpsecret = "18o-jZRLdFBkLa61H5DqcRo9tKG3bHuNVnv0tGSm8DI"; //部门应用id
//            String agentid = "1000005";//部门分组id
            //<数据中心配置信息>
            //<房发现配置信息>
            String info = "消息内容\n第二行内容\n第三行内容"; //消息体内容
            String corpsecret = "BpANxJxdqKcImhb6zYPsj_gWpcm1iUC7ou8ALCsL10k"; //部门应用id
            String agentid = "1000006";//部门分组id
            //<房发现配置信息>
            SendWeChat sendWeChat=new SendWeChat();
            boolean is_send = sendWeChat.send_info(corpsecret, agentid,info);
            if (is_send) {
                System.out.println("发送成功");
            } else {
                System.out.println("发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     public  boolean send_info(String corpsecret, String agentid, String info) {
        try {
            String corpid = "ww1bfe0036f1ec1e74";
            URL url = new URL("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + corpsecret);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);
            connection.connect();
            InputStream is = connection.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String result = new String(jsonBytes, "UTF-8");
            Map<String, String> map = gson.fromJson(result, Map.class);
            is.close();
            return send_by_token(map.get("access_token"), agentid,info);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean send_by_token(String access_token, String agentid,String info) {
        try {
            URL url = new URL("https://qyapi.weixin.qq.com/cgi-bin/message/send?" + "access_token=" + access_token);
            HashMap<String, String> content = new HashMap<>();

            content.put("content", info);
            HashMap<String, Object> sendmsg = new HashMap<>();
            sendmsg.put("touser", "@all"); //可见成员
            sendmsg.put("msgtype", "text");
            sendmsg.put("agentid", agentid);//部门id
            sendmsg.put("text", content);
            sendmsg.put("safe", 0);   //是否加密  0不加密  1加密
            String jsonstr = gson.toJson(sendmsg, HashMap.class);
            HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setConnectTimeout(20000);
            http.setReadTimeout(20000);
            http.connect();
            OutputStream os = http.getOutputStream();
            os.write(jsonstr.getBytes("UTF-8"));// 传入参数
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String result = new String(jsonBytes, "UTF-8");
            os.flush();
            os.close();
            is.close();
            Map<String, String> result_map = gson.fromJson(result, Map.class);
            if (result_map.get("errmsg").equals("ok")) {
                return true;
            } else {

                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

