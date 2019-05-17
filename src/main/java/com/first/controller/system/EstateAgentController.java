package com.first.controller.system;

import com.first.annotation.SystemLog;
import com.first.controller.index.BaseController;
import com.first.entity.*;
import com.first.service.system.ProjectApartmentService;
import com.first.service.system.ProjectHomeService;
import com.first.service.system.ProjectOfficeService;
import com.first.service.system.ProjectShopsService;
import com.first.util.ImageUtil;
import com.first.util.Result;
import com.first.util.WatermarkImgUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

/**
 * 经纪人助手接口
 * Copyright (C), 2018-2022, ChengDu First Real estate agency
 *
 * @author zhaoh
 * @version 1.00
 * @date 2018年6月2日
 */
@Controller
@RequestMapping("/estateAgent/")
public class EstateAgentController extends BaseController {

    @Inject
    private ProjectShopsService projectShopsService;
    @Inject
    private ProjectApartmentService projectApartmentService;
    @Inject
    private ProjectOfficeService projectOfficeService;
    @Inject
    private ProjectHomeService projectHomeService;
    /**
     * 查看项目列表
     *
     * @param pageSize
     * @param pageNum
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("projectList")
    public   Result<Void> findByFFXProject(String projectName, String commissions,String commissione,String orderBy, String district, String type, String areas, String areae, String city,String prices, String pricee, String pricess, String pricese, int pageSize, @RequestParam(required = true, defaultValue = "1") Integer pageNum) throws Exception {
        Result<Void> rr = null;
        try {
            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put("projectName", projectName);
            searchMap.put("district", district);
            searchMap.put("areas", areas);
            searchMap.put("areae", areae);
            searchMap.put("prices", prices);
            searchMap.put("pricee", pricee);
            searchMap.put("pricess", pricess);
            searchMap.put("pricese", pricese);
            searchMap.put("commissions", commissions);
            searchMap.put("commissione", commissione);
            searchMap.put("city",city);
            searchMap.put("orderBy", orderBy);
            if(type.equals("1")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectShopsFormMap> p = projectShopsService.findAgentProjects(searchMap);
                PageInfo<ProjectShopsFormMap> pageinfo = new PageInfo<ProjectShopsFormMap>(p);
                rr = new Result<Void>(1, "成功", pageinfo);
            }else  if (type.equals("2")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectApartmentFormMap> p1 = projectApartmentService.findAgentProjects(searchMap);
                PageInfo<ProjectApartmentFormMap> pageinfo = new PageInfo<ProjectApartmentFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
            }else  if (type.equals("3")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectOfficeFormMap> p1 = projectOfficeService.findAgentProjects(searchMap);
                PageInfo<ProjectOfficeFormMap> pageinfo = new PageInfo<ProjectOfficeFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
            }else  if (type.equals("4")){
                PageHelper.startPage(pageNum, pageSize);
                List<ProjectHomeFormMap> p1 = projectHomeService.findAgentProjects(searchMap);
                PageInfo<ProjectHomeFormMap> pageinfo = new PageInfo<ProjectHomeFormMap>(p1);
                rr = new Result<Void>(1, "成功", pageinfo);
            }

        } catch (RuntimeException e) {

            rr = new Result<Void>(0, e.getMessage(), "");


        }
        return  rr;
    }

    /**
     * 查看项目详细数据
     * @param id
     * @param type
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findProject")
    public Result<Void> findFFXProject(@RequestParam("id") String id,String type) throws Exception {

        Result<Void> rr = null;
        try {
            if(type.equals("1")){
                ProjectShopsFormMap mps = projectShopsService.findbyAgentProject(id);
                rr = new Result<Void>(1, "成功", mps);
            }else  if (type.equals("2")){
                ProjectApartmentFormMap mps = projectApartmentService.findbyAgentProject(id);
                rr = new Result<Void>(1, "成功", mps);
            }else  if (type.equals("3")){
                ProjectOfficeFormMap mps = projectOfficeService.findbyAgentProject(id);

                rr = new Result<Void>(1, "成功", mps);
            }else  if (type.equals("4")){
                ProjectHomeFormMap mps = projectHomeService.findbyAgentProject(id);
                rr = new Result<Void>(1, "成功", mps);
            }


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;
    }

    /**
     * 添加项目
     * @return
     */
    @ResponseBody
    @RequestMapping("addProject")
    @Transactional(readOnly = false)//需要事务操作必须加入此注解
    public Result<Void> addProject(HttpServletRequest request, HttpServletResponse response,String projectName, String province, String city, String  district, String  projectPosition, String type, String lease, String state, String projectType, String developers
            , String storeyHeight, String propertyCost, String utilities, String renovation, String areas, String areae, String  prices, String   pricee, String pricess, String pricese, String commission
            , String startDate, String floorArea, String coveredArea, String commercialArea, String business, String description, String feature, String userId, String latitude,String propertyCompany,String elevator,String greeningRate) {
        Result<Void> rr = null;
        response.setHeader("Access-Control-Allow-Origin", "*");
        HashMap fromMap=new HashMap();
        System.err.println("kais添加");
        fromMap.put("projectName",projectName);
        fromMap.put("province",province);
        fromMap.put("city",city);
        fromMap.put("district",district);
        fromMap.put("projectPosition",projectPosition);
        fromMap.put("lease",lease);
        fromMap.put("state",state);
        fromMap.put("projectType",projectType);
        fromMap.put("developers",developers);
        fromMap.put("storeyHeight",storeyHeight);
        fromMap.put("propertyCost",propertyCost);
        fromMap.put("utilities",utilities);
        fromMap.put("renovation",renovation);
        fromMap.put("areas",areas);
        fromMap.put("areae",areae);
        fromMap.put("prices",prices);
        fromMap.put("pricee",pricee);
        fromMap.put("pricess",pricess);
        fromMap.put("pricese",pricese);
        fromMap.put("commission",commission);
        fromMap.put("createDate",new Date());
        fromMap.put("startDate",startDate);
        fromMap.put("floorArea",floorArea);
        fromMap.put("coveredArea",coveredArea);
        fromMap.put("commercialArea",commercialArea);
        fromMap.put("business",business);
        fromMap.put("description",description);
        fromMap.put("feature",feature);
        fromMap.put("userId",userId);
        fromMap.put("latitude",latitude);
        fromMap.put("type",type);
        fromMap.put("elevator",elevator);
        fromMap.put("propertyCompany",propertyCompany);
        fromMap.put("greeningRate",greeningRate);
     System.err.println(type);
        try {
            if(type.equals("1")){

                projectShopsService.addAgentProjects(fromMap);
                rr = new Result<Void>(1, "成功", "success");
            }else  if (type.equals("2")){
                projectApartmentService.addAgentProjects(fromMap);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("3")){
                projectOfficeService.addAgentProjects(fromMap);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("4")){

                projectHomeService.addAgentProjects(fromMap);
                rr = new Result<Void>(1, "成功", "success");
            }


        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "添加失败");

        }
        return rr;

    }

    /**
     * 修改项目
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("editProject")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    public Result<Void> editProject(HttpServletRequest request, HttpServletResponse response,String projectName, String province, String city, String  district, String  projectPosition, String type, String lease, String state, String projectType, String developers
            , String storeyHeight, String propertyCost, String utilities, String renovation, String areas, String areae, String  prices, String   pricee, String pricess, String pricese, String commission
            , String startDate, String floorArea, String coveredArea, String commercialArea, String business, String description, String feature, String userId, String latitude,String propertyCompany,String elevator,String greeningRate) {
        Result<Void> rr = null;
        response.setHeader("Access-Control-Allow-Origin", "*");
        HashMap fromMap=new HashMap();
        fromMap.put("projectName",projectName);
        fromMap.put("province",province);
        fromMap.put("city",city);
        fromMap.put("district",district);
        fromMap.put("projectPosition",projectPosition);
        fromMap.put("lease",lease);
        fromMap.put("state",state);
        fromMap.put("projectType",projectType);
        fromMap.put("developers",developers);
        fromMap.put("storeyHeight",storeyHeight);
        fromMap.put("propertyCost",propertyCost);
        fromMap.put("utilities",utilities);
        fromMap.put("renovation",renovation);
        fromMap.put("areas",areas);
        fromMap.put("areae",areae);
        fromMap.put("prices",prices);
        fromMap.put("pricee",pricee);
        fromMap.put("pricess",pricess);
        fromMap.put("pricese",pricese);
        fromMap.put("commission",commission);
        fromMap.put("createDate",new Date());
        fromMap.put("startDate",startDate);
        fromMap.put("floorArea",floorArea);
        fromMap.put("coveredArea",coveredArea);
        fromMap.put("commercialArea",commercialArea);
        fromMap.put("business",business);
        fromMap.put("description",description);
        fromMap.put("feature",feature);
        fromMap.put("userId",userId);
        fromMap.put("latitude",latitude);
        fromMap.put("type",type);
        fromMap.put("elevator",elevator);
        fromMap.put("propertyCompany",propertyCompany);
        fromMap.put("greeningRate",greeningRate);
        try {
            if(type.equals("1")){

                projectShopsService.editAgentProject(fromMap);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("2")){

                projectApartmentService.editAgentProject(fromMap);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("3")){

                projectOfficeService.editAgentProject(fromMap);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("4")){

                projectHomeService.editAgentProject(fromMap);
                rr = new Result<Void>(1, "成功", "success");
            }
        }  catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "修改失败");

        }
        return rr;

    }

    /**
     * 删除项目
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("deleteProject")
    @Transactional(readOnly = false) // 需要事务操作必须加入此注解
    public  Result<Void>  deleteEntity( String id,String type) throws Exception {
        Result<Void> rr = null;
        try {
            if(type.equals("1")){
            projectShopsService.deleteAgentEntity(id);
                rr = new Result<Void>(1, "成功", "success");
            }else  if (type.equals("2")){
                projectApartmentService.deleteAgentEntity(id);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("3")){

                projectOfficeService.deleteAgentEntity(id);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("4")){
                projectHomeService.deleteAgentEntity(id);
                rr = new Result<Void>(1, "成功", "success");
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "删除失败");

        }
        return rr;

    }
    /**
     * 添加图片
     * @param pictureFile
     * @param proId
     * @param type
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "addImg")
    public  Result<Void> addImg(@RequestParam(value = "pictureFile", required = false) MultipartFile[] pictureFile, String proId,String type,
                         HttpServletRequest request) throws Exception {
        System.err.println("添加图片");
        Result<Void> rr = null;
        try {
        if (type!=null){
        HashMap imgForMap = new HashMap();
        imgForMap.put("proId", proId);
        imgForMap.put("createDate", new Date());
        //定义序号
        for (MultipartFile file : pictureFile) {
            if (!file.isEmpty()) {
                // 使用UUID给图片重命名，并去掉四个“-”
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                // 获取文件的扩展名
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                // 设置图片上传路径
                String url = request.getSession().getServletContext().getRealPath("/img/agengt_project/"+type+"/");
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
                if (type.equals("shops")){
                    projectShopsService.addAgentImg(imgForMap);
                }else  if (type.equals("apartment")){
                    projectApartmentService.addAgentImg(imgForMap);
                }else  if (type.equals("office")){
                    projectOfficeService.addAgentImg(imgForMap);
                }else  if (type.equals("home")){
                    projectHomeService.addAgentImg(imgForMap);
                }


            }

        }
            rr = new Result<Void>(1, "成功","success");
}

        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;

    }

    /**
     * 查找图片
     * @param proId
     * @param type
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findImg")
    public  Result<Void>  findImg(String proId, String type) throws Exception {
        Result<Void> rr = null;
        try {
        HashMap searchImg = new HashMap();
        searchImg.put("proId", proId);
            if(type.equals("1")){
                List<ProjectShopsFormMap> listImg = projectShopsService.findAgentImg(searchImg);
                rr = new Result<Void>(1, "成功",listImg);
            }else  if (type.equals("2")){
                List<ProjectApartmentFormMap> listImg = projectApartmentService.findAgentImg(searchImg);
                rr = new Result<Void>(1, "成功",listImg);
            }else  if (type.equals("3")){
                List<ProjectOfficeFormMap> listImg = projectOfficeService.findAgentImg(searchImg);
                rr = new Result<Void>(1, "成功",listImg);
            }else  if (type.equals("4")){
                List<ProjectHomeFormMap> listImg = projectHomeService.findAgentImg(searchImg);
                rr = new Result<Void>(1, "成功",listImg);
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;

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
    public  Result<Void> deleteImg(String id,String type) throws Exception {
        Result<Void> rr = null;
        try {
            if(type.equals("1")){
                projectShopsService.deleteAgentImg(id);
                rr = new Result<Void>(1, "成功", "success");
            }else  if (type.equals("2")){
                projectApartmentService.deleteAgentImg(id);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("3")){

                projectOfficeService.deleteAgentImg(id);
                rr = new Result<Void>(1, "成功","success");
            }else  if (type.equals("4")){
                projectHomeService.deleteAgentImg(id);
                rr = new Result<Void>(1, "成功", "success");
            }
        } catch (RuntimeException e) {
            rr = new Result<Void>(0, e.getMessage(), "");

        }
        return rr;

    }


}









