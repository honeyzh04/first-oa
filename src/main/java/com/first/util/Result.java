package com.first.util;    /**
 * @Title: Result
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/10/1014:39
 */

import java.io.Serializable;

/**
 * @Title: Result
 * @ProjectName first-oa
 * @Description: TODO
 * @author Administrator
 * @date 2018/10/1014:39
 */

public class Result<T> implements Serializable  {
    private static final long serialVersionUID = 1L;

    private Integer state;
    private String message;
    private Object content;
    public Integer getState() {
        return state;
    }
    public Result(){
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Result(Integer state, String message, Object content) {
        this.state = state;
        this.message = message;
        this.content = content;
    }





}
