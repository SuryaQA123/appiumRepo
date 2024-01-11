package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class Assignment_Test {
    public static WebDriver driver;
    public static Actions action;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.t-mobile.com/tablets");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
        action = new Actions(driver);
        SelectFilter("Brands", "Apple", "Samsung", "TCL");
        SelectFilter("Operating System", "iPadOS");
        SelectFilter("Brands", "All");
        System.out.println("Test Completed");
        driver.quit();
    }

    public static void SelectFilter(String menu, String... options) {
        WebElement menuButton = driver.findElement(By.xpath("//fieldset[@class='ng-star-inserted']//child::legend[text()=' " + menu + " ']"));

        if (menuButton.getText().equalsIgnoreCase(menu)) {
            menuButton.click();

            if (options.length == 1 && options[0].equalsIgnoreCase("All")) {
                List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@aria-label='Brands']//mat-checkbox[contains(@id, 'mat-checkbox-')]//*[@type='checkbox']"));
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(60, 500);");
                for (int i = 0; i < checkboxes.size(); i++) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    action.moveToElement(checkboxes.get(i)).click().perform();
                    System.out.println(checkboxes.get(i).isSelected());
                }
            } else {
                for (String option : options) {
                    WebElement option_menu = driver.findElement(By.xpath("//mat-checkbox//span[text()=' " + option + " ']"));

                    if (option_menu.getText().equalsIgnoreCase(option)) {
                        option_menu.click();
                    }
                }
            }
        }
    }
}

