package com.first.controller.system;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.InterlocutionFormMap;
import com.first.exception.SystemException;
import com.first.mapper.InterlocutionMapper;
import com.first.util.Common;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 销售百问
 */
@Controller
@RequestMapping("/interlocution/")
public class InterlocutionController extends BaseController {

	@Inject
	private InterlocutionMapper interlocutionMapper;

	/**
	 * 导航栏搜索问题
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/assistant/interlocution";
	}

	@ResponseBody
	@RequestMapping("findQuestions")

	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	public List<InterlocutionFormMap> findQuestions(String que) {

		List<InterlocutionFormMap> p = interlocutionMapper.findQuestions(que);

		return p;

	}

	/**
	 * 网页里面栏搜索问题
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("lista")
	public String listUIa(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/assistant/list";
	}

	@ResponseBody
	@RequestMapping("findQuestionsa")

	public Object findQuestionsa(String que, @RequestParam(required = true, defaultValue = "1") Integer page) {
		System.err.println("que" + que + "page" + page);
		String userName = getuserName();
		PageHelper.startPage(page, 20);

		List<InterlocutionFormMap> p = interlocutionMapper.findQuestions(que);

		for (int i = 0; i < p.size(); i++) {
			InterlocutionFormMap a = p.get(i);
			if (a.get("createBy") != null) {
				System.err.println(a.get("createBy").toString().equals(userName));
				if (a.get("createBy").toString().equals(userName)) {
					a.put("edit", "编辑");
					a.put("dele", "删除");
				} else {
					a.put("edit", "");
					a.put("dele", "");
				}
				

			}else {
				a.put("edit", "");
				a.put("dele", "");
			}
			p.set(i, a);

		}

		PageInfo<InterlocutionFormMap> pageinfo = new PageInfo<InterlocutionFormMap>(p);

		return pageinfo;

	}

	/**
	 * 录入问题
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
		System.err.println("ads");
		return Common.BACKGROUND_PATH + "/system/assistant/add";
	}

	@ResponseBody
	@RequestMapping("addInterlocution")
	@SystemLog(module = "系统功能", methods = "销售百问-提问") // 凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	public String addEntity(HttpServletRequest request) {
		try {
			InterlocutionFormMap interlocutionFormMap = getFormMap(InterlocutionFormMap.class);

			String userName = getuserName();

			interlocutionFormMap.put("createBy", userName);
			interlocutionFormMap.put("createDate", new Date());
			System.err.println(interlocutionFormMap);
			interlocutionMapper.addquestion(interlocutionFormMap);// 添加问题

		} catch (Exception e) {
			throw new SystemException("添加账号异常");
		}
		return "success";
	}

	/**
	 * 回答问题
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addaUI")
	public String addaUI(Model model) throws Exception {
		String id = getPara("id");

		if (Common.isNotEmpty(id)) {

			InterlocutionFormMap mps = interlocutionMapper.findbyquestion(id);

			model.addAttribute("interlocution", mps);
		}
		return Common.BACKGROUND_PATH + "/system/assistant/adda";
	}

	@ResponseBody
	@RequestMapping("addaInterlocution")
	@SystemLog(module = "系统功能", methods = "销售百问-回答问题") // 凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	public String addaEntity() {
		try {
			InterlocutionFormMap interlocutionFormMap = getFormMap(InterlocutionFormMap.class);
			String userName = getuserName();

			interlocutionFormMap.put("createBy", userName);
			interlocutionFormMap.put("createDate", new Date());

			System.err.println(interlocutionFormMap);

			interlocutionMapper.addanswer(interlocutionFormMap);// 新增后返回新增信息

		} catch (Exception e) {
			throw new SystemException("修改异常");
		}
		return "success";
	}
	/**
	 * 编辑问题
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("etidUI")
	public String etidUI(Model model) throws Exception {
		String id = getPara("aId");
		System.err.println(id);
		if (Common.isNotEmpty(id)) {

			InterlocutionFormMap mps = interlocutionMapper.findbyanswer(id);

			model.addAttribute("interlocution", mps);
		}
		return Common.BACKGROUND_PATH + "/system/assistant/edit";
	}

	@ResponseBody
	@RequestMapping("editInterlocution")
	@SystemLog(module = "系统功能", methods = "销售百问-回答问题") // 凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	public String etidEntity() {
		try {
			InterlocutionFormMap interlocutionFormMap = getFormMap(InterlocutionFormMap.class);
		

			interlocutionFormMap.put("createDate", new Date());

			System.err.println(interlocutionFormMap);

			interlocutionMapper.editanswer(interlocutionFormMap);// 新增后返回新增信息

		} catch (Exception e) {
			throw new SystemException("修改异常");
		}
		return "success";
	}
	/**
	 * 删除答案
	 */
	@ResponseBody
	@RequestMapping("deleteEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "客户管理", methods = "客户管理-客户删除") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String deleteEntity() throws Exception {
		String aId = getPara("aId");
		System.err.println("ASda"+aId);
		if (Common.isNotEmpty(aId)) {
			interlocutionMapper.deleteanswer(aId);
		}
		return "success";
	}
	/**
	 * 展开更多问题
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findanswer")

	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	public List<InterlocutionFormMap> findanswer(String id) {
		String userName = getuserName();
		List<InterlocutionFormMap> p = interlocutionMapper.findanswer(id);
		for (int i = 0; i < p.size(); i++) {
			InterlocutionFormMap a = p.get(i);
			if (a.get("createBy") != null) {
				System.err.println(a.get("createBy").toString().equals(userName));
				if (a.get("createBy").toString().equals(userName)) {
					a.put("edit", "编辑");
					a.put("dele", "删除");
				} else {
					a.put("edit", "");
					a.put("dele", "");
				}
				

			}else {
				a.put("edit", "");
				a.put("dele", "");
			}
			p.set(i, a);

		}
		System.err.println("qqe" + p);
		return p;

	}
	/**
	 * 查看答案
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("answerUI")
	public String answerUI(Model model) throws Exception {
		String userName = getuserName();
		String id = getPara("id");
		System.err.println(id);
		if (Common.isNotEmpty(id)) {

			InterlocutionFormMap mps = interlocutionMapper.findbyquestion(id);
			List<InterlocutionFormMap> p = interlocutionMapper.findanswers(id);
			for (int i = 0; i < p.size(); i++) {
				InterlocutionFormMap a = p.get(i);
				if (a.get("createBy") != null) {
					System.err.println(a.get("createBy").toString().equals(userName));
					if (a.get("createBy").toString().equals(userName)) {
						a.put("edit", "编辑");
						a.put("dele", "删除");
					} else {
						a.put("edit", "");
						a.put("dele", "");
					}
					

				}else {
					a.put("edit", "");
					a.put("dele", "");
				}
				p.set(i, a);

			}
			System.err.println("DAas"+p);
			model.addAttribute("interlocution", mps);
			model.addAttribute("answers", p);
		}
		return Common.BACKGROUND_PATH + "/system/assistant/answer";
	}

}
