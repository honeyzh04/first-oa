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

import com.first.controller.index.BaseController;
import com.first.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/credit/")
public class CreditController   extends BaseController {

    @RequestMapping("peListUI")
    public String peListUI(HttpServletRequest request, Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/credit/pelist";
    }
}
