package com.first.util;

import java.security.MessageDigest;
import java.util.Date;

/**
 * @Title: SHAUtil
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/10/3014:26
 */


public class SHAUtil {
    /***
     * SHA加密 生成40位SHA码
     * @param
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 测试主函数
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("amigoxiexiexingxing");
        long c=  new Date().getTime();
        String a ="api.fangfaxianFFXfangfaxianFFX"+c;
        System.out.println("SHA后：" + shaEncode(a));
/*
        String str1 = "hello";
        String base64Encoded = Base64.encodeToString(str1.getBytes());
        String str2 = Base64.decodeToString(base64Encoded);
        System.err.println("2"+base64Encoded);*/
    }
}

