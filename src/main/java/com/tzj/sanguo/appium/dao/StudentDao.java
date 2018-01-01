//package com.tzj.sanguo.appium.dao;
//
//import com.tzj.sanguo.appium.model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//
///**
// * Created by clint on 2017/12/29.
// */
//@Repository
//public interface StudentDao extends JpaRepository<Student, Integer>{
//
//    @Autowired
//    EntityManager em =  null;
//
//    @Query(value = "?1", nativeQuery = true)
//    public String queryVersion(String sql);
//
//
//}
