package com.finder.steps;

import com.finder.pages.ProgressIndicatorsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProgressIndicatorsSteps {
    private WebDriver driver;
    private ProgressIndicatorsPage progressIndicatorsPage;

    public ProgressIndicatorsSteps(WebDriver driver) {
        this.driver = driver;
        progressIndicatorsPage = new ProgressIndicatorsPage(driver);
    }

    public List<String> getActiveProgressIndicators() {
        List <String> indicators = new ArrayList<>();
        for ( WebElement indicator: progressIndicatorsPage.activeProgressIndicators ) {
            indicators.add(indicator.getText());
        }
        return indicators;
    }

    public List<String> getInActiveProgressIndicators() {
        List <String> indicators = new ArrayList<>();
        for ( WebElement indicator: progressIndicatorsPage.inactiveProgressIndicators ) {
            indicators.add(indicator.getText());
        }
        return indicators;
    }
}
