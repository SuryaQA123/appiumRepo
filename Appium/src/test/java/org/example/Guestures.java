package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ExecutesDriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guestures  extends  Base{
    @Test
    public  void longPress() throws InterruptedException {
       driver.findElement(AppiumBy.accessibilityId("Views")).click();
       driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
       driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPress_action(element);
    String    menuText= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
        Assert.assertEquals(menuText,"Sample menu");

 boolean  sampleStatus=     driver.findElement(By.id("android:id/title")).isDisplayed();
     Assert.assertTrue(sampleStatus);
        System.out.println(sampleStatus);
     Thread.sleep(2000);

    }

}
