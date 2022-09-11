package com.navinautomationlab.step_definations;

import com.navinautomationlab.driver.DriverManager;
import com.navinautomationlab.pages.HomePage;
import cucumber.api.java.en.*;
import gherkin.lexer.Th;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomeSteps extends DriverManager{
DriverManager driverManager = new DriverManager();
HomePage homePage = new HomePage();

    @Given("^I am on home page$")
    public void i_am_on_home_page() throws Throwable {
    String actualURL = driverManager.getURL();
        System.out.println(actualURL);
        assertThat(actualURL,is(endsWith("opencart/index.php?route=common/home")));
    }
    @When("^I click on \"([^\"]*)\" button$")
    public void i_click_on_button(String button) throws Throwable {
    switch (button){
        case "My Account":
             homePage.clickMyAccountButton();

            break;
        case "Tablets":
            homePage.clickOnTabletButton();
            break;
    }
    }

    @When("^I select \"([^\"]*)\" button$")
    public void i_select_button(String arg1) throws Throwable {
    homePage.clickOnRegisterButton();
    }
}
