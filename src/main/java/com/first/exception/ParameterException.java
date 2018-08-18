/**
 * @(#)ParameterException.java 2011-12-20 Copyright 2011 it.kedacom.com, Inc.
 *                             All rights reserved.
 */

package com.first.exception;
/**
 * 自定义异常处理,描述类..throw new ParameterException("XXXX")
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
   @author zhaoh
 * @date 2018年4月4日
   @version 1.00
 */

public class ParameterException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 6417641452178955756L;

	public ParameterException() {
		super();
	}

	public ParameterException(String message) {
		super(message);
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}
