package com.amazon.step_definitions;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
   boolean isFailed;

    @Before
    public void setup() {
        Driver.getDriver().manage().window().maximize();
        BrowserUtils.createDevToolsSession();
    }

    @After(order=1)
    public void logs(Scenario scenario) {
        isFailed=scenario.isFailed();
        Driver.analyzeLogConsoleError();
        BrowserUtils.getNetworkLogs();
        BrowserUtils.performance();

    }

    @After(order=0)
    public void tearDown(Scenario scenario) {
        //how to check if scenario failed
        if (isFailed) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }


}
