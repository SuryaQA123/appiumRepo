package General_Stroe_TestCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base_ECom {
    AppiumDriverLocalService service;
    AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws Exception {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Devendragoude//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("devendra");
//        options.setDeviceName("eed31076");
        options.setApp("C://Users///Devendragoude//Desktop//AppiumSetup//General-Store.apk");
        options.setCapability("autoGrantPermissions", true);

//        options.setChromedriverExecutable("C://Users//Devendragoude//Desktop//New folder//chromedriver.exe");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public Double getPriceValue(String str) {
        double sum = 0;

        Double d1 = Double.parseDouble(str);
        sum = d1 + sum;

        return sum;
    }

    @AfterClass
    public void closeAppium() throws Exception {
        driver.quit();
        service.stop();

    }
}
