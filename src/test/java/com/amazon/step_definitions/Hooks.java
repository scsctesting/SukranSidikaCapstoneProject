package com.amazon.step_definitions;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.logging.Logger;

public class Hooks {

    //---------sukran's--------------
//    private static Logger logger = Logger.getLogger(Hooks.class);
//
//    //it runs automatically based on this annotations
//    @Before
//    public void setup() {
//        logger.info("##############################");
//        logger.info("Test setup!");
//        // if(ConfigurationReader.getProperties("browser".contains("remote"))){
//        String browser = ConfigurationReader.getProperties("browser");  // change for Appium class
//        if (!browser.contains("remote") && !browser.contains("mobile")) {  // change for Appium class
//            Driver.get().manage().window().maximize(); // you cannot maximize window if you are using mobile device.
//        }
//    }
//    @After
//    //if test failed  - do this
//    public void teardown(Scenario scenario){
//        if(scenario.isFailed()){
//            //  System.out.println("Test failed"); old version  or
//            logger.error("Test failed!");
//            byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png");
//        } else {
////            System.out.println("Cleanup!");
////            System.out.println("Test completed");
//            logger.info("Cleanup!");
//            logger.info("Test completed!");
//        }
//        logger.info("##############################");
//        //  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> \n");
//        //after every test we are gonna close browser
//        Driver.close();
//    }
//








 //----------------mine--------------
    @Before
    public void setup() {
        Driver.getDriver().manage().window().maximize();
    }

    @After("@driver")
    public void specialTearDown() {
        System.out.println("Tear down");
    }

    @After
    public void tearDown(Scenario scenario) {
        //how to check if scenario failed
        if (scenario.isFailed()) {
//            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
//            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //attach screenshot to the report
           // scenario.embed(image, "image/png", scenario.getName());
            //try the one below maybe?

            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        System.out.println("Test clean up");
        Driver.closeDriver();
    }

//
//        //----------------------------
////        analyzeLogConsoleError();
////        BrowserUtilities.getNetworkLogs();
//






}
