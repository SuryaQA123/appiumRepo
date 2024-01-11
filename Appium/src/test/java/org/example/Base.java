package org.example;


import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
    AppiumDriverLocalService service;
    AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws Exception {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Devendragoude//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("devendra");
        options.setApp("C://Users//Devendragoude//eclipse-workspace//new//AppiumProject//apps//ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeAppium() throws Exception {
        driver.quit();
        service.stop();

    }
    public  void longPress_action(WebElement element){

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
                ,"duration" ,2000 ));
    }

    public  void scrollTo_ElementView(String str){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+str+"\"));"));
    }
    public  void SwipeAction(WebElement el,String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)el).getId(),
                "direction", direction,
                "percent", 0.75
        ));
}
}
