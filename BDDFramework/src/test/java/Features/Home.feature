 Feature: "Add product to cart "

    @tag
    Scenario: verify login is successful with valid credentials
      Given navigate to home page
      When  Click on navlink
      When user enters as "mshirodkar53@gmail.com"
      And user clicks on continue
      And user enters "Welcome@2024"
      And user clicks on sign in
      Then  verify user navigated to user home page

    @tag
    Scenario Outline: Search for product and add product to cart and verify product details.
      When user searches for "<bookName>"
      And clicks on search button
      And Clicks on first search result "<bookName>"
      Then new window should opened and Verify product details
      And clicks on add to cart
      Then Navigate Back to Main window
      Examples:
        | bookName|
        | One Habit a Day  |
        | you can |

    @tag
    Scenario: Click Proceed to buy Add address, verify user land on checkout page and payment option is visible and return back to cart.
      When user click on cart button on home page
      And clicks on Proceed to buy button
      And clicks Add new Address link
      Then user should enter details "Test Data" "9120192029" 431003 "03,N-7 Cidco" and click Use this address button
      And Payment method options should be displayed
      And user clicks on Amazon.in and further clicks on Return to cart button
      Then Verify user lands on cart page with both items added in cart.




   
  
      
      
    
      
      
      
      
      
   
      
     
      
      