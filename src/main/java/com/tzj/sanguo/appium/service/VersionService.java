//package com.tzj.sanguo.appium.service;
//
//import com.tzj.sanguo.appium.dao.BaseDao;
//import com.tzj.sanguo.appium.dao.VersionDao;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * Created by clint on 2017/12/31.
// */
//@Service
//public class VersionService {
//
//    @Resource
//    VersionDao versionDao;
//
//    @Resource
//    BaseDao baseDao;
//
//    public Page findAll(int page, int size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = new PageRequest(page, size, sort);
//        return versionDao.findAll(pageable);
//    }
//}
//
