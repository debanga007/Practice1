Feature: Test Google Search

  @google
  Scenario: Search Google with your name
    Given I open Google.com
    And I type name in Search box
    When I click on search
    Then I should see matching search results
		And I close the browser