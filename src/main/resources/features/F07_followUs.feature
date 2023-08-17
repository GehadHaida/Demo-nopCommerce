@smoke
Feature: F07_followUs | users could open followUs links

  Scenario: user opens facebook link
    When user click facebook link
    Then facebook is opened in new tab

    Scenario:  user opens twitter link
      When  user click twitter link
      Then Twitter is opened in new tab

  Scenario:  user opens rss link
    When  user click rss link
    Then rss is opened in new tab

  Scenario:  user opens youtube link
    When  user click youtube link
    Then youtube is opened in new tab