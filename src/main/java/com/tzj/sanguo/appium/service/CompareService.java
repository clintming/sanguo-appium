package com.tzj.sanguo.appium.service;

import com.tzj.sanguo.appium.common.MysqlUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//
//import com.tzj.sanguo.appium.dao.BaseDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by clint on 2017/12/31.
// */
@Service
public class CompareService {

        private Logger logger = LoggerFactory.getLogger(CompareService.class);

    private Error e;
    private Error error;

    //    @Autowired
//    BaseDao baseDao;
//
//    public List findBySql(String tableName, String field, Object o){
//        return baseDao.findBySql(tableName, field, o);
//    }
//
//    public void findByTable(String tableName, String uniqueField){
//        baseDao.findByTable(tableName, uniqueField);
//    }
public List<Object> mysqlJava(String url, String tableName, String dbUsername, String dbPassword,
                              String secondDbUrl, String secondDbTableName, String seconddbUsername, String secondDbPassword, String uniqueField){

    JSONArray jsonArray = MysqlUtils.returnArrayByCusSql(url,tableName, dbUsername,dbPassword);
    JSONObject uniqueJson = MysqlUtils.returnUniqueByCusSql(secondDbUrl,secondDbTableName, seconddbUsername,secondDbPassword,uniqueField);
    return compareTwoJson(jsonArray, uniqueJson, uniqueField);
}

    public List compareTwoJson(JSONArray jsonArray, JSONObject uniqueJson, String uniqueField){
        ArrayList errorsList = new ArrayList();
        for(Object obj: jsonArray){
            JSONObject jsonObject = (JSONObject) obj;
            String uniqueValue = jsonObject.optString(uniqueField);
            if(!uniqueJson.has(uniqueValue)){
                String errorMsg = "比较时发现第二个表不包含："+uniqueField+"="+uniqueValue+"的数据";
                errorsList.add(errorMsg);
                continue;
            }
            JSONObject jsonSecond = uniqueJson.getJSONObject(uniqueValue);
            logger.info("第一个json数据为："+jsonObject.toString());
            logger.info("第二个json数据为："+jsonSecond);
            List<String> firstTableFields = new ArrayList();
            firstTableFields.add("name");
            firstTableFields.add("id");
            List<String> twoTableFields = new ArrayList();
            twoTableFields.add("name");
            twoTableFields.add("id");
            for(int i = 0; i < firstTableFields.size(); i++){
                try {
                    Assert.assertEquals(jsonSecond.get(firstTableFields.get(i)),jsonObject.get(firstTableFields.get(i)));
                }catch (Error e){
                    String msg = "比较对象："+uniqueField+"="+uniqueValue+"时，字段："+firstTableFields.get(i)+"值不相等，原因为："+ e.getMessage();
                    logger.info(msg);
                    errorsList.add(msg);
                }
            }
            continue;
        }
        if(errorsList == null){
            errorsList.add("比较的数据全部相等");
            return errorsList;

        }else {
        return errorsList;
        }
    }
}

