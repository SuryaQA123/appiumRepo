package org.example;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class WifitestCase extends  Base {
  public static   AppiumDriverLocalService service;
@Test
    public  void enable_WifiSettings(){
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Devendra");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.findElement(By.id("android:id/button1")).click();

        System.out.println("Completed");

    }


}
