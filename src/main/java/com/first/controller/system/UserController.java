package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.CreditFormMap;
import com.first.entity.UserFormMap;
import com.first.entity.UserRoleFormMap;
import com.first.exception.SystemException;
import com.first.mapper.CustomerMapper;
import com.first.mapper.UserMapper;
import com.first.service.system.CreditService;
import com.first.util.Common;
import com.first.util.PasswordHelper;
import com.first.util.PostUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 用户控制器 Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年4月4日
 */
@Controller
@RequestMapping("/user/")
public class UserController extends BaseController {
    private static final RequestMethod[] GET = null;
    @Inject
    private UserMapper userMapper;
    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private CreditService creditService;
    /**
     * 显示按钮
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public String listUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());

        return Common.BACKGROUND_PATH + "/system/user/list";
    }

    /**
     * 员内列表
     *
     * @param request
     * @param draw
     * @param start
     * @param length
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public Object findByPage(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("userName", request.getParameter("userName"));
        PageHelper.startPage((start / length) + 1, length);
        List<UserFormMap> p = userMapper.findUserPage(searchMap);
        PageInfo<UserFormMap> pageinfo = new PageInfo<UserFormMap>(p);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (UserFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);

        return map;
    }

    /**
     * excel导出
     *
     * @param request
     * @param response
     * @throws IOException
     */
    /*
     * @RequestMapping("/export") public void download(HttpServletRequest request,
     * HttpServletResponse response) throws IOException { String fileName = "用户列表";
     * UserFormMap userFormMap = findHasHMap(UserFormMap.class);
     *
     * String exportData = userFormMap.getStr("exportData");// 列表头的json字符串
     *
     * List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);
     *
     * List<UserFormMap> lis = userMapper.findUserPage();
     * POIUtils.exportToExcel(response, listMap, lis, fileName); }
     */

