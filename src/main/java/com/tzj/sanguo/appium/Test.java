package com.tzj.sanguo.appium;


import com.tzj.sanguo.appium.android.AppInstallation;
import com.tzj.sanguo.appium.android.MultiThread;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by clint on 2017/12/16.
 */
public class Test {

    AppiumDriver appiumDriver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //runAndroidApp();

        String appPath = System.getProperty("user.dir")+"/apps/debt-debug.apk";
        String appiumServerUrl = "http://127.0.0.1:4723/wd/hub";
        String udid1 = "127.0.0.1:62001";

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium-version","1.5.3");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("platformVersion","5.0");

        desiredCapabilities.setCapability("deviceName",udid1);
        //desiredCapabilities.setCapability("udid",udid1);
        desiredCapabilities.setCapability("app",appPath);
        AppiumDriver appiumDriver = new AppiumDriver(new URL(appiumServerUrl),desiredCapabilities);
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
       // WebElement element = appiumDriver.findElementById("com.tzj.wallet.debug:id/enter_home_btn");
        appiumDriver.findElement(By.id("com.tzj.wallet.debug:id/banner_indicatorId")).click();
//        appiumDriver.findElementByLinkText("立即体验").click();

        System.out.println(dimension);

    }
    public static void runAndroidApp() throws MalformedURLException {
        String appPath = System.getProperty("user.dir")+"/apps/debt-debug.apk";
        String appiumServerUrl = "http://127.0.0.1:4023/wd/hub";
        String appiumServerUr2 = "http://127.0.0.1:4025/wd/hub";
        String udid1 = "127.0.0.1:62001";
        String udid2 = "emulator-5556";
        AppInstallation installApp = new AppInstallation();
        MultiThread multiThread = new MultiThread(appPath,appiumServerUrl,udid1);
        //MultiThread multiThread2 = new MultiThread(appPath,appiumServerUr2,udid2);
        multiThread.start();
        //multiThread2.start();
    }

    public static void runPythonScript(){
        try {
//            Process process = Runtime.getRuntime().exec("python3 /Users/clint/IdeaProjects/sangouappium/src/main/java/com/tzj/sanguo/Test.py");
            String [] params = new String[]{"python3","/Users/clint/IdeaProjects/ScheduleTimer/Test.py","8","8"};
//            Process process = Runtime.getRuntime().exec("python3 /Users/clint/IdeaProjects/ScheduleTimer/Test.py 5 8");
            Process process = Runtime.getRuntime().exec(params);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
            process.waitFor();
            System.out.println("finish");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
