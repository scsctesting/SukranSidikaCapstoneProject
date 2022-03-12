package com.amazon.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/amazon/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        publish = true,
        tags =// "@SmokeTest and not @ignore",
                "@TC_17",
        plugin = {
                "html:target/default-report",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)

public class CucumberRunner {
}
