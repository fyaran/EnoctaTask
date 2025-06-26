#Author: furkan.yaran@outlook.com


Feature: n11 adding products to shopping cart functionality

  @enocta
  Scenario: n11 searh for a phone
 	  When Go to login page
    And I enter valid username
    And I enter valid password
    Then I click the login button
 	  When I click the search button and write cell phone
    And I filter the price as 15000 - 20000 TL
    And I choose the phone
    And I go to details of the phone and choose the seller
    Then I add the shopping cart and check it



