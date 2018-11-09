package com.first.controller.system;

import com.first.controller.index.BaseController;
import com.first.entity.CustomerFormMap;
import com.first.entity.DepartmentFormMap;
import com.first.entity.StatisticsFormMap;
import com.first.entity.UserFormMap;
import com.first.mapper.CustomerMapper;
import com.first.mapper.DepartMapper;
import com.first.mapper.StatisticsMapper;
import com.first.service.system.HomeService;
import com.first.util.Common;
import com.first.util.DateWeek;
import com.first.util.Result;
import com.first.util.TreeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 主页展示
 *
 * @Title: HomeController
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/10/1910:08
 */
@Controller
@RequestMapping("/home/")
public class HomeController extends BaseController {
    @Inject
    private DepartMapper departMapper;
    @Inject
    private HomeService homeService;
    @Inject
    private StatisticsMapper statisticsMapper;
    @Inject
    private CustomerMapper customerMapper;

    @ResponseBody
    @RequestMapping("findByWeekExtension")
    public Result<Void> findByWeekExtension(HttpServletRequest request) throws Exception {
        Result<Void> rr = null;
        try {
            List<StatisticsFormMap> p = null;
            SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
            String date1 = formater.format(new Date());
            Date date = formater.parse(date1);
            Date b = DateWeek.getThisWeekTuesday(date);
            System.out.println(b);
            UserFormMap userFormMap = (UserFormMap) Common.findUserSession(request);
            Map<String, Object> searchMap = new HashMap<String, Object>();
            String depar = userFormMap.get("department").toString();
            System.err.println("af3" + depar);
            searchMap.put("departweeks", b);
            searchMap.put("departweeke", new Date());
            if (depar.equals("1")) {
                p = statisticsMapper.findDeweek(searchMap);
                rr = new Result<Void>(1, "成功", p);
                System.err.println("af" + p);
            } else {
                int depId = Integer.parseInt(depar);
                List<DepartmentFormMap> departmentFormMap = departMapper.getDepart();
                List<String> idss = null;
                idss = TreeUtil.treeMenuList(departmentFormMap, depId);
                idss.add(depar);
                searchMap.put("deId", idss);
                System.err.println("af2" + idss);
                p = homeService.findpeweek(searchMap);
                rr = new Result<Void>(2, "成功", p);
                System.err.println("af1" + p);
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");
        }
        return rr;
    }

    /**
     * 成交项目
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findByDeal")
    public Result<Void> findByDeal() throws Exception {
        Result<Void> rr = null;
        Map<String, Object> searchMap = new HashMap<String, Object>();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天 
            String first = format.format(c.getTime());
            System.out.println("===============first:" + first);

            searchMap.put("ecreateDate", new Date());
            searchMap.put("screateDate", first);
            List<CustomerFormMap> p = customerMapper.finddealCustomerPage(searchMap);
            rr = new Result<Void>(1, "成功", p);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }


    /**
     * 排行榜
     *
     * @param callback
     * @return
     * @throws Exception
     */
    @RequestMapping("rank")
    @ResponseBody
    public Result<Void> shows(String callback) throws Exception {
        Result<Void> rr = null;
        Map<String, Object> searchMap = new HashMap<String, Object>();
        try {

            List<StatisticsFormMap> rankPerAddMonth = statisticsMapper.findRankPerAddMonth();//个人当月新增排行

            List<StatisticsFormMap> rankPerFollowMonth = statisticsMapper.findRankPerFollowMonth();//个人当月跟进排行榜

            List<StatisticsFormMap> rankPerVisMonth = statisticsMapper.findRankPerVisMonth();//个人当月到访排行

            List<StatisticsFormMap> rankPerDeaMonth = statisticsMapper.findRankPerDeaMonth();//个人月成交排行
            searchMap.put("rankPerAddMonth", rankPerAddMonth);
            searchMap.put("rankPerFollowMonth", rankPerFollowMonth);
            searchMap.put("rankPerVisMonth", rankPerVisMonth);
            searchMap.put("rankPerDeaMonth", rankPerDeaMonth);
            rr = new Result<Void>(1, "成功", searchMap);

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
}
