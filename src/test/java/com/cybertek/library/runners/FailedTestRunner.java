package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(



        glue = "com/cybertek/library/step_definitions",
        features = "target/rerun.txt"
//this does not report, to report add "html:target/default-cucumber-reports"
        //if you use the same report name as you runner file, it will
        //delete that report and create a new one only of failed tests
        //if you write a different name, it will create second report
)
public class FailedTestRunner {
}