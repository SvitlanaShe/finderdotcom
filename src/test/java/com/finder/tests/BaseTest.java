package com.finder.tests;

import com.finder.Browser;
import com.finder.WebDriverFactory;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    static Browser browser = Browser.CHROME;

    public void openSite() throws IOException {
        Properties properties = new Properties();
        WebDriverFactory F = new WebDriverFactory(browser.toString());
        driver = F.getDriver();

        try(InputStream stream = getClass().getResourceAsStream("/url.properties")){
            properties.load(stream);
            driver.get( properties.getProperty("mainURI").toString() );
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS );
    }

    public WebDriver getDriver() {
        return WebDriverFactory.getDriver();
    }

    protected void quitDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }

}
