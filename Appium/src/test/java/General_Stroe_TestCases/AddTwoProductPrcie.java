package General_Stroe_TestCases;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AddTwoProductPrcie extends Base_ECom {
    public static WebDriverWait wait;

    @Test
    public void product_price() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Devendra");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"));"));
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        Thread.sleep(4000);
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(4000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartId = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        wait.until(ExpectedConditions.attributeContains(cartId, "text", "Cart"));
        List<WebElement> productsPrice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        double sum = 0;

        for (WebElement product : productsPrice) {
            String priceText = product.getText().replace("$", ""); // Remove any currency symbols
            double priceValue = Double.parseDouble(priceText);
            sum += priceValue;
        }
        Thread.sleep(3000);
        String totalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        String sub = totalPrice.substring(1);
        double d1 = getPriceValue(sub);
        Assert.assertEquals(sum, d1);
        System.out.println(sum);
        System.out.println(d1);
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(10000);

       Set<String> context= driver.getContextHandles();
       for(String Context: context){
           System.out.println(Context);
       }
        Thread.sleep(20000);
       //opening the browser in mobile code to switching from native to webview
        //add the options .setchromeExecutables
       driver.context("WEBVIEW_com.androidsample.generalstore");
       driver.findElement(By.name("q")).sendKeys("Devendra Goud");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //switch back to Native app
        driver.context("NATIVE_APP");


    }

}
