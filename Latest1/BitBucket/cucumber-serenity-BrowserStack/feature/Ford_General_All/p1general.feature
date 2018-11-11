Feature: P1 General Test Scenarios

Background:
Given Open Chrome browser on P1General
 
#@P1 
#Scenario Outline: Verify latest version of JS
#   When Maximize browser and enter link "<JSLink>"
#   Then See the latest version of JS "<Version>"
#
#Examples:
#| JSLink | Version |
#| https://wwwint.brandap.ford.com/etc/designs/guxfoap/clientlibs/guxfoap.js | 20.1 |
#



@P1
Scenario Outline: P1 Model compare
	When Maximize browser and enter link "<FiestaPageUrl>"
	Then See all components on Fiesta page loaded without performance issue
	When Click on Model Compare button
	Then Verify user is taken to model compare page
	When Click on Active Compare button
	And Select up to 2 items on the list
	And Click on Compare button
	Then Click on select other models to compare button
	And Select any model from the list and unselect after that
	When Select any model
	And Click on Confirm button
	Then See the old model should be replaced with the new selected models
	When Click on Add Models To Compare button
	And Select a model and click on Cancel button
	Then See selected vehicle should not be added in comapre model page
	And Click on Add Models To Compare button
	When Select any model
	And Click on Confirm button
	Then See the old model should be replaced with the new selected models
	When Click on Back to Overview CTA
	And Click on Active Compare button
	And Select up to 3 items on the list
	And Click on Compare button
	Then Compare model result page should be displayed with selected model listed with details
Examples:
|FiestaPageUrl| 
|https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta.html|




@P1
Scenario Outline: P1 Showroom 
	When Maximize browser and enter link "<LandingPageUrl>"
	Then See all components on home page loaded without performance issue
	When Click on Main Nav "<VehicleMenuItemName>"
	And Click on tab in Vehicle "<TabName>" 
	Then Verify vehicle name in menu "<Vehicle1>"
	When Click on a model "<Vehicle1>"   
	
Examples:
| LandingPageUrl | VehicleMenuItemName | TabName | Vehicle1 | Vehicle2 | VehiclePageUrl | Vehicle2PageUrl |
| https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home.html | Vehicles | SUVs | Fiesta | Fiesta | https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/vehicles.html | https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta.html |


@P1
Scenario Outline: P1 Home page
	When Maximize browser and enter link "<HomePageUrl>"
	Then See all components on home page loaded without performance issue
	When Input position "<BlankData>" to Mini LAD and Search
	Then Appropriate validation message displayed
	When Input position "<InvalidData>" to Mini LAD and Search
	Then Appropriate validation message displayed
	When Input position "<PositionText>" to Mini LAD and Search
	Then Dealer should be searched and shown on the page
	When Click on "+"
	Then Dealer section should be expanded and dealers should be displayed
	When Click on "X"
	Then Dealer section should be compressed and First dealer should be shown
	When Click on "+"
	Then Dealer section should be expanded and dealers should be displayed
	
Examples:
|HomePageUrl|PositionText|SearchedPosition|BlankData|InvalidData|
|https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home.html|Manila|Ford Manila||InvalidData|



@P1
Scenario Outline: P1 Nameplate Page
	When Maximize browser and enter link "<FiestaPageUrl>"
	Then See all components on Fiesta page loaded without performance issue
	When Click on Main Nav "<VehicleMenuItemName>"
	And Search SubMenu link accros the Main Navigation link"<SubMenuItem>"
	When Click on Secondary menu switcher
	And Click on Secondary Menu "<GalleryItemName>"
	When Click on image on Gallery
	Then Verify overlay open from image Gallery
	When Click on View Details
	Then Verify seen Share and Download button
	When Click on Share
	Then See the sharing popup
	When Click on Download
	And Click to close overlay
	Then Verify 360 images
	When Click on Colorize tab
	Then Verify Image with Color is seen
	When Click on Black color to change
	Then Verify the color of image and title are changed
	When Click on Disclosure to Collapse
	Then Verify don't see Disclosure content 
	When Click on Disclosure
	Then Verify see Disclosure Content	

