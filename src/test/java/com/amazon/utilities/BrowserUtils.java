package com.amazon.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.devtools.v97.network.model.Request;
import org.openqa.selenium.devtools.v97.network.model.Response;
import org.openqa.selenium.devtools.v97.performance.Performance;
import org.openqa.selenium.devtools.v97.performance.model.Metric;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;


public class BrowserUtils {
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace(); // it is a message saying where,why and what is the problem
        }

    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    public static void waitForVisibilityList(List<WebElement> element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(element)));
    }

    public static void waitForInvisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForInvisibilityList(List<WebElement> element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }

    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void highlightAndRemoveWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        js.executeScript("arguments[0].removeAttribute('style','')", element);
    }

    public static boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementPresentList(List<WebElement> element) {
        try {
            element.get(0).isDisplayed();
            return true;
        } catch (java.lang.IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static void scrollToSpecificWebElement(WebElement target) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        waitFor(2);
        js.executeScript("arguments[0].scrollIntoView(true)", target);
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenshot(String name) {
        //adding date and time to screenshot name, to make screenshot unique
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        //where we gonna store a screenshot
        String path = "";

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }

        System.out.println("OS name: " + System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);
        //since our reference type is a WebDriver
        //we cannot see methods from TakesScreenshot interface
        //that's why do casting
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        //take screenshot of web browser, and save it as a file
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //where screenshot will be saved
        File destination = new File(path);
        try {
            //copy file to the previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
//------------------------------------------------

   static DevTools devTools=((ChromiumDriver)Driver.getDriver()).getDevTools();

    static String pathConsole =System.getProperty("user.dir")+ File.separator+"target"+File.separator+"browserErrors.txt";
    static String pathNetwork =System.getProperty("user.dir")+ File.separator+"target"+File.separator+"networkLogs.txt";
    static String pathPerformance =System.getProperty("user.dir")+ File.separator+"target"+File.separator+"performance.txt";

    //use this method to analyze logs of response status
    public static void getNetworkLogs(){
        devTools.addListener(Network.requestWillBeSent(), request->{
            Request req=request.getRequest();
            System.out.println(req.getUrl());
        });
        devTools.addListener(Network.responseReceived(), response->{
            Response res=response.getResponse();
            String resData="url: "+res.getUrl()+ ", status: "+res.getStatus();
            System.out.println("network log: "+resData );
            Driver.createLogs(resData, pathNetwork);
            Driver.createLogs(" ", pathNetwork);
        });
    }

   // ------------performance --------------

    public static void createDevToolsSession(){
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Performance.enable(Optional.empty()));

    }
//----------------------------

    public static void performance(){
        List<Metric> metrics = devTools.send(Performance.getMetrics());
        List<String> metricNames= metrics.stream().map(o-> o.getName()).collect(Collectors.toList());

        devTools.send(Performance.disable());

        List<String> metricsToCheck = Arrays.asList(
                "Timestamp", "Documents", "Frames", "JSEventListeners",
                "LayoutObjects", "MediaKeySessions", "Nodes",
                "Resources", "DomContentLoaded", "NavigationStart");

        metricsToCheck.forEach( metric -> Driver.createLogs(metric +
                " is : " + metrics.get(metricNames.indexOf(metric)).getValue(), pathPerformance));
         Driver.createLogs("end of performance log",pathPerformance);
         Driver.createLogs(" ",pathPerformance);
    }

}
