package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.ProjectApartmentFormMap;
import com.first.entity.ProjectFormMap;
import com.first.exception.SystemException;
import com.first.service.system.ProjectApartmentService;
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
 * 公寓项目管理
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年6月2日
 */
@Controller
@RequestMapping("/projectApartment/")
public class ProjectApartmentController extends BaseController {

    @Inject
    private ProjectApartmentService projectApartmentService;
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
    @RequestMapping("findByProjectApartment")
    public Object findByProjectApartment(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        String area= request.getParameter("area");
        String prices= request.getParameter("prices");
        HashMap b= search(area,prices);
        searchMap.putAll(b);
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectApartmentFormMap> p = projectApartmentService.findProjectApartment(searchMap);
        PageInfo<ProjectApartmentFormMap> pageinfo = new PageInfo<ProjectApartmentFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectApartmentFormMap a : pageinfo.getList()) {
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
    public List<ProjectApartmentFormMap> showProvince() {
        List<ProjectApartmentFormMap> projectApartmentFormMap =projectApartmentService.getProject();
        return projectApartmentFormMap;
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
        return Common.BACKGROUND_PATH + "/system/project/apartmentDetails";
    }
    /**
     * 查看项目具体
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findProject")
    public ProjectApartmentFormMap findProject(@RequestParam("id") String id) throws Exception {
        ProjectApartmentFormMap mps = projectApartmentService.findbyProject(id);
        return mps;
    }

    /**
     * 添加
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addProjectApartmentUI")
    public String addUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/addProjectApartment";
    }

    @ResponseBody
    @RequestMapping("addProjectApartment")
    @SystemLog(module = "项目管理", methods = "项目管理-添加公寓项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addProjectApartment() {
        try {
            ProjectApartmentFormMap projectApartmentFormMap = getFormMap(ProjectApartmentFormMap.class);
            projectApartmentFormMap.put("createDate", new Date());
            projectApartmentFormMap.put("delFlag", "0");
            projectApartmentFormMap.put("modifyDate", new Date());
            projectApartmentFormMap.put("type", "2");
            projectApartmentFormMap.put("modifyPerson", getuserName());
            System.err.println(projectApartmentFormMap);
            projectApartmentService.addProjects(projectApartmentFormMap);
        } catch (Exception e) {
            throw new SystemException("添加公寓项目异常");
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
    @RequestMapping(value = "editProjectApartmentUI")
    public String editUI(Model model, @RequestParam("id") String id) throws Exception {
        if (Common.isNotEmpty(id)) {
            ProjectApartmentFormMap mps=projectApartmentService.findbyProject(id);
            model.addAttribute("projectApartment", mps);
        }
        return Common.BACKGROUND_PATH + "/system/project/editProjectApartment";
    }

    @ResponseBody
    @RequestMapping("editProjectApartment")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-修改公寓项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editProjectApartment() throws Exception {
        ProjectApartmentFormMap ProjectApartmentFormMap = getFormMap(ProjectApartmentFormMap.class);
        projectApartmentService.editProject(ProjectApartmentFormMap);
        return "success";
    }

    /**
     * 删除项目
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping("deleteProjectApartment")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-删除公寓项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteEntity() throws Exception {
        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectApartmentService.deleteEntity(id);
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
        return Common.BACKGROUND_PATH + "/system/project/addProjectApartmentImg";
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
                String url = request.getSession().getServletContext().getRealPath("/img/project/apartment/");
                String imgName = name + "." + ext;
                String zip=url + proId + "\\" + imgName;
                System.err.println(url+"ad"+zip);
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
                projectApartmentService.addImg(imgForMap);

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
    public List<ProjectApartmentFormMap> findImg(String proId, String type) throws Exception {
        HashMap searchImg = new HashMap();
        searchImg.put("proId", proId);
        searchImg.put("type", type);
        List<ProjectApartmentFormMap> listImg = projectApartmentService.findImg(searchImg);
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

        projectApartmentService.deleteImg(id);
        return "success";
    }


    //公寓销控管理

    @RequestMapping("apartmentlist")
    public String apartmentListUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/project/apartmentlist";
    }

    @ResponseBody
    @RequestMapping("findApartmentList")
    public Object findApartmentList(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        searchMap.put("type", request.getParameter("type"));
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectApartmentFormMap> p =  projectApartmentService.findApartmentList(searchMap);
        PageInfo<ProjectApartmentFormMap> pageinfo = new PageInfo<ProjectApartmentFormMap>(p);
        System.err.println("公寓" + pageinfo);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectApartmentFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
    }

    @RequestMapping("addApartmentUI")
    public String addApartmentUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/addApartment";
    }

    @ResponseBody
    @RequestMapping("addApartment")
    @SystemLog(module = "项目管理", methods = "项目管理-添加公寓销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addApartment() {
        try {
            ProjectApartmentFormMap ProjectApartmentFormMap = getFormMap(ProjectApartmentFormMap.class);
            ProjectApartmentFormMap.put("date", new Date());
            ProjectApartmentFormMap.put("delFlag", "0");

            projectApartmentService.addApartment(ProjectApartmentFormMap);
        } catch (Exception e) {
            throw new SystemException("添加项目异常");
        }
        return "success";
    }
    @RequestMapping("editApartmentUI")
    public String editApartmentUI(Model model,String id) throws Exception {
        ProjectApartmentFormMap apartment = projectApartmentService.findApartment(id);
        model.addAttribute("apartment", apartment);
        return Common.BACKGROUND_PATH + "/system/project/editApartment";
    }
    @ResponseBody
    @RequestMapping("editApartment")
    @SystemLog(module = "项目管理", methods = "项目管理-修改公寓销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String editApartment() {
        try {
            ProjectApartmentFormMap ProjectApartmentFormMap = getFormMap(ProjectApartmentFormMap.class);

            projectApartmentService.editApartment(ProjectApartmentFormMap);
        } catch (Exception e) {
            throw new SystemException("修改异常");
        }
        return "success";
    }
    @RequestMapping("findApartmentUI")
    public String findApartmentUI(Model model) throws Exception {
        String apartmentId = getPara("id");
        model.addAttribute("apartmentId", apartmentId);
        return Common.BACKGROUND_PATH + "/system/project/apartment";
    }

    @ResponseBody
    @RequestMapping("findApartment")
    public Result<Void> findApartment(String id) throws Exception {
        Result<Void> rr = null;
        HashMap apartmentList = new HashMap();
        try {
            ProjectApartmentFormMap apartment = projectApartmentService.findApartment(id);

            List<ProjectApartmentFormMap> apartmentImg = projectApartmentService.findApartmentImg(id);
            apartmentList.put("apartment", apartment);
            apartmentList.put("apartmentImg", apartmentImg);
            rr = new Result<Void>(1, "成功", apartmentList);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    @ResponseBody
    @RequestMapping("deleteApartment")
    @Transactional(readOnly = false)
    @SystemLog(module = "项目管理", methods = "项目管理-删除公寓销控")
    public String deleteApartment() throws Exception {

        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectApartmentService.deleteApartment(id);


        }
        return "success";
    }



    @RequestMapping("addApartmentImgUI")
    public String addApartmentImgUI(Model model) throws Exception {
        String apartmentId = getPara("id");
        model.addAttribute("apartmentId", apartmentId);
        return Common.BACKGROUND_PATH + "/system/project/addApartmentImg";
    }


    @ResponseBody
    @RequestMapping(value = "addApartmentImg")
    @SystemLog(module = "项目管理", methods = "项目管理-添加公寓销控图片")
    public String addApartmentImg(@RequestParam(value = "pictureFile", required = false) MultipartFile[] pictureFile, String apartmentId,
                              HttpServletRequest request) throws Exception {

        HashMap imgForMap = new HashMap();
        imgForMap.put("apartmentId", apartmentId);
        imgForMap.put("createDate", new Date());
        //定义序号
        for (MultipartFile file : pictureFile) {
            if (!file.isEmpty()) {
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                // 获取文件的扩展名
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                // 设置图片上传路径
                String url = request.getSession().getServletContext().getRealPath("/img/pro_apartment/");
                String imgName = name + "." + ext;
                System.err.println(url);
                // 以绝对路径保存重名命后的图片
                File targetFile = new File(url + apartmentId + "/" + imgName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                file.transferTo(targetFile); // 保存文件
                imgForMap.put("img", imgName);
                projectApartmentService.addApartmentImg(imgForMap);

            }

        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "findApartmentImg")
    public List<ProjectApartmentFormMap> findApartmentImg(String apartmentId) throws Exception {
        List<ProjectApartmentFormMap> listImg = projectApartmentService.findApartmentImg(apartmentId);
        return listImg;
    }

    @ResponseBody
    @RequestMapping("deleteApartmentImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除公寓销控图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteApartmentImg(String id) throws Exception {

        projectApartmentService.deleteApartmentImg(id);

        return "success";
    }





}









