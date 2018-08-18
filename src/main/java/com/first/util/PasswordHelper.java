package com.first.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.first.entity.UserFormMap;
/**
 * 密码加密工具 
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月18日
   @version 1.00
 */
public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void encryptPassword(UserFormMap userFormMap) {
		String salt=randomNumberGenerator.nextBytes().toHex();
		userFormMap.put("credentialsSalt", salt);
		String newPassword = new SimpleHash(algorithmName, userFormMap.get("password"), ByteSource.Util.bytes(userFormMap.get("accountName")+salt), hashIterations).toHex();
		userFormMap.put("password", newPassword); 
	}
	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		UserFormMap userFormMap = new UserFormMap();
		userFormMap.put("password","123456");
		userFormMap.put("accountName","guoshengqi");
		passwordHelper.encryptPassword(userFormMap);
		System.out.println(userFormMap);
		
	}
}
