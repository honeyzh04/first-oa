package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.annotation.Token;
import com.first.controller.index.BaseController;
import com.first.entity.CustomerFormMap;
import com.first.entity.DepartmentFormMap;
import com.first.entity.ExtendFormMap;
import com.first.entity.UserFormMap;
import com.first.exception.SystemException;
import com.first.mapper.CustomerMapper;
import com.first.mapper.DepartMapper;
import com.first.service.system.ShareCustomerService;
import com.first.util.Common;
import com.first.util.TreeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 客户管理 Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年5月3日
 */
@Controller
@RequestMapping("/customer/")
public class CustomerController extends BaseController {
    private static final String String = null;
    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private DepartMapper departMapper;
    @Inject
    private ShareCustomerService shareCustomerService;

    /**
     * 账号查询
     *
     * @param model
     * @return
     * @throws Exception
     **/
    @RequestMapping("listUI")
    public String listUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/customer/list";
    }

    /**
     * 客户查看
     *
     * @param draw
     * @param start
     * @param length
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public Object findByPage(HttpServletRequest request, int draw, int start, int length) throws Exception {

        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

        String depar = userFormMap.get("department").toString();
        int depId = Integer.parseInt(depar);

        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("id", userFormMap.get("id"));
        searchMap.put("departmentId", userFormMap.get("department"));
        searchMap.put("customerName", request.getParameter("customerName"));
        searchMap.put("telephone", request.getParameter("telephone"));
        searchMap.put("followa", request.getParameter("followa"));
        searchMap.put("screateDate", request.getParameter("screateDate"));
        searchMap.put("ecreateDate", request.getParameter("ecreateDate"));
        searchMap.put("stotalPrice", request.getParameter("stotalPrice"));
        searchMap.put("etotalPrice", request.getParameter("etotalPrice"));
        searchMap.put("department", request.getParameter("department"));
        searchMap.put("userId", request.getParameter("userId"));
        searchMap.put("state", request.getParameter("state"));
        searchMap.put("intention", request.getParameter("intention"));

        /*
         * String g= request.getParameter("purpose"); String[] strarr =g.split(",");
         *
         */

        searchMap.put("purpose", request.getParameter("purpose"));
        searchMap.put("apartment", request.getParameter("apartment"));
        searchMap.put("cusource", request.getParameter("cusource"));
        searchMap.put("date", request.getParameter("date"));


        String choice = request.getParameter("choice").toString();
        ;
        searchMap.put("choice", choice);
        if (choice.equals("1")) {


            PageHelper.startPage((start / length) + 1, length);

            List<CustomerFormMap> p = customerMapper.findCustomerPage(searchMap);
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

        } else if (choice.equals("2")) {
            // 获取登录人部门及下属部门
            List<DepartmentFormMap> departmentFormMap = departMapper.getDepart();


            List<String> idss = new ArrayList<>();

            TreeUtil.treeMenuList(idss,departmentFormMap, depId);



            idss.add(depar);
            searchMap.put("departments", idss);





            PageHelper.startPage((start / length) + 1, length);

            List<CustomerFormMap> p = customerMapper.finddCustomerPage(searchMap);
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
            idss.clear();
            return map;
        } else {

            PageHelper.startPage((start / length) + 1, length);

            List<CustomerFormMap> p = customerMapper.findaCustomerPage(searchMap);
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

    }

    /**
     * 添加
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addUI")
    @Token(save = true)
    public String addUI(HttpServletRequest request, Model model) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

        model.addAttribute("user", userFormMap);
        return Common.BACKGROUND_PATH + "/system/customer/add";
    }

    /**
     * 添加
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addaUI")
    @Token(save = true)
    public String addaUI(HttpServletRequest request, Model model) throws Exception {
        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String dateStr = df.format(date);
        userFormMap.put("creatDate", dateStr.substring(0, 16));

        model.addAttribute("user", userFormMap);
        return Common.BACKGROUND_PATH + "/system/customer/add-a";
    }

    @ResponseBody
    @RequestMapping("addEntity")
    @SystemLog(module = "客户管理", methods = "客户管理-添加客户") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @Token(remove = true)
    public String addEntity(HttpServletRequest request) {

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
            System.out.println("AD" + source);
            if (source.equals("3") || source.equals("6")) {

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
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "editUI")
    public String editUI(Model model) throws Exception {
        String id = getPara("id");

        if (Common.isNotEmpty(id)) {
            // int id = Integer.parseInt(iid);
            CustomerFormMap mps = customerMapper.findbyeditUI(id);
            String visproject = customerMapper.findbyproject(id);



            model.addAttribute("customer", mps);
            model.addAttribute("visproject", visproject);
        }
        return Common.BACKGROUND_PATH + "/system/customer/edit";
    }

    @ResponseBody
    @RequestMapping("editEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "客户管理", methods = "用户管理-跟进客户") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editEntity() throws Exception {

        CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
        System.err.println("各级"+customerFormMap);
        customerFormMap.put("userName", getuserName());
        customerFormMap.put("userId", getuserId());

        Object ntrackDate = customerFormMap.get("ntrackDate");

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


            customerMapper.addVisit(customerFormMap);// 到访客户
            // &&dealprojectId !=null
        } else if (state.equals("4") && dealprojectId != null) {
            customerMapper.addVisit1(customerFormMap);//到访客户
            customerMapper.addDeal(customerFormMap);// 成交客户
        }
        return "success";
    }

    /**
     * 客户扩展
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "extendUI")
    public String extendUI(Model model) throws Exception {
        String id = getPara("id");
        String customerName = getPara("customerName");

        if (Common.isNotEmpty(id)) {
            // int id = Integer.parseInt(iid);
            ExtendFormMap mps = customerMapper.findbyExtend(id);
            mps.put("customerName", customerName);


            model.addAttribute("customer", mps);
        }
        return Common.BACKGROUND_PATH + "/system/customer/extend";
    }

    @ResponseBody
    @RequestMapping("extendEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "客户管理", methods = "客户管理-客户扩展") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String extendEntity() throws Exception {
        ExtendFormMap extendFormMap = getFormMap(ExtendFormMap.class);
        extendFormMap.put("createDate", new Date());


        customerMapper.editExtend(extendFormMap);

        return "success";
    }

    /**
     * 转让客户
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "transferUI")
    public String transferUI(Model model) throws Exception {
        String id = getPara("id");

        if (Common.isNotEmpty(id)) {
            // int id = Integer.parseInt(iid);
            CustomerFormMap mps = new CustomerFormMap();
            mps.put("id", id);
            model.addAttribute("customer", mps);
        }
        return Common.BACKGROUND_PATH + "/system/customer/transfer";
    }

    @ResponseBody
    @RequestMapping("transferEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "客户管理", methods = "客户管理-转让客户") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String transferEntity() throws Exception {
        CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
        String Ids = customerFormMap.get("id").toString();
        String userIds= customerFormMap.get("userId").toString();
        if (null != Ids && !Common.isEmpty(Ids.toString())) {
            String[] ids = Ids.split(",");
            for (String id : ids) {
                //查看该客户是否共享
                CustomerFormMap customer= customerMapper.findCustomer(id);
                String userId=customer.get("userId").toString();
                System.err.println(userId);
                HashMap a= shareCustomerService.findShareCustomer(id,userId);
                if(a!=null){
                    shareCustomerService.editShareCustomer(id,userId,userIds);
                    System.err.println(1111);

                }
                System.err.println("chakan"+a);

                customerFormMap.put("id", id);
                customerMapper.discardEntity(customerFormMap);
                customerFormMap.put("source", "3");
                customerFormMap.put("createDate", new Date());

                customerMapper.addCu(customerFormMap);// 新增客户统计



            }

        }
        return "success";
    }

    /**
     * 丢弃公共池
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "discardUI")
    public String discardUI(Model model) throws Exception {
        String id = getPara("id");
        if (Common.isNotEmpty(id)) {
            // int id = Integer.parseInt(iid);
            CustomerFormMap mps = new CustomerFormMap();
            mps.put("id", id);
            model.addAttribute("customer", mps);
        }
        return Common.BACKGROUND_PATH + "/system/customer/discard";
    }

    @ResponseBody
    @RequestMapping("discardEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "客户管理", methods = "客户管理-放入公共池") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String discardEntity() throws Exception {
        CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
        String id=customerFormMap.get("id").toString();
        System.err.println("公共出"+customerFormMap);
        customerFormMap.put("trackremind", "7");
        shareCustomerService.outShareCustomer(id,null);
        customerMapper.discardEntity(customerFormMap);

        return "success";
    }

    /**
     * 客户报备
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "preparationUI")
    public String preUI(Model model) throws Exception {
        String id = getPara("id");

        if (Common.isNotEmpty(id)) {
            // int id = Integer.parseInt(iid);
            CustomerFormMap mps = customerMapper.findbyeditUI(id);


            model.addAttribute("customer", mps);
        }
        return Common.BACKGROUND_PATH + "/system/customer/preparation";
    }

    @ResponseBody
    @RequestMapping("preparationEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "客户管理", methods = "客户管理-客户报备") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String preEntity() throws Exception {
        CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);

        customerMapper.addpreEntity(customerFormMap);


        return "success";
    }

    /**
     * 删除客户
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deleteEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "客户管理", methods = "客户管理-客户删除") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteEntity() throws Exception {
        String id = getPara("id");
        if (Common.isNotEmpty(id)) {

            customerMapper.deleteEntity(id);// 基本信息
            customerMapper.deleteFollow(id);// 跟进信息
            customerMapper.deletExtend(id);// 扩展信息
            customerMapper.deletePreparation(id);// 报备信息
        }
        return "success";
    }
    /**
     * 带访成交
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("dealvisitUI")
    public String dealvisitUI(HttpServletRequest request,Model model) throws Exception {

        UserFormMap userFormMap = (UserFormMap)Common.findUserSession(request);

        model.addAttribute("user", userFormMap);
        return Common.BACKGROUND_PATH + "/system/customer/visdealist";
    }
    @ResponseBody
    @RequestMapping("findByVisitCustomer")
    public Object findByVisitCustomer(HttpServletRequest request, int draw, int start, int length) throws Exception {
        System.out.println("123+2018");
        Map<String, Object> searchMap = new HashMap<String, Object>();

        searchMap.put("customerName", request.getParameter("customerName"));
        searchMap.put("telephone", request.getParameter("telephone"));
        searchMap.put("screateDate", request.getParameter("screateDate"));
        searchMap.put("ecreateDate", request.getParameter("ecreateDate"));

        PageHelper.startPage((start / length) + 1, length);

        List<CustomerFormMap> p = customerMapper.findvisitCustomerPage(searchMap);

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
    @RequestMapping(" findByDealCustomer")
    public Object  findByDealCustomer(HttpServletRequest request, int draw, int start, int length) throws Exception {
        System.out.println("123+20181");
        Map<String, Object> searchMap = new HashMap<String, Object>();

        searchMap.put("customerName", request.getParameter("customerName"));
        searchMap.put("telephone", request.getParameter("telephone"));
        searchMap.put("screateDate", request.getParameter("screateDate"));
        searchMap.put("ecreateDate", request.getParameter("ecreateDate"));

        PageHelper.startPage((start / length) + 1, length);

        List<CustomerFormMap> p = customerMapper.finddealCustomerPage(searchMap);

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
     * 客户共享
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "shareUI")
    public String shareUI(Model model) throws Exception {
        String id = getPara("id");

        if (Common.isNotEmpty(id)) {
            // int id = Integer.parseInt(iid);
            CustomerFormMap mps = customerMapper.findbyeditUI(id);


            model.addAttribute("customer", mps);
        }
        return Common.BACKGROUND_PATH + "/system/customer/share";
    }

    @ResponseBody
    @RequestMapping("shareEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "客户管理", methods = "客户管理-客户共享") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String shareEntity() throws Exception {
        CustomerFormMap customerFormMap = getFormMap(CustomerFormMap.class);
        customerFormMap.put("createDate", new Date());
        customerFormMap.put("state", "1");

        List<String> list = new ArrayList<String>();
        list = shareCustomerService.findOldUser(customerFormMap);
        String userId = customerFormMap.get("userId").toString();
        // String str=String.join(",", list);

        String Ids = customerFormMap.get("userIds").toString() + "," + userId;

        if (null != Ids && !Common.isEmpty(Ids.toString())) {
            String[] ids = Ids.split(",");
            for (String id : ids) {
                if (!list.contains(id)) {
                    customerFormMap.put("userId", id);

                    customerMapper.shareEntity(customerFormMap);
                    customerMapper.share1Entity(customerFormMap);
                }

            }

        }
        return "success";
    }

    /**
     * 房发现客户
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("fangfaxianlistUI")
    public String fangfaxianlistUI() throws Exception {

        return Common.BACKGROUND_PATH + "/system/customer/ffxlist";
    }

    @ResponseBody
    @RequestMapping("findByffxCustomer")
    public Object findByffxCustomer(HttpServletRequest request, int draw, int start, int length) throws Exception {

        Map<String, Object> searchMap = new HashMap<String, Object>();

        searchMap.put("customerName", request.getParameter("customerName"));
        searchMap.put("telephone", request.getParameter("telephone"));
        searchMap.put("screateDate", request.getParameter("screateDate"));
        searchMap.put("ecreateDate", request.getParameter("ecreateDate"));

        PageHelper.startPage((start / length) + 1, length);

        List<CustomerFormMap> p = customerMapper.findffxCustomerPage(searchMap);

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
     * 提示今日预约客户
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findNtrackDate")
    public  CustomerFormMap findNtrackDate() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String userId=getuserId();
        map.put("userId", userId);
        map.put("ntrackDate",new Date());

        CustomerFormMap p = customerMapper.findNtrackDate( map);

        return p;
    }
    /**
     * 预约客户
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "orderedCustomer")
    public String orderedCustomer(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/customer/orderedCustomer";
    }

    @ResponseBody
    @RequestMapping("findOrCustomer")
    public Object findOrCustomer(HttpServletRequest request, int draw, int start, int length) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        String userId=getuserId();
        map.put("userId", userId);
        map.put("ntrackDate",new Date());

        PageHelper.startPage((start/length)+1, length);

        List< CustomerFormMap> p = customerMapper.findOrCustomer( map);

        PageInfo<CustomerFormMap> pageinfo = new PageInfo<CustomerFormMap>(p);

        List<Object> data = new ArrayList<Object>();
        for (CustomerFormMap a : pageinfo.getList()) {

            data.add(a);

        }

        map.put("draw", draw);
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);

        return map;
    }


}