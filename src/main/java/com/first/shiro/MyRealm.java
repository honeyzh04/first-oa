package com.first.shiro;

import com.first.entity.ResFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.ResourcesMapper;
import com.first.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.inject.Inject;
import java.util.List;
/**
 * 自定义Realm,进行数据源配置
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月9日
   @version 1.00
 */
public class MyRealm extends AuthorizingRealm {

	/**
	 * 用户信息操作类，实现用户信息，用户角色信息、用户权限信息查询功能  
	 */
	@Inject
	private ResourcesMapper resourcesMapper;

	@Inject
	private UserMapper userMapper;

	/**
	 * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String loginName = SecurityUtils.getSubject().getPrincipal().toString();
		
		if (loginName != null) {
		
			String userId = SecurityUtils.getSubject().getSession().getAttribute("userSessionId").toString();
			
			List<ResFormMap> rs = resourcesMapper.findUserResourcess(userId);
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户的角色集合
			// info.addRole("default");
			// 用户的角色集合
			// info.setRoles(user.getRolesName());
			// 用户的角色对应的所有权限，如果只使用角色定义访问权限
			for (ResFormMap resources : rs) {
				info.addStringPermission(resources.get("resKey").toString());
			}
			
			return info;
		}
		return null;
	}

	/**
	 * 认证回调函数,登录时调用
	 * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
	 * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
	 * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
	 * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
	 * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
	 * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
	 * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		System.out.println("名字"+username);
		UserFormMap userFormMap = new UserFormMap();
		userFormMap.put("accountName", "" + username + "");
		List<UserFormMap> userFormMaps = userMapper.findByNames(userFormMap);
		System.err.println(userFormMaps);
		if (userFormMaps.size() != 0) {
			String locked= userFormMaps.get(0).get("locked").toString();
			System.err.println("0".equals(locked));
			if ("0".equals(locked)) {
				throw new LockedAccountException(); // 帐号锁定
			}
			// 从数据库查询出来的账号名和密码,与用户输入的账号和密码对比
			// 当用户执行登录时,在方法处理上要实现user.login(token);
			// 然后会自动进入这个类进行认证
			// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, // 用户名
					userFormMaps.get(0).get("password"), // 密码
					ByteSource.Util.bytes(username + "" + userFormMaps.get(0).get("credentialsSalt")),// 盐 salt=username+salt
					getName() // 当前 realm name
			);
			// 当验证都通过后，把用户信息放在session里
			Session session = SecurityUtils.getSubject().getSession();
			//System.err.println("session过期时间"+session.getTimeout());
			/*session.setAttribute("userSession", userFormMaps.get(0));
			session.setAttribute("userSessionId", userFormMaps.get(0).get("id"));*/
			return authenticationInfo;
		} else {
			throw new UnknownAccountException();// 没找到帐号
		}

	}
	/**
     * 更新用户授权信息缓存.
     */
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
     * 更新用户信息缓存.
     */
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	/**
	 * 清除用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	/**
	 * 清除用户信息缓存.
	 */
	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}
	
	/**
	 * 清空所有缓存
	 */
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}


	/**
	 * 清空所有认证缓存
	 */
	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
   public void clearCache() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}