package com.amazon.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

public class Driver {
    //same for everyone
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    //so no one can create object of Driver class
    //everyone should call static getter method instead
    private Driver() {
    }

    /**
     * synchronized makes method thread safe. It ensures that only 1 thread can use it at the time.
     * <p>
     * Thread safety reduces performance but it makes everything safe.
     *
     * @return
     */
    public synchronized static WebDriver createDriver() {
        //if webdriver object doesn't exist, create it
        if (driverPool.get() == null) {
            //specify browser type in configuration.properties file
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            if (System.getProperty("browser") != null) {
                browser = System.getProperty("browser");
            }

            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                    //log icin
                    LoggingPreferences chromeLogs=new LoggingPreferences();
                    chromeLogs.enable(LogType.BROWSER, Level.ALL);
                    chromeHeadlessOptions.setCapability(CapabilityType.LOGGING_PREFS,chromeLogs);
                    //-------
                    WebDriverManager.chromedriver().setup();
                    chromeHeadlessOptions.setHeadless(true);
                    driverPool.set(new ChromeDriver(chromeHeadlessOptions));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions=new FirefoxOptions();
                    driverPool.set(new FirefoxDriver(firefoxOptions));
                    break;

                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptionsHeadless=new FirefoxOptions();
                    firefoxOptionsHeadless.setHeadless(true);
                    driverPool.set(new FirefoxDriver(firefoxOptionsHeadless));
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions=new EdgeOptions();
                    EdgeDriverService edgeDriverService=EdgeDriverService.createDefaultService();
                    driverPool.set(new EdgeDriver(edgeDriverService,edgeOptions));
                    break;
//                case "edge-headless":
//                    WebDriverManager.edgedriver().setup();
//                    EdgeOptions edgeHeadlessOptions=new EdgeOptions();
//                    EdgeDriverService edgeDriverServiceHeadless=EdgeDriverService.createDefaultService();
//                    driverPool.set(new EdgeDriver(edgeDriverServiceHeadless,edgeHeadlessOptions));
//                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driverPool.get();
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            createDriver();
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.set(null);
            driverPool.remove();
        }
    }
}
