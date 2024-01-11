package org.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;


public class Assignment extends Base {

    @Test(priority = 0)
    public void assignment() {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
    }

    @Test(priority = 1, dependsOnMethods = "assignment")
    public void AlertHandling() throws InterruptedException {
        WebElement ok_Cancel = driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message"));
        ok_Cancel.click();
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(4000);
        ok_Cancel.click();
        driver.findElement(By.id("android:id/button2")).click();
        System.out.println("alert closed");

    }

    @Test(priority = 3, dependsOnMethods = "AlertHandling")
    public void diologMessageAndCancel() throws InterruptedException {
        WebElement longMessage = driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message"));
        longMessage.click();
        System.out.println("open");
        driver.findElement(By.id("android:id/button1")).click();
//        WebDriverWait wait = new WebDriverWait(driver, z.ofSecconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK Cancel dialog with a long message"))).click();
//        System.out.println("open");
//        driver.findElement(By.id("android:id/button2")).click();
//        System.out.println("closed");
//        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
//        driver.findElement(By.id("android:id/button3")).click();
//        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
    }

    @Test(priority = 4, dependsOnMethods = "diologMessageAndCancel")
    public void ultraLongMessage() {
        WebElement ultraLongMsg = driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message"));
        System.out.println(ultraLongMsg.getText());
        ultraLongMsg.click();
        System.out.println("long1");
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
        System.out.println("long2");
        driver.findElement(By.id("android:id/button2")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
        System.out.println("long3");
        driver.findElement(By.id("android:id/button3")).click();
    }

    @Test(priority = 5, dependsOnMethods = "ultraLongMessage")
    public void listDialog() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement listDialog = driver.findElement(AppiumBy.accessibilityId("List dialog"));
        listDialog.click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Command one']")).click();
        System.out.println(driver.findElement(By.id("android:id/message")).getText());
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Command two']")).click();
        System.out.println(driver.findElement(By.id("android:id/message")).getText());
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Command three']")).click();
        System.out.println(driver.findElement(By.id("android:id/message")).getText());
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Command four']")).click();
        System.out.println(driver.findElement(By.id("android:id/message")).getText());
        driver.navigate().back();


    }

    @Test(priority = 6)
    public void singleChoiceList() {
        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Map']")).click();
        Assert.isTrue(driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Map']")).isEnabled(), "true");
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Traffic']")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();

        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Street view']")).click();
        driver.findElement(By.id("android:id/button1")).click();


//
    }

    @Test(priority = 7)
    public void repeat_Alarm() {
        driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
        driver.findElement(By.xpath("//android.widget.ListView/android.widget.CheckedTextView[@text='Every Saturday']")).click();
        driver.findElement(By.id("android:id/button1")).click();

    }

    @Test(priority = 8, dependsOnMethods = "repeat_Alarm")
    public void textEntry() {
        driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
        driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Devndra Goud");
        driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("123456");
        driver.findElement(By.id("android:id/button1")).click();
        System.out.println("Entered Successfully");
    }
@Test(priority = 9)
    public  void traditionalTheme(){
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
        driver.findElement(By.id("android:id/button1")).click();
    driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
    driver.findElement(By.id("android:id/button2")).click();
    driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with Holo Light theme")).click();
    driver.findElement(By.id("android:id/button2")).click();
    driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with Holo Light theme")).click();
    driver.findElement(By.id("android:id/button1")).click();



}
}
