package com.first.logAop;
import com.first.annotation.SystemLog;
import com.first.entity.LogFormMap;
import com.first.mapper.LogMapper;
import com.first.util.Common;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * 切点类
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月1日
   @version 1.00
 */
@Aspect //@Aspect放在类头上，把这个类作为一个切面。
@Component
public  class LogAopAction {
    //本地异常日志记录对象
     private  static  final Logger logger = LoggerFactory.getLogger(LogAopAction. class);
     @Inject
 	private LogMapper logMapper;
     //Controller层切点
    @Pointcut("@annotation(com.first.annotation.SystemLog)")//@Pointcut放在方法头上，定义一个可被别的方法引用的切入点表达式。
     public  void controllerAspect() {
    }
    
    /**
     *  操作异常记录，后通知（After advice） ：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
     * @param point
     * @param e
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")  
    public  void doAfterThrowing(JoinPoint point, Throwable e) {  
    	LogFormMap logForm = new LogFormMap();
		 Map<String, Object> map = null;
		String user = null;
		String ip = null;
		try {
			ip = SecurityUtils.getSubject().getSession().getHost();
		} catch (Exception ee) {
			ip = "无法获取登录用户Ip";
		}
		try {
			map=getControllerMethodDescription(point);
			// 登录名
			user = SecurityUtils.getSubject().getPrincipal().toString();
			if (Common.isEmpty(user)) {
				user = "无法获取登录用户信息！";
			}
		} catch (Exception ee) {
			user = "无法获取登录用户信息！";
		}
		
    	logForm.put("accountName",user);
		logForm.put("module",map.get("module"));
		logForm.put("methods","<font color=\"red\">执行方法异常:-->"+map.get("methods")+"</font>");	
		logForm.put("actionTime","0");
		logForm.put("userIP",ip);
		logForm.put("operTime",new  Date());
		logForm.put("description","<font color=\"red\">执行方法异常:-->"+e+"</font>");
		try {
			
			logMapper.addEntity(logForm);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *环绕通知（Around advice） ：包围一个连接点的通知，类似Web中Servlet规范中的Filter的doFilter方法。
     *可以在方法的调用前后完成自定义的行为，也可以选择不执行。
     * @param point 切点
     */
    @Around("controllerAspect()")
     public Object doController(ProceedingJoinPoint point) {
    	Object result = null;
		// 执行方法名
		String methodName = point.getSignature().getName();
		String className = point.getTarget().getClass().getSimpleName();
		LogFormMap logForm = new LogFormMap();
		 Map<String, Object> map = null;
		String user = null;
		Long start = 0L;
		Long end = 0L;
		Long time = 0L;
		String ip = null;
		try {
			ip = SecurityUtils.getSubject().getSession().getHost();
		} catch (Exception e) {
			ip = "无法获取登录用户Ip";
		}
		try {
			// 登录名
			user = SecurityUtils.getSubject().getPrincipal().toString();
			if (Common.isEmpty(user)) {
				user = "无法获取登录用户信息！";
			}
		} catch (Exception e) {
			user = "无法获取登录用户信息！";
		}
		// 当前用户
		try {
			map=getControllerMethodDescription(point);
			// 执行方法所消耗的时间
			start = System.currentTimeMillis();
			result = point.proceed();
			end = System.currentTimeMillis();
		    time = end - start;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
         try {
 			logForm.put("accountName",user);
 			logForm.put("module",map.get("module"));
 			logForm.put("methods",map.get("methods"));
 			logForm.put("description",map.get("description"));
 			logForm.put("actionTime",time.toString());
 			logForm.put("userIP",ip);
 			logForm.put("operTime",new  Date());
 			logMapper.addEntity(logForm);
            //*========控制台输出=========*//
            System.out.println("=====通知开始=====");
            System.out.println("请求方法:" + className + "." + methodName + "()");
            System.out.println("方法描述:" + map);
            System.out.println("请求IP:" + ip);
            System.out.println("=====通知结束=====");
        }  catch (Exception e) {
            //记录本地异常日志
            logger.error("====通知异常====");
            logger.error("异常信息:{}", e.getMessage());
        }
         return result;
    }
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
     @SuppressWarnings("rawtypes")
	public Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	//Signature getSignature();	获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
    	// Object[] getArgs();	获取传入目标方法的参数对象
    	// Object getTarget();	获取被代理的对象
    	// Object getThis();	获取代理对象
    	String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
         for (Method method : methods) {
             if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                 if (clazzs.length == arguments.length) {
                	 map.put("module", method.getAnnotation(SystemLog.class).module());
                	 map.put("methods", method.getAnnotation(SystemLog.class).methods());
                	 String de = method.getAnnotation(SystemLog.class).description();
                	 if(Common.isEmpty(de))de="执行成功!";
                	 map.put("description", de);
                     break;
                }
            }
        }
         return map;
    }
}
