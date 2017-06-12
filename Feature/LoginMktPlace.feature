Feature: Login MktPlace

Scenario: Successful Login with Valid Credentials2
	Given User is on Home Page2
	When User Navigate to LogIn Page2
	And User enters UserName and Password2
	Then Message displayed Login Successfully2
	When User LogOut from the Application2
	Then Message displayed Logout Successfully2