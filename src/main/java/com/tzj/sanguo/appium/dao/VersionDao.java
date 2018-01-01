//package com.tzj.sanguo.appium.dao;
//
//import com.tzj.sanguo.appium.model.Version;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//
//import static javafx.scene.input.KeyCode.T;
//
///**
// * Created by clint on 2017/12/16.
// */
//@Repository
//@Transactional
//public interface VersionDao extends JpaRepository<Version, Integer> {
//
//
//    public Version findById(int id);
//
//    @Query(value="select v.* from version v where v.name=?1 ", nativeQuery = true)
//    public Version findByName(String name);
//
//    @Query(value="select v.id from version v where v.name=?1 ", nativeQuery = true)
//    public int queryCustomByName(String name);
//
//    /*
//    分页查询
//     */
//    public Page findAll(Pageable pageable);
//
//}
