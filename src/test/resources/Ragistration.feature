Feature: Registration Feature

  @Regi
  Scenario:Successful Registration

    Given I am on home page
    When I click on "My Account" button
    And I select "Register" button
    Then I Should see "Register Account" text on "Register" page
    And I enter following detail for registration
      | firstName | lastName | email           | telephone  | password | confirmPassword |
      | Samit     | Kotadia  | samit@gmail.com | 1234567891 | 123456   | 123456          |
    And I select "Yes" button for newsletter
    And I agree on Privacy Policy on register page
    Then I click on Continue button
    And I Should see "Your Account Has Been Created!" text on "Successful Register Page" page
    And I click on Continue button after Successful register

