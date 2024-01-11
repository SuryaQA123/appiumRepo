package org.example;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.Test;

import java.io.File;

public class d {
    @Test
    public void startAppiumServer(int portNumber) {
        AppiumDriverLocalService localService;
        AppiumServiceBuilder builder = new AppiumServiceBuilder().usingPort(portNumber).
                withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/").withArgument(GeneralServerFlag.RELAXED_SECURITY).
                withArgument(GeneralServerFlag.USE_DRIVERS, "uiautomator2").withLogFile(new File("./appium.log"));
        localService = AppiumDriverLocalService.buildService(builder);
        localService.start();
        localService.getUrl().toString().replace("/wd/hub/", "");
        System.out.println("Appium server has been started successfully with port number " + portNumber);


    }
}
