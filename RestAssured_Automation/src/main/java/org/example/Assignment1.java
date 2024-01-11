package org.example;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment1 {
    public static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.t-mobile.com/tablets");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Example: Selecting filters for brands and operating systems
        SelectFilter("Brands", "Apple", "Samsung", "Tcl");
        SelectFilter("Operating System", "iPadOs");
    }

    public static void SelectFilter(String menu, String... options) {
        WebElement menuButton = driver.findElement(By.xpath("//fieldset[@class='ng-star-inserted']//child::legend[text()=' " + menu + " ']"));

        if (menuButton.getText().equalsIgnoreCase(menu)) {
            menuButton.click();

            for (String option : options) {
                WebElement option_menu = driver.findElement(By.xpath("//mat-checkbox//span[text()=' " + option + " ']"));

                if (option_menu.getText().equalsIgnoreCase(option)) {
                    option_menu.click();
                }
            }
        }
    }
}

