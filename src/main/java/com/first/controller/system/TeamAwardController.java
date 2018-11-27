package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.CustomerFormMap;
import com.first.entity.TeamAwardFormMap;
import com.first.mapper.CustomerMapper;
import com.first.service.system.TeamAwardService;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
     *战队客户奖励
     * @ClassName:      AwardController
     * @Description:
     * @Author:         zhaoh
     * @CreateDate:     2018/11/21 14:50
     * @UpdateDate:     2018/11/21 14:50
     * @Version:        1.0
     */
@Controller
@RequestMapping("/temaaward/")
public class TeamAwardController extends BaseController {
    @Inject
    private TeamAwardService teamAwardService;
    @Inject
    private CustomerMapper customerMapper;

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
        return Common.BACKGROUND_PATH + "/system/teamaward/teamlist";
    }

    @ResponseBody
    @RequestMapping("findTeam")
    public Object findTeam(HttpServletRequest request, int draw, int start, int length) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();


        PageHelper.startPage((start/length)+1, length);

        List<TeamAwardFormMap> p =  teamAwardService.findTeam( map);

        PageInfo<TeamAwardFormMap> pageinfo = new PageInfo<TeamAwardFormMap>(p);

        List<Object> data = new ArrayList<Object>();
        for (TeamAwardFormMap a : pageinfo.getList()) {

            data.add(a);

        }

        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
    }

    /**
     * 添加奖励
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addawardUI")
    public String discardUI(Model model) throws Exception {
        String id = getPara("id");
        if (Common.isNotEmpty(id)) {
            // int id = Integer.parseInt(iid);
            CustomerFormMap mps = new CustomerFormMap();
            mps.put("id", id);
            model.addAttribute("customer", mps);
        }
        return Common.BACKGROUND_PATH + "/system/teamaward/addaward";
    }


    @ResponseBody
    @RequestMapping("addAward")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "战队管理", methods = "战队管理-发放奖励") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String addAward() throws Exception {
        TeamAwardFormMap teamAwardFormMap = getFormMap(TeamAwardFormMap.class);
        String id=teamAwardFormMap.get("id").toString();
        System.err.println("公共出"+teamAwardFormMap);
        List<CustomerFormMap> p = customerMapper.findAwardCustomer(teamAwardFormMap);
       for (CustomerFormMap customerFormMap :p){
           String cuId=customerFormMap.get("id").toString();
           Map<String, Object> searchMap = new HashMap<String, Object>();
           searchMap.put("cuId",cuId);
           searchMap.put("teamId",id);
           searchMap.put("date",new Date());
           System.err.println(searchMap);

           teamAwardService.addAward(searchMap);
       }
        return "success";
    }

    @RequestMapping(value = "awardCustomer")
    public String awardCustomer(Model model) throws Exception {
      String userId=getuserId();
        List<CustomerFormMap> p = customerMapper.getAwardCustomer(userId);
        System.err.println(p);
        model.addAttribute("customer",p);
        return Common.BACKGROUND_PATH + "/system/teamaward/awardCustomer";
    }

}
