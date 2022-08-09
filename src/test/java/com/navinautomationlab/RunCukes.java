package com.navinautomationlab;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/",
        dryRun = false, //step is define in step definition or not
        strict = true,
        tags = "@pro",
        plugin = "json:target/cucumber-report/cucumber.json")


public class RunCukes {
}