Examples:
| FiestaPageUrl | VehicleMenuItemName | SubMenuItem | MustangPageUrl | FiestaPageItemName | GalleryItemName | GalleryItemUrl |
| https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta.html | Vehicles | Mustang | https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/performance/mustang.html | Fiesta | Gallery | https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/performance/mustang/gallery.html |



@P1
Scenario Outline: P1 Locate a dealer at Philipines
	When Maximize browser and enter link "<HomeLandingPageUrl>"
	Then See all components on home page loaded without performance issue
	When Click on locate a dealer at the header
	Then See page redirected to link contains "<LocateADealerPage>"
	When Input text to Search Input and click Search "<Position>"
	Then Verify seen search result
	
Examples:
| HomeLandingPageUrl | LocateADealerPage | Position |
| https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home.html | locate-a-dealer.html | Manila |





@P1
Scenario Outline: P1 Locate a dealer at Australia
	When Maximize browser and enter link "<HomeLandingPageUrl>"
	And Input text to Search Input and click Search "<Position>"
	And Click on Submit on AU LAD
	Then Verify seen search result
	And Verify Delears details on Map
Examples:
| HomeLandingPageUrl | LocateADealerPage | Position |
| https://wwwint.brandap.ford.com/content/guxap-uat-demo/au1/en_au/home/shopping/locate-dealer.html | locate-dealer.html | Queensland Avenue, Broadbeach, Queensland |





@P1
Scenario Outline: P1 Engineering 
	When Maximize browser and enter link "<EngineeringPageUrl>"
	Then See all components on Engineering page loaded without performance issue
	When Click on boron steel in the engineering page
	When Go to the hotspot component and hover on the plus sign

Examples:
| EngineeringPageUrl | BoronSteelPageUrl |
| https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/engineering.html | https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/engineering/boron-steel.html |	



@P1
Scenario Outline: P1 Gallery
	When Maximize browser and enter link "<FiestaPageUrl>"
	Then See all components on Fiesta page loaded without performance issue
	When Click on Secondary menu switcher on Fiesta
	And Click on Secondary Menu "<GalleryItemName>"
	When Click on image on Gallery
	Then Verify overlay open from image
	When Click on Show Details
	Then Verify seen Share and Download button
	When Click on Share
	Then See the sharing popup
	And Click on Download
	When Click on the X button on the top left
	When Click on view more button
	Then Verify see more images
	When Click on Video
	Then see video is playing without error
Examples:
| FiestaPageUrl | GalleryItemName | GalleryItemUrl |
| https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta.html | Gallery | https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta/gallery.html |



@P1
Scenario Outline: P1 Accessories
	When Maximize browser and enter link "<FiestaPageUrl>"
	Then See all components on Fiesta page loaded without performance issue
	When Click on Secondary menu switcher on Fiesta
	And Click on Secondary Menu "<AccessoriesItemName>"
	When Click on image on Accessories
	Then Verify overlay open from image Accessories
	When Click on Show Details
	Then Verify seen Share and Download button
	When Click on Share
	Then See the sharing popup
	And Click on Download
	When Click on the X button on the top left

Examples:
| FiestaPageUrl | AccessoriesItemName | AccessoriesItemUrl |
| https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta.html | Accessories | https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta/accessories.html |


@P1
Scenario Outline: P1 News room
	When Maximize browser and enter link "<NewsRoomPageUrl>"
	Then See all components on News Room page loaded without performance issue
	When Click on any Article
	Then Article page should display
	When Click on Sort By
	Then Verify all months in filter
	When Click on Sort by October
	Then Verify message Results Found on page
	When Redirect to link "<NewsRoomPageUrl>"
	And Click on View More
	Then Verify seen more view
	When Click on Learn More

Examples:
| NewsRoomPageUrl | FirstDetailUrl |
| https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/about-ford/newsroom.html | https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/about-ford/newsroom.html |


