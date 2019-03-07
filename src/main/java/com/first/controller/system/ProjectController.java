package com.first.controller.system;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.ProjectFormMap;
import com.first.exception.SystemException;
import com.first.mapper.ProjectMapper;
import com.first.service.system.ProjectService;
import com.first.util.Baidugeocoder;
import com.first.util.Common;
import com.first.util.Result;
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
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 项目管理
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年6月2日
 */
@Controller
@RequestMapping("/project/")
public class ProjectController extends BaseController {
    @Inject
    private ProjectMapper projectMapper;
    @Inject
    private ProjectService projectService;

    @RequestMapping("tablelist")
    public String listUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/project/tablelist";
    }

    @RequestMapping("shopslist")
    public String shopsListUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/project/shopslist";
    }

    @RequestMapping("apartmentlist")
    public String apartmentListUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/project/apartmentlist";
    }

    @RequestMapping("homelist")
    public String homeListUI(Model model) throws Exception {
        model.addAttribute("res", findByRes());
        return Common.BACKGROUND_PATH + "/system/project/homelist";
    }

    @RequestMapping("maplist")
    public String maplistUI(Model model) throws Exception {
        /*projectservice.addproject();*/
        return Common.BACKGROUND_PATH + "/system/project/maplist";
    }

    /**
     * 选择项目
     *
     * @return
     */
    @RequestMapping("getProject")
    @ResponseBody
    public List<ProjectFormMap> showProvince() {
        List<ProjectFormMap> projectFormMap = projectMapper.getProject();
        return projectFormMap;
    }

    /**
     * 项目列表
     *
     * @param request
     * @param draw
     * @param start
     * @param length
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping("findByProject")
    public Object findByProject(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        searchMap.put("type", request.getParameter("type"));
        if ("".equals(request.getParameter("area"))) {
            searchMap.put("areas", "");
            searchMap.put("areae", "");
        } else {
            String a = request.getParameter("area").toString();
            String[] areas = a.split("-");
            for (int i = 0; i < areas.length; i++) {

            }
            searchMap.put("areas", areas[0]);
            searchMap.put("areae", areas[1]);

        }
        if ("".equals(request.getParameter("prices"))) {
            searchMap.put("pricess", "");
            searchMap.put("pricese", "");
        } else {
            String a = request.getParameter("prices").toString();
            String[] price = a.split("-");
            for (int i = 0; i < price.length; i++) {

            }
            searchMap.put("pricess", price[0]);
            searchMap.put("pricese", price[1]);

        }
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectFormMap> p = projectMapper.findProject(searchMap);
        PageInfo<ProjectFormMap> pageinfo = new PageInfo<ProjectFormMap>(p);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
    }


    /**
     * 添加
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addUI")
    public String addUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/add";
    }

    @ResponseBody
    @RequestMapping("addEntity")
    @SystemLog(module = "项目管理", methods = "项目管理-添加项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String addEntity() {
        try {
            ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
            //ProjectFormMap projectFormMap = new ProjectFormMap()
            projectFormMap.put("createDate", new Date());
            projectFormMap.put("delFlag", "0");
            projectFormMap.put("modifyDate", new Date());
            projectFormMap.put("modifyPerson", getuserName());
            System.err.println("添加项目" + projectFormMap);
            projectService.addprojects(projectFormMap);
        } catch (Exception e) {
            throw new SystemException("添加项目异常");
        }
        return "success";
    }

    /**
     * 获取经纬度
     *
     * @param address
     * @param callback
     * @return
     */
    @ResponseBody
    @RequestMapping("getLatAndLng")
    public Object getLatAndLng(String address, String callback) {
        Result<Void> rr = null;
        String latAndLng = "";
        if (address != null && !address.equals("")) {
            Map<String, String> latAndLngs = Baidugeocoder.getLatAndLngByAddress(address);
            String lat = latAndLngs.get("lat").toString();
            String lng = latAndLngs.get("lng").toString();
            latAndLng = lng + "," + lat;

            rr = new Result<Void>(1, "成功", latAndLng);
        }
        return rr;
    }

    /**
     * 修改项目
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "editUI")
    public String editUI(Model model, @RequestParam("id") String id) throws Exception {
        //String id = getPara("id");

        if (Common.isNotEmpty(id)) {

            ProjectFormMap mps = projectService.findbyProject(id);
            System.err.println("xiangmu" + mps);

            model.addAttribute("project", mps);
        }
        return Common.BACKGROUND_PATH + "/system/project/edit";
    }

    @ResponseBody
    @RequestMapping("editEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-修改项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String editEntity(String txtGroupsSelect) throws Exception {
        ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
        System.err.println("c测试2" + projectFormMap);
        projectService.editEntity(projectFormMap);


        return "success";
    }

    /**
     * 查看项目
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findProject")
    public ProjectFormMap findProject(@RequestParam("id") String id) throws Exception {
        ProjectFormMap mps = projectService.findbyProject(id);
        return mps;
    }

    /**
     * 添加项目图片
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addImgUI")
    public String addImgUI(Model model) throws Exception {
        String proId = getPara("id");
        model.addAttribute("proId", proId);
        return Common.BACKGROUND_PATH + "/system/project/addImg";
    }


    @ResponseBody
    @RequestMapping(value = "addImgEntity")
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
                String url = request.getSession().getServletContext().getRealPath("/img/project/");
                String imgName = name + "." + ext;
                System.err.println(url);
                // 以绝对路径保存重名命后的图片
                File targetFile = new File(url + proId + "/" + imgName);
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }

                file.transferTo(targetFile); // 保存文件

                System.err.println(targetFile);

            /*    String url1 ="F:\\idea-workspace\\新建文件夹\\";
                File targetFile1= new File(url1 + imgName);
                System.err.println(url1);
                if (targetFile1.getParentFile().exists()) {
                    targetFile1.getParentFile().mkdirs();

                }
                file.transferTo(targetFile1);*/
                imgForMap.put("img", imgName);
                projectService.addImg(imgForMap);

            }

        }
        return "success";
    }

    //根据请求的路径中的参数id,从本地磁盘中读取图片，picUrl是从配置文件中读取出来的
    @ResponseBody
    @RequestMapping("tofindPic")
    public void picToJSP(String imgName, HttpServletRequest request, HttpServletResponse response) {
        FileInputStream in;
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            //图片读取路径
            in = new FileInputStream("F:/idea-workspace/first-oa/target/first-oa/img/project/" + imgName);
            int i = in.available();
            byte[] data = new byte[i];
            in.read(data);
            in.close();

            //写图片
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "findImg")
    public List<ProjectFormMap> findImg(String proId, String type) throws Exception {
        HashMap searchImg = new HashMap();
        searchImg.put("proId", proId);
        searchImg.put("type", type);
        List<ProjectFormMap> listImg = projectService.findImg(searchImg);
        return listImg;
    }

    @ResponseBody
    @RequestMapping("deleteImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteImg(String id) throws Exception {

        projectService.deleteImg(id);

        return "success";
    }

    /**
     * 查看特点
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findFeature")
    public List<ProjectFormMap> findFeature() throws Exception {

        List<ProjectFormMap> feature = projectService.findFeature();
        return feature;
    }

    /**
     * 删除项目
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deleteEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-删除项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteEntity() throws Exception {

        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectService.deleteEntity(id);


        }
        return "success";
    }

    /**
     * 手动更新项目
     *
     * @return
     * @throws Exception
     */
   /* @ResponseBody
    @RequestMapping("updateEntity")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    @SystemLog(module = "项目管理", methods = "项目管理-更新项目") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String updateEntity() throws Exception {

        projectService.addproject();

        return "success";
    }*/

    /**
     * 自动更新项目
     */

