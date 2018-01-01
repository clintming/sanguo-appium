package com.tzj.sanguo.appium.common;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by clint on 2018/1/1.
 */
public class MysqlUtils {

    private static Logger logger = LoggerFactory.getLogger(MysqlUtils.class);

    public static JSONArray returnArrayByCusSql(String url, String tableName, String username, String password){

        /*
        java连接数据库步骤：
        1、加载数据库驱动
        2、由DriverManager获取数据库连接
        3、得到一个statement
        4、执行sql语句
        5、处理结果
        6、关闭连接
         */
        String sql = "select * from "+tableName;
        Connection conn =  null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()){
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                JSONObject jsonObject = new JSONObject();
                JSONObject uniqueJson = new JSONObject();
                for(int i = 1; i < resultSetMetaData.getColumnCount(); i++){
                    String columnName = resultSetMetaData.getColumnName(i);
                    if(resultSet.getObject(columnName) == null){
                        jsonObject.put(columnName, "");
                    }else {
                        jsonObject.put(columnName, resultSet.getObject(columnName));
                    }
                }
                //uniqueJson.put(jsonObject.optString(uniqueField),jsonObject);
                jsonArray.put(jsonObject);
                logger.info("把结果组装为jsonarray后为：{}",jsonArray.toString());
            }
            return jsonArray;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public static JSONObject returnUniqueByCusSql(String url, String tableName, String username, String password, String uniqueField){

        /*
        java连接数据库步骤：
        1、加载数据库驱动
        2、由DriverManager获取数据库连接
        3、得到一个statement
        4、执行sql语句
        5、处理结果
        6、关闭连接
         */
        String sql = "select * from "+tableName;
        Connection conn =  null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            JSONArray jsonArray = new JSONArray();
            JSONObject uniqueJson = new JSONObject();
            while (resultSet.next()){
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                JSONObject jsonObject = new JSONObject();
                for(int i = 1; i < resultSetMetaData.getColumnCount(); i++){
                    String columnName = resultSetMetaData.getColumnName(i);
                    if(resultSet.getObject(columnName) == null){
                        jsonObject.put(columnName, "");
                    }else {
                        jsonObject.put(columnName, resultSet.getObject(columnName));
                    }
                }
                uniqueJson.put(jsonObject.optString(uniqueField),jsonObject);
                jsonArray.put(jsonObject);
                logger.info("把结果组装为jsonarray后为：{}",jsonArray.toString());
            }
            return uniqueJson;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
