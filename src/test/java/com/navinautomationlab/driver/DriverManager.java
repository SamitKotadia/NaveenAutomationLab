package com.navinautomationlab.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DriverManager {
    ReadCongiFile readCongiFile = new ReadCongiFile("Config.properties");
    public static WebDriver driver;

  //  String browser = "chrome";
   // String URL = "https://naveenautomationlabs.com/opencart/index.php?route=common/home";
String URL = readCongiFile.getApplicationURL();
String browser = readCongiFile.getApplicationBrowser();

    public DriverManager() {
        PageFactory.initElements(driver, this);
    }

    public void runOnLocalBrowser() throws IllegalAccessException {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalAccessException("Unexpected browser");
        }
    }

    public void maxBrowser() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void goToURL() {
        driver.get(URL);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(50);
    }

    public WebElement waitUntilElementIsClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementIsVisible(WebElement element, int timeOut, String failureMassage){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.withMessage(failureMassage);
    }

    public static void flash(WebElement element, WebDriver driver){
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        String backGroundColor = element.getCssValue("backgroundColor");
        for (int i = 0; i<1; i++){
            changeColor("#000000", element, driver);
            changeColor(backGroundColor, element, driver);
        }
    }

    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '"+ color+"'",element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
    public static void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
        javascriptExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void screenShot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File trg = new File("\"C:\\Users\\jigar\\Desktop\\screenShotTest\"");
        FileUtils.copyFile(src, trg);
    }

}
