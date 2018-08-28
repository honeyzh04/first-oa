package com.first.util;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Title: JsonInterfaceTest
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/8/2815:21
 */
public class JsonInterfaceTest {

    @Test
    public void readJsonFromUrl() {
    }

    @Test
    public void show1() {
        List<Map<String, Object>> x = JsonUtils.getListByUrl("http://win.firstjia.com/first-oa/TVreport/test1.shtml");
        System.err.println("asd" + x);
        for (Map b : x) {

            System.err.println(b);
        }
    }
}