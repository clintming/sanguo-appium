//package com.tzj.sanguo.appium.service;
//
//import com.tzj.sanguo.appium.controller.CompatibilityController;
//import com.tzj.sanguo.appium.dao.VersionDao;
//import com.tzj.sanguo.appium.model.Version;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.io.IOException;
//
///**
// * Created by clint on 2017/12/17.
// */
//@Service
//public class CompatibilityService {
//
//    @Resource
//    private VersionDao versionDao;
//
//    private Logger logger = LoggerFactory.getLogger(CompatibilityController.class);
//    private String projectPath = System.getProperty("user.dir") + "/uploadFile/";
//    /*
//    处理上传文件并保存在服务器上
//     */
//    public String saveUploadFile(MultipartFile file) {
//        Version version = new Version();
//
//        if (!file.isEmpty()) {
//            String fileName = file.getOriginalFilename();
//            File fileInServer = new File(projectPath + fileName);
//            if (!fileInServer.getParentFile().exists()) {
//                fileInServer.getParentFile().mkdir();
//            }
//            try {
//                file.transferTo(fileInServer);
//                version.setName("android");
//                version.setPath(projectPath+fileName);
//                versionDao.save(version);
//                logger.info("保存文件{}成功", fileName);
//                return "保存文件"+fileName+"成功";
//            } catch (IOException e) {
//                String errorMsg = "在服务器上保存文件时失败，原因为：" + e.getMessage();
//                logger.error(errorMsg);
//                return errorMsg;
//            }
//
//        } else {
//            String msg = "上传的文件为空";
//            logger.info(msg);
//            return msg;
//        }
//    }
//
//
//
//}
