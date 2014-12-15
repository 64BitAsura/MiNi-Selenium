package edu.pw.mini.selenium;

import static edu.pw.mini.selenium.config.DriverType.determineEffectiveDriverType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import edu.pw.mini.selenium.config.DriverType;
import edu.pw.mini.selenium.listeners.ScreenshotListener;

/**
 * @author SAMBATH
 *
 */

@Listeners(ScreenshotListener.class)
public class DriverFactory {

    private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());
    private static ThreadLocal<WebDriver> driverThread;

    @BeforeSuite
    public static void instantiateDriverObject() {

        final DriverType desiredDriver = determineEffectiveDriverType(System.getProperty("browser"));

        driverThread = new ThreadLocal<WebDriver>() {
            @Override
            protected WebDriver initialValue() {
                final WebDriver webDriver = desiredDriver.configureDriverBinaryAndInstantiateWebDriver();                
                webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                webDriverPool.add(webDriver);
                return webDriver;
            }
        };
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    @AfterMethod
    public static void clearCookies() {
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public static void closeDriverObject() {
        for (WebDriver driver : webDriverPool) {
            driver.quit();
        }
    }
}