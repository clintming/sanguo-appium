package com.tzj.sanguo.appium.service;

import com.tzj.sanguo.appium.controller.CompatibilityController;
import com.tzj.sanguo.appium.dao.VersionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * Created by clint on 2017/12/17.
 */
@Service
public class CompatibilityService {


    private Logger logger = LoggerFactory.getLogger(CompatibilityController.class);

    public String uploadFile(MultipartFile file){
        if(!file.isEmpty()){
            String name = file.getOriginalFilename();
            int size = (int) file.getSize();
            logger.info("上传文件名为:{},大小为:{}",name,size);
            String path = System.getProperty("user.dir")+"/uploadFile/";
            logger.info("上传路径为：{}",path);
            File fileInServer = new File(path+name);
            if(!fileInServer.getParentFile().exists()){
                fileInServer.getParentFile().mkdir();
            }
            try {
                file.transferTo(fileInServer);
                return "true";
            } catch (IOException e) {
                e.printStackTrace();
                return "false";
            }

        }else {
            logger.info("上传文件为空");
            return "false";
        }

    }
}
