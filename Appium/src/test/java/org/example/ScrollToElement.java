package org.example;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollToElement  extends  Base
{
    @Test
    public  void ScrollTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollTo_ElementView("WebView");
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));

    }
}
