Feature: Test API

  @api
  Scenario: Scenario One Test Get Call
    Given I hit token request
    When I trigger GET API Call for customerid "10000142874"
    Then I should get status "200" OK
	And I should get response as per design