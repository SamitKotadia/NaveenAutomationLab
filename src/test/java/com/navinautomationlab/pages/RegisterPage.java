package com.navinautomationlab.pages;

import com.navinautomationlab.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends DriverManager {


    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerText;

    @FindBy(how = How.XPATH, using = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @FindBy(how = How.XPATH, using = "//input[@id='input-email']")
    WebElement emailId;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephoneNumber;

    @FindBy(how = How.XPATH, using = "//input[@id='input-password']")
    WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@id='input-confirm']")
    WebElement confirmPassword;

    @FindBy(css = "input[value='1'][name='newsletter']")
    WebElement newLetterYes;

    @FindBy(how = How.CSS, using = "input[value='0'][name='newsletter']")
    WebElement newLetterNo;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement clickOnContinue;

    @FindBy(how = How.XPATH, using = "//input[@name='agree']")
    WebElement policyCheckBox;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement successfulRegisterText;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement clickOnContinueAfterSuccess;

    public void setClickOnContinueAfterSuccess(){
        clickOnContinueAfterSuccess.click();

    }

    public String getSuccessfulRegisterText(){
        return successfulRegisterText.getText();
    }

    public void clickOnPrivacyCheckBox(){
        policyCheckBox.click();
    }

    public void setClickOnContinue(){
    clickOnContinue.click();
    }

    public void selectNewLetterNo(){
    newLetterNo.click();
    }

    public void selectNewLetterYes(){
    newLetterYes.click();
    }

    public void enterConfirmPassword(String myConfirm){
        confirmPassword.sendKeys(myConfirm);
    }

    public void enterPassword(String myPassword){
        password.sendKeys(myPassword);
    }

    public void enterTelephoneNumber(String number){
    telephoneNumber.sendKeys(number);
    }

    public void enterEmailID(String email){
    emailId.sendKeys(generateRandomNumber()+email);
    }

    public void enterLastName(String myLastName){
        lastName.sendKeys(myLastName);
    }

    public void enterFirstName(String myFirstName){
        firstName.sendKeys(myFirstName);
    }

    public String getRegisterText(){
     return registerText.getText();
    }



}
