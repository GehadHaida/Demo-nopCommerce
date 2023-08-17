@smoke
Feature: F05_hoverCategories | select sub element category from a main category

  Scenario: hover over computers and select notebooks from it
    When user hover over computers
    Then  user select random subcategory | verify if subtitle and page main title matches
