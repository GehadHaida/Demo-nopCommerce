@smoke
Feature: F04_Search | user search product by name | product code

  Scenario Outline: user could search using the product name.
    When user search using product <productName>
    And  user clicks search
    Then user could find results
    And user could find <productName> relative results
    Examples:
      | productName |
      | book |
      | laptop |
      | nike |

  Scenario Outline: user could search for products using sku.
    When user uses product SKU to search <sku>
    And  user clicks search
    And user click on the product in search result
    Then  user could find <sku> contains the sku in search
    Examples:
      | sku |
      | SCI_FAITH |
      | LT_MIR_DC |
      | SF_PRO_11 |