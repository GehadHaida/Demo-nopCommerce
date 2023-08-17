@smoke
Feature: F08_WshList | users could add items to the wishlist

  Scenario: user add item to the wishlist
    When user click on the wishlist button on a product
    Then verify success message is displayed

  Scenario: user add item to the wishlist
    When user click on the wishlist button on a product
    Then user wait until the green success message disappear
    And  verify if the wishlist quantity value is more than 0