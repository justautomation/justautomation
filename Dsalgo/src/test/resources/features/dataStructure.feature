Feature:
User navigate to Data Structure introduction Page for selected Topics covered and click on Try Here button 

@ds 
Scenario Outline:
User navigate to Data Structure introduction Page for selected Topics covered and click on Try Here button 
	Given The user is on signin page
  When The user enter sheet "<Sheetname>" and <RowNumber>
  And  click login button
	Then User click Get Started button for Data Structure Introduction card
  Then User should redirected to Data Structure Introduction page 
  When User click Try Here button in the Data Structure Introduction page
  Then User should be redirected to try Text Editor page
	
	
	Examples: 
		| Sheetname | RowNumber |
		| Sheet1    |         3 |
		
