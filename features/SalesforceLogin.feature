
Feature: List of scenarios.
Scenario: SalesForce Project.

  Scenario:Login scenario with valid username and password
    Given User launch the application
    Given User is on "LoginPage"
    Then User enter into the username "parimala@google.com"
    Then User enter into the password "Test1234"
    Then User click on Button "loginbutton"
    
  Scenario:Login scenario with invalid username and invalid password
    Given User launch the application
    Given User is on "LoginPage"
    Then User enter into the username "parimala@google.com"
    Then User enter into the password "Tes1234"
    Then User click on Button "loginbutton"
    Then verify the text "error message" "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
Scenario:Login scenario with valid username and invalid password
    Given User launch the application
    Given User is on "LoginPage"
    Then User enter into the username "parimala@google.com"
    Then User enter into the password ""
    Then User click on Button "loginbutton"
    Then verify the text "error message" "Please enter your password."
 Scenario:verify checkrememberme
    Given User launch the application
    Given User is on "LoginPage"
    Then User enter into the username "parimala@google.com"
    Then User enter into the password "Test1234"
    Then user click on button1 "checkRememberme"
    Then User click on Button "loginbutton"
    Then user click on "usermenudropDown"
    Then User click on logoutButton "logout"
    Then User check the username "parimala@google.com"
    Then verify the checkbox is selected 
  Scenario:verify MenuDropDown   
  Given User launch the application
    Given User is on "LoginPage"
    Then User enter into the username "parimala@google.com"
    Then User enter into the password "Test1234"
    Then User click on Button "loginbutton"
     Then verify the"DropDownNameIsMatching"
	  Then user click on "usermenudropDown"
	  Then verify the"usermenuItem"
 Scenario:Login scenario for select Developer console
    Given User launch the application
    Given User is on "LoginPage"
    Then User enter into the username "parimala@google.com"
    Then User enter into the password "Test1234"
    Then User click on Button "loginbutton"
    Then user click on "usermenudropDown"
    And User clicks on "Developer Console" in the dropdown
    Then Developer Console should be opened "Developer Console"
	
    
    
       