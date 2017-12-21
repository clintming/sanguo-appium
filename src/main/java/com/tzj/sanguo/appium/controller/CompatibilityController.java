package com.tzj.sanguo.appium.controller;

import com.tzj.sanguo.appium.android.AppInstallation;
import com.tzj.sanguo.appium.model.Version;
import com.tzj.sanguo.appium.dao.VersionDao;
import com.tzj.sanguo.appium.service.CompatibilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.net.MalformedURLException;
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

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Resource
    VersionDao versionDao;

    @Autowired
    CompatibilityService compatibilityService;

    @Autowired
    AppInstallation installApp;

    @GetMapping("/hello")
    @ResponseBody
    String hello(){
        return "Hello world";
    }

    @RequestMapping("/getAppFile")
    @ResponseBody
    public String getAppFile(){
        String sql = "select * from version";
        List<Map<String, Object>> lists = jdbcTemplate.queryForList(sql);
        for(Map<String,Object> map: lists){
            Set<Map.Entry<String,Object>> entries = map.entrySet();
            if(entries != null){
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                while(iterator.hasNext()){
                    Map.Entry<String, Object> entry = iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return lists.toString();
    }

    @RequestMapping("/getApp")
    @ResponseBody
    public Long getApp(){

        Long sum = versionDao.count();
        return sum;
    }
    @RequestMapping("/getVersion")
    @ResponseBody
    public List getVersion(){
        List<Version> list = versionDao.findAll();
        for(Version v: list){
            System.out.println(v.toString());
        }
        return list;
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/file")
    public String getFile(){
        return "file";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String uploadOneFile(@RequestParam("fileName") MultipartFile file){

        return compatibilityService.uploadFile(file);

    }

    @GetMapping("/install")
    @ResponseBody
    public String installApp() throws MalformedURLException {
        //installApp.setUp("");
        return "运行完成";
    }

}
