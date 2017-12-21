package com.tzj.sanguo.appium.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by clint on 2017/12/18.
 */
public class Driver {

    AppiumDriver driver = null;
    public Driver(URL url, DesiredCapabilities desiredCapabilities){
        driver = new AppiumDriver(url, desiredCapabilities);
    }

}
