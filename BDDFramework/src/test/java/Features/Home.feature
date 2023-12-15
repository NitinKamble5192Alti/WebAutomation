Feature: "Application login"

  @tag
  Scenario Outline: verify login is successful with valid credentials
    Given navigate to home page
    When Click on navlink
    And user enters "<username>"
    And user clicks on continue
    When user enters password as "<password>"
    And user clicks on sign in
    Then verify user navigated to user home page

    Examples: 
      | username                  | password     |
      | krushnamasal999@gmail.com | Welcome@2023 |

  @tag
  Scenario Outline: Add item in cart and verify details
    Given User on home page
    When Click on search
    And the user searches for "<bookName1>"
    When Click on search submit
    And Click on first result
    And verifies details (Book name, author, length, publisher, reading age)
    When Click on add cart
    And Clik on nevigate back
    When Search book "<bookName2>"
    And Clicks on a random result
    Then Two books added in cart

    Examples: 
      | bookName1       | bookName2 |
      | One Habit a Day | You Can   |

  @tag
  Scenario: Checkout process
    Given User is on Home page
    When Clicks on cart for checkout
    And click on proceed to buy
    When Clicks on add new address
    And Enters first and last name "Dipak Sinkar" and enter mobile number "8765535663"
    And Enters pincode "431127" and flat no "building no 504" and area "Kolgaon"
    And Verify payment options are displayed
    When clicks on the Amazon.in icon
    And clicks on the Cart option
    And Verify both items are present in cart
    Then Two items availeble in Cart
