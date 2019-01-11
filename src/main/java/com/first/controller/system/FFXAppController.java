package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.*;
import com.first.exception.SystemException;
import com.first.mapper.CustomerMapper;
import com.first.mapper.DepartMapper;
import com.first.mapper.InterlocutionMapper;
import com.first.mapper.UserMapper;
import com.first.service.system.CreditService;
import com.first.service.system.FFXAppService;
import com.first.service.system.PersonalService;
import com.first.service.system.ShareCustomerService;
import com.first.util.*;
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
import java.text.SimpleDateFormat;
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
    private ShareCustomerService shareCustomerService;
    @Inject
    private InterlocutionMapper interlocutionMapper;
    @Inject
    private PersonalService personalService;
    @Inject
    private DepartMapper departMapper;
    @Inject
    private CreditService creditService;

    /**
     * 查找用户信息
     * @param userName
     * @return
     */
    private UserFormMap findByUser(String userName){
        UserFormMap user=new UserFormMap();
        if(userName!=null){
            UserFormMap a = new UserFormMap();
            a.put("accountName", userName);
             user = userMapper.findByUser(a);

        }
        return  user;
    }

    /**
     * 销售个人信息
     *
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "userInfo")
    public Result<Void> addUI(String userName) throws Exception {
        Result<Void> rr = null;
        try {
            UserFormMap user =  findByUser(userName);
            rr = new Result<Void>(1, "成功", user);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }
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
                    Map<String, Object> searchMap = new HashMap<>();
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
     *
     * @param userName
     * @param customerName
     * @param telephone
     * @param page
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findByShare")
    public Result<Void> findByShare(String userName, String customerName, String telephone, @RequestParam(required = true, defaultValue = "1") Integer page) throws Exception {
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
                    searchMap.put("id", user.get("id").toString());
                    searchMap.put("customerName", customerName);
                    searchMap.put("telephone", telephone);

                    System.err.println("app" + searchMap);
                    PageHelper.startPage(page, 10);
                    List<CustomerFormMap> p = shareCustomerService.findShareCu(searchMap);
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
    public Result<Void> shareUser(String id) throws Exception {
        Result<Void> rr = null;
        try {
            System.err.println("客户" + id);
            if (Common.isNotEmpty(id)) {
                // int id = Integer.parseInt(iid);
                List<String> mps = shareCustomerService.findShareUser(id);// 报备信息
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


    @ResponseBody
    @RequestMapping("findQuestion")
    public Result<Void> findQuestionsa(String que, @RequestParam(required = true, defaultValue = "1") Integer page) {
        Result<Void> rr = null;
        System.err.println("que" + que + "page" + page);
        try {
            PageHelper.startPage(page, 10);
            List<InterlocutionFormMap> p = interlocutionMapper.findQuestions(que);
            PageInfo<InterlocutionFormMap> pageinfo = new PageInfo<InterlocutionFormMap>(p);
            rr = new Result<Void>(1, "成功", pageinfo);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }
    @ResponseBody
    @RequestMapping("findAnswer")
    public Result<Void> findAnswer(String id) {
        Result<Void> rr = null;

        try {
            if(id!=null &id .length()!=0){
                List<InterlocutionFormMap> p = interlocutionMapper.findanswers(id);
                rr = new Result<Void>(1, "成功",p);
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    @ResponseBody
    @RequestMapping("addAnswer")
    @SystemLog(module = "系统功能", methods = "销售百问-回答问题") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    public String addAnswer() {
        try {
            InterlocutionFormMap interlocutionFormMap = getFormMap(InterlocutionFormMap.class);
            interlocutionFormMap.put("createDate", new Date());
            System.err.println(interlocutionFormMap);
            interlocutionMapper.addanswer(interlocutionFormMap);// 新增后返回新增信息
        } catch (Exception e) {
            throw new SystemException("修改异常");
        }
        return "success";
    }

    /**
     * 添加个人日报表
     * @return
     * @throws Exception
     */
    @RequestMapping("dayadd")
    @ResponseBody
    public String dayadd() throws Exception {
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        System.err.println(personalFormMap);
        personalService.addDayPlan(personalFormMap);
        return "success";
    }
    /**
     * 验证计划是否存在
     *
     * @param
     * @return
     */
    @RequestMapping("isExist")
    @ResponseBody
    public Result<Void> isExist(String createDate,String userId) throws Exception {
        Result<Void> rr = null;
        try {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("createDate", createDate);
        searchMap.put("userId", userId);
        PersonalFormMap lis  = personalService.finddayadd(searchMap);
        if (lis == null) {
            rr = new Result<Void>(1, "成功",true);
        } else {
            rr = new Result<Void>(1, "成功",false);
        }

    } catch (RuntimeException e) {
        rr = new Result<Void>(0, e.getMessage(), "");
    }
        return rr;
}
    /**
     * 个人报表审核
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("pereport")
    public  Result<Void> pereportUI(String userName) throws Exception {
        Result<Void> rr = null;

        try {
            if (userName == null || userName.length() == 0) {
                rr = new Result<Void>(0, "经纪人用户名不正确", "");
            }else {
        UserFormMap user=findByUser(userName);
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("createDate", new Date());
        searchMap.put("userId", user.get("id"));
        searchMap.put("nexteDate",DateUtil.getnNext());
        PersonalFormMap daynextP = personalService.findnextdayadd(searchMap);
        PersonalFormMap daylisR = personalService.finddayreport(searchMap); //日数据
        System.err.println(daylisR);
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        String date1 = formater.format(new Date());
        Date date = formater.parse(date1);
        Date a = DateUtil.getThisWeekTuesday(date);
        Date b = DateUtil.getNextWeekTuesday(date);
        searchMap.put("screateDate", a);
        searchMap.put("ecreateDate", b);
        PersonalFormMap weeklisP = personalService.findweekadd(searchMap); //周计划
        PersonalFormMap weeklisR = personalService.findweekreport(searchMap);//周数据
        System.err.println("2"+weeklisP);
        PersonalFormMap monthlisP = personalService.findmonthadd(searchMap);   //月计划
        PersonalFormMap monthlisR = personalService.findmonthreport(searchMap);//月数据
            HashMap<String,PersonalFormMap> p=new HashMap<>();
            p.put("daynextP",daynextP);
            p.put("daylisR",daylisR);
            p.put("weeklisP",weeklisP);
            p.put("weeklisR",weeklisR);
            p.put("monthlisP",monthlisP);
            p.put("monthlisR", monthlisR);
            rr = new Result<Void>(1, "成功",p);
            }
    } catch (RuntimeException e) {
        rr = new Result<Void>(0, e.getMessage(), "");
    }
        return rr;
}
    /**
     * 添加部门日计划
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("dedayadd")
    @ResponseBody
    public String dedayadd() throws Exception {
        PersonalFormMap personalFormMap = getFormMap(PersonalFormMap.class);
        personalService.adddeDayPlan(personalFormMap);
        return "success";
    }


    /**
     * 验证部门计划是否存在
     *
     * @param
     * @return
     */
    @RequestMapping("deisExist")
    @ResponseBody
    public   Result<Void> deisExist(String createDate,String deId) throws Exception {
        Result<Void> rr = null;
        try {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("createDate", createDate);
        searchMap.put("deId", deId);
        PersonalFormMap lis = personalService.finddedayadd(searchMap);
        if (lis == null) {
            rr = new Result<Void>(1, "成功",true);
        } else {
            rr = new Result<Void>(1, "成功",false);
        }

    } catch (RuntimeException e) {
        rr = new Result<Void>(0, e.getMessage(), "");
    }
        return rr;
}
    /**
     * 部门报表审核
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("dereport")
    public  Result<Void> dereportUI(String userName) throws Exception {
        Result<Void> rr = null;

        try {
            if (userName == null || userName.length() == 0) {
                rr = new Result<Void>(0, "经纪人用户名不正确", "");
            }else {
                UserFormMap user=findByUser(userName);
                Map<String, Object> searchMap = new HashMap<String, Object>();
                searchMap.put("createDate", new Date());
                searchMap.put("userId", user.get("id"));
                searchMap.put("deId", user.get("departmentId"));
                searchMap.put("nexteDate",DateUtil.getnNext());

                String depar = user.get("departmentId").toString();
                int depId = Integer.parseInt(depar);
                List<DepartmentFormMap> departmentFormMap = departMapper.getDepart();
                List<String> idss = new ArrayList<>();
                TreeUtil.treeMenuList(idss,departmentFormMap, depId);
                idss.add(depar);
                searchMap.put("departments", idss);
                PersonalFormMap daynextP = personalService.finddenextdayadd(searchMap);
                PersonalFormMap daylisR = personalService.finddedayreport(searchMap); //日数据
                SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
                String date1 = formater.format(new Date());
                Date date = formater.parse(date1);
                Date a = DateUtil.getThisWeekTuesday(date);
                Date b = DateUtil.getNextWeekTuesday(date);
                searchMap.put("screateDate", a);
                searchMap.put("ecreateDate", b);
                PersonalFormMap weeklisP = personalService.finddeweekadd(searchMap); //周计划
                PersonalFormMap weeklisR = personalService.finddeweekreport(searchMap);//周数据

                PersonalFormMap monthlisP = personalService.finddemonthadd(searchMap);   //月计划
                PersonalFormMap monthlisR = personalService.finddemonthreport(searchMap);//月数据
                HashMap<String,PersonalFormMap> p=new HashMap<>();
                p.put("daynextP",daynextP);
                p.put("daylisR",daylisR);
                p.put("weeklisP",weeklisP);
                p.put("weeklisR",weeklisR);
                p.put("monthlisP",monthlisP);
                p.put("monthlisR", monthlisR);
                rr = new Result<Void>(1, "成功",p);
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }
    /**
     * 发送微信
     * @return
     * @throws Exception
     */
    @RequestMapping("sendWeChat")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-发送计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public  Result<Void> sendWeChat(String corpsecret, String agentid,String info) throws Exception {
        Result<Void> rr = null;

        try {
        SendWeChat sendWeChat=new SendWeChat();
        boolean is_send = sendWeChat.send_info(corpsecret, agentid,info);
        if (is_send){
            rr = new Result<Void>(1, "发送成功","");

        }else {
            rr = new Result<Void>(1, "发送失败","");
        }

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    /**
     *发布房源加积分
     *
     * @param
     * @return
     */
    @RequestMapping("fyCredit")
    @ResponseBody
    public   Result<Void> fyCredit(String userName) throws Exception {
        Result<Void> rr = null;
        try {
           if (findByUser(userName)!=null){
               // 积分系统
               String userId=findByUser(userName).get("id").toString();
               HashMap creditMap1 = new HashMap();
               creditMap1.put("id",6);
               creditMap1.put("userId",userId);
               creditService. editUserCredit(creditMap1);

               rr = new Result<Void>(1, "成功",true);
           }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }
}

