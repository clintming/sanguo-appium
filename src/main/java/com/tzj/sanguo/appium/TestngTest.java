package com.tzj.sanguo.appium;

import org.testng.annotations.*;
import org.testng.annotations.Test;

/**
 * Created by mingcl on 2017/12/18.
 */
public class TestngTest {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("run before suit");
    }

    @BeforeTest
    public void setup(){
        System.out.println("run setup");
    }

    @Test
    public void testCase1(){
        System.out.println("run testCase1");
    }
    @Test
    public void testCase2(){
        System.out.println("run testCase2");
    }

    @AfterTest
    public void tearDown(){
        System.out.println("run tearDown...");
    }
}
