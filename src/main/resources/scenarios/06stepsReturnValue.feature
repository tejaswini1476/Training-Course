@returnValue
Feature: return values

  Scenario: Get value from step
    Given I am on Google Search Page
    When I search for "weather"
    Then I check chance of rain
    And store into 'rain.chance'
    Then Do i need an umbrella "rain.chance"


