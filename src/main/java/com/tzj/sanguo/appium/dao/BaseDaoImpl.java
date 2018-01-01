//package com.tzj.sanguo.appium.dao;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//import java.io.Serializable;
//import java.util.List;
//
///**
// * Created by clint on 2017/12/31.
// */
//@Repository
//public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID>{
//
//    Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Transactional
//    @Override
//    public List findBySql(String tableName, String field, Object o) {
//        String sql = "select v from "+tableName+ " v where v."+field +"=?";
//        Query query = entityManager.createQuery(sql);
//        query.setParameter(1,o);
//        logger.info("执行的sql为:"+sql);
//        entityManager.close();
//        return query.getResultList();
//    }
//
//    @Transactional
//    @Override
//    public JSONArray findByTable(String tableName, String uniqueField) {
//
//        String sql = "select tt from "+tableName+" tt";
//        Query query = entityManager.createQuery(sql);
//        List list = query.getResultList();
//        JSONArray jsonArray = new JSONArray();
//        for(Object obj: list){
//
//            JSONObject jsonObject = new JSONObject(obj);
//            logger.info("查询到的数据为："+jsonObject);
//            Object uniqueFieldData =  jsonObject.opt(uniqueField);
//
//            JSONObject json = new JSONObject();
//            json.put(uniqueFieldData.toString(),jsonObject);
//            logger.info("反向获取id："+ json.getJSONObject(uniqueFieldData.toString()).get("name"));
//            jsonArray.put(json);
//
//
////            String str = new Gson().toJson(obj);
////            JsonElement uniqueFieldData = new Gson().fromJson(str, JsonObject.class).get(uniqueField);
////            JsonObject jsonObject = new JsonObject();
////            jsonObject.addProperty(uniqueFieldData.getAsString(),str);
////            logger.info("查询到的数据为："+jsonObject);
////            logger.info("反向获取对象："+jsonObject.getAsJsonObject("2"));
////            logger.info("反向获取id："+jsonObject.getAsJsonObject("2").get("name"));
//        }
//        return jsonArray;
//    }
//}
