package com.login.tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.login.utils.ConfigReader;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;

    public void setup() {

        // Load config.properties
        prop = ConfigReader.loadProperties();

        // Read correct keys from config.properties
        String driverPath = prop.getProperty("chromedriverPath");
        String url = prop.getProperty("baseUrl");
        String implicitWait = prop.getProperty("implicitWait");

        // Validate config
        if (driverPath == null || url == null) {
            throw new RuntimeException("Missing config values! Check config.properties.");
        }

        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Set implicit wait
        int wait = 10;
        if (implicitWait != null) {
            wait = Integer.parseInt(implicitWait);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

        // Launch application
        driver.get(url);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
