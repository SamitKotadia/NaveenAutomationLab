package com.navinautomationlab.pages;

import com.navinautomationlab.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class HomePage extends DriverManager{
    DriverManager driverManager = new DriverManager();


    @FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")
    WebElement myAccountButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Register')]")
    WebElement registerButton;

    @FindBy(xpath = "//a[contains(text(),'Tablets')]")
    WebElement tabletButton;

    public void clickOnTabletButton() throws InterruptedException {
        driverManager.flash(tabletButton,driver);
        driverManager.drawBorder(tabletButton, driver);

        tabletButton.click();
        driverManager.generateAlert(driver,"You clicked on Tablet button");
        Thread.sleep(5000);
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    public void clickMyAccountButton()  {

        myAccountButton.click();

    }

}
