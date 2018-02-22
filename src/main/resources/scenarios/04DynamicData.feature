@dynamicData
Feature: Add Contact

  Scenario Outline: Dynamic Data
    Given I launch Contacts application
    Then I Add Contact with name "<ContactName>" and number  "<ContactNumber>"
  Examples: {'datafile' : 'src/main/resources/data/axaData.xls', 'sheetName': 'Sheet1'}





