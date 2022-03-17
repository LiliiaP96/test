Feature: This feature file tests MyBlue Medical Plan Finder

  Background:
    Given user navigates to MyBlue HomePage

    @MedicalPlan
  Scenario: user should be able to select "Medical" plan finder tool
    When user hovers over "Tools and Resources" tab
    And user hovers over AskBlue Finder Tool
    And user clicks on "Medical" plan finder tool
    Then user is redirected to "Medical" plan finder tool page

  @MedicalPlan
    Scenario: User should be able to complete the survey
      When user hovers over "Tools and Resources" tab
      And user hovers over AskBlue Finder Tool
      And user clicks on "Medical" plan finder tool
      Then user is redirected to "Medical" plan finder tool page
      And user clicks on "No, I am not a member" button
      And user clicks on "Let's get started" button



