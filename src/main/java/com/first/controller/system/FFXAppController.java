package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.CustomerFormMap;
import com.first.entity.UserFormMap;
import com.first.exception.SystemException;
import com.first.mapper.CustomerMapper;
import com.first.mapper.UserMapper;
import com.first.service.system.FFXAppService;
import com.first.service.system.ShareCustomerService;
import com.first.util.Common;
import com.first.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 房发现app接口
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年10月10日
 */

@Controller
@RequestMapping("/ffxapp/")
public class FFXAppController extends BaseController {
    @Inject
    private FFXAppService ffxAppService;
    @Inject
    private UserMapper userMapper;
    @Inject
    private CustomerMapper customerMapper;

    @Inject
    private ShareCustomerService sharecustomerservice;
    @ResponseBody
    @RequestMapping("findCustomer")
    public Result<Void> findCustomer(String userName, String customerName, String telephone, String state, String intention, @RequestParam(required = true, defaultValue = "1") Integer page) {
        Session session = SecurityUtils.getSubject().getSession();

        System.err.println("loginIP" + session.getHost());
        Result<Void> rr = null;
        try {
            System.err.println("que" + userName + "page" + page);
            if (userName == null || userName.length() == 0) {
                rr = new Result<Void>(0, "请输入经纪人姓名", "");

            } else {
                UserFormMap a = new UserFormMap();
                a.put("accountName", userName);

                UserFormMap user = userMapper.findByUser(a);

                if (user == null) {
                    rr = new Result<Void>(0, "用户不存在", "");
                } else {
                    Map<String, Object> searchMap = new HashMap<String, Object>();
                    searchMap.put("userName", userName);
                    searchMap.put("customerName", customerName);
                    searchMap.put("telephone", telephone);
                    searchMap.put("state", state);
                    searchMap.put("intention", intention);
                    System.err.println("app" + searchMap);
                    PageHelper.startPage(page, 10);
                    List<CustomerFormMap> p = ffxAppService.findCustomerPage(searchMap);
                    PageInfo<CustomerFormMap> pageinfo = new PageInfo<CustomerFormMap>(p);
                    System.err.println("app" + p);
                    rr = new Result<Void>(1, "成功", pageinfo);
                }
            }

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;


    }

    /**
     * 客户共享
     * @param userName
     * @param customerName
     * @param telephone
     * @param page
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findByShare")
    public  Result<Void> findByShare(String userName, String customerName, String telephone, @RequestParam(required = true, defaultValue = "1") Integer page) throws Exception {
        Result<Void> rr = null;
        try {
            System.err.println("que" + userName + "page" + page);
            if (userName == null || userName.length() == 0) {
                rr = new Result<Void>(0, "请输入经纪人姓名", "");

            } else {
                UserFormMap a = new UserFormMap();
                a.put("accountName", userName);

                UserFormMap user = userMapper.findByUser(a);

                if (user == null) {
                    rr = new Result<Void>(0, "用户不存在", "");
                } else {
                    Map<String, Object> searchMap = new HashMap<String, Object>();
                    searchMap.put("id",user.get("id").toString());
                    searchMap.put("customerName", customerName);
                    searchMap.put("telephone", telephone);

                    System.err.println("app" + searchMap);
                    PageHelper.startPage(page, 10);
                    List<CustomerFormMap> p = sharecustomerservice.findShareCu(searchMap);
                    PageInfo<CustomerFormMap> pageinfo = new PageInfo<CustomerFormMap>(p);
                    System.err.println("app" + p);
                    rr = new Result<Void>(1, "成功", pageinfo);
                }
            }

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;


    }
    /**
     * 添加客户
     *
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "addUI")
    public Result<Void> addUI(String userName) throws Exception {
        Result<Void> rr = null;
        try {
            UserFormMap a = new UserFormMap();
            a.put("accountName", userName);

            UserFormMap user = userMapper.findByUser(a);
            rr = new Result<Void>(1, "成功", user);


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    @ResponseBody
    @RequestMapping("addCustomer")
    @SystemLog(module = "客户管理", methods = "客户管理-添加客户") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    public String addCustomer() {

        try {
            CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);

            customerFormMap.put("createDate", new Date());
            customerFormMap.put("trackDate", new Date());
            customerFormMap.put("ntrackDate", null);

            customerMapper.addEntity(customerFormMap);// 新增后返回新增信息

            customerMapper.addFollow(customerFormMap);// 跟进客户
            customerMapper.addLFollow(customerFormMap);// 跟进客户长期保存

            customerMapper.addExtend(customerFormMap);// 扩展客户
            String source = customerFormMap.get("cusource").toString();
            System.out.println("AD1" + source);
            if (source.equals("3") || source.equals("6")) {
                System.err.println("fangfaxiankehu");
                customerMapper.addSource(customerFormMap);// 房发现客户具体来源
            }

            customerFormMap.put("source", "1");
            customerMapper.addCu(customerFormMap);// 新增客户统计
        } catch (Exception e) {
            throw new SystemException("添加客户异常");
        }
        return "success";
    }

    /**
     * 跟进客户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "editUI")
    public Result<Void> editUI(String id) throws Exception {
        Result<Void> rr = null;
        try {
            System.err.println("客户" + id);
            CustomerFormMap mps = null;
            if (Common.isNotEmpty(id)) {
                // int id = Integer.parseInt(iid);
                mps = customerMapper.findbyeditUI(id);
                String visproject = customerMapper.findbyproject(id);
                mps.put("visproject", visproject);
                rr = new Result<Void>(1, "成功", mps);
            }

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    @ResponseBody
    @RequestMapping("editEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "客户管理", methods = "用户管理-跟进客户") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editEntity() throws Exception {

        CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);

        System.err.println("客户跟进" + customerFormMap);
        Object ntrackDate = customerFormMap.get("ntrackDate");
        System.err.println(ntrackDate);
     /*   if (ntrackDate == null) {
            customerFormMap.put("ntrackDate", new Date());
        }*/
        /*
         * customerFormMap.put("visitprojectId", null);
         * customerFormMap.put("dealprojectId", null);
         */

        customerFormMap.put("trackDate", new Date());

        customerFormMap.put("trackremind", "0");
        customerMapper.editEntity(customerFormMap);// 修改客户

        customerMapper.addFollow(customerFormMap);// 跟进客户
        customerMapper.addLFollow(customerFormMap);// 跟进客户长期保存
        String state = customerFormMap.get("state").toString();
        Object visitprojectId = customerFormMap.get("visitprojectId");
        Object dealprojectId = customerFormMap.get("dealprojectId");

        if (state.equals("2") && visitprojectId != null) {

            System.err.println("s1");
            customerMapper.addVisit(customerFormMap);// 到访客户
            // &&dealprojectId !=null
        } else if (state.equals("4") && dealprojectId != null) {
            customerMapper.addVisit1(customerFormMap);//到访客户
            customerMapper.addDeal(customerFormMap);// 成交客户
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "shareUser")
    public Result<Void>  shareUser(String  id) throws Exception {
        Result<Void> rr = null;
        try {
        System.err.println("客户" + id);
        if (Common.isNotEmpty(id)) {
            // int id = Integer.parseInt(iid);
            List<String> mps = sharecustomerservice.findShareUser(id);// 报备信息
            System.err.println("ce" + mps);
            rr = new Result<Void>(1, "成功", mps);
        }

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }
    @ResponseBody
    @RequestMapping("appTest")
    public CustomerFormMap appTest() throws Exception {
        CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
        return customerFormMap;
    }

}

