package com.tzj.sanguo.appium.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by clint on 2017/12/31.
 */
@Repository
public class JdbcDao {

    @Resource
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate secondaryJdbcTemplate;

    @Resource
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    public List getUserInfo(){
         return    secondaryJdbcTemplate.queryForList("select * from user_info");
    }

    public List getVersion(){
        return primaryJdbcTemplate.queryForList("select * from version");
    }
}
