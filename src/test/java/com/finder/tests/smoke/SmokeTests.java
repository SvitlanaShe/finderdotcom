package com.finder.tests.smoke;

import com.finder.steps.InsuranceFormSteps;
import com.finder.steps.ProgressIndicatorsSteps;
import com.finder.tests.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class SmokeTests extends BaseTest {

    WebDriver driver = getDriver();
    InsuranceFormSteps insuranceForm = new InsuranceFormSteps(driver);
    ProgressIndicatorsSteps mainPageSteps;

    @Given("on main page")
    public void test() throws IOException, InterruptedException {
        openSite();

    }

    @When("^set sex \"([^\"]*)\"$")
    public void set_sex_female(String sex) throws Throwable {
        insuranceForm.chooseSex(sex);
    }

    @When("^set birthdate (\\d+) \"([^\"]*)\" (\\d+)$")
    public void set_birthdate_January(int birthday,String month, int year) throws Throwable {
        insuranceForm.setDateOfBirth(birthday);
        insuranceForm.setMonthOfBirth(month);
        insuranceForm.setYearOfBirth(year);
    }

    @When("^select State \"([^\"]*)\"$")
    public void select_State_SA(String state) throws Throwable {
        insuranceForm.setState(state);
   }

    @When("^select smoke \"([^\"]*)\"$")
    public void select_smoke_no(String smoke) throws Throwable {
        insuranceForm.clickOnSmoke(smoke);
    }

    @When("^fill occupation \"([^\"]*)\"$")
    public void fill_occupation(String occupation) throws Throwable {
        insuranceForm.setOccupation(occupation);
    }

    @When("^click button \"([^\"]*)\"$")
    public void click_button(String buttonName) throws Throwable {
        insuranceForm.clickButton(buttonName);
    }

    @Then("^close driver$")
    public void close_driver() throws Throwable {
        quitDriver();
    }

    @Then("^check submitted$")
    public void check_submitted() throws Throwable {

        mainPageSteps = new ProgressIndicatorsSteps(driver);

        List<String> listActiveIndicators = mainPageSteps.getActiveProgressIndicators();

        Assert.assertEquals(listActiveIndicators.size(),2, "Shoulw be 2 active indicators");
        Assert.assertEquals(mainPageSteps.getInActiveProgressIndicators().size(),1, "Should be 1 inactive indicators");
        Assert.assertTrue(listActiveIndicators.contains("2. COVER REQUIRED"),
                "No Cover required active found . Current active progress indicators are: " + mainPageSteps.getActiveProgressIndicators());
    }


}
