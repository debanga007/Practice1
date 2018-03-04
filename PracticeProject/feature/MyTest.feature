Feature: Test Google Search

<<<<<<< HEAD
  @success	@regression
  Scenario: Scenario One Search Google with your name
    Given I open Google.com
    And I type name in Search box
    When I click on search
    Then I should see matching search results
		And I close the browser
		
		@failure	@regression
	Scenario: Scenario Two Search Google with your name
    Given I open Google.com
    And I type surname in Search box
    When I click on search
    Then I should see matching image results
		And I close the browser	
		
=======
  @google
  Scenario: Search Google with your name
    Given I open Google.com
    And I type name in Search box
    When I click on search
    Then I should see matching search results
		And I close the browser
>>>>>>> branch 'master' of https://github.com/debanga007/Practice1.git
