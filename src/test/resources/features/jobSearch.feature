
Feature: Job Search on Labcorp

  Scenario: Search and validate a job posting
    Given I open the labcorp homepage
    When I click on the Careers link
    And I search for the job "QA Test Automation Developer"
    And I select the job "QA Test Automation Developer"
    Then I verify job title is "QA Test Automation Developer"
    Then I verify job location is "Remote"
    Then I verify job id is "12345"
    Then I verify description paragraph 3 is "The right candidate for this role will participate in the test automation technology development and best practice models."
    Then I verify management support bullet 2 is "Prepare test plans, budgets, and schedules."
    Then I verify requirement 3 is "5+ years of experience in QA automation development and scripting."
    Then I verify suggested automation tool contains "Selenium"
    When I click Apply Now
    Then I verify application page details job title "QA Test Automation Developer", location "Remote", job id "12345", extra text "The right candidate for this role"
    When I click Return to Job Search
