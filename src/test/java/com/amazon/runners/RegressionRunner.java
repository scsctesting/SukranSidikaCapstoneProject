package com.amazon.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/amazon/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        tags = "@RegressionTest",
        plugin = {"pretty",
        "json:target/cucumber.json",
        "rerun:target/rerun.txt"
}
)
public class RegressionRunner {

//        @BeforeClass
//        public static void before(){
//                BrowserUtils.createDevToolsSession();
//        }

        @AfterClass
        public static void reportsC(){
                File reportOutputDirectory=new File("target/cucumberReport");
                List<String> jsonFiles= new ArrayList<>();
                jsonFiles.add("target/cucumber.json");
                String name="Capstone Cucumber Report";
                Configuration configuration= new Configuration(reportOutputDirectory, name);//net.masterthoght.cucmber.Configuration
                ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);///net.masterthoght.cucmber.Configurati
                reportBuilder.generateReports();//comes from import

        }


}
