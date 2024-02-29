Feature: GET - All Users


 @getusers
 Scenario Outline: Check authorized user able to get all the Users with Valid URL and valid endpoint
    Given User makes GET request to <endpoint>
	Then Response is <statuscode>
 
	Examples: 
		| endpoint | statuscode |
		| /users   |  200       |
  
 
 @getusers
 Scenario Outline: Check authorized user make call to get all the Users with Valid URL and invalid endpoint
    Given User makes GET request to <endpoint>
	Then Response is <statuscode>
 
	Examples: 
		| endpoint   | statuscode |
		| /invalid   | 404        |
		

@getusers
 Scenario Outline: Check unauthorized user able to get all the Users with Valid URL and invalid endpoint
    Given Unauthorized user makes GET request to <endpoint>
	Then Response is <statuscode>
 
	Examples: 
		| endpoint   | statuscode |
		| /users     | 401        |
