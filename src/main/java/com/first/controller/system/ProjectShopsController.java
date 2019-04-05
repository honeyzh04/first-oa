package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.ProjectOfficeFormMap;
import com.first.entity.ProjectShopsFormMap;
import com.first.exception.SystemException;
import com.first.service.system.ProjectShopsService;
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
@RequestMapping("/projectShops/")
public class ProjectShopsController extends BaseController {
    @Inject
    private ProjectShopsService projectShopsService;

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
    @RequestMapping("findByProjectShops")
    public Object findByProjectShops(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        String area= request.getParameter("area");
        String prices= request.getParameter("prices");
        HashMap b= search(area,prices);
        searchMap.putAll(b);
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectShopsFormMap> p = projectShopsService.findProjectShops(searchMap);
        PageInfo<ProjectShopsFormMap> pageinfo = new PageInfo<ProjectShopsFormMap>(p);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectShopsFormMap a : pageinfo.getList()) {
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
    public List<ProjectShopsFormMap> showProvince() {
        List<ProjectShopsFormMap> projectShopsFormMap = projectShopsService.getProject();
        return projectShopsFormMap;
    }
    /**
     * 查看项目具体
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findProject")
    public ProjectShopsFormMap findProject(@RequestParam("id") String id) throws Exception {
        ProjectShopsFormMap mps = projectShopsService.findbyProject(id);
        return mps;
    }

    /**
     * 添加
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addProjectShopsUI")
    public String addUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/addProjectShops";
    }

    @ResponseBody
    @RequestMapping("addProjectShops")
    @SystemLog(module = "项目管理", methods = "项目管理-添加商铺项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addProjectShops() {
        try {
            ProjectShopsFormMap projectShopsFormMap = getFormMap(ProjectShopsFormMap.class);

            projectShopsFormMap.put("createDate", new Date());
            projectShopsFormMap.put("delFlag", "0");
            projectShopsFormMap.put("modifyDate", new Date());
            projectShopsFormMap.put("type", "1");
            projectShopsFormMap.put("modifyPerson", getuserName());
            System.err.println(projectShopsFormMap);
            projectShopsService.addProjects(projectShopsFormMap);
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
    @RequestMapping(value = "editProjectShopsUI")
    public String editUI(Model model, @RequestParam("id") String id) throws Exception {
        if (Common.isNotEmpty(id)) {
            ProjectShopsFormMap mps=projectShopsService.findbyProject(id);
            model.addAttribute("projectShops", mps);
        }
        return Common.BACKGROUND_PATH + "/system/project/editProjectShops";
    }

    @ResponseBody
    @RequestMapping("editProjectShops")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-修改商铺项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editProjectShops() throws Exception {
        ProjectShopsFormMap projectShopsFormMap = getFormMap(ProjectShopsFormMap.class);
        projectShopsService.editProject(projectShopsFormMap);
        return "success";
    }

    /**
     * 删除项目
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping("deleteProjectShops")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-删除商铺项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteEntity() throws Exception {
        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectShopsService.deleteEntity(id);
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
        return Common.BACKGROUND_PATH + "/system/project/addProjectShopsImg";
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
                String url = request.getSession().getServletContext().getRealPath("/img/project/shops/");
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
                projectShopsService.addImg(imgForMap);

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
    public List<ProjectShopsFormMap> findImg(String proId, String type) throws Exception {
        HashMap searchImg = new HashMap();
        searchImg.put("proId", proId);
        searchImg.put("type", type);
        List<ProjectShopsFormMap> listImg = projectShopsService.findImg(searchImg);
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

        projectShopsService.deleteImg(id);
        return "success";
    }


    //商铺销控管理

    @RequestMapping("shopslist")
    public String shopsListUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/project/shopslist";
    }

    @ResponseBody
    @RequestMapping("findShopsList")
    public Object findShopsList(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        searchMap.put("type", request.getParameter("type"));
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectShopsFormMap> p =  projectShopsService.findShopsList(searchMap);
        PageInfo<ProjectShopsFormMap> pageinfo = new PageInfo<ProjectShopsFormMap>(p);
        System.err.println("商铺" + pageinfo);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectShopsFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
    }

    @RequestMapping("addShopsUI")
    public String addShopsUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/addShops";
    }

    @ResponseBody
    @RequestMapping("addShops")
    @SystemLog(module = "项目管理", methods = "项目管理-添加商铺销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addShops() {
        try {
            ProjectShopsFormMap ProjectShopsFormMap = getFormMap(ProjectShopsFormMap.class);
            ProjectShopsFormMap.put("date", new Date());
            ProjectShopsFormMap.put("delFlag", "0");

            projectShopsService.addShops(ProjectShopsFormMap);
        } catch (Exception e) {
            throw new SystemException("添加项目异常");
        }
        return "success";
    }
    @RequestMapping("editShopsUI")
    public String editShopsUI(Model model,String id) throws Exception {
        ProjectShopsFormMap shops = projectShopsService.findShops(id);
        model.addAttribute("shops", shops);
        return Common.BACKGROUND_PATH + "/system/project/editShops";
    }
    @ResponseBody
    @RequestMapping("editShops")
    @SystemLog(module = "项目管理", methods = "项目管理-修改商铺销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String editShops() {
        try {
            ProjectShopsFormMap ProjectShopsFormMap = getFormMap(ProjectShopsFormMap.class);

            projectShopsService.editShops(ProjectShopsFormMap);
        } catch (Exception e) {
            throw new SystemException("修改异常");
        }
        return "success";
    }
    @RequestMapping("findShopsUI")
    public String findShopsUI(Model model) throws Exception {
        String shopsId = getPara("id");
        model.addAttribute("shopsId", shopsId);
        return Common.BACKGROUND_PATH + "/system/project/shops";
    }

    @ResponseBody
    @RequestMapping("findShops")
    public Result<Void> findShops(String id) throws Exception {
        Result<Void> rr = null;
        HashMap shopsList = new HashMap();
        try {
            ProjectShopsFormMap shops = projectShopsService.findShops(id);

            List<ProjectShopsFormMap> shopsImg = projectShopsService.findShopsImg(id);
            shopsList.put("shops", shops);
            shopsList.put("shopsImg", shopsImg);
            rr = new Result<Void>(1, "成功", shopsList);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }
    @ResponseBody
    @RequestMapping("deleteShops")
    @Transactional(readOnly = false)
    @SystemLog(module = "项目管理", methods = "项目管理-删除商铺销控")
    public String deleteShops() throws Exception {

        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectShopsService.deleteShops(id);


        }
        return "success";
    }



    @RequestMapping("addShopsImgUI")
    public String addShopsImgUI(Model model) throws Exception {
        String shopsId = getPara("id");
        model.addAttribute("shopsId", shopsId);
        return Common.BACKGROUND_PATH + "/system/project/addShopsImg";
    }


    @ResponseBody
    @RequestMapping(value = "addShopsImg")
    @SystemLog(module = "项目管理", methods = "项目管理-添加商铺销控图片")
    public String addShopsImg(@RequestParam(value = "pictureFile", required = false) MultipartFile[] pictureFile, String shopsId,
                              HttpServletRequest request) throws Exception {

        HashMap imgForMap = new HashMap();
        imgForMap.put("shopsId", shopsId);
        imgForMap.put("createDate", new Date());
        //定义序号
        for (MultipartFile file : pictureFile) {
            if (!file.isEmpty()) {
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                // 获取文件的扩展名
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                // 设置图片上传路径
                String url = request.getSession().getServletContext().getRealPath("/img/pro_shops/");
                String imgName = name + "." + ext;
                System.err.println(url);
                // 以绝对路径保存重名命后的图片
                File targetFile = new File(url + shopsId + "/" + imgName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }
                file.transferTo(targetFile); // 保存文件
                imgForMap.put("img", imgName);
                projectShopsService.addShopsImg(imgForMap);

            }

        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "findShopsImg")
    public List<ProjectShopsFormMap> findShopsImg(String shopsId) throws Exception {
        List<ProjectShopsFormMap> listImg = projectShopsService.findShopsImg(shopsId);
        return listImg;
    }

    @ResponseBody
    @RequestMapping("deleteShopsImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除商铺销控图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteShopsImg(String id) throws Exception {

        projectShopsService.deleteShopsImg(id);

        return "success";
    }






}









