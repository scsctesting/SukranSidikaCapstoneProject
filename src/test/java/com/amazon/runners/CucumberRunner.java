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
        tags = "@TC_16",
        plugin = {
                "html:target/default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"
        }
)

public class CucumberRunner {
}
