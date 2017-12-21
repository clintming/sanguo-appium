package com.tzj.sanguo.appium;

import com.tzj.sanguo.appium.android.AppInstallation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 * Created by clint on 2017/12/16.
 */
public class Test {

    public static void main(String[] args) throws MalformedURLException {
        runAndroidApp();

    }

    public static void runAndroidApp() throws MalformedURLException {
        String appPath = System.getProperty("user.dir")+"/apps/debt-debug.apk";
        String serverUrl = "http://127.0.0.1:4725/wd/hub";
        String uuid = "emulator-5554";
        AppInstallation installApp = new AppInstallation();
        installApp.setUp(appPath, serverUrl,uuid);
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
