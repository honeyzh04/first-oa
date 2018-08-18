package com.first.shiro.credentials;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.ByteSource;

/**
 * 身份认证的密码匹配
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月22日
   @version 1.00
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
  
    }
    
    @Override
    //身份认证的密码匹配
    public boolean doCredentialsMatch(AuthenticationToken token,
        AuthenticationInfo info) {
    	
        String username = (String) token.getPrincipal();
      ;
        
     
        // retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
      
        if (retryCount.incrementAndGet() > 5) {
            // if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }
        //进行密码验证的，如果成功，则清除ehcache中存储的记录登录失败次数的count
       
     
    
        boolean matches=super.doCredentialsMatch(token, info);
     
        System.err.println("登录验证是否成功"+matches);

        if (matches) {
            // clear retry count
            passwordRetryCache.remove(username);
        }
     
        return matches;
    }
	

	public String buildCredentials(String userName, String password,String credentialsSalt) {
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,ByteSource.Util.bytes(userName + credentialsSalt),userName);
		//用户名/密码Token组
		AuthenticationToken token = new UsernamePasswordToken(userName, password);
		
		return super.hashProvidedCredentials(token, authenticationInfo).toString();
	
    }

}