@P1
Scenario: P1 Newsroom- Verification of search functionality
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/about-ford/newsroom.html"
	Then See all components in newsroom page
	When Input any word into Search field in newsroom page
	|ford| 
	Then See the searched word display in newsroom page
	|Ford|




@P1
Scenario: P1 Search functionality on Home page
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home.html#overlay/content/guxap-uat-demo/ph/en_ph/configuration/navigation-config/searchoverlay.html"
	And Input any word into Search field in newsroom page
	|fiesta| 
	Then See the searched word display in newsroom page
	|Fiesta|
	When Redirect to link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home.html#overlay/content/guxap-uat-demo/ph/en_ph/configuration/navigation-config/searchoverlay.html" on P1
	And Input any word into Search field in newsroom page
	|invalidsearch| 
	Then See the searched word display in newsroom page
	|No results for "invalidsearch"|



@P1
Scenario: P1 China Mini LAD
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn1/zh_cn/home.html"
	And Select province and city in China Mini LAD
	| 上海 |	上海	|
	And Click on Search button in China Mini LAD
	Then See dealer in China Mini LAD Map
	When Click on Dealer Details in China Mini LAD Map
	Then See Dealer Details expander in China Mini LAD Map 


@P1
Scenario: P1 China Main LAD
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn1/zh_cn/home/locate-a-dealer.html"
	And Select province and city in China Main LAD 
	| 安徽 |亳州|福特金牛座|
	And Click on Search button in China Main LAD
	Then See dealer in China Map
	When Click on Dealer Details in China Map
	Then See Dealer Details expander in China Map 

	

@P1
Scenario: P1 Model compare different nameplates
When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/in/en_in/home/demo/normal-market/compare-models-across-nameplates.html"
And Select 1 vehicle and model
|EcoSport|EcoSport_1.0l_Petrol_EcoBoost_Titanium__MT_FIN|
And click on Add Vehicle
Then see Model and detail are added successfully
|12345|996000|5|
###And Open 2nd and 3rd columns and see above selected model is not listed there
###|EcoSport|EcoSport_1.0l_Petrol_EcoBoost_Titanium__MT_FIN|
When Add 2 more models from different nameplates
|Aspire|Aspire_1.2l_Petrol_Trend_MT_FIN|Aspire|Aspire_1.2l_Petrol_Ambiente_MT_FIN|
Then see Model and detail are added successfully
|618600|5|557500|5|
When Scroll down profile page 1500
Then Model name & remove button should be sticky on the page top
When Click on Remove button for any model
Then Selected model should be removed


#@P1
#### Same scenario as above but data is different
##Scenario: P1 Model compare different nameplates
##When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/in/en_in/home/demo/normal-market/compare-models-across-nameplates.html"
##And see all vehicles and their models are listed respectively in selection boxes
##When Select 1 vehicle and model
##|EcoSport|Classic 1.6 Duratec LXi|
##And click on Add Vehicle
##Then see Model and detail are added successfully
##|12345|7|5|
##And Open 2nd and 3rd columns and see above selected model is not listed there
##|EcoSport|Classic 1.6 Duratec LXi|
##When Add 2 more models from different nameplates
##|Escape|1.2 Duratec Petrol EXI|Fiesta|1.5P Ambiente MT|
##Then see Model and detail are added successfully
##|2663000|7|6630000|4|
##When Scroll down profile page 1500
##Then Model name & remove button should be sticky on the page top
##When Click on Remove button for any model
##Then Selected model should be removed



@P1
Scenario: P1 Model details page
When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta/models/hatchback-trend-1-5l-ps.html"
Then see all the componets and CTAs are functioning
When Click on Back to Overview CTA
Then Model Compare page should be displayed
When Click on any model link CTA on Model Compare page
Then see user is taken to model details page
And see select other models to compare CTA is disabled
When Click on Add Models To Compare button
And Click on Hatchback Sport 1L Ecoboost PS checkbox
|Hatchback Sport+ 1.0L Ecoboost PS|
And Click on Confirm button on model compare	
When Click on select other models to compare CTA
And Click on Fiesta Ambiente checkbox
And Click on Confirm button on model compare
##When Click on Book a Test Drive CTA
##Then Test drive form should be opened




