package com.tzj.sanguo.appium.android;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by mingcl on 2017/12/21.
 */
public class AppiumServer {
    Logger log = LoggerFactory.getLogger(AppiumServer.class);

    public AppiumServer(){
        KillTask("node.exe");
        log.info("init appium server...");
    }

    public void KillTask(String taskname){
        String Command = "taskkill /F /im " + taskname;
        log.info("kill " + taskname + " task ...");
        runCommand(Command);
    }

    public void runServer(int port,String udid) {
        log.info("run " + udid + " Appium Server in port " + port + "...");
        int bpport = port +1;
        int chromeport = port + 4792;
        //多设备server端需要手动指定每台设备的udid,安卓无线连接下就是设备的ip:port..
        String Command = "appium.cmd -p " + port + " -bp " + bpport + " --session-override --chromedriver-port "+ chromeport +" -U "
                + udid +  " >c://" + port + ".txt";
        log.info(Command);
        runCommand(Command);
    }

    private void runCommand(String command){
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
