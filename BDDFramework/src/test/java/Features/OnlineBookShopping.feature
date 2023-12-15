Feature: "Add product to cart "

  @tag
  Scenario: verify login is successful with valid credentials
    Given navigate to home page
    When Click on navlink
    When user enters "assuregaonkar@gmail.com"
    And user clicks on continue
    And user mention "Janavi@2001"
    And user clicks on sign in
    Then verify user navigated to user home page

  @tag
  Scenario Outline: Search for product and add product to cart and verify product details.
    When user searches for "<bookName>"
    And Clicks on first search result
    Then new window should opened and Verify product details
    And clicks on add to cart
    And clicks on proceed to buy
    And clicks on address
    Then Navigate Back to Main window

    Examples: 
      | bookName        |
      | One Habit a Day |
      | You can         |
