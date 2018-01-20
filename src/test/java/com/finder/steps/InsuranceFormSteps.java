package com.finder.steps;

import com.finder.pages.InsuranceFormPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InsuranceFormSteps {

    private WebDriver driver;
    private InsuranceFormPage insuranceFormPage;

    public InsuranceFormSteps(WebDriver driver) {
        this.driver = driver;
        insuranceFormPage = new InsuranceFormPage(driver);
    }

    public void chooseSex(String sex) {
        switch (sex){
            case "female":
                insuranceFormPage.female.click();
                break;
            case "male":
                insuranceFormPage.male.click();
                break;
            default:
                insuranceFormPage.female.click();
                break;
        }
    }

    public void setDateOfBirth(int birthday) {
        insuranceFormPage.dayOfBirthday.clear();
        insuranceFormPage.dayOfBirthday.sendKeys(birthday+"");
    }

    public void setMonthOfBirth(String month) {
        insuranceFormPage.monthOfBirthday.click();
        insuranceFormPage.selectMonth(month);
    }

    public void setYearOfBirth(int year) {
        insuranceFormPage.yearOfBirthday.sendKeys(year + "");
    }

    public void setState(String state) {
        insuranceFormPage.countryState.sendKeys(state);
    }

    public void clickOnSmoke(String smoke) {
        if(smoke.equals("no"))
            insuranceFormPage.nonSmoker.click();
        else if (smoke.equals("yes"))
            insuranceFormPage.smoker.click();
        else
           System.out.println("Please provide correct smoke condition!") ;
    }

    public void setOccupation(String occupation) {
        insuranceFormPage.occupationTextField.clear();
        insuranceFormPage.occupationTextField
                .sendKeys(occupation.substring(0, (occupation.length()-1) ));
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        insuranceFormPage.occupationTextField.sendKeys(Keys.ARROW_DOWN);
        insuranceFormPage.occupationTextField.sendKeys(Keys.ENTER);
    }

    public void clickButton(String buttonName) {
        if(buttonName.equals("Next"))
        {
            insuranceFormPage.nextButton.click();
        }
    }
}
