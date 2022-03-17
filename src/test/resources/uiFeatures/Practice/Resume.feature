Feature: This feature uploads the resume to the different job platforms

  @resumeUploader
  Scenario: User should be able to successfully upload the resume
    Given user navigates to "LinkedIn" home page
    When user clicks on "More" button at "LinkedIn" profile page
    And user selects "Build a Resume" option
    Then user successfully uploads the resume