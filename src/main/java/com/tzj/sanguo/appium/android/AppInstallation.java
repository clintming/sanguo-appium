package com.tzj.sanguo.appium.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by clint on 2017/12/17.
 */
@Component
public class AppInstallation{

    AppiumDriver appiumDriver;
    public void setUp(String appPath, String appiumServerUrl, String udid) throws MalformedURLException, InterruptedException {
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

        desiredCapabilities.setCapability("deviceName",udid);
//        desiredCapabilities.setCapability("udid",udid);
        desiredCapabilities.setCapability("app",appPath);
        appiumDriver = new AppiumDriver(new URL(appiumServerUrl),desiredCapabilities);
        appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //appium -a 127.0.0.1 -p 4725 -bp 4728 --session-override -U emulator-5556
        //http://blog.csdn.net/a_little_smallsharp/article/details/77338272

        Dimension dimension = appiumDriver.manage().window().getSize();
        int x = dimension.getWidth();
        int y = dimension.getHeight();

        TouchAction touchAction = new TouchAction(appiumDriver);
//        PointOption pointOption = new PointOption();
        Thread.sleep(5000);
//        WebElement imageView = appiumDriver.findElementByXPath
//                ("xpath=(//android.widget.LinearLayout[@resource-id='android.widget.LinearLayout']/android.widget.ImageView" +
//                        "[contains(@index,0)])");
       // WebElement element = appiumDriver.findElementById("com.tzj.wallet.debug:id/banner_indicatorId");
        //System.out.println("---------"+element);
        for(int i=0; i< 3; i++) {
//            touchAction.press(PointOption.point(x * 9 / 10, y / 2)).waitAction().moveTo(PointOption.point(x / 10, y / 2)).release();
            touchAction.press(x * 9 / 10, y / 2).waitAction().moveTo(x / 10, y / 2).release();
            touchAction.perform();
        }
        Thread.sleep(3000);
        appiumDriver.findElementById("com.tzj.wallet.debug:id/enter_home_btn").click();
//        appiumDriver.findElementByLinkText("立即体验").click();

        System.out.println(dimension);


        //driver.findElement(By.id("com.tzj.wallet.debug:id/register_bonus_close_iv")).click();
    }

    public void tearDown(){
        appiumDriver.close();
    }
}
