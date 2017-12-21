package com.tzj.sanguo.appium;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by clint on 2017/12/18.
 */
public class TestNgTest {

    @BeforeTest
    public void setUp(){
        System.out.println("running setup ...");
    }

    @Test
    public void testCase1(){
        System.out.println("running testcase 1 ...");
        Assert.assertEquals("1","1");
    }

    @Test
    public void testCase2(){
        System.out.println("running testcase 2 ...");
        Assert.assertEquals("1","2");
    }

    @AfterTest
    public void tearDown(){
        System.out.println("running teardown ...");
    }

}
