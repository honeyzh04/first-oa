package com.first.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  防止重复提交注解，用于方法上<br/>
 *  在新建页面方法上，设置save为true，此时拦截器会在Session中保存一个token，
 *   同时需要在新建的页面中添加
 *  <input type="hidden" name="token" value="${token}">
 *  <br/>
 *  保存方法需要验证重复提交的，设置remove为true
 * @Title: Token
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/11/2715:13
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {

    boolean save() default false;

    boolean remove() default false;

}