    /**
     * 添加
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addUI")
    public String addUI(Model model) throws Exception {
        System.err.println("添加用户");
        return Common.BACKGROUND_PATH + "/system/user/add";
    }

    @ResponseBody
    @RequestMapping("addEntity")
    @SystemLog(module = "系统管理", methods = "用户管理-新增用户") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    public String addEntity(String txtGroupsSelect) {
        try {
            UserFormMap userFormMap = getFormMap(UserFormMap.class);
            userFormMap.put("txtGroupsSelect", txtGroupsSelect);

            PasswordHelper passwordHelper = new PasswordHelper();
            // 默认密码
            userFormMap.set("password", "123456");
            passwordHelper.encryptPassword(userFormMap);
            userFormMap.put("createDate", new Date());
            userFormMap.put("locked", "1");
            userMapper.addEntity(userFormMap);// 新增后返回新增信息
            if (!Common.isEmpty(txtGroupsSelect)) {
                String[] txt = txtGroupsSelect.split(",");
                UserRoleFormMap userRoleFormMap = new UserRoleFormMap();
                for (String roleId : txt) {
                    UserFormMap ui = userMapper.findbyFrist(userFormMap);
                    userRoleFormMap.put("userId", ui.get("id"));
                    userRoleFormMap.put("roleId", roleId);

                    userMapper.addUREntity(userRoleFormMap);

                }
            }
            String register = userFormMap.get("register").toString();

            //创建房源发布系统账号
            if (register.equals("1")) {
                Map<String, String> map = new HashMap<>();
                map.put("CreatID", getuserId());
                map.put("OAID", userFormMap.get("id").toString());
                map.put("LoginName", userFormMap.get("accountName").toString());
                map.put("MemberName", userFormMap.get("userName").toString());
                String url = "http://api.fangfaxian.com/api/OGMember";

                PostUtil.httpPost(url, map);

            }
            //创建积分表
            CreditFormMap creditFormMap=new CreditFormMap();
            creditFormMap.put("userId",userFormMap.get("id").toString());
            creditFormMap.put("userName", userFormMap.get("userName").toString());
            creditFormMap.put("balance",0);
            creditFormMap.put("status",1);
            creditFormMap.put("createDate",new Date());
            creditService.addCredit(creditFormMap);
        } catch (Exception e) {
            throw new SystemException("添加账号异常");
        }
        return "success";
    }

    /**
     * 验证账号是否存在
     *
     * @param name
     * @return
     * @author numberONe date：2014-2-19
     */
    @RequestMapping("isExist")
    @ResponseBody
    public boolean isExist(String name) {
        UserFormMap userFormMap = getFormMap(UserFormMap.class);
        String ac = (String) userFormMap.get("accountName");

        UserFormMap lis = userMapper.findbyFrist(userFormMap);
        if (lis == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除用户
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deleteEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "系统管理", methods = "用户管理-删除用户") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteEntity() throws Exception {

        String[] ids = getParaValues("ids");

        for (String id : ids) {

            /*
             * userMapper.deleteByUR(UserRoleFormMap.class); userMapper.deleteByRU("userId",
             * id, ResUserFormMap.class); userMapper.deleteByUser("id", id,
             * UserFormMap.class);
             */
        }
        return "success";
    }

    /**
     * 修改用户
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
            UserFormMap mps = userMapper.findbyeditUI(id);
            System.err.println("ce" + mps);

            model.addAttribute("user", mps);
        }
        return Common.BACKGROUND_PATH + "/system/user/edit";
    }

    @ResponseBody
    @RequestMapping("editEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "系统管理", methods = "用户管理-修改用户") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editEntity(String txtGroupsSelect) throws Exception {
        UserFormMap userFormMap = getFormMap(UserFormMap.class);
        String deIdo = userFormMap.getStr("departmento");
        String deId = userFormMap.getStr("department");
        String userId = userFormMap.getStr("id");
        if (!deIdo.equals(deId)) {
            HashMap<String, String> forMap = new HashMap();
            forMap.put("department", deId);
            forMap.put("userId", userId);
            customerMapper.modifCuEntity(forMap); //  部门改变 修改客户归属
        }
        userFormMap.put("txtGroupsSelect", txtGroupsSelect);
        userMapper.editEntity(userFormMap);
        userMapper.deleteByUR(userFormMap);
        if (!Common.isEmpty(txtGroupsSelect)) {
            String[] txt = txtGroupsSelect.split(",");
            for (String roleId : txt) {
                UserRoleFormMap userGroupsFormMap = new UserRoleFormMap();
                userGroupsFormMap.put("userId", userFormMap.get("id"));
                userGroupsFormMap.put("roleId", roleId);
                userMapper.addUREntity(userGroupsFormMap);
            }
        }
        return "success";
    }

    /**
     * 修改密码
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("updatePassword")
    public String updatePassword(HttpServletRequest request, Model model) throws Exception {

        UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);

        model.addAttribute("userSession", userFormMap);
        return Common.BACKGROUND_PATH + "/system/user/updatePassword";
    }

    // 保存新密码
    @RequestMapping("editPassword")
    @ResponseBody
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "系统管理", methods = "用户管理-修改密码") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editPassword() throws Exception {

        // 当验证都通过后，把用户信息放在session里
        UserFormMap userFormMap = getFormMap(UserFormMap.class);
        userFormMap.put("password", userFormMap.get("newpassword"));
        // 这里对修改的密码进行加密
        PasswordHelper passwordHelper = new PasswordHelper();

        passwordHelper.encryptPassword(userFormMap);

        userMapper.editEntity(userFormMap);
        return "success";
    }


    // 重置密碼
    @RequestMapping("resetPassword")
    @ResponseBody
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "系统管理", methods = "用户管理-重置密码") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String resetPassword() throws Exception {

        String Id = getPara("id");


        // 当验证都通过后，把用户信息放在session里
        UserFormMap userFormMap = userMapper.findbyeditUI(Id);
        userFormMap.put("password", "123456");

        // 这里对修改的密码进行加密
        PasswordHelper passwordHelper = new PasswordHelper();

        passwordHelper.encryptPassword(userFormMap);

        userMapper.editEntity(userFormMap);
        return "success";
    }
}