package com.first.controller.system;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.*;
import com.first.exception.SystemException;
import com.first.mapper.CustomerMapper;
import com.first.mapper.DepartMapper;
import com.first.mapper.InterlocutionMapper;
import com.first.mapper.UserMapper;
import com.first.service.system.*;
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
    @Inject
    private ProjectService projectService;
    @Inject
    private ProjectShopsService projectShopsService;
    @Inject
    private ProjectApartmentService projectApartmentService;
    @Inject
    private ProjectOfficeService projectOfficeService;
    @Inject
    private ProjectHomeService projectHomeService;
    /**
     * 查找用户信息
     *
     * @param userName
     * @return
     */
    private UserFormMap findByUser(String userName) {
        UserFormMap user = new UserFormMap();
        if (userName != null) {
            UserFormMap a = new UserFormMap();
            a.put("accountName", userName);
            user = userMapper.findByUser(a);

        }
        return user;
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
            UserFormMap user = findByUser(userName);
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
            if (id != null & id.length() != 0) {
                List<InterlocutionFormMap> p = interlocutionMapper.findanswers(id);
                rr = new Result<Void>(1, "成功", p);
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
     *
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
    public Result<Void> isExist(String createDate, String userId) throws Exception {
        Result<Void> rr = null;
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("createDate", createDate);
            searchMap.put("userId", userId);
            PersonalFormMap lis = personalService.finddayadd(searchMap);
            if (lis == null) {
                rr = new Result<Void>(1, "成功", true);
            } else {
                rr = new Result<Void>(1, "成功", false);
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
    public Result<Void> pereportUI(String userName) throws Exception {
        Result<Void> rr = null;

        try {
            if (userName == null || userName.length() == 0) {
                rr = new Result<Void>(0, "经纪人用户名不正确", "");
            } else {
                UserFormMap user = findByUser(userName);
                Map<String, Object> searchMap = new HashMap<String, Object>();
                searchMap.put("createDate", new Date());
                searchMap.put("userId", user.get("id"));
                searchMap.put("nexteDate", DateUtil.getnNext());
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
                System.err.println("2" + weeklisP);
                PersonalFormMap monthlisP = personalService.findmonthadd(searchMap);   //月计划
                PersonalFormMap monthlisR = personalService.findmonthreport(searchMap);//月数据
                HashMap<String, PersonalFormMap> p = new HashMap<>();
                p.put("daynextP", daynextP);
                p.put("daylisR", daylisR);
                p.put("weeklisP", weeklisP);
                p.put("weeklisR", weeklisR);
                p.put("monthlisP", monthlisP);
                p.put("monthlisR", monthlisR);
                rr = new Result<Void>(1, "成功", p);
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
    public Result<Void> deisExist(String createDate, String deId) throws Exception {
        Result<Void> rr = null;
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("createDate", createDate);
            searchMap.put("deId", deId);
            PersonalFormMap lis = personalService.finddedayadd(searchMap);
            if (lis == null) {
                rr = new Result<Void>(1, "成功", true);
            } else {
                rr = new Result<Void>(1, "成功", false);
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
    public Result<Void> dereportUI(String userName) throws Exception {
        Result<Void> rr = null;

        try {
            if (userName == null || userName.length() == 0) {
                rr = new Result<Void>(0, "经纪人用户名不正确", "");
            } else {
                UserFormMap user = findByUser(userName);
                Map<String, Object> searchMap = new HashMap<String, Object>();
                searchMap.put("createDate", new Date());
                searchMap.put("userId", user.get("id"));
                searchMap.put("deId", user.get("departmentId"));
                searchMap.put("nexteDate", DateUtil.getnNext());

                String depar = user.get("departmentId").toString();
                int depId = Integer.parseInt(depar);
                List<DepartmentFormMap> departmentFormMap = departMapper.getDepart();
                List<String> idss = new ArrayList<>();
                TreeUtil.treeMenuList(idss, departmentFormMap, depId);
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
                HashMap<String, PersonalFormMap> p = new HashMap<>();
                p.put("daynextP", daynextP);
                p.put("daylisR", daylisR);
                p.put("weeklisP", weeklisP);
                p.put("weeklisR", weeklisR);
                p.put("monthlisP", monthlisP);
                p.put("monthlisR", monthlisR);
                rr = new Result<Void>(1, "成功", p);
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    /**
     * 发送微信
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("sendWeChat")
    @ResponseBody
    @SystemLog(module = "计划制定", methods = "计划制定-发送计划") // 凡需要处理业务逻辑的.都需要记录操作日志
    public Result<Void> sendWeChat(String corpsecret, String agentid, String info) throws Exception {
        Result<Void> rr = null;

        try {
            SendWeChat sendWeChat = new SendWeChat();
            boolean is_send = sendWeChat.send_info(corpsecret, agentid, info);
            if (is_send) {
                rr = new Result<Void>(1, "发送成功", "");

            } else {
                rr = new Result<Void>(1, "发送失败", "");
            }

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    /**
     * 个人积分
     *
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("findUserCredit")
    public Result<Void> findUserCredit(String userName) {
        Result<Void> rr = null;
        try {
            if (findByUser(userName) != null) {
                System.err.println("132");
                // 积分系统
                String userId = findByUser(userName).get("id").toString();
                System.err.println("132" + userId);
                CreditFormMap creditFormMap = creditService.findUserCredit(userId);
                rr = new Result<Void>(1, "成功", creditFormMap);
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    /**
     * 发布房源加积分
     *
     * @param
     * @return
     */
    @RequestMapping("fyCredit")
    @ResponseBody
    @Transactional(readOnly = false)
    public Result<Void> fyCredit(String userName) throws Exception {
        Result<Void> rr = null;
        try {
            if (findByUser(userName).get("id") != null) {
                // 积分系统
                String userId = findByUser(userName).get("id").toString();
                HashMap creditMap1 = new HashMap();
                creditMap1.put("id", 6);
                creditMap1.put("userId", userId);
                creditService.editUserCredit(creditMap1);

                rr = new Result<Void>(1, "成功", true);
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    /**
     * 积分兑换
     *
     * @param
     * @return
     */
    @RequestMapping("useCredit")
    @ResponseBody
    @Transactional(readOnly = false)
    public Result<Void> useCredit(String userName, String opId, Integer score) throws Exception {
        Result<Void> rr = null;
        try {
            if (findByUser(userName).get("id") != null) {
                String userId = findByUser(userName).get("id").toString();
                HashMap creditMap = new HashMap();
                creditMap.put("type", "1");
                creditMap.put("id", opId);
                creditMap.put("userId", userId);
                creditMap.put("score", score);
                creditService.editUserCredit(creditMap);

                rr = new Result<Void>(1, "成功", "success");
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    /**
     * 查看项目图片
     * @param proId
     * @param callback
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping(value = "findImg")
    public Object findImg(String proId, String proType,String ImgType, String callback) throws Exception {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        if (callback == null || callback.equals("")) {
            callback = "callback";
        }
        try {
            HashMap searchImg = new HashMap();
            searchImg.put("proId", proId);
            searchImg.put("type", ImgType);
            if(proType.equals("1")){
                List<ProjectShopsFormMap> listImg = projectShopsService.findImg(searchImg);
                rr = new Result<Void>(1, "成功", listImg);
                jsonpObject = new JSONPObject(callback, rr);
            }else  if (proType.equals("2")){
                List<ProjectApartmentFormMap> listImg = projectApartmentService.findImg(searchImg);
                rr = new Result<Void>(1, "成功", listImg);
                jsonpObject = new JSONPObject(callback, rr);

            }else  if (proType.equals("3")){
                List<ProjectOfficeFormMap> listImg = projectOfficeService.findImg(searchImg);
                rr = new Result<Void>(1, "成功", listImg);
                jsonpObject = new JSONPObject(callback, rr);
            }else  if (proType.equals("4")){
                List<ProjectHomeFormMap> listImg = projectHomeService.findImg(searchImg);
                rr = new Result<Void>(1, "成功", listImg);
                jsonpObject = new JSONPObject(callback, rr);
            }

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }

    @ResponseBody
    @RequestMapping(value = "findFFXImg")
    public Result<Void> findFFXImg(String proId, String proType,String ImgType,String callback) throws Exception {
        Result<Void> rr = null;
        try {
            HashMap searchImg = new HashMap();
            searchImg.put("proId", proId);
            searchImg.put("type", ImgType);
            if(proType.equals("1")){
                List<ProjectShopsFormMap> listImg = projectShopsService.findImg(searchImg);
                rr = new Result<Void>(1, "成功", listImg);

            }else  if (proType.equals("2")){
                List<ProjectApartmentFormMap> listImg = projectApartmentService.findImg(searchImg);
                rr = new Result<Void>(1, "成功", listImg);

            }else  if (proType.equals("3")){
                List<ProjectOfficeFormMap> listImg = projectOfficeService.findImg(searchImg);
                rr = new Result<Void>(1, "成功", listImg);

            }else  if (proType.equals("4")){
                List<ProjectHomeFormMap> listImg = projectHomeService.findImg(searchImg);
                rr = new Result<Void>(1, "成功", listImg);
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    /**
     * 查看项目列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findFFXProjectList")
    public   Result<Void> findByFFXProject(String projectName, String orderBy, String district, String type, String areas, String areae, String prices, String pricee, String pricess, String pricese, int pageSize, @RequestParam(required = true, defaultValue = "1") Integer pageNum) throws Exception {
        Result<Void> rr = null;
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("projectName", projectName);
            searchMap.put("district", district);
            searchMap.put("areas", areas);
            searchMap.put("areae", areae);
            searchMap.put("prices", prices);
            searchMap.put("pricee", pricee);
            searchMap.put("pricess", pricess);
            searchMap.put("pricese", pricese);
            searchMap.put("orderBy", orderBy);
            if(type.equals("1")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectShopsFormMap> p = projectShopsService.findProjects(searchMap);
                PageInfo<ProjectShopsFormMap> pageinfo = new PageInfo<ProjectShopsFormMap>(p);
                rr = new Result<Void>(1, "成功", pageinfo);
            }else  if (type.equals("2")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectApartmentFormMap> p1 = projectApartmentService.findProjects(searchMap);
                PageInfo<ProjectApartmentFormMap> pageinfo = new PageInfo<ProjectApartmentFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
            }else  if (type.equals("3")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectOfficeFormMap> p1 = projectOfficeService.findProjects(searchMap);
                PageInfo<ProjectOfficeFormMap> pageinfo = new PageInfo<ProjectOfficeFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
            }else  if (type.equals("4")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectHomeFormMap> p1 = projectHomeService.findProjects(searchMap);
                PageInfo<ProjectHomeFormMap> pageinfo = new PageInfo<ProjectHomeFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
            }

        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");


        }
        return  rr;
    }

    @ResponseBody
    @RequestMapping(value = "findFFXProject")
    public Result<Void> findFFXProject(@RequestParam("id") String id,String type) throws Exception {

        Result<Void> rr = null;
        try {
            if(type.equals("1")){
                ProjectShopsFormMap mps = projectShopsService.findbyProject(id);
                rr = new Result<Void>(1, "成功", mps);
            }else  if (type.equals("2")){
                ProjectApartmentFormMap mps = projectApartmentService.findbyProject(id);
                rr = new Result<Void>(1, "成功", mps);
            }else  if (type.equals("3")){
                ProjectOfficeFormMap mps = projectOfficeService.findbyProject(id);

                rr = new Result<Void>(1, "成功", mps);
            }else  if (type.equals("4")){
                ProjectHomeFormMap mps = projectHomeService.findbyProject(id);
                rr = new Result<Void>(1, "成功", mps);
            }


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }

    @ResponseBody
    @RequestMapping("findFFXHomeList")
    public Result<Void> findFFXHomeList(String proId, int pageSize,@RequestParam(required = true, defaultValue = "1") Integer pageNum) throws Exception {
        Result<Void> rr = null;
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("proId", proId);
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectHomeFormMap> p1 = projectHomeService.findHomeList(searchMap);
                PageInfo<ProjectHomeFormMap> pageinfo = new PageInfo<ProjectHomeFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");


        }
        return rr;
    }


    @ResponseBody
    @RequestMapping("findFFXHome")
    public Result<Void> findFFXHome(String id) {

        Result<Void> rr = null;
        HashMap homeList = new HashMap();
        try {
            ProjectHomeFormMap home = projectHomeService.findHome(id);
            List<ProjectHomeFormMap> homeImg = projectHomeService.findHomeImg(id);
            homeList.put("home", home);
            homeList.put("homeImg", homeImg);
           rr = new Result<Void>(1, "成功", homeList);
  } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }

    @ResponseBody
    @RequestMapping(value = "findFFXHomeImg")
    public Result<Void> findFFXHomeImg(String homeId) throws Exception {
        Result<Void> rr = null;
        try {

            List<ProjectHomeFormMap> listHomeImg = projectHomeService.findHomeImg(homeId);

            rr = new Result<Void>(1, "成功",listHomeImg);


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    @ResponseBody
    @RequestMapping("findFFXApartmentList")
    public Result<Void> findFFXApartmentList(String proId, int pageSize, @RequestParam(required = true, defaultValue = "1") Integer pageNum, String callback) throws Exception {
        Result<Void> rr = null;

        if (callback == null || callback.equals("")) {
            callback = "callback";
        }
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("proId", proId);
            PageHelper.startPage(pageNum, pageSize);
            List<ProjectApartmentFormMap> p = projectApartmentService.findApartmentList(searchMap);
            PageInfo<ProjectApartmentFormMap> pageinfo = new PageInfo<ProjectApartmentFormMap>(p);

            rr = new Result<Void>(1, "成功", pageinfo);

        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");


        }
        return rr;
    }

    @ResponseBody
    @RequestMapping("findFFXApartment")
    public Result<Void> findFFXApartment(String id, String callback) {

        Result<Void> rr = null;
        HashMap apartmentList = new HashMap();
        try {
            ProjectApartmentFormMap apartment = projectApartmentService.findApartment(id);
            List<ProjectApartmentFormMap> apartmentImg = projectApartmentService.findApartmentImg(id);
            apartmentList.put("apartment", apartment);
            apartmentList.put("apartmentImg", apartmentImg);

            if (callback == null || callback.equals("")) {
                callback = "callback";
            }
            rr = new Result<Void>(1, "成功", apartmentList);


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    @ResponseBody
    @RequestMapping(value = "findFFXApartmentImg")
    public Result<Void> findFFXApartmentImg(String apartmentId) throws Exception {

        Result<Void> rr = null;
        try {

            List<ProjectApartmentFormMap> listApartmentImg = projectApartmentService.findApartmentImg(apartmentId);

            rr = new Result<Void>(1, "成功",listApartmentImg);


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    @ResponseBody
    @RequestMapping("findFFXShopsList")
    public Object findFFXShopsList(String proId, int pageSize, @RequestParam(required = true, defaultValue = "1") Integer pageNum, String callback) throws Exception {
        Result<Void> rr = null;


        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("proId", proId);
            PageHelper.startPage(pageNum, pageSize);
            List<ProjectShopsFormMap> p = projectShopsService.findShopsList(searchMap);
            PageInfo<ProjectShopsFormMap> pageinfo = new PageInfo<ProjectShopsFormMap>(p);
            System.err.println("app" + p);
            rr = new Result<Void>(1, "成功", pageinfo);
        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }

    @ResponseBody
    @RequestMapping("findFFXShops")
    public Result<Void> findFFXShops(String id) {

        Result<Void> rr = null;
        HashMap shopList = new HashMap();
        try {
            ProjectShopsFormMap shops = projectShopsService.findShops(id);
            List<ProjectShopsFormMap> shopsImg = projectShopsService.findShopsImg(id);
            shopList.put("shops", shops);
            shopList.put("shopsImg", shopsImg);

            rr = new Result<Void>(1, "成功", shopList);


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    @ResponseBody
    @RequestMapping(value = "findFFXShopsImg")
    public Result<Void> findFFXShopsImg(String shopsId) throws Exception {

        Result<Void> rr = null;
        try {
            List<ProjectShopsFormMap> listShopsImg = projectShopsService.findShopsImg(shopsId);

            rr = new Result<Void>(1, "成功",listShopsImg);

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    /**
     * 查看项目列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findProjectList")
    public Object findByProject(String projectName, String orderBy, String business,String district, String type, String areas, String areae, String prices, String pricee, String pricess, String pricese, int pageSize, @RequestParam(required = true, defaultValue = "1") Integer pageNum, String callback) throws Exception {
        Result<Void> rr = null;
        JSONPObject jsonpObject = null;
        if (callback == null || callback.equals("")) {
            callback = "callback";
        }

        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("projectName", projectName);
            searchMap.put("district", district);
            searchMap.put("areas", areas);
            searchMap.put("areae", areae);
            searchMap.put("prices", prices);
            searchMap.put("pricee", pricee);
            searchMap.put("pricess", pricess);
            searchMap.put("pricese", pricese);
            searchMap.put("orderBy", orderBy);
            searchMap.put("business", business);
            if(type.equals("1")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectShopsFormMap> p = projectShopsService.findProjects(searchMap);
                PageInfo<ProjectShopsFormMap> pageinfo = new PageInfo<ProjectShopsFormMap>(p);
                rr = new Result<Void>(1, "成功", pageinfo);
                jsonpObject = new JSONPObject(callback, rr);
            }else  if (type.equals("2")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectApartmentFormMap> p1 = projectApartmentService.findProjects(searchMap);
                PageInfo<ProjectApartmentFormMap> pageinfo = new PageInfo<ProjectApartmentFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
                jsonpObject = new JSONPObject(callback, rr);
            }else  if (type.equals("3")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectOfficeFormMap> p1 = projectOfficeService.findProjects(searchMap);
                PageInfo<ProjectOfficeFormMap> pageinfo = new PageInfo<ProjectOfficeFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
                jsonpObject = new JSONPObject(callback, rr);
            }else  if (type.equals("4")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectHomeFormMap> p1 = projectHomeService.findProjects(searchMap);
                PageInfo<ProjectHomeFormMap> pageinfo = new PageInfo<ProjectHomeFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
                jsonpObject = new JSONPObject(callback, rr);
            }

        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);

        }
        return jsonpObject;
    }

    @ResponseBody
    @RequestMapping(value = "findProject")
    public Object findProject(@RequestParam("id") String id, String type,String callback) throws Exception {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        if (callback == null || callback.equals("")) {
            callback = "callback";
        }
        try {
            if(type.equals("1")){
                ProjectShopsFormMap mps = projectShopsService.findbyProject(id);

                rr = new Result<Void>(1, "成功", mps);
                jsonpObject = new JSONPObject(callback, rr);
            }else  if (type.equals("2")){
                ProjectApartmentFormMap mps = projectApartmentService.findbyProject(id);

                rr = new Result<Void>(1, "成功", mps);
                jsonpObject = new JSONPObject(callback, rr);
            }else  if (type.equals("3")){
                ProjectOfficeFormMap mps = projectOfficeService.findbyProject(id);


                rr = new Result<Void>(1, "成功", mps);
                jsonpObject = new JSONPObject(callback, rr);
            }else  if (type.equals("4")){
                ProjectHomeFormMap mps = projectHomeService.findbyProject(id);

                rr = new Result<Void>(1, "成功", mps);
                jsonpObject = new JSONPObject(callback, rr);
            }


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }

    @ResponseBody
    @RequestMapping("findHomeList")
    public Object findHomeList(String proId, int pageSize, @RequestParam(required = true, defaultValue = "1") Integer pageNum, String callback) throws Exception {
        System.err.println("sehenm");
        Result<Void> rr = null;
        JSONPObject jsonpObject = null;
        if (callback == null || callback.equals("")) {
            callback = "callback";
        }
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("proId", proId);
            PageHelper.startPage(pageNum, pageSize);
            List<ProjectHomeFormMap> p = projectHomeService.findHomeList(searchMap);
            PageInfo<ProjectHomeFormMap> pageinfo = new PageInfo<ProjectHomeFormMap>(p);

            rr = new Result<Void>(1, "成功", pageinfo);
            jsonpObject = new JSONPObject(callback, rr);
        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);

        }
        return jsonpObject;
    }


    @ResponseBody
    @RequestMapping("findHome")
    public Object findHome(String id, String callback) {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        HashMap homeList = new HashMap();
        try {
            ProjectHomeFormMap home = projectHomeService.findHome(id);
            List<ProjectHomeFormMap> homeImg = projectHomeService.findHomeImg(id);

            homeList.put("home", home);
            homeList.put("homeImg", homeImg);
            if (callback == null || callback.equals("")) {
                callback = "callback";
            }
            rr = new Result<Void>(1, "成功", homeList);
            jsonpObject = new JSONPObject(callback, rr);

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }

    @ResponseBody
    @RequestMapping(value = "findHomeImg")
    public Object findHomeImg(String homeId,  String callback) throws Exception {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        try {

            List<ProjectHomeFormMap> listHomeImg = projectHomeService.findHomeImg(homeId);
            if (callback == null || callback.equals("")) {
                callback = "callback";
            }
            rr = new Result<Void>(1, "成功",listHomeImg);
            jsonpObject = new JSONPObject(callback, rr);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }
    @ResponseBody
    @RequestMapping("findApartmentList")
    public Object findApartmentList(String proId, int pageSize, @RequestParam(required = true, defaultValue = "1") Integer pageNum, String callback) throws Exception {
        Result<Void> rr = null;
        JSONPObject jsonpObject = null;
        if (callback == null || callback.equals("")) {
            callback = "callback";
        }
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("proId", proId);
            PageHelper.startPage(pageNum, pageSize);
            List<ProjectApartmentFormMap> p = projectApartmentService.findApartmentList(searchMap);
            PageInfo<ProjectApartmentFormMap> pageinfo = new PageInfo<ProjectApartmentFormMap>(p);

            rr = new Result<Void>(1, "成功", pageinfo);
            jsonpObject = new JSONPObject(callback, rr);
        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);

        }
        return jsonpObject;
    }

    @ResponseBody
    @RequestMapping("findApartment")
    public Object findApartment(String id, String callback) {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        HashMap apartmentList = new HashMap();
        try {
            ProjectApartmentFormMap apartment = projectApartmentService.findApartment(id);
            List<ProjectApartmentFormMap> apartmentImg = projectApartmentService.findApartmentImg(id);
            apartmentList.put("apartment", apartment);
            apartmentList.put("apartmentImg", apartmentImg);

            if (callback == null || callback.equals("")) {
                callback = "callback";
            }
            rr = new Result<Void>(1, "成功", apartmentList);
            jsonpObject = new JSONPObject(callback, rr);

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }
    @ResponseBody
    @RequestMapping(value = "findApartmentImg")
    public Object findApartmentImg(String apartmentId,  String callback) throws Exception {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        try {

            List<ProjectApartmentFormMap> listApartmentImg = projectApartmentService.findApartmentImg(apartmentId);
            if (callback == null || callback.equals("")) {
                callback = "callback";
            }
            rr = new Result<Void>(1, "成功",listApartmentImg);
            jsonpObject = new JSONPObject(callback, rr);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }
    @ResponseBody
    @RequestMapping("findShopsList")
    public Object findShopsList(String proId, int pageSize, @RequestParam(required = true, defaultValue = "1") Integer pageNum, String callback) throws Exception {
        Result<Void> rr = null;
        JSONPObject jsonpObject = null;
        if (callback == null || callback.equals("")) {
            callback = "callback";
        }
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("proId", proId);
            PageHelper.startPage(pageNum, pageSize);
            List<ProjectShopsFormMap> p = projectShopsService.findShopsList(searchMap);
            PageInfo<ProjectShopsFormMap> pageinfo = new PageInfo<ProjectShopsFormMap>(p);
            rr = new Result<Void>(1, "成功", pageinfo);
            jsonpObject = new JSONPObject(callback, rr);
        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);

        }
        return jsonpObject;
    }

    @ResponseBody
    @RequestMapping("findShops")
    public Object findShops(String id, String callback) {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        HashMap shopList = new HashMap();
        try {
            ProjectShopsFormMap shops = projectShopsService.findShops(id);
            List<ProjectShopsFormMap> shopsImg = projectShopsService.findShopsImg(id);
            shopList.put("shops", shops);
            shopList.put("shopsImg", shopsImg);


            if (callback == null || callback.equals("")) {
                callback = "callback";
            }
            rr = new Result<Void>(1, "成功", shopList);
            jsonpObject = new JSONPObject(callback, rr);

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }
    @ResponseBody
    @RequestMapping(value = "findShopsImg")
    public Object findShopsImg(String shopsId,  String callback) throws Exception {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        try {
            List<ProjectShopsFormMap> listShopsImg = projectShopsService.findShopsImg(shopsId);
            if (callback == null || callback.equals("")) {
                callback = "callback";
            }
            rr = new Result<Void>(1, "成功",listShopsImg);
            jsonpObject = new JSONPObject(callback, rr);
            return jsonpObject;
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }
    /**
     * 搜索栏数据
     *
     * @param city
     * @param callback
     * @return
     */
    @ResponseBody
    @RequestMapping("findProjectSearch")
    public Object findProjectSearch(String city, String callback) {
        JSONPObject jsonpObject = null;
        Result<Void> rr = null;
        Map search = new HashMap();
        search.put("city", city);
        try {
            List<HashMap> projectSearch = projectService.findProjectSearch(search);

            if (callback == null || callback.equals("")) {
                callback = "callback";
            }
            rr = new Result<Void>(1, "成功", projectSearch);
            jsonpObject = new JSONPObject(callback, rr);

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
            jsonpObject = new JSONPObject(callback, rr);
        }
        return jsonpObject;
    }
    @ResponseBody
    @RequestMapping("findFFXProjectSearch")
    public  Result<Void> findFFXProjectSearch(String city) {

        Result<Void> rr = null;
        Map search = new HashMap();
        search.put("city", city);
        try {
            List<HashMap> projectSearch = projectService.findProjectSearch(search);


            rr = new Result<Void>(1, "成功", projectSearch);

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }

}

