package com.first.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.first.entity.DepartmentFormMap;
import com.first.mapper.DepartMapper;
import com.first.util.TreeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.controller.index.BaseController;
import com.first.entity.CustomerFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.CustomerMapper;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 公共池客户管理
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年5月26日
 */
@Controller
@RequestMapping("/publicCustomer/")
public class publicCustomerController extends BaseController {
    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private DepartMapper departMapper;

    /**
     * 页面显示
     *
     * @param model
     * @return
     * @throws Exception
     **/
    @RequestMapping("listUI")
    public String listUI(HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("res", findByRes());
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

        model.addAttribute("user", userFormMap);
        return Common.BACKGROUND_PATH + "/system/publicCustomer/list";
    }

    /**
     * 客户列表查看
     *
     * @param draw
     * @param start
     * @param length
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findByCustomer")
    public Object findByCustomer(HttpServletRequest request, int draw, int start, int length) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("id", userFormMap.get("id"));
        searchMap.put("department", userFormMap.get("department"));
        searchMap.put("customerName", request.getParameter("customerName"));
        searchMap.put("telephone", request.getParameter("telephone"));
        searchMap.put("userId", request.getParameter("userName"));
        searchMap.put("stotalPrice", request.getParameter("stotalPrice"));
        searchMap.put("etotalPrice", request.getParameter("etotalPrice"));
        searchMap.put("purpose", request.getParameter("purpose"));
        searchMap.put("apartment", request.getParameter("apartment"));
        String depar = userFormMap.get("department").toString();
        int depId = Integer.parseInt(depar);
        List<DepartmentFormMap> departmentFormMap = departMapper.getDepart();

        List<String> idss = new ArrayList<>();

        TreeUtil.treeMenuList(idss,departmentFormMap, depId);
        idss.add(depar);
        searchMap.put("departments", idss);
        PageHelper.startPage((start / length) + 1, length);

        List<CustomerFormMap> p = customerMapper.findcCustomerPage(searchMap);

        PageInfo<CustomerFormMap> pageinfo = new PageInfo<CustomerFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (CustomerFormMap a : pageinfo.getList()) {

            data.add(a);

        }

        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);

        return map;
    }

    @ResponseBody
    @RequestMapping("findByAll")
    public Object findByAll(HttpServletRequest request, int draw, int start, int length) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("id", userFormMap.get("id"));

        searchMap.put("customerName", request.getParameter("customerName"));
        searchMap.put("telephone", request.getParameter("telephone"));

        searchMap.put("department", request.getParameter("department"));
        searchMap.put("userId", request.getParameter("userId"));
        searchMap.put("stotalPrice", request.getParameter("stotalPrice"));
        searchMap.put("etotalPrice", request.getParameter("etotalPrice"));
        searchMap.put("purpose", request.getParameter("purpose"));
        searchMap.put("apartment", request.getParameter("apartment"));
        searchMap.put("screateDate", request.getParameter("screateDate"));
        searchMap.put("ecreateDate", request.getParameter("ecreateDate"));

        searchMap.put("cusource", request.getParameter("acusource"));
        PageHelper.startPage((start / length) + 1, length);

        List<CustomerFormMap> p = customerMapper.findcAllPage(searchMap);

        PageInfo<CustomerFormMap> pageinfo = new PageInfo<CustomerFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (CustomerFormMap a : pageinfo.getList()) {

            data.add(a);

        }

        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);

        return map;
    }

    /**
     * 公共池拾取客户
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "pickupUI")
    public String discardUI(HttpServletRequest request) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        CustomerFormMap customerFormMap = new CustomerFormMap();
        customerFormMap.put("userId", userFormMap.get("id"));
        customerFormMap.put("department", userFormMap.get("department"));
        customerFormMap.put("userName", userFormMap.get("userName"));

        String Ids = getPara("id");



        if (null != Ids && !Common.isEmpty(Ids.toString())) {
            String[] ids = Ids.split(",");
            for (String id : ids) {
                customerFormMap.put("id", id);
                customerFormMap.put("stop", 1);
                customerFormMap.put("resources", 1);
                customerFormMap.put("state", 1);
                //customerFormMap.put("trackremind", 1);

                customerMapper.discardEntity(customerFormMap);
                customerFormMap.put("source", "2");
                customerFormMap.put("createDate", new Date());

                customerMapper.addCu(customerFormMap);// 新增客户统计
            }

        }


        return "success";
    }


}