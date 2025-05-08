@login
Feature: Login Functionality
 To login to automationpractice application

@validLogin
Scenario: Login With Valid Credentials
	 
Given User navigates to the Application Login page
And  User enters valid username and password
When  User click on submit button
Then  User loged in sucessfully

@validLoginTestData
Scenario Outline: Login With Valid Credentials

#Given User opens the <browserName> browser 
Given User navigates to the Application Login page
And  User enters valid username <username> and password <password>
When  User click on submit button
Then  User loged in sucessfully
Examples:
|browserName|username             |password|
|edge|gawedo3803@lxheir.com|Password|

	
@invalidLogin
Scenario: Login With InValid Credentials
	 
Given User navigates to the Application Login page
Then  User enters invalid username and password
When User click on submit button
Then User should get the invalid login message

@invalidUaserNameLogin
Scenario: Login With InValid username with valid password

	 
Given User navigates to the Application Login page
Then  User enters invalid username and valid password
When User click on submit button
Then User should get the invalid login message

@invalidPasswordLogin
Scenario: Login With Valid username with Invalid password
	 
Given User navigates to the Application Login page
Then  User enters invalid username and valid password
When User click on submit button
Then User should get the invalid login message

   
 @NoCredentials
Scenario: Login Without Credentials
	 
Given User navigates to the Application Login page
Then  User did not enter username and password
When User click on submit button
Then User should get the invalid login message
   