@P1
Scenario: P1 Sort By and drag n drop in refactored compare model page
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph-org/en_ph/home/demo/modelcomparenew.html"
	And Click on Active Compare button
	Then See Select all Models checkbox available above model display
	When check Select all the models
	Then All the models available for comparing should be checked
	When Select any value in Sort By dropdown list
	|Price (high first)|
	Then Models should be sorted based on the selected value in Sort By dropdown list "high first"
	When Select any value in Sort By dropdown list
	|Price (low first)|
	Then Models should be sorted based on the selected value in Sort By dropdown list "low first"
	When Click on Compare button
	Then Click on any vehicle and drag & drop and see Vehicle is reordered at desired drop position



@P1
Scenario: P1 Validate Compare Model result page
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph-org/en_ph/home/demo/modelcompareresultnew.html"
	And Click on Active Compare button
	And See Select all Models checkbox available above model display
	And check Select all the models
	And Click on Compare button
	Then Feature accordion should be hidden by default
	When Click on any feature accordion
	Then The accordion should anchor to the bottom of the section
	When Click on feature category dropdown filter
	Then Feature categories filter should contain all available features categories
	When Click on Feature category filter and select any value
	Then Model compare results should be filtered based on selected feature category
	When Click the checkbox Show difference only
	Then Features with difference among models must be displayed
	When Click on the X icon for any model on compare model result page
	Then The selected model should be removed using it
	When Click on Select other model button
	And Select any model
	And Click on Confirm button
	Then The selected model should be displayed


@P1
Scenario: P1 Test Drive Form
When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/vehicles.html#overlay/content/guxap-uat-demo/ph/en_ph/site-wide-content/overlays/forms/test-drive.html?captchaMark=1234&captchaMarkEncrypt=8U8ZdxsyiATvLaJ6eHIq4Q==&notToDB=true"
Then see all componets loads successfully without performance issue
When On overlay do not input anything and click on submit
Then Verify error message is seen
When On overlay enter an incorrect item on one of the fields and click submit
|Mr|TestFirstName|TestLastName|080817174330|0123456789|Cebu|Cebu|Ford Cebu|Fiesta|Sedan Trend 1.5L PS|0-3 Months|
Then Verify error message is seen
When On overlay enter all items correctly and click on submit
|Mr|TestFirstName|TestLastName|080817174330@mailinator.com|0123456789|Cebu|Cebu|Ford Cebu|Fiesta|Sedan Trend 1.5L PS|0-3 Months|
Then Verify thank you page is seen



@P1
Scenario: P1 Request a brochure
When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/vehicles.html#overlay/content/guxap-uat-demo/ph/en_ph/home/forms/request-a-brochure.html?captchaMark=1234&captchaMarkEncrypt=8U8ZdxsyiATvLaJ6eHIq4Q==&notToDB=true"
Then Verify brochure download overlay is seen
When Do not select any vehicle and click on Download button
Then see validation message is displayed
When Select a vehicle on brochure download overlay 
And click on Get By Email button
Then verify Email form is opened 
And  Fill all the details on Email form
|TestName|080817174330@mailinator.com|
When Click on submit email form
Then verify Thank you message
When Redirect to link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/vehicles.html#overlay/content/guxap-uat-demo/ph/en_ph/home/forms/request-a-brochure.html?captchaMark=1234&captchaMarkEncrypt=8U8ZdxsyiATvLaJ6eHIq4Q==&notToDB=true" on P1
Then Select a vehicle and click on download brochure button
And Verify PDF file is downloaded and thank you page is seen
|VN_Fiesta|



