package com.navinautomationlab.step_definations;

import com.navinautomationlab.driver.DriverManager;
import com.navinautomationlab.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

import java.util.List;
import java.util.Map;

public class RegisterSteps extends DriverManager {
    RegisterPage registerPage = new RegisterPage();
    DriverManager driverManager = new DriverManager();

    @Then("^I enter following detail for registration$")
    public void i_enter_following_detail_for_registration(DataTable registrationTable) throws Throwable {
        List<Map<String,String>>data;
        data =  registrationTable.asMaps(String.class, String.class);
        System.out.println(data);
        registerPage.enterFirstName(data.get(0).get("firstName"));
        registerPage.enterLastName(data.get(0).get("lastName"));
        registerPage.enterEmailID(data.get(0).get("email"));
        registerPage.enterTelephoneNumber(data.get(0).get("telephone"));
        registerPage.enterPassword(data.get(0).get("password"));
        registerPage.enterConfirmPassword(data.get(0).get("confirmPassword"));

    }

    @Then("^I select \"([^\"]*)\" button for newsletter$")
    public void i_select_button_for_newsletter(String option) throws Throwable {
        switch (option){
            case "Yes":
                registerPage.selectNewLetterYes();
                break;
            case "No":
                registerPage.selectNewLetterNo();
                break;
        }
    }

    @Then("^I agree on Privacy Policy on register page$")
    public void i_agree_on_Privacy_Policy_on_register_page() throws Throwable {
        registerPage.clickOnPrivacyCheckBox();

    }

    @Then("^I click on Continue button$")
    public void i_click_on_Continue_button() throws Throwable {
        registerPage.setClickOnContinue();
    }

    @Then("^I click on Continue button after Successful register$")
    public void i_click_on_Continue_button_after_Successful_register() throws Throwable {
    registerPage.setClickOnContinueAfterSuccess();

    }
}
