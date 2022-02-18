# zopa-qanat-quotes-test

This project contains the 3 example tests for Zopa. 
Prerequisites:
Maven 3.5+

Steps to execute the tests:
1, clone the repository
2, execute the following cmd from the root directory: man clean install -Dcucumber.options="--tags @complete"


The project will run 3 test scenarios:

  Scenario: Valid quote decision is returned
    When I request a loan for "validQuote" user with valid value
    Then I should receive a decision that the loan is offered

  Scenario: Invalid Quote request
    When I request a loan for "invalidQuote" user with data
    Then I should receive an message about loan is not offered

  Scenario: Non existing user
    When I request a loan for "nonExisting" user
    Then I should receive a non existing user message

One of them (Scenario: Valid quote decision is returned) is failing due to the fact that the quote service is returning a different quote rate each time. The 2 other tests supposed to pass. Json reports should be generated into /target/cucumber-json/. To generate an html report rum cmd mvn surefire-report:report in the root directory of the project this will generate an html report in the folder /target/site/.
