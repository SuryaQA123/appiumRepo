package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssignMent {
    public static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.t-mobile.com/tablets");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String menu = "Deals";
        WebElement menuButton = driver.findElement(By.xpath("//fieldset[@class='ng-star-inserted' ]//child::legend[text()=' " + menu + " ']"));
        System.out.println(menuButton.getText());

    }

    public static void SeclectFilter(String menu, String otpion1, String otpion2, String option2) {
        WebElement menuButton = driver.findElement(By.xpath("//fieldset[@class='ng-star-inserted' ]//child::legend[text()=' " + menu + " ']"));
        if (menuButton.getText().equalsIgnoreCase(menu)) {
            menuButton.click();
          WebElement option1_menu=  driver.findElement(By.xpath("//mat-checkbox//span[text()=' "+otpion1+" ']"));
          if(option1_menu.getText().equalsIgnoreCase(otpion1)){
              option1_menu.click();
          } else if (option1_menu.getText().equalsIgnoreCase(option2)) {

          }

        }


    }
}
