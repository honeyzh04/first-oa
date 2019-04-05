package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.ProjectApartmentFormMap;
import com.first.entity.ProjectHomeFormMap;
import com.first.exception.SystemException;
import com.first.service.system.ProjectHomeService;
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
 * 住宅项目管理
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年6月2日
 */
@Controller
@RequestMapping("/projectHome/")
public class ProjectHomeController extends BaseController {
    @Inject
    private ProjectHomeService projectHomeService;
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
     * 查看住宅项目列表
     * @param request
     * @param draw
     * @param start
     * @param length
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findByProjectHome")
    public Object findByProjectHome(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        String area= request.getParameter("area");
        String prices= request.getParameter("prices");
        HashMap b= search(area,prices);
        searchMap.putAll(b);
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectHomeFormMap> p = projectHomeService.findProjectHome(searchMap);
        PageInfo<ProjectHomeFormMap> pageinfo = new PageInfo<ProjectHomeFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectHomeFormMap a : pageinfo.getList()) {
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
    public List<ProjectHomeFormMap> showProvince() {
        List<ProjectHomeFormMap> projectHomeFormMap =projectHomeService.getProject();
        return projectHomeFormMap;
    }
    /**
     * 查看项目具体
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findProject")
    public ProjectHomeFormMap findProject(@RequestParam("id") String id) throws Exception {
        ProjectHomeFormMap mps = projectHomeService.findbyProject(id);
        return mps;
    }

    /**
     * 添加
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addProjectHomeUI")
    public String addUI(Model model) throws Exception {
        System.err.println("ad");
        return Common.BACKGROUND_PATH + "/system/project/addProjectHome";
    }

    @ResponseBody
    @RequestMapping("addProjectHome")
    @SystemLog(module = "项目管理", methods = "项目管理-添加住宅项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addProjectHome() {
        try {
            ProjectHomeFormMap projectHomeFormMap = getFormMap(ProjectHomeFormMap.class);
            projectHomeFormMap.put("createDate", new Date());
            projectHomeFormMap.put("delFlag", "0");
            projectHomeFormMap.put("modifyDate", new Date());
            projectHomeFormMap.put("type", "4");
            projectHomeFormMap.put("modifyPerson", getuserName());
            System.err.println(projectHomeFormMap);
            projectHomeService.addProjects(projectHomeFormMap);
        } catch (Exception e) {
            throw new SystemException("添加住宅项目异常");
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
    @RequestMapping(value = "editProjectHomeUI")
    public String editUI(Model model, @RequestParam("id") String id) throws Exception {
        if (Common.isNotEmpty(id)) {
            ProjectHomeFormMap mps=projectHomeService.findbyProject(id);
            model.addAttribute("projectHome", mps);
        }
        return Common.BACKGROUND_PATH + "/system/project/editProjectHome";
    }

    @ResponseBody
    @RequestMapping("editProjectHome")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-修改住宅项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editProjectHome() throws Exception {
        ProjectHomeFormMap ProjectHomeFormMap = getFormMap(ProjectHomeFormMap.class);
        projectHomeService.editProject(ProjectHomeFormMap);
        return "success";
    }

    /**
     * 删除项目
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping("deleteProjectHome")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-删除住宅项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteEntity() throws Exception {
        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectHomeService.deleteEntity(id);
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
        return Common.BACKGROUND_PATH + "/system/project/addProjectHomeImg";
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
                String url = request.getSession().getServletContext().getRealPath("/img/project/home/");
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
                projectHomeService.addImg(imgForMap);

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
    public List<ProjectHomeFormMap> findImg(String proId, String type) throws Exception {
        HashMap searchImg = new HashMap();
        searchImg.put("proId", proId);
        searchImg.put("type", type);
        List<ProjectHomeFormMap> listImg = projectHomeService.findImg(searchImg);
        System.err.println(listImg);
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

        projectHomeService.deleteImg(id);
        return "success";
    }


    //住宅销控管理

    @RequestMapping("homelist")
    public String homeListUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/project/homelist";
    }

    @ResponseBody
    @RequestMapping("findHomeList")
    public Object findHomeList(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        searchMap.put("type", request.getParameter("type"));
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectHomeFormMap> p =  projectHomeService.findHomeList(searchMap);
        PageInfo<ProjectHomeFormMap> pageinfo = new PageInfo<ProjectHomeFormMap>(p);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectHomeFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
    }

    @RequestMapping("addHomeUI")
    public String addHomeUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/addHome";
    }

    @ResponseBody
    @RequestMapping("addHome")
    @SystemLog(module = "项目管理", methods = "项目管理-添加住宅销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addHome() {
        try {
            ProjectHomeFormMap projectHomeFormMap = getFormMap(ProjectHomeFormMap.class);
            projectHomeFormMap.put("date", new Date());
            projectHomeFormMap.put("delFlag", "0");
            System.err.println("da"+projectHomeFormMap);
            projectHomeService.addHome(projectHomeFormMap);
        } catch (Exception e) {
            throw new SystemException("添加项目异常");
        }
        return "success";
    }
    @RequestMapping("editHomeUI")
    public String editHomeUI(Model model,String id) throws Exception {
        ProjectHomeFormMap home = projectHomeService.findHome(id);
        model.addAttribute("home", home);
        return Common.BACKGROUND_PATH + "/system/project/editHome";
    }
    @ResponseBody
    @RequestMapping("editHome")
    @SystemLog(module = "项目管理", methods = "项目管理-修改住宅销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String editHome() {
        try {
            ProjectHomeFormMap ProjectHomeFormMap = getFormMap(ProjectHomeFormMap.class);

            projectHomeService.editHome(ProjectHomeFormMap);
        } catch (Exception e) {
            throw new SystemException("修改异常");
        }
        return "success";
    }
    @RequestMapping("findHomeUI")
    public String findHomeUI(Model model) throws Exception {
        String homeId = getPara("id");
        model.addAttribute("homeId", homeId);
        return Common.BACKGROUND_PATH + "/system/project/home";
    }

    @ResponseBody
    @RequestMapping("findHome")
    public Result<Void> findHome(String id) throws Exception {
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
    @RequestMapping("deleteHome")
    @Transactional(readOnly = false)
    @SystemLog(module = "项目管理", methods = "项目管理-删除住宅销控")
    public String deleteHome() throws Exception {

        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectHomeService.deleteHome(id);


        }
        return "success";
    }



    @RequestMapping("addHomeImgUI")
    public String addHomeImgUI(Model model) throws Exception {
        String homeId = getPara("id");
        model.addAttribute("homeId", homeId);
        return Common.BACKGROUND_PATH + "/system/project/addHomeImg";
    }


    @ResponseBody
    @RequestMapping(value = "addHomeImg")
    @SystemLog(module = "项目管理", methods = "项目管理-添加住宅销控图片")
    public String addHomeImg(@RequestParam(value = "pictureFile", required = false) MultipartFile[] pictureFile, String homeId,
                              HttpServletRequest request) throws Exception {

        HashMap imgForMap = new HashMap();
        imgForMap.put("homeId", homeId);
        imgForMap.put("createDate", new Date());
        //定义序号
        for (MultipartFile file : pictureFile) {
            if (!file.isEmpty()) {
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                // 获取文件的扩展名
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                // 设置图片上传路径
                String url = request.getSession().getServletContext().getRealPath("/img/pro_home/");
                String imgName = name + "." + ext;
                System.err.println(url);
                // 以绝对路径保存重名命后的图片
                File targetFile = new File(url + homeId + "/" + imgName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                file.transferTo(targetFile); // 保存文件
                imgForMap.put("img", imgName);
                projectHomeService.addHomeImg(imgForMap);

            }

        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "findHomeImg")
    public List<ProjectHomeFormMap> findHomeImg(String homeId) throws Exception {
        List<ProjectHomeFormMap> listImg = projectHomeService.findHomeImg(homeId);
        return listImg;
    }

    @ResponseBody
    @RequestMapping("deleteHomeImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除住宅销控图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteHomeImg(String id) throws Exception {

        projectHomeService.deleteHomeImg(id);

        return "success";
    }





}









