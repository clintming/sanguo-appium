package com.tzj.sanguo.appium.controller;

import com.tzj.sanguo.appium.android.AppInstallation;
import com.tzj.sanguo.appium.dao.JdbcDao;
//import com.tzj.sanguo.appium.dao.StudentDao;
//import com.tzj.sanguo.appium.model.Version;
//import com.tzj.sanguo.appium.dao.VersionDao;
//import com.tzj.sanguo.appium.service.CompareService;
//import com.tzj.sanguo.appium.service.CompatibilityService;
//import com.tzj.sanguo.appium.service.VersionService;
import com.tzj.sanguo.appium.service.CompareService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
//import javax.persistence.EntityManager;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by clint on 2017/12/16.
 */
@Controller
@RequestMapping("/")
public class CompatibilityController {
    private Logger logger = LoggerFactory.getLogger(CompatibilityController.class);

//
//    @Resource
//    VersionDao versionDao;
//
//    @Autowired
//    CompatibilityService compatibilityService;
//
//    @Autowired
//    AppInstallation installApp;
//
//    @Autowired
//    StudentDao studentDao;
//
//    @Autowired
//    EntityManager em = null;
//
//
//    @Autowired
//    VersionService versionService;
//
    @Autowired
    CompareService compareService;
//
//    @RequestMapping("/getAppFile")
//    @ResponseBody
//    public String getAppFile(){
//        String sql = "select * from version";
//        List<Map<String, Object>> lists = jdbcTemplate.queryForList(sql);
//        for(Map<String,Object> map: lists){
//            Set<Map.Entry<String,Object>> entries = map.entrySet();
//            if(entries != null){
//                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
//                while(iterator.hasNext()){
//                    Map.Entry<String, Object> entry = iterator.next();
//                    Object key = entry.getKey();
//                    Object value = entry.getValue();
//                    System.out.println(key+":"+value);
//                }
//            }
//        }
//        return lists.toString();
//    }
//
//    @RequestMapping("/getApp")
//    @ResponseBody
//    public Long getApp(){
//
//        Long sum = versionDao.count();
//        return sum;
//    }
//    @RequestMapping("/getVersion")
//    @ResponseBody
//    public List getVersion(){
//        List<Version> list = versionDao.findAll();
//        for(Version v: list){
//            System.out.println(v.toString());
//        }
//        return list;
//    }
//
//    @GetMapping("/findById")
//    @ResponseBody
//    public Version findById(int id){
//        return versionDao.findById(id);
//    }
//
//    @GetMapping("/getVersionByName")
//    @ResponseBody
//    public Version getVesionByName(String name){
//        return versionDao.findByName(name);
//    }
//
//    @GetMapping("/findIdByName")
//    @ResponseBody
//    public int findIdByName(String name){
//        return versionDao.queryCustomByName(name);
//    }
//
//    @GetMapping("/index")
//    public String getIndex(){
//        return "index";
//    }
//
//    @RequestMapping("/file")
//    public String getFile(){
//        return "file";
//    }
//
//    @PostMapping("/uploadOneApp")
//    @ResponseBody
//    public String uploadOneFile(@RequestParam("fileName") MultipartFile file){
//
//        return compatibilityService.saveUploadFile(file);
//
//    }
//
//    @GetMapping("/install")
//    @ResponseBody
//    public String installApp() throws MalformedURLException {
//
//        //installApp.setUp("");
//        return "运行完成";
//    }
//    //分页查询
//    @GetMapping("/findByPage")
//    @ResponseBody
//    public Page findByPage(int page, int size){
//        return versionService.findAll(page, size);
//    }
//
////    //自定义sql， 实现sql自定义配置
////    @GetMapping("/getByTable")
////    @ResponseBody
////    public List findBySql(){
////        return versionService.findAll("Version","name", "test");
////    }
//
//    @GetMapping("/findByTable")
//    @ResponseBody
//    public void findByTable(){
//
//        compareService.findByTable("Version", "id");
//    }

    @Autowired
    JdbcDao jdbcDao;

    @GetMapping("/getUserInfo")
    @ResponseBody
    public List getUserInfo(){

       return jdbcDao.getUserInfo();
    }

    @GetMapping("/getAllVersion")
    @ResponseBody
    public List getAllVersion(){

        return jdbcDao.getVersion();
    }

    @GetMapping("/compareTwoTables")
    @ResponseBody
    public List<Object> mysqlJava(){
        String url = "jdbc:mysql://localhost:3306/sanguo_appium";
        String username = "root";
        String password = "root";
        String unique = "id";
        String tableName = "version";

        return compareService.mysqlJava(url, tableName, username, password,
                url, "Student",username,password,unique);
    }

}
