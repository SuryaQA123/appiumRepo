package org.example;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends Base {
    @Test
    public void swipeTOLeft() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
        WebElement first_Image = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(first_Image.getAttribute("focusable"), "true");
        SwipeAction(first_Image, "left");
        Assert.assertEquals(first_Image.getAttribute("focusable"), "false");

        // Java
//        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "elementId",((RemoteWebElement)first_Image).getId(),
//                "direction", "left",
//                "percent", 0.75
//        ));

    }
    public void roation(){
        DeviceRotation rotation = new DeviceRotation(0, 0, 90);
        driver.rotate(rotation);
        // copy the
        driver.setClipboardText("Devendra ");
        driver.getClipboardText();
    }


}


