package Logical_Programmes;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SampleTest {
    public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeClass
    public void setUpAppium() throws Exception {
        // Start Appium server before test execution
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//Devendragoude//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4724);

        service = builder.build();
        service.start();
    }

    @Test
    public void configureAppium() throws Exception {
        // Set desired capabilities for AndroidDriver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "eed31076");
        capabilities.setCapability("app", "C://Users///Devendragoude//Desktop//AppiumSetup//General-Store.apk");
        capabilities.setCapability("autoGrantPermissions", true);

        // Initialize AndroidDriver with Appium server URL and capabilities
        driver = new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        // Quit the AndroidDriver and stop the Appium server after test execution
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
