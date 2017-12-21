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
public class AppInstallation {

    public void setUp(String appPath, String serverUrl, String uuid) throws MalformedURLException {
//
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("appium-version","1.5.3");
//        desiredCapabilities.setCapability("platformName","android");
//        desiredCapabilities.setCapability("platformVersion","5.0");
//        desiredCapabilities.setCapability("deviceName","emulator-5554");
//        desiredCapabilities.setCapability("app",appPath);
//        AppiumDriver appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
//        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium-version","1.5.3");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("platformVersion","5.0");
        desiredCapabilities.setCapability("deviceName",uuid);
        desiredCapabilities.setCapability("udid",uuid);
        desiredCapabilities.setCapability("app",appPath);
        AppiumDriver appiumDriver = new AppiumDriver(new URL(serverUrl),desiredCapabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //appium -a 127.0.0.1 -p 4725 -bp 4728 --session-override -U emulator-5556
        //http://blog.csdn.net/a_little_smallsharp/article/details/77338272

    }
}
