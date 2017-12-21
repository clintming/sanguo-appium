package com.tzj.sanguo.appium.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by clint on 2017/12/17.
 */
@Component
public class AppInstallation{

    public void setUp(String appPath, String appiumServerUrl, String udid) throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("device","android simulator");
//        desiredCapabilities.setCapability("app","/debt-debug.apk");
//        URL url = new URL("http://127.0.0.1:4723/wd/hub");
//        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url,desiredCapabilities);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium-version","1.5.3");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("platformVersion","5.0");
        desiredCapabilities.setCapability("deviceName",udid);
        desiredCapabilities.setCapability("udid",udid);
        desiredCapabilities.setCapability("app",appPath);
        AppiumDriver appiumDriver = new AppiumDriver(new URL(appiumServerUrl),desiredCapabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
}
