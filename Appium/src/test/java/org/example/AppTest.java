package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;


public class AppTest {
    AppiumDriverLocalService service;

    @Test
    public void shouldAnswerWithTrue() throws Exception {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Devendragoude//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
//        Map<String, String> environmentVariables = new HashMap<>();
//        environmentVariables.put("ANDROID_HOME", "C://Users//Devendragoude//AppData//Local//Android//Sdk");
//        environmentVariables.put("JAVA_HOME", "C://Program Files//Java//jdk-17");
//        AppiumDriverLocalService serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Devendragoude//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(environmentVariables).build();
//        serviceBuilder.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("devendra");
        options.setApp("C://Users//Devendragoude//eclipse-workspace//new//AppiumProject//apps//ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//        driver.quit();
        service.stop();
    }

//    @Test
    public void startServer() {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Devendragoude//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

    }

}


