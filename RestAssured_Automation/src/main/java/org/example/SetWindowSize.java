package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetWindowSize {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.6");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();



    }
}
