Feature: P3 General Test Scenarios

@P3
Scenario: P3 Service Price Calculator
	Given Open chrome browser
	When Maximize browser and enter link "https://wwwdev.brandap.ford.com/content/guxap-uat-demo/au2/en_au/home/service-price-calculator.html" in P3 Ford
	Then See all components in service price calculator page in P3 Ford
	When Select values in all the drop downs in P3 Ford
	Then See all information after selecting values in all the drop downs in P3 Ford
	When Input into Estimated Kilometres to date and select First Registration Date in P3 Ford
	|40000|
	And Click on Calculate button in P3 Ford
	Then See all Kilometers and Service number section highlighted accordingly in P3 Ford
	| 30,000 | 2 | 45,000 | 3 | 60,000 | 4 | 
	When Click on highlighted Kilometers and Service number in P3 Ford 
	|30,000|
	Then See all components on Payment Details in P3 Ford
	When Select up to 3 items on Additional Service Items in P3 Ford Chrome
	Then Verify Total Service Price is updated correctly in P3 Ford
	|	1,095	| //div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[4]/ul/li/div[2]/div/ul/li[9]/span[@class='price ng-binding'] |
	When Click on View and Print PDF in P3 Ford
	
	
	

@P3
Scenario: P3 Hot Deals Page
Given Open chrome browser
When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ar/en_ar/home/offers/Offers.html" in P3 Ford
And Click on Detalhes da Oferta for first vehicle
Then See all components loaded correctly in Offer Details page in P3 Ford
| KBB Official Guide | J.D. Power | Best Resale Value |
		



@P3
Scenario: P3 Latest Offers 
 Given Open chrome browser
 When Maximize browser and enter link "https://wwwdev.brandap.ford.com/content/ford/au/en_au/home/latest-offers.html" in P3 Ford
 When Input wrong postcode into postcode field and verify validation message displayed in P3 Ford
 | 0123 | There is no region for your postcode.|
 And Input correct postcode into postcode field in P3 Ford
 | 2055 | 
## Then Verify all the vehicles have details about model year details of offers available in P3 Ford
 When Redirect to link "https://wwwdev.brandap.ford.com/content/ford/au/en_au/home/latest-offers.html" in P3 Ford
 When Click on Sort by in Latest Offer page in P3 Ford
 | Price Low To High | 
## Then See the ascending sorting option in P3 Ford 
 And Click on the filters on the left pane of the page in P3 Ford
 | CAR | 
## Then See all the filters are behaving correctly in P3 Ford
 And Click on any offer in P3 Ford
 | Fiesta Ambiente |
## Then See all components in offer details page load correctly in P3 Ford
## | Fiesta Ambiente | 2055 | $15,997 | Fuel efficient 1.5L petrol engine with manual transmission (5.8L/100km) | Ford SYNC&reg; connectivity system | Bluetooth&reg; with Voice Control# | iPod and USB integration | Cruise Control| Power Windows | 7 Airbags | 
When Click on General Features
Then see all general features display correctly
|Ford SYNC|5-Star ANCAP Safety Rating|Always in style|
When Click on Fiesta Ambiente
Then see all Fiesta Ambiente features display correctly
|USB and iPod^ Integration|Cruise Control|MyKey|




#@P3-test
#Scenario: P3 More Offers Section - Vehicle Configuration Page
#Given Open chrome browser on P2
#When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" in P3 Ford
#And Click on Build and Price on P2
#And verify Cancel button exist
#And Input into Postcode field on POLK on P2
#|4000|
#And Click on Submit button on POLK Build and Price on P2
#And Select a Vehicle
#|Mondeo|	
#Then It navigate you on the latest offers page
#And B&P configuration should show the vehicle models of selected nameplate that has laters offers
#When Click on Latest offer button on B&P config page
#Then User directed to the respective configuration page of B&P More Offers Section
#When Redirect to link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" in P3 Ford
#And Click on Build and Price on P2
#And Select a Vehicle
#|Fiesta|	
#Then B&P configuration page shows all the vehicle models that has laters offers




@P3-test
Scenario: P3 Pre Delivery 
	Given Open chrome browser
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au1/en_au/home/predelivery.html?captchaMark=1234&captchaMarkEncrypt=8U8ZdxsyiATvLaJ6eHIq4Q==&notToDB=true" in P3 Ford
  When Fill in Pre Delivery form in P3 Ford
  |	Mr | TestFirstName | TestLastName | 080817174330@mailinator.com | 0916834845 | DenLu | Hanoi | 2055 | ACT | Focus ST | Focus ST Hatch| Frozen White | JH3SCV6U967402221 | Aberlines Ford |NSW|
  And Click on Next button in Pre Delivery form in P3 Ford
  Then See all records in Pre Delivery page in P3 Ford
  |	 Focus ST | Focus ST Hatch | Frozen White | JH3SCV6U967402221 | Aberlines Ford (West Wyalong) / 36600 | YOUR NEW FORD | MODEL | SERIES | COLOUR | VIN | DEALER | Step 1 | Basics of your Ford | Step 2 | Key features of your Ford | Step 3 | Other features of your Ford | Step 4 | Personalise your Ford |
  When Click on Save and Continue button in Pre Delivery page in P3 Ford
  Then Verify message is successfully saved in Pre Delivery page in P3 Ford
  | YOUR CURRENT PROGRESS HAS BEEN SUCCESSFULLY SAVED, AN EMAIL HAS BEEN SENT TO YOUR EMAIL ADDRESS WITH A LINK TO GET BACK TO THIS SECTION. |
  And Click on Step 4 in Pre Delivery page in P3 Ford
  Then See Personalise your Ford form in Pre Delivery page in P3 Ford
  | MOBILE PHONE | ADD YOUR FAVOURITE STATIONS | SATNAV SETTINGS |CLIMATE CONTROL | TIME FORMAT | DRIVER SEAT POSITION | AUTOMATIC HEADLIGHTS | AMBIENT LIGHTING | CUSTOMER NOTES |
  When Click on Next button in Personalise for pick up section in P3 Ford
  Then See all records after hitting Next in Step 4 in P3 Ford
  |	 Focus ST | Focus ST Hatch | Frozen White | JH3SCV6U967402221 | Aberlines Ford (West Wyalong) / 36600 | YOUR NEW FORD | MODEL | SERIES | COLOUR | VIN | DEALER | YOUR DETAILS | NAME | Mr TestFirstName TestLastName | EMAIL | 080817174330@mailinator.com | PHONE | 0916834845 | ADDRESS | DenLu | SUBURB | Hanoi | 2055 | STATE | ACT | YOUR PERSONALISED ITEMS | CLIMATE CONTROL | 22 Degrees | TIME FORMAT | 24-HOUR | DRIVER SEAT POSITION | MEDIUM |
  When Click on View Summary as PDF in Summary page in P3 Ford
  And Input into captcha field in Summary page in P3 Ford
  | ABCD | 
  And Click on Submit To Dealer in Summary page in P3 Ford
  Then See Confirmation page displayed in P3 Ford
  |	Ford Australia - Ford Orientation Guide | Confirmation | TO DO LIST | Bring your mobile phone when you pick up your vehicle | Check your | Download the Ford Owners app for | Register for |
  When Redirect to third party new link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=080817174330" on P2 
  And Click on Email on MailInator page
  When Verify Ford Delivery Checklist mail    