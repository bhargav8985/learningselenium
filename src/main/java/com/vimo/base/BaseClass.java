package com.vimo.base;

import com.vimo.Utilities.LoggerManager;
import com.vimo.actiondriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
public class BaseClass {

    // Thread-safe WebDriver
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final Logger logger = LoggerManager.getLogger(BaseClass.class);

    // Thread-safe ActionDriver
    protected static ThreadLocal<ActionDriver> actionDriver = new ThreadLocal<>();

    protected static Properties prop;



    // 🔹 Load config
    @BeforeSuite
    public void loadConfig() {
        try {
            BaseClass.logger.info("Loading config file");
            prop = new Properties();
            prop.load(
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream("config.properties")
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    // 🔹 Initialize browser
    @BeforeMethod
    public void initialize() {

        String browser = prop.getProperty("browser").toLowerCase();
        WebDriver localDriver;
BaseClass.logger.info("Initializing browser: " + browser);
        switch (browser) {
            case "chrome":
                localDriver = new ChromeDriver();
                break;
            case "firefox":
                localDriver = new FirefoxDriver();
                break;
            case "edge":
                localDriver = new EdgeDriver();
                break;
            case "safari":
                localDriver = new SafariDriver();
                break;
            default:
                BaseClass.logger.fatal("Unsupported browser: " + browser);
                throw new RuntimeException("Invalid browser name: " + browser);
        }

        driver.set(localDriver);

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();

        getDriver().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait")))
        );

        getDriver().manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeout")))
        );

        getDriver().get(prop.getProperty("url"));

        // Initialize ActionDriver AFTER WebDriver
        actionDriver.set(new ActionDriver(getDriver()));

    }

    // 🔹 Get WebDriver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // 🔹 Get ActionDriver
    public static ActionDriver getActionDriver() {
        return actionDriver.get();
    }

    // 🔹 Tear down
    @AfterMethod
    public void teardown() {
        BaseClass.logger.info("Tearing down");
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            actionDriver.remove();
        }
    }

    public static Properties getProp() {
        return prop;
    }
}