@P1
Scenario: P1 Fleet Registration Form
When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/vehicles.html#overlay/content/guxap-uat-demo/ph/en_ph/site-wide-content/overlays/forms/fleet-registration.html?captchaMark=1234&captchaMarkEncrypt=8U8ZdxsyiATvLaJ6eHIq4Q==&notToDB=true"
Then user is navigated to Ford Fleet Registration overlay
When On overlay do not input anything and click on submit
Then See validation message is displayed
When Enter an incorrect item on one of the fields and click submit
|Mr|TestFirstName|TestLastName|080817174330|0123456789|testbusinessname|0123456789|100|
Then Verify error message is seen
##When Click on Print button
##Then See print functionality is enabled and working successfully
When enter all items correctly and click on submit
|080817174330@mailinator.com|
Then Verify thank you page is seen



@P1
Scenario: P1 Keep Me Informed Form
When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ph/en_ph/home/cars/fiesta/accessories.html#overlay/content/guxap-uat-demo/ph/en_ph/site-wide-content/overlays/forms/kmi.html?captchaMark=1234&captchaMarkEncrypt=8U8ZdxsyiATvLaJ6eHIq4Q==&notToDB=true"
And On overlay do not input anything and click on submit
Then See validation message is displayed
When Enter an incorrect item on one of the fields and click submit kmi
|Mr|TestFirstName|TestLastName|080817174330|0123456789|1234|0-3 Months|
Then Verify error message is seen
When enter all items correctly and click on submit
|080817174330@mailinator.com|
Then Verify thank you page is seen


#@P1
#Scenario: P1 Verify the functionality is working fine with all the available coutry list - Saudi 
#When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/sau/en_sa/home/country-lang-selector.html" and check if link is broken



###################### PERF SANITY

#Scenario Outline:verify latest version of JS
#   When Maximize browser and enter link "<JSLink>"
#   Then See the latest version of JS "<Version>"
#
#Examples:
#| JSLink | Version |
#| https://wwwperf.brandap.ford.com/etc/designs/guxfoap/clientlibs/guxfoap.js | 18.7 |
#
#
#
###COMPLETED
####################################################################
##Scenario Key Page Function Check - Model compare 
#
#Scenario Outline: Key Page Function Check - Model compare
#	When Maximize browser and enter link "<FiestaPageUrl>"
##	Then See all components on Fiesta page loaded without performance issue
##	When Click on Model Compare button on PERF
#	When Click on Secondary menu switcher on Fiesta
#	And Click on Model compare
#	Then Verify user is taken to model compare page
#	When Click on Active Compare button
#	And Select up to 2 items on the list
#	And Click on Compare button
#	When Click on Add Models To Compare button
#	And Click on Hatchback Sport 1L Ecoboost PS checkbox
#	|Hatchback Trend 1.5L PS|
#	And Click on Confirm button	
#	When Click on select other models to compare button
#	And Click on Fiesta Ambiente checkbox
#	And Click on Confirm button
#	
#Examples:
#| FiestaPageUrl | 
#| https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/cars/fiesta.html |
##
##
#####COMPLETED 
######################################################################
####Scenario Key Page Function Check - Showroom 
##
#Scenario Outline:Key Page Function Check - Showroom 
#	When Maximize browser and enter link "<LandingPageUrl>"
##	Then See all components on home page loaded without performance issue
#	When Click on Main Nav "<VehicleMenuItemName>"
#	And Click on tab in Vehicle "<TabName>" 
#	Then Verify vehicle name in menu "<Vehicle1>"
#	When Click on a model "<Vehicle1>"   
#	
#Examples:
#| LandingPageUrl | VehicleMenuItemName | TabName | Vehicle1 | Vehicle2 | VehiclePageUrl | Vehicle2PageUrl |
#| https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home.html | Vehicles | Cars | Fiesta | Fiesta | https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/vehicles.html | https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/suvs/escape.html |
#
####COMPLETED - 
#####################################################################
###Scenario Key Page Function Check - Home page
#
#Scenario Outline:Key Page Function Check - Home page
#	When Maximize browser and enter link "<HomePageUrl>"
#	When Input position "<PositionText>" to Mini LAD and Search
#	And Click on LAD Expander button
#	Then See the first result "<SearchedPosition>" on Map
#	When Click on Dealer Detail
#	
#Examples:
#| HomePageUrl | PositionText | SearchedPosition | LocateDealerPageUrl |
#| https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home.html | Manila | Ford Manila | https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/locate-a-dealer.html?filters=HasSalesDepartmentPV&distance=10&intcmp=hp-return-lad#/search/manila/dealer/56387/|https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/locate-a-dealer.html?filters=HasSalesDepartmentPV&distance=10&intcmp=hp-return-lad#/search/Manila/dealer/56387/|



