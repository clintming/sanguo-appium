package com.tzj.sanguo.appium.dao;

import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by clint on 2017/12/31.
 */
public interface BaseDao<T, ID extends Serializable>{

    List findBySql(String tableName, String field, Object o);

    JSONArray findByTable(String tableName, String uniqueField);

}
