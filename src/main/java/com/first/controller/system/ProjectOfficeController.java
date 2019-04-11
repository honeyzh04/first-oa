package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.ProjectHomeFormMap;
import com.first.entity.ProjectOfficeFormMap;
import com.first.exception.SystemException;
import com.first.service.system.ProjectOfficeService;
import com.first.util.Common;
import com.first.util.ImageUtil;
import com.first.util.Result;
import com.first.util.WatermarkImgUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * 商铺项目管理
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年6月2日
 */
@Controller
@RequestMapping("/projectOffice/")
public class ProjectOfficeController extends BaseController {
    @Inject
    private ProjectOfficeService projectOfficeService;
    public HashMap search(String area,String prices){
        HashMap searchMap = new HashMap<String, Object>();
        if ("".equals(area)) {
            searchMap.put("areas", "");
            searchMap.put("areae", "");
        } else {
            String[] areas = area.split("-");
            for (int i = 0; i < areas.length; i++) {
            }
            searchMap.put("areas", areas[0]);
            searchMap.put("areae", areas[1]);
        }
        if ("".equals(prices)) {
            searchMap.put("pricess", "");
            searchMap.put("pricese", "");
        } else {
            String[] price = prices.split("-");
            for (int i = 0; i < price.length; i++) {
            }
            searchMap.put("pricess", price[0]);
            searchMap.put("pricese", price[1]);
        }
        return searchMap;
    }
    /**
     * 查看商铺项目列表
     * @param request
     * @param draw
     * @param start
     * @param length
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findByProjectOffice")
    public Object findByProjectOffice(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        String area= request.getParameter("area");
        String prices= request.getParameter("prices");
        HashMap b= search(area,prices);
        searchMap.putAll(b);
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectOfficeFormMap> p = projectOfficeService.findProjectOffice(searchMap);
        PageInfo<ProjectOfficeFormMap> pageinfo = new PageInfo<ProjectOfficeFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectOfficeFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
    }
    /**
     * 选择项目
     *
     * @return
     */
    @RequestMapping("getProject")
    @ResponseBody
    public List<ProjectOfficeFormMap> showProvince() {
        List<ProjectOfficeFormMap> projectOfficeFormMap = projectOfficeService.getProject();
        return projectOfficeFormMap;
    }
    /**
     * 楼盘详情
     *
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "projectDetails")
    public String projectDetailsUI(Model model, @RequestParam("id") String id) {

        model.addAttribute("IDs", id);
        return Common.BACKGROUND_PATH + "/system/project/officeDetails";
    }
    /**
     * 查看项目具体
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findProject")
    public ProjectOfficeFormMap findProject(@RequestParam("id") String id) throws Exception {
        ProjectOfficeFormMap mps = projectOfficeService.findbyProject(id);
        return mps;
    }

    /**
     * 添加
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addProjectOfficeUI")
    public String addUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/addProjectOffice";
    }

    @ResponseBody
    @RequestMapping("addProjectOffice")
    @SystemLog(module = "项目管理", methods = "项目管理-添加商铺项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addProjectOffice() {
        try {
            ProjectOfficeFormMap ProjectOfficeFormMap = getFormMap(ProjectOfficeFormMap.class);
            ProjectOfficeFormMap.put("createDate", new Date());
            ProjectOfficeFormMap.put("delFlag", "0");
            ProjectOfficeFormMap.put("modifyDate", new Date());
            ProjectOfficeFormMap.put("type", "1");
            ProjectOfficeFormMap.put("modifyPerson", getuserName());
            projectOfficeService.addProjects(ProjectOfficeFormMap);
        } catch (Exception e) {
            throw new SystemException("添加商铺项目异常");
        }
        return "success";
    }
    /**
     * 修改项目
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "editProjectOfficeUI")
    public String editUI(Model model, @RequestParam("id") String id) throws Exception {
        if (Common.isNotEmpty(id)) {
            ProjectOfficeFormMap mps=projectOfficeService.findbyProject(id);
            model.addAttribute("projectOffice", mps);
        }
        return Common.BACKGROUND_PATH + "/system/project/editProjectOffice";
    }

    @ResponseBody
    @RequestMapping("editProjectOffice")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-修改商铺项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editProjectOffice() throws Exception {
        ProjectOfficeFormMap ProjectOfficeFormMap = getFormMap(ProjectOfficeFormMap.class);
        projectOfficeService.editProject(ProjectOfficeFormMap);
        return "success";
    }

    /**
     * 删除项目
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping("deleteProjectOffice")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-删除商铺项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteEntity() throws Exception {
        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectOfficeService.deleteEntity(id);
        }
        return "success";
    }

    /**
     * 添加图片
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addImgUI")
    public String addImgUI(Model model) throws Exception {
        String proId = getPara("id");
        model.addAttribute("proId", proId);
        return Common.BACKGROUND_PATH + "/system/project/addProjectOfficeImg";
    }

    @ResponseBody
    @RequestMapping(value = "addImg")
    @SystemLog(module = "项目管理", methods = "项目管理-添加图片")
    public String addImg(@RequestParam(value = "pictureFile", required = false) MultipartFile[] pictureFile, String proId, String type,
                         HttpServletRequest request) throws Exception {

        HashMap imgForMap = new HashMap();
        imgForMap.put("proId", proId);
        imgForMap.put("type", type);
        imgForMap.put("createDate", new Date());
        //定义序号
        for (MultipartFile file : pictureFile) {
            if (!file.isEmpty()) {
                // 使用UUID给图片重命名，并去掉四个“-”
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                // 获取文件的扩展名
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                // 设置图片上传路径
                String url = request.getSession().getServletContext().getRealPath("/img/project/office/");
                String imgName = name + "." + ext;
                String zip=url + proId + "/" + imgName;
                System.err.println(url);
                // 以绝对路径保存重名命后的图片
                File targetFile = new File(url + proId + "/" + imgName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }

                file.transferTo(targetFile); // 保存文件
                ImageUtil.zipWidthHeightImageFile(targetFile,targetFile,1200,900,0.7f);

                String srcImgPath = zip;
                String iconPath =  url+"watermark.png";
                String targerPath = zip;
                // 给图片添加水印
                new WatermarkImgUtils().markImageByIcon(iconPath, srcImgPath, targerPath);
                imgForMap.put("img", imgName);
                projectOfficeService.addImg(imgForMap);

            }

        }
        return "success";
    }

    /**
     * 查看图片
     * @param proId
     * @param type
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findImg")
    public List<ProjectOfficeFormMap> findImg(String proId, String type) throws Exception {
        HashMap searchImg = new HashMap();
        searchImg.put("proId", proId);
        searchImg.put("type", type);
        List<ProjectOfficeFormMap> listImg = projectOfficeService.findImg(searchImg);
        return listImg;
    }

    /**
     * 删除图片
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deleteImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteImg(String id) throws Exception {

        projectOfficeService.deleteImg(id);
        return "success";
    }


    //商铺销控管理

    @RequestMapping("Officelist")
    public String OfficeListUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/project/officelist";
    }

    @ResponseBody
    @RequestMapping("findOfficeList")
    public Object findOfficeList(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        searchMap.put("type", request.getParameter("type"));
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectOfficeFormMap> p =  projectOfficeService.findOfficeList(searchMap);
        PageInfo<ProjectOfficeFormMap> pageinfo = new PageInfo<ProjectOfficeFormMap>(p);
        System.err.println("商铺" + pageinfo);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectOfficeFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
    }

    @RequestMapping("addOfficeUI")
    public String addOfficeUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/addOffice";
    }

    @ResponseBody
    @RequestMapping("addOffice")
    @SystemLog(module = "项目管理", methods = "项目管理-添加商铺销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addOffice() {
        try {
            ProjectOfficeFormMap ProjectOfficeFormMap = getFormMap(ProjectOfficeFormMap.class);
            ProjectOfficeFormMap.put("date", new Date());
            ProjectOfficeFormMap.put("delFlag", "0");

            projectOfficeService.addOffice(ProjectOfficeFormMap);
        } catch (Exception e) {
            throw new SystemException("添加项目异常");
        }
        return "success";
    }
    @RequestMapping("editOfficeUI")
    public String editOfficeUI(Model model,String id) throws Exception {
        ProjectOfficeFormMap office = projectOfficeService.findOffice(id);
        model.addAttribute("office", office);
        return Common.BACKGROUND_PATH + "/system/project/editOffice";
    }
    @ResponseBody
    @RequestMapping("editOffice")
    @SystemLog(module = "项目管理", methods = "项目管理-修改商铺销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String editOffice() {
        try {
            ProjectOfficeFormMap ProjectOfficeFormMap = getFormMap(ProjectOfficeFormMap.class);

            projectOfficeService.editOffice(ProjectOfficeFormMap);
        } catch (Exception e) {
            throw new SystemException("修改异常");
        }
        return "success";
    }
    @RequestMapping("findOfficeUI")
    public String findOfficeUI(Model model) throws Exception {
        String officeId = getPara("id");
        model.addAttribute("officeId", officeId);
        return Common.BACKGROUND_PATH + "/system/project/office";
    }

    @ResponseBody
    @RequestMapping("findOffice")
    public Result<Void> findOffice(String id) throws Exception {
        Result<Void> rr = null;
        HashMap officeList = new HashMap();
        try {
            ProjectOfficeFormMap office = projectOfficeService.findOffice(id);

            List<ProjectOfficeFormMap> officeImg = projectOfficeService.findOfficeImg(id);
            officeList.put("office", office);
            officeList.put("officeImg", officeImg);
            rr = new Result<Void>(1, "成功", officeList);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    @ResponseBody
    @RequestMapping("deleteOffice")
    @Transactional(readOnly = false)
    @SystemLog(module = "项目管理", methods = "项目管理-删除商铺销控")
    public String deleteOffice() throws Exception {

        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectOfficeService.deleteOffice(id);


        }
        return "success";
    }



    @RequestMapping("addOfficeImgUI")
    public String addOfficeImgUI(Model model) throws Exception {
        String officeId = getPara("id");
        model.addAttribute("officeId", officeId);
        return Common.BACKGROUND_PATH + "/system/project/addOfficeImg";
    }


    @ResponseBody
    @RequestMapping(value = "addOfficeImg")
    @SystemLog(module = "项目管理", methods = "项目管理-添加商铺销控图片")
    public String addOfficeImg(@RequestParam(value = "pictureFile", required = false) MultipartFile[] pictureFile, String officeId,
                              HttpServletRequest request) throws Exception {

        HashMap imgForMap = new HashMap();
        imgForMap.put("officeId", officeId);
        imgForMap.put("createDate", new Date());
        //定义序号
        for (MultipartFile file : pictureFile) {
            if (!file.isEmpty()) {
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                // 获取文件的扩展名
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                // 设置图片上传路径
                String url = request.getSession().getServletContext().getRealPath("/img/pro_office/");
                String imgName = name + "." + ext;
                System.err.println(url);
                // 以绝对路径保存重名命后的图片
                File targetFile = new File(url + officeId + "/" + imgName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                file.transferTo(targetFile); // 保存文件
                imgForMap.put("img", imgName);
                projectOfficeService.addOfficeImg(imgForMap);

            }

        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "findOfficeImg")
    public List<ProjectOfficeFormMap> findOfficeImg(String officeId) throws Exception {
        List<ProjectOfficeFormMap> listImg = projectOfficeService.findOfficeImg(officeId);
        return listImg;
    }

    @ResponseBody
    @RequestMapping("deleteOfficeImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除商铺销控图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteOfficeImg(String id) throws Exception {

        projectOfficeService.deleteOfficeImg(id);

        return "success";
    }





}