#
#
####COMPLETED 
#####################################################################
###Scenario Key Page Function Check - Nameplate Page
#
#Scenario Outline:Key Page Function Check - Nameplate Page
#	When Maximize browser and enter link "<FiestaPageUrl>"
#	When Click on Main Navigation "<VehicleMenuItemName>"
#	And Click on SubMenu Item "<SubMenuItem>"
#	When Click on model "<Vehicle1>"
#	When Click on Secondary menu switcher
#	And Click on Secondary Menu "<GalleryItemName>"
#	When Click on image on Gallery
#	Then Verify overlay open from image Gallery
#	When Click on View Details
#	Then Verify seen Share and Download button
#	When Click on Share
#	Then See the sharing popup
#	When Click on Download
#	And Click to close overlay
#	Then Verify 360 images
#	When Click on Colorize tab
#	Then Verify Image with Color is seen
#	When Click on Black color to change
#	Then Verify the color of image and title are changed
#	When Click on Disclosure to Collapse
#	Then Verify don't see Disclosure content 
#	When Click on Disclosure
#	Then Verify see Disclosure Content
#	
#
#Examples:
#| FiestaPageUrl | VehicleMenuItemName | SubMenuItem | MustangPageUrl | FiestaPageItemName | GalleryItemName | GalleryItemUrl |Vehicle1|
#| https://wwwperf.brandap.ford.com/content/ford/au/en_au/home/cars/fiesta.html | Vehicles | COMMERCIAL | https://wwwperf.brandap.ford.com/content/ford/au/en_au/home/cars/fiesta.html | Ranger | Gallery |https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/cars/fiesta/gallery.html|Ranger|
#
#
#### P
#####################################################################
###Scenario Key Page Function Check - Locate a dealer 
#
#Scenario Outline:Key Page Function Check - Locate a dealer 
#	When Maximize browser and enter link "<HomeLandingPageUrl>"
##	And Redirect to link "<HomeLandingPageUrl>"
#	Then See all components on home page loaded without performance issue
#	When Click on locate a dealer at the header
#	Then See page redirected to link contains "<LocateADealerPage>"
#	When Input text to Search Input and click Search "<Position>"
#	Then Verify seen search result
#	
#Examples:
#| HomeLandingPageUrl | LocateADealerPage | Position |
#| https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home.html | locate-a-dealer.html | Manila |
#
#
####
#####################################################################
###Scenario Key Page Function Check - Engineering 
#
#Scenario Outline:Key Page Function Check - Engineering 
#	When Maximize browser and enter link "<EngineeringPageUrl>"
##	And Redirect to link "<EngineeringPageUrl>"
#	Then See all components on Engineering page loaded without performance issue
#	When Click on boron steel in the engineering page
#	Then See page redirected to correct link "<BoronSteelPageUrl>"
#	When Go to the hotspot component and hover on the plus sign
#		
#	
#Examples:
#| EngineeringPageUrl | BoronSteelPageUrl |
#| https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/engineering.html | https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/engineering/boron-steel.html |	
#	
## P
###################################################################
##Scenario Key Page Function Check - Gallery
#
#Scenario Outline:Key Page Function Check - Gallery
#	When Maximize browser and enter link "<FiestaPageUrl>"
##	And Redirect to link "<FiestaPageUrl>"
#	Then See all components on Fiesta page loaded without performance issue
#	When Click on Secondary menu switcher on Fiesta
#	And Click on Secondary Menu "<GalleryItemName>"
#	When Click on image on Gallery
#	Then Verify overlay open from image
#	When Click on Show Details
#	Then Verify seen Share and Download button
#	When Click on Share
#	Then See the sharing popup
#	And Click on Download
#	When Click on the X button on the top left
#	When Click on view more button
#	Then Verify see more images
#	
#Examples:
#| FiestaPageUrl | GalleryItemName | GalleryItemUrl |
#| https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/cars/fiesta.html | Gallery | https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/cars/fiesta/gallery.html |
#
#
#### P
#####################################################################
###Scenario Key Page Function Check - Accessories
#
#Scenario Outline:Key Page Function Check - Accessories
#	When Maximize browser and enter link "<FiestaPageUrl>"
##	And Redirect to link "<FiestaPageUrl>"
#	Then See all components on Fiesta page loaded without performance issue
#	When Click on Secondary menu switcher on Fiesta
#	And Click on Secondary Menu "<AccessoriesItemName>"
#	Then See page redirected to correct link "<AccessoriesItemUrl>"
#	When Click on image on Accessories
#	Then Verify overlay open from image Accessories
#	When Click on Show Details
#	Then Verify seen Share and Download button
#	When Click on Share
#	Then See the sharing popup
#	And Click on Download
#	When Click on the X button on the top left
#
#Examples:
#| FiestaPageUrl | AccessoriesItemName | AccessoriesItemUrl |
#| https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/cars/fiesta.html | Accessories | https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/cars/fiesta/accessories.html |
#
#
### P
###################################################################
##Scenario Key Page Function Check - News room

