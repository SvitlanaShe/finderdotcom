package com.finder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProgressIndicatorsPage {
    private WebDriver driver;

    public ProgressIndicatorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//li[contains(@class,'progress')][contains(@class,'is-active')]")
    public List<WebElement> activeProgressIndicators;

    @FindBy(xpath = "//li[contains(@class,'progress')][not(contains(@class,'is-active'))]")
    public List<WebElement> inactiveProgressIndicators;

    @FindBy(xpath = "//li[contains(@class,'progress')]")
    public List<WebElement> allProgressIndicators;
}
