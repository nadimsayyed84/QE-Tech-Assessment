Feature: Test Scenarios for BGP -> My Grant -> New Application


Scenario Outline: Verify application for Get new grant
Given Launch application url "https://<User>:<Password>@<Url>"
But Login using predefined BGP user <Predefined-User>
Then Select <Applications>
And Sector <Sector> and Sub-sector <Sub-Sector>
And Select <Grant-for>
And Select <Area-of-Development>
When Click "Apply"
Then Click "Proceed"
Examples:
|Url|User|Password|Predefined-User|Applications|Sector|Sub-Sector|Grant-for|Area-of-Development|
|bgp-qa.gds-gov.tech|public|Let$BeC001|S9333333A|Get new grant|Building & Construction|Builders (Contractors)|Upgrade key business areas|Pre-scoped Productivity Solutions|



Scenario: AC 1-1 Verify Next button and Side menus disabled for given Ques -> no answer selected
Given "Does the applicant meet the eligibility criteria" question is visible to answer
When No answer is selected
Then Next button is "disabled"
And All side menus are "disabled"
But Eligibility Menu is enabled



Scenario: AC 1-2 Verify Next button and Side menus enabled for given Ques -> answer selected as Yes
Given "Does the applicant meet the eligibility criteria" question is visible to answer
When Answer is selected as "Yes"
Then Next button is "enabled"
And All side menus are "enabled"
And User is allowed to navigate through side menus



Scenario: AC 1-3 Verify warning message on selection of 'No' answer for given Ques
Given "Does the applicant meet the eligibility criteria" question is visible to answer
When Answer is selected as "No"
Then Next button is "disabled"
And All side menus are "disabled"
And See below warning message triggers "Visit Smart Advisor on the SME Portal for more information on other government assistance."



Scenario: AC 1-4 Verify Navigation on Smart Advisor link and Target Url should open in same window Tab
Given "Does the applicant meet the eligibility criteria" question is visible to answer
When Answer is selected as "No"
Then Click on Smart Advisor link and Check Target website launched on the same windows tab "https://www.smeportal.sg/content/smeportal/en/moneymatters.html"