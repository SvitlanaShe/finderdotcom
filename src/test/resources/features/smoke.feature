Feature: Smoke Test Pack
    In order to check main functionality
    I want to use links on main page

    @Positive
    @Smoke
    Scenario: Test fill the form and submit it
    Given on main page
    When set sex "female"
        And set birthdate 11 "January" 1944
        And select State "SA"
        And select smoke "no"
        And fill occupation "Music Director"
        And click button "Next"
    Then check submitted

  @After
  Scenario: Close driver
    Given  close driver

