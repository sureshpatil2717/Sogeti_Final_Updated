Feature: To verify the Backed Apis of sogeti Application  

  Scenario Outline: API Data Driven Test for http://api.zippopotam.us/{country}/{postal-code}
    Given I Api with url <http://api.zippopotam.us/<Country>/<postalcode>
    Then I verify resonse code is <Responsecode>
    Then I verify ContentType is <ContentType>
    Then I verify ResponseTime 
    Then I verify the <PlaceName> in step
    Examples: 
      |Country|postalcode|PlaceName|Responsecode|ContentType|
      |us|90210|Beverly Hills|200|application/json|
      |us|12345|Schenectady|200|application/json|
      |ca|B2R|Waverley|200|application/json|
 
 	  Scenario: Api to test http://api.zippopotam.us/de/bw/stuttgart
 	   Given I have url apizippop
 	   Then I verify resonse code 
     Then I verify ContentType ContentType as applicationjson
     Then I verify ResponseTime in seconds 
 		 Then I verify That country is Germany and state is BadenWurttemberg
     Then I Verify Post Code  the place name has Stuttgart Degerloch
 	   
 	