package com.tzj.sanguo.appium.dao;

import com.tzj.sanguo.appium.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by clint on 2017/12/16.
 */
@Repository
@Transactional
public interface VersionDao extends JpaRepository<Version, Integer> {

}
