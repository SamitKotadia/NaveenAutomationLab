package com.navinautomationlab.pages;

import com.navinautomationlab.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class HomePage extends DriverManager{


    @FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")
    WebElement myAccountButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Register')]")
    WebElement registerButton;

    @FindBy(xpath = "//a[contains(text(),'Tablets')]")
    WebElement tabletButton;

    public void clickOnTabletButton() {
        DriverManager.flash(tabletButton,driver);
        DriverManager.drawBorder(tabletButton, driver);

        tabletButton.click();
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    public void clickMyAccountButton()  {

        myAccountButton.click();

    }

}
