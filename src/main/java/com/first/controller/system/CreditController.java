package com.first.controller.system;
/**
 *
 * 会员积分系统
 * @Title: CreditController
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/11/2917:12
 */

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.CreditFormMap;
import com.first.service.system.CreditService;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/credit/")
public class CreditController   extends BaseController {
    @Inject
    private CreditService creditService;

    @RequestMapping("ListUI")
    public String ListUI(HttpServletRequest request, Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/credit/list";
    }


    /**
     * 积分列表
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findCredit")
    public  Object findCredit(HttpServletRequest request, int draw, int start, int length) {
        HashMap searchMap=new HashMap();
        searchMap.put("1",1);
        PageHelper.startPage((start / length) + 1, length);
         List<CreditFormMap> p=creditService.findCredit(searchMap);
        PageInfo<CreditFormMap> pageinfo = new PageInfo<CreditFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (CreditFormMap a : pageinfo.getList()) {

            data.add(a);

        }

        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);

        return map;

    }
    @RequestMapping("peListUI")
    public String peListUI(HttpServletRequest request, Model model) throws Exception {
        CreditFormMap creditFormMap=creditService.findUserCredit(getuserId());
        model.addAttribute("creditFormMap", creditFormMap);
        return Common.BACKGROUND_PATH + "/system/credit/pelist";
    }

    /**
     * 个人积分
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findUserCredit")
    public  CreditFormMap findUserCredit(String userId) {
        if (userId==null) {
            userId = getuserId();
        }
        CreditFormMap creditFormMap=creditService.findUserCredit(userId);
        System.err.println("das"+creditFormMap);
        return creditFormMap;
    }

    /**
     * 积分记录
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findCreditRecord")
    public  Object findCreditRecord(String userId,String type, @RequestParam(required = true, defaultValue = "1") Integer page) {
        if (userId==null){
            userId=getuserId();
        }
        HashMap searchMap=new HashMap();
        searchMap.put("userId",userId);
        searchMap.put("type",type);
        PageHelper.startPage(page, 15);
        List< CreditFormMap> creditFormMap=creditService.findCreditRecord(searchMap);
        System.err.println("asd"+creditFormMap);
        PageInfo< CreditFormMap> pageinfo = new PageInfo< CreditFormMap>(creditFormMap);

        return pageinfo;

    }
    /**
     * 积分消费
     * @param opId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("useCredit")
    @Transactional(readOnly = false)
    @SystemLog(module = "积分管理", methods = "积分管理-消费积分") // 凡需要处理业务逻辑的.都需要记录操作日志
    public Object useCredit(String opId ) throws Exception {
        HashMap creditMap1 = new HashMap();
        creditMap1.put("id",opId);
        creditMap1.put("userId",getuserId());
        creditService.editUserCredit(creditMap1);

        return "success" ;

    }

}
