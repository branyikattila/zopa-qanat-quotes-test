Feature: Quote decision
	
  @createUser @complete
  Scenario: Valid quote decision is returned
    When I request a loan for "validQuote" user with valid value
    Then I should receive a decision that the loan is offered

  @createUser @complete
  Scenario: Invalid Quote request
    When I request a loan for "invalidQuote" user with data
    Then I should receive an message about loan is not offered

  @complete
  Scenario: Non existing user
    When I request a loan for "nonExisting" user
    Then I should receive a non existing user message

