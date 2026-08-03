package com.NewCucum;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    // ThreadLocal ensures that each parallel thread gets its own completely isolated browser instance
    public static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * Initializes the driver based on execution type and browser configuration.
     * Call this inside your @Before cucumber hook.
     * 
     * @param executionType "local" or "remote" (Grid)
     * @param browserName "chrome", "firefox", or "edge"
     * @param gridHubUrl The URL of your Selenium Grid Hub (e.g., "http://localhost:4444/wd/hub")
     */
    public static void setDriver(String executionType, String browserName, String gridHubUrl) {
        WebDriver driver = null;
        browserName = browserName.toLowerCase().trim();
        executionType = executionType.toLowerCase().trim();

        if (executionType.equalsIgnoreCase("remote")) {
            driver = createRemoteDriver(browserName, gridHubUrl);
        } else {
            driver = createLocalDriver(browserName);
        }

        // 1. Bind the created driver instance to the specific executing thread
        tlDriver.set(driver);

        // 2. Apply standard web browser configurations safely to this isolated instance
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    /**
     * Instantiates local web browsers using WebDriverManager automatically.
     */
    private static WebDriver createLocalDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                // Mandatory flags for running locally inside GitHub Actions
                chromeOptions.addArguments("--headless=new"); 
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                return new ChromeDriver(chromeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                return new EdgeDriver(edgeOptions);

            default:
                throw new IllegalArgumentException("Unsupported local browser type specified: " + browserName);
        }
    }

    /**
     * Instantiates grid-managed remote environments using Selenium 4 RemoteWebDriver.
     */
    private static WebDriver createRemoteDriver(String browserName, String gridHubUrl) {
        try {
            URL url = new URL(gridHubUrl);
            
            switch (browserName) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    return new RemoteWebDriver(url, chromeOptions);

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    return new RemoteWebDriver(url, firefoxOptions);

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    return new RemoteWebDriver(url, edgeOptions);

                default:
                    throw new IllegalArgumentException("Unsupported Grid browser type specified: " + browserName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("CRITICAL: The specified Selenium Grid Hub URL is malformed: " + gridHubUrl, e);
        }
    }

    /**
     * Retrieves the isolated WebDriver instance assigned exclusively to the calling thread.
     * Call this inside your Step Definitions to perform browser actions.
     */
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * Safely closes the browser window and destroys the thread allocation structure to avoid memory leaks.
     * Call this inside your @After cucumber hook.
     */
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove(); // Essential to scrub background thread data structures cleanly
        }
    }
}
