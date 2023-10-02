Feature: Home Page

@Gunjit
Scenario: The User is on Home page and click on get started button or dropdown option without login
 Given User is on homepage of DS Algo
 When User click on "Get started button" for the different option without login
 Then User should get error message
 
