package com.tzj.sanguo.appium.android.tzjqianbao.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;

/**
 * Created by clint on 2017/12/23.
 */
public class Welcome {

    private AppiumDriver driver;

    public Welcome(AppiumDriver driver){
        this.driver = driver;
    }

    public void goToHomePage(){
        Dimension dimension = driver.manage().window().getSize();
        System.out.println(dimension);

        //driver.findElement(By.id("com.tzj.wallet.debug:id/register_bonus_close_iv")).click();
    }
}
