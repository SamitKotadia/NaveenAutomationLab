package com.navinautomationlab.step_definations;

import com.navinautomationlab.driver.DriverManager;
import com.navinautomationlab.pages.RegisterPage;
import cucumber.api.java.en.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CommanSteps extends DriverManager {
RegisterPage registerPage = new RegisterPage();

    @Then("^I Should see \"([^\"]*)\" text on \"([^\"]*)\" page$")
    public void i_Should_see_text_on_page(String expectedText, String pageType) throws Throwable {
    switch (pageType){
        case "Register":
            String myActualText = registerPage.getRegisterText();
            assertThat(myActualText,is(equalToIgnoringCase(expectedText)));
            System.out.println(myActualText);
            break;
        case "Successful Register Page":
            String myActualTexts = registerPage.getSuccessfulRegisterText();
            assertThat(myActualTexts,is(equalToIgnoringCase(expectedText)));
            System.out.println(myActualTexts);
            break;
    }
    Thread.sleep(5000);
    }
}
