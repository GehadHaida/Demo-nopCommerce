@smoke
Feature: F03_currencies | Check the currency of the products after using the dropdown menu

  Scenario: user change the currency of the homepage products

    When user select euro sign from the dropdown menu
    Then all 4 products switch to euro sign
