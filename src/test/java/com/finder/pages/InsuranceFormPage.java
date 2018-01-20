package com.finder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceFormPage {

    private WebDriver driver;

    public InsuranceFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@for='gender_female']")
    public  WebElement female;

    @FindBy(xpath = "//*[@for='gender_male']")
    public  WebElement male;

    @FindBy(id = "birthdate")
    public WebElement dayOfBirthday;

    @FindBy(xpath = "//select[@name='birthmonth']")
    public WebElement monthOfBirthday;

    @FindBy(xpath = "//select[@name='birthyear']")
    public WebElement yearOfBirthday;

    @FindBy(xpath = "//select[@name='countrystate']")
    public WebElement countryState;

    @FindBy(xpath = "//label[@for='non_smoker']")
    public WebElement nonSmoker;

    @FindBy(xpath = "//label[@for='smoker']")
    public WebElement smoker;

    @FindBy(xpath = "//input[@name ='occupation']")
    public WebElement occupationTextField;

    @FindBy(xpath = "//form[@class='relative clearfix']//button[@type='submit']")
    public WebElement nextButton;

    public void selectMonth(String month) {
        monthOfBirthday.findElement(By.xpath("//*[text()='" + month + "']")).click();
    }

}
