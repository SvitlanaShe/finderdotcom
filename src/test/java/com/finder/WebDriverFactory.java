package com.finder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;

public class WebDriverFactory {
    private static WebDriver driver;
    private static Browser browser = Browser.CHROME;

    public WebDriverFactory(String browser) throws IOException {
        switch (browser) {
            case "Chrome":
            case "chrome":
                this.browser = Browser.CHROME;
                break;
            case "IE":
            case "ie":
                this.browser = Browser.IE;
        }
        getDriver();

    }


    public static WebDriver getDriver() {

        if (driver == null) {
            return newWebDriver();
        }
        return driver;
    }

    private static WebDriver newWebDriver() {
        String driverPath = "";
        switch (browser) {
            case IE:
                System.out.print("Some stuff for IE should be implemented here");
                break;
            case CHROME:
                driverPath = WebDriverFactory.class.getClassLoader().getResource("drivers/chromedriver.exe").getPath();
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                break;
            default:
                System.out.print("Incorrect browser name, please select IE or Chrome");

        }
        return driver;
    }


}
