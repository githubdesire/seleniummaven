package com.selenium.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverInitializer {

    private static Properties properties = null;
    private static WebDriver driver = null;

    static {
        try {
            properties = new Properties();
            properties.load(DriverInitializer.class.getClassLoader()
                    .getResourceAsStream("project.properties"));
                   System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.path"));  
                  driver = new FirefoxDriver();                   
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }


    public static String getProperty(String key) {
        return properties == null ? null : properties.getProperty(key, "");
    }
}