#Scenario Outline:Key Page Function Check - News room
#	When Maximize browser and enter link "<NewsRoomPageUrl>"
##	And Redirect to link "<NewsRoomPageUrl>"
#	Then See all components on News Room page loaded without performance issue
#	When Click on Sort By
#	Then Verify all months in filter Perf
#	When Click on Sort by October
#	Then Verify message Results Found on page
#	When Redirect to link "<NewsRoomPageUrl>"
##	And Click on View More
##	Then Verify seen more view
#	When Click on Learn More
#	Then See page redirected to correct link "<FirstDetailUrl>"
#
#Examples:
#| NewsRoomPageUrl | FirstDetailUrl |
#| https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/about-ford/newsroom.html | https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/about-ford/newsroom/2015/the-15th-henry-ford-awards.html|https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/about-ford/newsroom.html |


## P
#Scenario: Verify search functionality is working fine
#	When Maximize browser and enter link "https://wwwperf.brandap.ford.com/content/ford/ph/en_ph/home/about-ford/newsroom.html"
#	Then See all components in newsroom page Perf
#	When Input any word into Search field in newsroom page
#	|	ford	| 
#	Then See the searched word display in newsroom page
#	|	Ford |

### P
#Scenario: Key Page Function Check - China Mini LAD
#	When Maximize browser and enter link "https://wwwperf.brandap.ford.com/content/ford/cn/zh_cn/home.html"
#	And Select province and city in China Mini LAD
#	| 上海 |	上海	|
#	And Click on Search button in China Mini LAD
#	Then See dealer in China Mini LAD Map
#	When Click on Dealer Details in China Mini LAD Map
#	Then See Dealer Details expander in China Mini LAD Map 
#
#
###### P
#Scenario: Key Page Function Check - China Main LAD
#	When Maximize browser and enter link "https://wwwperf.brandap.ford.com/content/ford/cn/zh_cn/home/locate-a-dealer.html"
#	And Select province and city in China Main LAD 
#	| 安徽 |亳州|全新福特福克斯|
#	And Click on Search button in China Main LAD
#	Then See dealer in China Map
#	When Click on Dealer Details in China Map
#	Then See Dealer Details expander in China Map 
#
#	
### P
#Scenario: Verify the functionality is working fine with all the available coutry list 
#	When Maximize browser and enter link "https://wwwperf.brandap.ford.com/content/ford/sau/en_sa/home/country-lang-selector.html" and check if link is broken



##Scenario: Verify the functionality is working fine with all the available coutry list in AU Predelivery
##	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/ford/au/en_au/home/predelivery.html" and check if link is broken
##	And Fill in step one in AU Predelivery
#
	