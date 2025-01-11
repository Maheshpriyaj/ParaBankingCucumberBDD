package com.banking.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.banking.stepdefinition", features = "src\\test\\resources",dryRun=false,plugin = {
        "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports/cucumber-html-report.html"
    })

public class TestRunner {

}
