package com.navinautomationlab;

import com.navinautomationlab.driver.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    DriverManager driverManager = new DriverManager();

    @Before
    public void setUp() throws IllegalAccessException {
        driverManager.runOnLocalBrowser();
        driverManager.goToURL();
        driverManager.maxBrowser();

    }

    @After
    public void tearDown() {
        driverManager.closeBrowser();
    }
}

