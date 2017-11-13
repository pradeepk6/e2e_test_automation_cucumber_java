package com.elsevier.mendeley.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@createaccount","~@ignore"},
        features = "src/test/resources/features",
        glue = "com.elsevier.mendeley",
        monochrome = true,
        format = {"pretty", "html:target/cucumber"})
public class RunCukesAT {
}