/*    @Scheduled(cron = "0 0 3,13 * * ?")
    public void updateProject() throws UnsupportedEncodingException {


        projectService.addproject();

    }*/

    /**
     * 楼盘详情
     *
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "housedetail")
    public String housedetailUI(Model model, @RequestParam("id") String id, @RequestParam("state") String state) {


        if (state.equals("2")) {
            state = "在售";
        } else {
            state = "停售";
        }

        model.addAttribute("IDs", id);
        model.addAttribute("state", state);
        return Common.BACKGROUND_PATH + "/system/project/housedetail";
    }

    /**
     * 查看商铺
     *
     * @param request
     * @param draw
     * @param start
     * @param length
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("findShopsList")
    public Object findShopsList(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        searchMap.put("type", request.getParameter("type"));
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectFormMap> p = projectMapper.findShopsList(searchMap);
        PageInfo<ProjectFormMap> pageinfo = new PageInfo<ProjectFormMap>(p);
        System.err.println("商铺" + pageinfo);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectFormMap a : pageinfo.getList()) {
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
            ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
            projectFormMap.put("date", new Date());
            projectFormMap.put("delFlag", "0");

       projectService.addShops(projectFormMap);
        } catch (Exception e) {
            throw new SystemException("添加项目异常");
        }
        return "success";
    }
    @RequestMapping("editShopsUI")
    public String editShopsUI(Model model,String id) throws Exception {
        ProjectFormMap shops = projectService.findShops(id);
        model.addAttribute("shops", shops);
        return Common.BACKGROUND_PATH + "/system/project/editShops";
    }
    @ResponseBody
    @RequestMapping("editShops")
    @SystemLog(module = "项目管理", methods = "项目管理-修改商铺销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String editShops() {
        try {
            ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
          //  projectService.editShops(projectFormMap);
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
            ProjectFormMap shops = projectService.findShops(id);

            List<ProjectFormMap> shopsImg = projectService.findShopsImg(id);
            shopsList.put("shops", shops);
            shopsList.put("shopsImg", shopsImg);
            rr = new Result<Void>(1, "成功", shopsList);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
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
                // 使用UUID给图片重命名，并去掉四个“-”
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
                projectService.addShopsImg(imgForMap);

            }

        }
        return "success";
    }
    @ResponseBody
    @RequestMapping("deleteShops")
    @Transactional(readOnly = false)
    @SystemLog(module = "项目管理", methods = "项目管理-删除商铺销控")
    public String deleteShops() throws Exception {

        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectService.deleteShops(id);


        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "findShopsImg")
    public List<ProjectFormMap> findShopsImg(String shopsId) throws Exception {
        List<ProjectFormMap> listImg = projectService.findShopsImg(shopsId);
        return listImg;
    }

    @ResponseBody
    @RequestMapping("deleteShopsImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除商铺销控图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteShopsImg(String id) throws Exception {

        projectService.deleteShopsImg(id);

        return "success";
    }

    // 公寓管理
    @RequestMapping("addApartmentUI")
    public String addApartmentUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/addApartment";
    }

    @ResponseBody
    @RequestMapping("addApartment")
    @SystemLog(module = "项目管理", methods = "项目管理-添加公寓销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String Apartment() {
        try {
            ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
            projectFormMap.put("CreationDate", new Date());
            projectFormMap.put("delFlag", "0");
            projectService.addApartment(projectFormMap);
        } catch (Exception e) {
            throw new SystemException("添加项目异常");
        }
        return "success";
    }
    @RequestMapping("editApartmentUI")
    public String editApartmentUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/editApartment";
    }
    @ResponseBody
    @RequestMapping("editApartment")
    @SystemLog(module = "项目管理", methods = "项目管理-修改公寓销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String editApartment() {
        try {
            ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
            //  projectService.editApartment(projectFormMap);
        } catch (Exception e) {
            throw new SystemException("修改异常");
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping("deleteApartment")
    @Transactional(readOnly = false)
    @SystemLog(module = "项目管理", methods = "项目管理-删除公寓销控")
    public String deleteApartment() throws Exception {

        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectService.deleteApartment(id);


        }
        return "success";
    }
    @ResponseBody
    @RequestMapping("findApartmentList")
    public Object findApartmentList(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        searchMap.put("type", request.getParameter("type"));
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectFormMap> p = projectMapper.findApartmentList(searchMap);
        PageInfo<ProjectFormMap> pageinfo = new PageInfo<ProjectFormMap>(p);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
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
            ProjectFormMap apartment = projectService.findApartment(id);
            List<ProjectFormMap> apartmentImg = projectService.findApartmentImg(id);
            apartmentList.put("apartment", apartment);
            apartmentList.put("apartmentImg", apartmentImg);
            rr = new Result<Void>(1, "成功", apartmentList);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
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
                // 使用UUID给图片重命名，并去掉四个“-”
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
                projectService.addApartmentImg(imgForMap);

            }

        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "findApartmentImg")
    public List<ProjectFormMap> findApartmentImg(String apartmentId) throws Exception {
        List<ProjectFormMap> listImg = projectService.findApartmentImg(apartmentId);
        return listImg;
    }

    @ResponseBody
    @RequestMapping("deleteApartmentImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除公寓销控图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteApartmentImg(String id) throws Exception {

        projectService.deleteApartmentImg(id);

        return "success";
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
            ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
            //ProjectFormMap projectFormMap = new ProjectFormMap()
            projectFormMap.put("createDate", new Date());
            projectFormMap.put("delFlag", "0");
            projectService.addHome(projectFormMap);
        } catch (Exception e) {
            throw new SystemException("添加项目异常");
        }
        return "success";
    }

    @RequestMapping("editHomeUI")
    public String editHomeUI(Model model) throws Exception {

        return Common.BACKGROUND_PATH + "/system/project/editHome";
    }
    @ResponseBody
    @RequestMapping("editHome")
    @SystemLog(module = "项目管理", methods = "项目管理-修改住宅销控") // 凡需要处理业务逻辑的.都需要记录操作日志
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public String editHome() {
        try {
            ProjectFormMap projectFormMap = getFormMap(ProjectFormMap.class);
            //  projectService.editHome(projectFormMap);
        } catch (Exception e) {
            throw new SystemException("修改异常");
        }
        return "success";
    }
    @ResponseBody
    @RequestMapping("deleteHome")
    @Transactional(readOnly = false)
    @SystemLog(module = "项目管理", methods = "项目管理-删除公寓销控")
    public String deleteHome() throws Exception {

        String Ids = getPara("ids");
        String[] ids = Ids.split(",");
        for (String id : ids) {
            projectService.deleteHome(id);


        }
        return "success";
    }
    @ResponseBody
    @RequestMapping("findHomeList")
    public Object findHomeList(HttpServletRequest request, int draw, int start, int length) throws Exception {
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("projectName", request.getParameter("projectName"));
        searchMap.put("region", request.getParameter("region"));
        searchMap.put("type", request.getParameter("type"));
        PageHelper.startPage((start / length) + 1, length);
        List<ProjectFormMap> p = projectMapper.findHomeList(searchMap);
        PageInfo<ProjectFormMap> pageinfo = new PageInfo<ProjectFormMap>(p);

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for (ProjectFormMap a : pageinfo.getList()) {
            data.add(a);
        }
        map.put("draw", draw);
        map.put("recordsTotal", pageinfo.getTotal());
        map.put("recordsFiltered", pageinfo.getTotal());
        map.put("data", data);
        return map;
    }

    @RequestMapping("findHomeUI")
    public String findHomeUI(Model model) throws Exception {
        String homeId = getPara("id");
        model.addAttribute("homeId", homeId);
        return Common.BACKGROUND_PATH + "/system/project/home";
    }

    @ResponseBody
    @RequestMapping("findHome")
    public Result<Void> findHome(String id) {
        Result<Void> rr = null;
        HashMap homeList = new HashMap();
        try {
            ProjectFormMap home = projectService.findHome(id);
            List<ProjectFormMap> homeImg = projectService.findHomeImg(id);
            homeList.put("home", home);
            homeList.put("homeImg", homeImg);
            rr = new Result<Void>(1, "成功", homeList);
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
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
                // 使用UUID给图片重命名，并去掉四个“-”
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
                projectService.addHomeImg(imgForMap);

            }

        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "findHomeImg")
    public List<ProjectFormMap> findHomeImg(String homeId) throws Exception {
        List<ProjectFormMap> listImg = projectService.findHomeImg(homeId);
        return listImg;
    }

    @ResponseBody
    @RequestMapping("deleteHomeImg")
    @SystemLog(module = "项目管理", methods = "项目管理-删除住宅销控图片") // 凡需要处理业务逻辑的.都需要记录操作日志
    public String deleteHomeImg(String id) throws Exception {

        projectService.deleteHomeImg(id);

        return "success";
    }

}









