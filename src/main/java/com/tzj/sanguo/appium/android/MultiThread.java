package com.tzj.sanguo.appium.android;

import java.net.MalformedURLException;

/**
 * Created by mingcl on 2017/12/21.
 */
public class MultiThread extends Thread{
    AppInstallation appInstallation = new AppInstallation();
    private String appPath;
    private String appiumServerUrl;
    private  String udid;
    public MultiThread(String appPath, String appiumServerUrl, String udid) {
        this.appPath = appPath;
        this.appiumServerUrl = appiumServerUrl;
        this.udid = udid;
    }

    @Override
    public void run() {
        runMethod(appPath,appiumServerUrl,udid);
    }

    public void runMethod(String appPath, String appiumServerUrl, String udid){
        try {
            appInstallation.setUp(appPath,appiumServerUrl,udid);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
