Feature: P2 General Test Scenarios - Owner VN/CN, B&P and Credit


################################# SIT Node


@P2-NonJenkinsSc
Scenario: P2 Verify New Owner Registration for VIETNAM 
	Given Open chrome browser on P2 
	And Generate unique string 
	When Maximize browser and enter link "https://www.mailinator.com/" on P2 
	And Input email to inbox field 
		| 18062017155002 | 
	And Click on Go button 
	When Redirect to link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/HomePage-unauthenticated.html" on P2 
	And Click on Login link on P2 
	And See the Login overlay on P2 
	And Click on Register link on Login overlay on P2 
	Then See the Register overlay on P2 
	When Enter credentials to register on P2 
		|Name062017155002|Test12345|Test12345|18062017155002@mailinator.com|FirstName|Lastname|
	And Click on Next button on P2 
	And Select vehicle credentials on P2 
		|New EcoSport|RL04TBBAMFSR05380|
	And Click on Next button on P2 
	And Fill in Vehicle Info credentials on P2 
		|Mr|NickName|An Giang|12345|0916834845|0123456789|ABCDEF| 
	And Click on Register button on P2 
	And Click on Close button on P2 
	When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2 
	And Click on Activation Email on MailInator page on P2 
	When Click on Activate My Account link in activation mail on P2 
	Then Registration Success message is displayed


@P2
Scenario: P2 Verify Forgot Username and Forgot Password on Owner Login page for VIETNAM 
	Given Open chrome browser on P2 
	When Redirect to link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/HomePage-unauthenticated.html" on P2 
	And Click on Login link on P2 
	And See the Login overlay on P2
	And Click on Login button on P2
	Then Mandatory exceptions displayed for username and password
	|Username is mandatory|Password is mandatory|  
	Then Click on Forgot your username
	When See forgot overlay opened
	Then Enter email id
	||
	When click on Submit button
	Then Successful message displayed
    When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2
   	And Click on Forgot username Email on MailInator page
    Then Verify Username name in Forgot username Email
	||
	When Redirect to link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/HomePage-unauthenticated.html" on P2 
	And Click on Login link on P2 
	And See the Login overlay on P2
	Then Click on Forgot your Password
	When See forgot overlay opened
	Then Enter email id and Username
	|||
	When click on Submit button
	Then Successful message displayed
    When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2
   	And Click on Forgot username Email on MailInator page
   	And Click on Password reset
    Then See Reset Password Overlay opened
    When Enter New password and confirm password
    |Test1234567|
    And click on Submit button
    Then Successful message displayed
	


@P2-NonJenkinsSc
Scenario: P2 Verify loading page for Owner for VIETNAM - Login using New User 
	Given Open chrome browser on P2 
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/HomePage-unauthenticated.html" on P2 
	And Click on Login link on P2 
	And See the Login overlay on P2 
	When Enter credentials to login on P2 
		||Test1234567|
	And Click on Login button on P2 
	And Click on My Profile link on P2 
	And See VehicleName and Vincode on Profile overlay on P2 
		|New EcoSport|//*[@id='tabs-0'] |RL04TBBAMFSR05380| //*[@id='sticky-header']/table[3]/thead/tr/td[2]/span/span |
	And Click on Account Info tab on Profile overlay on P2 
	And See all account information in Account Info tab on Profile overlay on P2 
		||//*[@id='userName'] |FirstName|//*[@id='firstName'] | Lastname|//*[@id='lastName'] ||//*[@id='email'] |Mr|//*[@id='title'] |An Giang|//*[@id='state'] |12345|//*[@id='postCode'] ||//*[@id='mobileNumber'] ||//*[@id='workphoneNumber'] |NickName|//*[@id='nickName']|
	And Click on Add Vehicle on Profile overlay on P2 
	Then See that Add vehicle form is displayed on Add Vehicle tab on P2 Production 
	When Add vehicle with Vehicle name and Vincode on P2 Production 
		|New Fiesta|RL05DFBAMFMR09354|
	When Click on Confirm to Add Vehicle on P2 
	Then See the first vehicle tab name on P2 
	And See the second vehicle tab name on P2 
	When Click on second vehicle tab on P2 
	Then Verify second vehicle tab is loaded correctly on P2 
	When Click on first vehicle tab on P2 
	Then Verify first vehicle tab is loaded correctly on P2 
	When Click on second vehicle tab on P2 
	Then Verify second vehicle tab is loaded correctly on P2 
	When Click on Delete Vehicle on P2 
	Then See delete vehicle confirmation overlay 
	And Click on Confirm to Delete Vehicle on P2 
	And Do not See Vehicle tab name on P2 
		|New Fiesta|
	When Click on My Profile link on P2  
	And Click on Account Info tab on Profile overlay on P2 
	And See all account information in Account Info tab on Profile overlay on P2
		||//*[@id='userName'] |FirstName|//*[@id='firstName'] | Lastname|//*[@id='lastName'] ||//*[@id='email'] |Mr|//*[@id='title'] |An Giang|//*[@id='state'] |12345|//*[@id='postCode'] ||//*[@id='mobileNumber'] ||//*[@id='workphoneNumber'] |NickName|//*[@id='nickName']|
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		||
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		||
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test123456|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test1234567|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test123456|	
	And Click on first vehicle tab on P2 
	Then Verify first vehicle tab is loaded correctly on P2 
#	When Click on Update New Version link on Profile overlay on P2 
#	And See Your download is ready overlay on P2 
#	When Click on OK button on your download is ready overlay on P2 
#	When Click on Download Now link on Profile overlay on P2 
#	Then Close the SYNC overlay on P2 
#	When Click on Download Now link on Profile overlay on P2 
#	Then See page redirected to correct link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/myprofile.html#overlay/content/guxap-sit-demo/vn/en_vn/site-wide-content/overlays/form-overlays/owner-download-manual-overlay.html" on P2 
#	And See all components on Owner Download Manual overlay on P2 
#	When Redirect to Download Owner Manual PDF on P2 
 	And Logout China Owner
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/HomePage-unauthenticated.html" on P2 
	And Click on Login link on P2 
	And See the Login overlay on P2 
	When Enter credentials to login on P2 
		||Test123456|
	And Click on Login button on P2 
	And Click on My Profile link on P2 	
 	Then Logout China Owner



@P2
Scenario: P2 Verify loading page for Owner for VIETNAM - Login using existing User
Given Open chrome browser on P2 
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/HomePage-unauthenticated.html" on P2 
	And Click on Login link on P2 
	And See the Login overlay on P2 
	When Enter credentials to login on P2 
		|121017121847|Test1234567|
	And Click on Login button on P2 
	And Click on My Profile link on P2 
	And See VehicleName and Vincode on Profile overlay on P2 
		|New EcoSport|//*[@id='tabs-0'] |RL04TBBAMFSR05380| //*[@id='sticky-header']/table[3]/thead/tr/td[2]/span/span |
	And Click on Account Info tab on Profile overlay on P2 
	And See all account information in Account Info tab on Profile overlay on P2 
		|121017121847|//*[@id='userName'] |FirstName|//*[@id='firstName'] | Lastname|//*[@id='lastName'] |121017121847@mailinator.com|//*[@id='email'] |Mr|//*[@id='title'] |An Giang|//*[@id='state'] |12345|//*[@id='postCode'] |01210171218|//*[@id='mobileNumber'] |01210171218|//*[@id='workphoneNumber'] |NickName|//*[@id='nickName']|
	And Click on Add Vehicle on Profile overlay on P2 
	Then See that Add vehicle form is displayed on Add Vehicle tab on P2 Production 
	When Add vehicle with Vehicle name and Vincode on P2 Production 
		|New Fiesta|RL05DFBAMFMR09354|
	When Click on Confirm to Add Vehicle on P2 
	Then See the first vehicle tab name on P2 
	And See the second vehicle tab name on P2 
	When Click on second vehicle tab on P2 
	Then Verify second vehicle tab is loaded correctly on P2 
	When Click on first vehicle tab on P2 
	Then Verify first vehicle tab is loaded correctly on P2 
	When Click on second vehicle tab on P2 
	Then Verify second vehicle tab is loaded correctly on P2 
	When Click on Delete Vehicle on P2 
	Then See delete vehicle confirmation overlay 
	And Click on Confirm to Delete Vehicle on P2 
	And Do not See Vehicle tab name on P2 
		|New Fiesta|
	When Click on My Profile link on P2  
	And Click on Account Info tab on Profile overlay on P2 
	And See all account information in Account Info tab on Profile overlay on P2 
		|121017121847|//*[@id='userName'] |FirstName|//*[@id='firstName'] | Lastname|//*[@id='lastName'] |121017121847@mailinator.com|//*[@id='email'] |Mr|//*[@id='title'] |An Giang|//*[@id='state'] |12345|//*[@id='postCode'] |01210171218|//*[@id='mobileNumber'] |01210171218|//*[@id='workphoneNumber'] |NickName|//*[@id='nickName']|
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		|1210171218470@mailinator.com|
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		|121017121847@mailinator.com|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test123456|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test1234567|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test123456|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test1234567|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test1234567|	
	And Click on first vehicle tab on P2 
	Then Verify first vehicle tab is loaded correctly on P2 
#	When Click on Update New Version link on Profile overlay on P2 
#	And See Your download is ready overlay on P2 
#	When Click on OK button on your download is ready overlay on P2 
#	When Click on Download Now link on Profile overlay on P2 
#	Then Close the SYNC overlay on P2 
#	When Click on Download Now link on Profile overlay on P2 
#	Then See page redirected to correct link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/myprofile.html#overlay/content/guxap-sit-demo/vn/en_vn/site-wide-content/overlays/form-overlays/owner-download-manual-overlay.html" on P2 
#	And See all components on Owner Download Manual overlay on P2 
#	When Redirect to Download Owner Manual PDF on P2


 
@P2-NonJenkinsSc
Scenario: P2 Verify Owner Registration for CHINA 
	Given Open chrome browser on P2 
	And Generate unique string 
	When Maximize browser and enter link "https://www.mailinator.com/" on P2 
	And Input email to inbox field 
		|| 
	And Click on Go button 
	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2 
	And Click on Register link on Login overlay on P2 
	Then See the Register overlay on P2 
	When Enter credentials to register on China P2 
		|Name062017155002|Test12345|Test12345|18062017155002@mailinator.com|FirstName|Lastname|先生|
	And Click on Next button on P2 
	And Select vehicle credentials on P2 
		|New EcoSport|1FA6P8TH1F5421281|
	And Click on Next button on P2 
	And Fill in Vehicle Info credentials on china P2 
		|安徽|12345|12122121110|TestName|An Giang|0123456789|ABCDEF| 
	And Click on Register button on P2 
	And Click on Close button on P2 
	When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2 
	And Click on Activation Email on MailInator page on P2 
	When Click on Activate My Account link in activation mail on P2 
	Then Registration Success message is displayed
 



@P2-NonJenkinsSc
Scenario: P2 Verify Forgot Username and Forgot Password of New Owner for CHINA
	Given Open chrome browser on P2 
	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2 
	And Click on Login button on P2
	Then Mandatory exceptions displayed for username and password
	|Username is mandatory|Password is mandatory|  
	Then Click on Forgot your username
	When See forgot overlay opened
	Then Enter email id
	||
	When click on Submit button
	Then Successful message displayed
    When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2
   	And Click on Forgot username Email on MailInator page
    Then Verify Username name in Forgot username Email
	||
	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2
	Then Click on Forgot your Password
	When See forgot overlay opened
	Then Enter email id and Username
	|||
	When click on Submit button
	Then Successful message displayed
    When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2
   	And Click on Forgot username Email on MailInator page
   	And Click on Password reset
    Then See Reset Password Overlay opened
    When Enter New password and confirm password
    |Test1234567|
    And click on Submit button
    Then Successful message displayed



@P2-NonJenkinsSc
Scenario: P2 Verify loading page for Owner for CHINA - Login using New User 
	Given Open chrome browser on P2 
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2
	When Enter credentials to login on P2 
		||Test1234567|
	And Click on Login button on P2 
	And See VehicleName and Vincode on Profile overlay on P2 
		|New EcoSport|//*[@id='tabs-0'] |1FA6P8TH1F5421281| //*[@id='sticky-header']/table[3]/thead/tr/td[2]/span/span |
	And Click on Account Info tab on Profile overlay on P2 
	And See all account information in Account Info tab on Profile overlay on P2 
		||//*[@id='userName'] |FirstName|//*[@id='firstName'] | Lastname|//*[@id='lastName'] ||//*[@id='email'] |先生|//*[@id='title'] ||//*[@id='state'] |12345|//*[@id='postCode'] ||//*[@id='mobileNumber'] |NA|//*[@id='workphoneNumber'] ||| 
	And Click on Add Vehicle on Profile overlay on P2 
	Then See that Add vehicle form is displayed on Add Vehicle tab on P2 Production 
	When Add vehicle with Vehicle name and Vincode on China P2
		|New Fiesta|LVSHFFML4GS547492|
	When Click on Confirm to Add Vehicle on P2 
	Then See the first vehicle tab name on P2 
	And See the second vehicle tab name on P2 
	When Click on second vehicle tab on P2 
	Then Verify second vehicle tab is loaded correctly on P2 
	When Click on first vehicle tab on P2 
	Then Verify first vehicle tab is loaded correctly on P2 
	When Click on second vehicle tab on P2 
	Then Verify second vehicle tab is loaded correctly on P2 
	When Click on Delete Vehicle on P2 
	Then See delete vehicle confirmation overlay 
	And Click on Confirm to Delete Vehicle on P2 
	And Do not See Vehicle tab name on P2 
		|New Fiesta|
	And Click on Account Info tab on Profile overlay on P2 
	And See all account information in Account Info tab on Profile overlay on P2 
	||//*[@id='userName'] |FirstName|//*[@id='firstName'] | Lastname|//*[@id='lastName'] ||//*[@id='email'] |先生|//*[@id='title'] ||//*[@id='state'] |12345|//*[@id='postCode'] ||//*[@id='mobileNumber'] |NA|//*[@id='workphoneNumber'] |||
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		||
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		||
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test123456|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test1234567|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test123456|
	And Click on first vehicle tab on P2 
	Then Verify first vehicle tab is loaded correctly on P2 
#	When Click on Update New Version link on Profile overlay on P2 
#	And See Your download is ready overlay on P2 
#	When Click on OK button on your download is ready overlay on P2 
#	When Click on Download Now link on Profile overlay on P2 
#	Then Close the SYNC overlay on P2 
#	When Click on Download Now link on Profile overlay on P2 
#	Then See page redirected to correct link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/vn/en_vn/home/owner/myprofile.html#overlay/content/guxap-sit-demo/vn/en_vn/site-wide-content/overlays/form-overlays/owner-download-manual-overlay.html" on P2 
#	And See all components on Owner Download Manual overlay on P2 
#	When Redirect to Download Owner Manual PDF on P2 	
	And Logout China Owner
	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2
	When Enter credentials to login on P2 
		||Test123456|
	And Click on Login button on P2  
	And Logout China Owner
 


@P2-JenkinsSpecific
Scenario: P2 Verify Forgot Username and Forgot Password of Existing Owner for CHINA
	Given Open chrome browser on P2 
	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2 
	And Click on Login button on P2
	Then Mandatory exceptions displayed for username and password
	|Username is mandatory|Password is mandatory|  
	Then Click on Forgot your username
	When See forgot overlay opened
	Then Enter email id
	|191017125435@mailinator.com|
	When click on Submit button
	Then Successful message displayed
    When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2
   	And Click on Forgot username Email on MailInator page
    Then Verify Username name in Forgot username Email
	|191017125435|
	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2
	Then Click on Forgot your Password
	When See forgot overlay opened
	Then Enter email id and Username
	|191017125435@mailinator.com|191017125435|
	When click on Submit button
	Then Successful message displayed
    When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2
   	And Click on Forgot username Email on MailInator page
   	And Click on Password reset
    Then See Reset Password Overlay opened
    When Enter New password and confirm password
    |Test1234567|
    And click on Submit button
    Then Successful message displayed
	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2
	When Enter credentials to login on P2 
		|191017125435|Test1234567|
	And Click on Login button on P2  
	And Logout China Owner




@P2 
Scenario: P2 Verify loading page for Owner for CHINA - Login using Existing User 
	Given Open chrome browser on P2 
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
	And See the Login overlay on P2 
	When Enter credentials to login on P2 
		|050917114224|Test12345|
	And Click on Login button on P2 
	And See VehicleName and Vincode on Profile overlay on P2 
		|New EcoSport|//*[@id='tabs-0'] |5LMCJ2ANXFUJ44326| //*[@id='sticky-header']/table[3]/thead/tr/td[2]/span/span |
	And Click on Account Info tab on Profile overlay on P2 
	And See all account information in Account Info tab on Profile overlay on P2 
		|050917114224|//*[@id='userName'] |FirstName|//*[@id='firstName'] | Lastname|//*[@id='lastName'] |050917114224@mailinator.com|//*[@id='email'] |先生|//*[@id='title'] ||//*[@id='state'] |12345|//*[@id='postCode'] |00509171142|//*[@id='mobileNumber'] |NA|//*[@id='workphoneNumber'] |||
	And Click on Add Vehicle on Profile overlay on P2 
	Then See that Add vehicle form is displayed on Add Vehicle tab on P2 Production 
	When Add vehicle with Vehicle name and Vincode on China P2
		|New Fiesta|LVSHFFML4GS547492|
	When Click on Confirm to Add Vehicle on P2 
	Then See the first vehicle tab name on P2 
	And See the second vehicle tab name on P2 
	When Click on second vehicle tab on P2 
	Then Verify second vehicle tab is loaded correctly on P2 
	When Click on first vehicle tab on P2 
	Then Verify first vehicle tab is loaded correctly on P2 
	When Click on second vehicle tab on P2 
	Then Verify second vehicle tab is loaded correctly on P2 
	When Click on Delete Vehicle on P2 
	Then See delete vehicle confirmation overlay 
	And Click on Confirm to Delete Vehicle on P2 
	And Do not See Vehicle tab name on P2 
		|New Fiesta|
	And Click on Account Info tab on Profile overlay on P2 
	And See all account information in Account Info tab on Profile overlay on P2 
	|050917114224|//*[@id='userName'] |FirstName|//*[@id='firstName'] | Lastname|//*[@id='lastName'] |050917114224@mailinator.com|//*[@id='email'] |先生|//*[@id='title'] ||//*[@id='state'] |12345|//*[@id='postCode'] |00509171142|//*[@id='mobileNumber'] |NA|//*[@id='workphoneNumber'] |||
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		|050917114221@mailinator.com|
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		|050917114221@mailinator.com|
	And Click on Change Email Address link on Account Info on P2 
	And Verify Change Email to new email on Account Info on P2 
		|050917114224@mailinator.com|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test123456|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test12345|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test123456|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test12345|
	And Click on Change Password on Account Info on P2
	And Verify Change Password to new password on Account Info on P2 
		|Test12345|
	And Click on first vehicle tab on P2 
	Then Verify first vehicle tab is loaded correctly on P2 
#	When Click on Update New Version link on Profile overlay on P2 
#	And See Your download is ready overlay on P2 
#	When Click on OK button on your download is ready overlay on P2 
#	When Click on Download Now link on Profile overlay on P2 
#	Then Close the SYNC overlay on P2 
#	When Click on Download Now link on Profile overlay on P2 
#	And See all components on Owner Download Manual overlay on P2 
#	When Redirect to Download Owner Manual PDF on P2 

 


#@test
#@P2-NonJenkinsSc
#Scenario: P2 CHINA Owner Registration using chinese charachter
#	Given Open chrome browser on P2 
#	And Generate unique string 
#	When Maximize browser and enter link "https://www.mailinator.com/" on P2 
#	And Input email to inbox field 
#		||
#	And Click on Go button 
#	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
#	And See the Login overlay on P2 
#	And Click on Register link on Login overlay on P2 
#	Then See the Register overlay on P2 
#	When Enter credentials to register on China P2 
#		|Name062017155002|张伟12345|张伟12345|18062017155002@mailinator.com|张伟|王芳|先生|
#	And Click on Next button on P2 
#	And Select vehicle credentials on P2 
#		|嘉年華|1FA6P8TH1F5421281|
#	And Click on Next button on P2 
#	And Fill in Vehicle Info credentials on china P2 
#		|安徽|12345|12122121110|TestName|An Giang|0123456789|ABCDEF| 
#	And Click on Register button on P2 
#	And Click on Close button on P2 
#	When Redirect to link "https://www.mailinator.com/v2/inbox.jsp?zone=public&query=REPLACETOUNIQUE" on P2 
#	And Click on Activation Email on MailInator page on P2 
#	When Click on Activate My Account link in activation mail on P2 
#	Then Registration Success message is displayed
# 
#
#
#@P2-NonJenkinsSc,@test
#Scenario: P2 Verify loading page for Owner for CHINA - Login using New User 
#	Given Open chrome browser on P2 
#	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
#	And See the Login overlay on P2
#	When Enter credentials to login on P2 
#		||张伟12345|
#	And Click on Login button on P2 
#	And See VehicleName and Vincode on Profile overlay on P2 
#		|嘉年華|//*[@id='tabs-0'] |1FA6P8TH1F5421281| //*[@id='sticky-header']/table[3]/thead/tr/td[2]/span/span |
#	And Click on Account Info tab on Profile overlay on P2 
#	And See all account information in Account Info tab on Profile overlay on P2 
#		||//*[@id='userName'] |张伟|//*[@id='firstName'] |王芳|//*[@id='lastName'] ||//*[@id='email'] |先生|//*[@id='title'] ||//*[@id='state'] |12345|//*[@id='postCode'] ||//*[@id='mobileNumber'] |NA|//*[@id='workphoneNumber'] ||| 
#	And Click on Add Vehicle on Profile overlay on P2 
#	Then See that Add vehicle form is displayed on Add Vehicle tab on P2 Production 
#	When Add vehicle with Vehicle name and Vincode on China P2
#		|New Fiesta|LVSHFFML4GS547492|
#	When Click on Confirm to Add Vehicle on P2 
#	Then See the first vehicle tab name on P2 
#	And See the second vehicle tab name on P2 
#	When Click on second vehicle tab on P2 
#	Then Verify second vehicle tab is loaded correctly on P2 
#	When Click on first vehicle tab on P2 
#	Then Verify first vehicle tab is loaded correctly on P2 
#	When Click on second vehicle tab on P2 
#	Then Verify second vehicle tab is loaded correctly on P2 
#	When Click on Delete Vehicle on P2 
#	Then See delete vehicle confirmation overlay 
#	And Click on Confirm to Delete Vehicle on P2 
#	And Do not See Vehicle tab name on P2 
#		|New Fiesta|
#	And Click on Account Info tab on Profile overlay on P2 
#	And See all account information in Account Info tab on Profile overlay on P2 
#		||//*[@id='userName'] |张伟|//*[@id='firstName'] |王芳|//*[@id='lastName'] ||//*[@id='email'] |先生|//*[@id='title'] ||//*[@id='state'] |12345|//*[@id='postCode'] ||//*[@id='mobileNumber'] |NA|//*[@id='workphoneNumber'] ||| 
#	And Click on Change Email Address link on Account Info on P2 
#	And Verify Change Email to new email on Account Info on P2 
#		||
#	And Click on Change Email Address link on Account Info on P2 
#	And Verify Change Email to new email on Account Info on P2 
#		||
#	And Click on Change Password on Account Info on P2
#	And Verify Change Password to new password on Account Info on P2 
#		|张伟123456|
#	And Click on first vehicle tab on P2 
#	Then Verify first vehicle tab is loaded correctly on P2 
#	And Logout China Owner
#	When Redirect to link "https://wwwint.brandap.ford.com/content/ford/cn/zh_cn/home.html#overlay/content/ford/cn/zh_cn/site-wide-content/overlays/form-overlays/login.html" on P2 
#	And See the Login overlay on P2
#	When Enter credentials to login on P2 
#		||张伟123456|
#	And Click on Login button on P2  
#	And Logout China Owner

@P2
Scenario: P2 Verify loading landing page on Build and Price on AU
		Given Open chrome browser on P2	
	  	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
	  	And Click on Build and Price on P2
		When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/build-and-price.html?n=Fiesta_AU&l=2000&u=P" on P2
	  	When Click on Models on P2 INT
	  	And Click on kind of vehicle on P2 INT
	  	|Fiesta Trend|
		Then Verify Drive away price with SL calls
  		|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=P|
	  	When Click on Drive on P2 INT
	  	Then See Drive list on P2 INT
	  	When Click on Color & Trim on P2
	  	And Click on Race Red color on P2
	  	When Click on Accessories on P2 INT
	  	And Click on Sort by Name on P2 INT
	  	Then See the names are sorted on P2 INT
	  	And Click on Accessory Name Item on P2 INT
		Then Verify Drive away price with SL calls
  		|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=123&env=P&location=2000&modelKey=396&optionPrice=784&transmissionFeatureKey=6396&usageType=P|
	  	And Click on Sort by Price on P2 INT
	  	Then See the prices are sorted on P2 INT
	  	And Click on Accessory Price Item on P2 INT
		Then Verify Drive away price with SL calls
  		|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=161&env=P&location=2000&modelKey=396&optionPrice=784&transmissionFeatureKey=6396&usageType=P|
	  	When Click on Review & Save button on P2
		Then See Pricing Summary on P2
		Then Verify Drive away price with SL calls
  		|//div[@class='txt-price ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=161&env=P&location=2000&modelKey=396&optionPrice=784&transmissionFeatureKey=6396&usageType=P|
		When Click on Share button on P2
		Then See the sharing popup on P2
		And Verify the Download File on "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/build-price-review-save-page.html?l=2000&u=P&n=Fiesta_AU&m=396&d=6396&e=6135&t=6275&y=2013&vc=Passenger_Vehicles&p=25451&ae=6748&ai=&ao=&as=&au=&am=" on P2

				
@P2
Scenario: P2 Verify Credit on CHINA Data validation on Payment Estimator page,Sort By features,verify price details,change vehicle model
Given Open chrome browser on P2
  When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-sit-demo/cn/en_cn/home/credit/credit-china/uc03-payment-estimator.html" on P2
  Then See all components loaded without performance issue on Payment Estimator on P2
  | //div[@id='global-ux']/div[3]/div[2]/div[2]/div/div[9]/div[1]/ul/li/a/i | //div[@id='global-ux']/div[3]/div[2]/div[2]/div/div[9]/div[1]/ul/li/a/span | //div[@id='splitter']/div/div/div//picture/img |
  When Click on Change Vehicle button on P2
  Then See the vehicle selection overlay on P2
  When Click on Sort By menu list on P2
  Then See options of Sort By menu list on P2
  When Select Sort By Price option on P2
  Then See list of models sorting by price on P2
  | //div[@id='showroom-vehicle-card']/div[2]/div[3]/div/div/div/div/div |
  When Click on Sort By menu list on P2
  Then See options of Sort By menu list on P2
  When Select Sort By Category option on P2
  Then See list of models sorting by category on P2 
  | //div[@id='showroom-vehicle-card']/div[2]/div[3]/div/div/dl/dd/div/div/div |
  When Click on model sorting by category on P2
  | //div[@id='showroom-vehicle-card']/div[2]/div[3]/div/div/dl/dd[2]/div/div/div/div[1]/a/img/ancestor::a |//div[@id='showroom-vehicle-card']/div[2]/div[3]/div/div/dl/dd[2]/div/div/div/div[1]/a/img/ancestor::a//ancestor::div[@class='img']/following-sibling::h3|
  Then See all components of Mustang model on P2
  When Click on Mustang menu list on P2
  And Select kind in Mustang menu list on P2
  | 福特翼搏 1.5MT 尊贵型 |
  Then See the price updated correctly on P2
  |//div[@class='vehicle-price']/span[contains(text(),'¥')]|
  And Click on Change Vehicle button on P2
  Then See the vehicle selection overlay on P2
  When Click on model sorting by category on P2
  | //div[@id='showroom-vehicle-card']/div[2]/div[3]/div/div/dl/dd[1]/div/div/div/div[1]/a/img |//div[@id='showroom-vehicle-card']/div[2]/div[3]/div/div/dl/dd[2]/div/div/div/div[1]/a/img/ancestor::a//ancestor::div[@class='img']/following-sibling::h3|
  Then See all components of MSRP model on P2
   		


@P2 
Scenario: P2 Verify Credit on P2 Mexico verify change of vehicle, selection of vehicle,verify all components of Focus model, select time on Term
		Given Open chrome browser on P2
		When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/mx/en_mx/home/credit/credit-mx/payment-presenter.html" on P2
		And Click on Change Vehicle button on P2 Mexico
		Then See the vehicle selection overlay on P2
		When Click on Focus on P2
		Then See all components of Focus model on P2 Mexico
		When Select time on Term on P2
		|24 Months|	


@P2 
Scenario: P2 Verify loading landing page on Build and Price for INDIA
  Given Open chrome browser on P2
  When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/in/en_in/home/build-and-price/build-and-price.html?v=All-New%20Endeavour&n=All-New_Endeavour_FIN&u=P&l=&c=&y=2015" on P2
  And Click on Accessories on P2 IND
  Then See the price updated correctly on P2
  |//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')] |
  When Click on Car Cover on P2 IND
  Then See the price updated correctly on P2
  |//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')] |
  When Click on Color and Trim on P2 IND
  Then See the price updated correctly on P2
  |//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')] |
  And Click on color on P2 IND
  |Smoke Grey| 
  Then See the price updated correctly on P2
  |//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')] |
  When Click on Review & Save button on P2
  Then See Pricing Summary on P2
  And See the price updated correctly on P2
  |//div[contains(@class,'txt-price')] |
  And See your vehicle details on P2
  |Smoke Grey| //tr[2]/td[@class='txt-col2 ng-binding'] | Car Cover | //tr[4]/td[@class='txt-col2 ng-binding'] |



@P2
Scenario: P2 B&P INDIA Vehicle selection,Sort By Price/Fuel/Body Style,Pkg,Color/Trim,Assosseries,Hamburger menu,Change Vehicle,Book a test drive,Review & save,start a new build,Save as PDF,Share,Req a Quote
  Given Open chrome browser on P2
  When Maximize browser and enter link "https://wwwdev.brandap.ford.com/content/guxap-uat-demo/in/en_in/home/build-and-price/billboard.html" on P2
  Then See CTAs and links are functional on the page
  When Click on Build & Price CTA
  Then Verify that page is navigated to Select Location page
  And Enter Location
  |Delhi|
  And click on submit
  And Verify that page is Navigated to select vehicle page
  When Click on Sort By "price"
  Then Available vehicles should be sorted as per sort selection "price"
  |EcoSport|Aspire|Next-Gen Figo|Fiesta|
  When Click on Sort By "fuel"
  Then Available vehicles should be sorted as per sort selection "fuel"
  |Aspire|Next-Gen Figo|EcoSport|Fiesta|
  When Click on Sort By "body"
  Then Available vehicles should be sorted as per sort selection "body"
  |Fiesta|Aspire|Next-Gen Figo|EcoSport|     
  When Select a Vehicle
  |Figo|
  When Click on Hamburger menu
  Then Click on start a New build
  Then Click on YES for confirmation overlay
  And see user is navigate to vehicle selection page
  And Select a Vehicle
  |Figo|
  And Click on Accessories on P2 IND
  Then See the price updated correctly
  |//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')]|NA|
  When Click on Car Cover on P2 IND
  Then See the price updated correctly
  |//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')]|NA|
  When Click on Color and Trim on P2 IND
  Then See the price updated correctly
  |//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')]|NA|
  And Click on color on P2 IND
  |Smoke Grey| 
  Then See the price updated correctly
  |//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')]|NA|
  When Click on Hamburger menu  
  And Click on Change Vehicle 
  Then Click on YES on confirmation overlay 
  And see user is navigate to vehicle selection page
  And Select a Vehicle
  |Figo|
  When Click on Hamburger menu  
  And Click on Book a Test Drive 
  Then User enters the details and submits the test drive request
  |Mr|TestFullName|DO-NOT-DELETE|080817174330@mailinator.com|0123456789|TestAddress|An Giang|0-3 Months|
  And Verify thank you page is seen and Close Overlay
  When Click on Hamburger menu
  When Click on Review & Save button
  Then See Pricing Summary on P2
  And See the price updated correctly
  |//div[contains(@class,'txt-price')]|//*[contains(text(),'Total Price')]/ancestor::td/following-sibling::td|
  When Click on Back link in Review & Save page
  Then see User is directing to Build and Price page
  When Click on Hamburger menu
  When Click on Go Back to Ford.com
  Then See confirmation overlay is displayed
  When user clicks on Cancel button
  Then See user stays on Build and Price page
  When Click on Change Vehicle link under vehicle nameplate
  Then Click on YES on confirmation overlay 
  And see user is navigate to vehicle selection page
  And Select a Vehicle
  |Figo|
  When Click on Drive Away Price arrow
  Then Drive Away Price should be expanded and correct price should be displayed
  And Close expanded window
  When Click on Review & Save button on P2
  Then See Pricing Summary on P2
  And See the price updated correctly
  |//div[contains(@class,'txt-price')]|//*[contains(text(),'Total Price')]/ancestor::td/following-sibling::td|
  When Click on Save as PDF link
  Then User is able to download the pdf file
  When Click on Share link
  Then See share popup is displaying
  When Click on the Request a quote Button 
  Then user can make a request after filling all the details in the page
  |Mr|TestFullName|DO-NOT-DELETE|080817174330@mailinator.com|0123456789|TestAddress|An Giang|0-3 Months|
  And Verify thank you page is seen and Close Overlay

 ####################### AUST POLK
@P2
Scenario: P2 B&P AU Validate the Select Location overlay,Postalcode on Build and Price
		Given Open chrome browser on P2
		When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
		And Click on Build and Price on P2
		When Input into Postcode field on POLK on P2
		|	10000	|
		And Click on Submit button on POLK Build and Price on P2
		Then See validation of invalid Postalcode on POLK on P2
		|Invalid postal code.|This field is required|Invalid postal code.|
		When Input into Postcode field on POLK on P2
		| 2055 |
		And Click on Submit button on POLK Build and Price on P2
		Then See all components on Select Vehicles page on POLK P2
		| 2055 |	Your Location| Fiesta | All-New Mondeo | Mustang | Falcon and G Series MkII | EcoSport |
		When Click on any Vehicle on Select Vehicles page on POLK P2
		|	/content/dam/Ford/website-assets/ap/au/credit/Fiesta/1249197264045.jpeg	|
		Then See all components on Vehice Build and Price POLK P2
		| Models | Drive | Color & Trim | accessories | Fiesta Trend | $ 25,413 | Fiesta Trend | Fiesta ST_test | Fiesta Sport |

   	

@P2				
Scenario: P2 B&P AU Verify Close Location selection overlay on Build and Price
		Given Open chrome browser on P2
		When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
		And Click on Build and Price on P2
		And verify Cancel button exist
		When Click on Cancel button on POLK Build and Price on P2



@P2
Scenario: P2 B&P AU Verify Navigating to vehicle Selection by entering valid Postal code on Build and Price
		Given Open chrome browser on P2
		When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
		And Click on Build and Price on P2
		And verify Cancel button exist
		When Input into Postcode field on POLK on P2
		|3551|
		And Click on Submit button on POLK Build and Price on P2
		Then Verify not seeing prices on POLK Build and Price on P2 



@P2
Scenario: P2 B&P AU Verify Sorting the Vehicle based on different Criteria on Build and Price
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
	And Click on Build and Price on P2
	And verify Cancel button exist
	And Input into Postcode field on POLK on P2
	|2000|
	And Click on Submit button on POLK Build and Price on P2
  	When Click on Sort By "price"
  	Then Available vehicles should be sorted as per sort selection "price"
 	 |Fiesta|EcoSport|All-New Mondeo|Mustang|
 	 When Click on Sort By "fuel"
 	 Then Available vehicles should be sorted as per sort selection "fuel"
 	 |EcoSport|Fiesta|Falcon and G Series MkII|Falcon Ute MKII|
	  When Click on Sort By "body"
 	 Then Available vehicles should be sorted as per sort selection "body"
 	 |Fiesta|All-New Mondeo|Mustang|MUSTANG Test|    


	


@P2 
Scenario: P2 B&P AU Verify seeing parameters passing to Service Layer at form loading on POLK Build and Price on P2
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
	And Click on Build and Price on P2
	And verify Cancel button exist
	And Input into Postcode field on POLK on P2
	|2000|
	And Click on Submit button on POLK Build and Price on P2
  	When Select a Vehicle
 	 |Fiesta|	
	Then see Drive away price
	When Click on Models on P2 INT
##  	And Click on kind of vehicle on P2 INT
##  	|Fiesta Trend|
	When Click on Color & Trim on P2
  	And Click On below color on P2
  	|Panther Black|
  	And Click on Sub Tab
  	|Trim|
  	And Click On below color on P2
  	|Cloth seat trim|
  	When Click on Accessories on P2 INT
#	And Click on Accessory Sub Tab
#  	|Option Packages|
#  	And Select Accessories
#  	|Professional|
#  	Then Verify No Cost Option text for zero price
#  	|No Cost Option|
#  	When Click on Drive Away Price arrow
#	Then Verify Text should no exist on UI
#	|MSRP|
#	And Close expanded window
#  	And Verify Drive away price with SL calls
#  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=396&optionPrice=784&transmissionFeatureKey=6396&usageType=P|

		

@P2
Scenario: P2 B&P AU Verify Drive away price of Personal Type Vehicles,Drive Transmission key/Accessories price sending to SL,drive away price after changing Model/Engine transmission/Color and Trim,Accessories price/Optional price sending to SL & drive away price after selecting accessories/Optional pkg 
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
	And Click on Build and Price on P2
	And verify Cancel button exist
	And Input into Postcode field on POLK on P2
	|2000|
	And Click on Submit button on POLK Build and Price on P2
  	When Click on Sort By "price"
  	Then Available vehicles should be sorted as per sort selection "price"
 	|Fiesta|EcoSport|All-New Mondeo|Mustang|
 	When Click on Sort By "fuel"
 	Then Available vehicles should be sorted as per sort selection "fuel"
 	|EcoSport|Fiesta|Falcon and G Series MkII|Falcon Ute MKII|
	When Click on Sort By "body"
 	Then Available vehicles should be sorted as per sort selection "body"
 	|Fiesta|All-New Mondeo|Mustang|MUSTANG Test|     
  	When Select a Vehicle
 	|Fiesta|	
	Then see Drive away price
	When Click on Models on P2 INT
##  	And Click on kind of vehicle on P2 INT
##  	|Fiesta Trend|
  	Then Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=P|
  	When Click on kind of vehicle on P2 INT
  	|Fiesta Sport|
  	Then Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=397&optionPrice=0&transmissionFeatureKey=6391&usageType=P| 	
  	And Verify the Model key sending to SL
  	|397|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=397&optionPrice=0&transmissionFeatureKey=6391&usageType=P|
  	When Click on Drive on P2 INT
  	And Select Drive
  	|1.0L GTDi EcoBoost Petrol PowerShift|
  	Then Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=397&optionPrice=0&transmissionFeatureKey=6367&usageType=P|
  	When Click on Color & Trim on P2
  	And Click On below color on P2
  	|Panther Black|
  	Then Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=397&optionPrice=385&transmissionFeatureKey=6367&usageType=P|
  	When Click on Accessories on P2 INT
###  	And Click on Accessory Sub Tab
###  	|Exterior|
  	And Select Accessories
  	|AlloyFiestaSport|
  	Then Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=397&optionPrice=385&transmissionFeatureKey=6367&usageType=P|
  	And Click on Accessory Sub Tab
  	|Interior|
  	And Select Accessories
  	|DVD / CD Wallet|
  	Then Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=26&env=P&location=2000&modelKey=397&optionPrice=385&transmissionFeatureKey=6367&usageType=P|
##	And Click on Accessory Sub Tab
##  	|Option Packages|
##  	And Select Accessories
##  	|Sports Executive Pack|
##  	Then Verify Drive away price with SL calls
##  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=26&env=P&location=2000&modelKey=397&optionPrice=1385&transmissionFeatureKey=6367&usageType=P|


@P2
Scenario: P2 B&P AU Verify the drive away price of commercial type vehicles 
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
	And Click on Build and Price on P2
	And verify Cancel button exist
	And Input into Postcode field on POLK on P2
	|4000|
	And Select Usage Type
	|Commercial|
	And Click on Submit button on POLK Build and Price on P2
  	When Click on Sort By "price"
  	Then Available vehicles should be sorted as per sort selection "price"
 	|Fiesta|EcoSport|All-New Mondeo|Mustang|
 	When Click on Sort By "fuel"
 	Then Available vehicles should be sorted as per sort selection "fuel"
 	|EcoSport|Fiesta|Falcon and G Series MkII|Falcon Ute MKII|
	When Click on Sort By "body"
 	Then Available vehicles should be sorted as per sort selection "body"
 	|Fiesta|All-New Mondeo|Mustang|MUSTANG Test|     
  	When Select a Vehicle
 	|Fiesta|
	Then see Drive away price
	When Click on Models on P2 INT
##  	And Click on kind of vehicle on P2 INT
##  	|Fiesta Trend|
  	Then Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=4000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=B|


@P2
Scenario: P2 B&P AU Verify the drive away price in Review and Save page,Verify the drive away price after Download PDF,Shared feature,Back Button Feature,Verify Change Postal Code link in Review and Save page
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
	And Click on Build and Price on P2
	And verify Cancel button exist
	And Input into Postcode field on POLK on P2
	|4000|
	And Select Usage Type
	|Commercial|
	And Click on Submit button on POLK Build and Price on P2
  	When Select a Vehicle
 	|Fiesta|
	Then see Drive away price
	When Click on Models on P2 INT
##  	And Click on kind of vehicle on P2 INT
##  	|Fiesta Trend|
 	When Click on Review & Save button on P2
	Then See Pricing Summary on P2
	And Verify No Cost Option text for zero price
  	|No Cost Option| 	
  	And Verify Drive away price with SL calls
  	|//div[contains(@class,'txt-price')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=4000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=B|
	When Click on Save as PDF link
	Then User is able to download the pdf file 
	And Verify Drive away price with SL calls
  	|//div[contains(@class,'txt-price')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=4000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=B|	
	When Click on Share link
	Then See share popup is displaying
	And Verify Drive away price with SL calls
  	|//div[contains(@class,'txt-price')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=4000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=B|	
 	When Ciick on Change Postal Code link
	And Input into Postcode field on POLK on P2
	|2000|
	And Select Usage Type
	|Personal|
	And Click on Submit button on POLK Build and Price on P2	
	Then See Pricing Summary on P2 
	And Verify Drive away price with SL calls
  	|//div[contains(@class,'txt-price')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=P|
  	When Click on Back link in Review & Save page
	Then see User is directing to Build and Price page
	And Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=P|	


@P2
Scenario: P2 B&P AU Verify Functionality of Change Postal Code link and Change Vehicle link in B&P configuration page 
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/au/en_au/home/build-and-price/billboard.html" on P2
	And Click on Build and Price on P2
	And verify Cancel button exist
	And Input into Postcode field on POLK on P2
	|4000|
	And Select Usage Type
	|Commercial|
	And Click on Submit button on POLK Build and Price on P2
  	When Select a Vehicle
 	 |Fiesta|	
	Then see Drive away price
	When Ciick on Change Postal Code link
	And Input into Postcode field on POLK on P2
	|2000|
	And Select Usage Type
	|Commercial|
	And Click on Submit button on POLK Build and Price on P2	
	Then see Drive away price
	And Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=B|	
	When Click on Change Vehicle link under vehicle nameplate
	Then Click on YES on confirmation overlay 
	And see user is navigate to vehicle selection page
	And Select a Vehicle
	|Fiesta|	
	Then see Drive away price
	And Verify Drive away price with SL calls
  	|//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'$')]|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/calcBPDriveAwayPriceForAUS?accessoryPrice=0&env=P&location=2000&modelKey=396&optionPrice=399&transmissionFeatureKey=6396&usageType=B|	
	

@P2
Scenario: P2 Credit CHINA - Check Home and Showroom
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc03-payment-estimator.html" on P2
	Then All components loads successfully without performance issue
	And See CTAs and links are functional on the page
	When Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	And Check displaying of a vehicle name format
	 


@P2
Scenario: P2 Credit CHINA - Change Vehicle and Payment Calculator Header
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc03-payment-estimator.html" on P2
	Then All components loads successfully without performance issue
	When Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	When Select a China Vehicle
 	|ANY|
 	Then Verify display of vehicle image



@P2
Scenario: P2 Credit CHINA - Check Financing Package Selection
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc03-payment-estimator.html" on P2
	And Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	When Select a China Vehicle
 	|福特福睿斯|
 	Then Check elements in Financing Package Selection
 	And Check default value of Down Payment and Amount Financed
 	When Input valid value for Down Payment
 	Then Down Payment Ratio is changed accordingly and Amount Financed varies with any changes from Down Payment
 	When Input valid value for Amount Financed
 	Then Down Payment Ratio is changed accordingly and Down Payment varies with any changes from Amount Financed
 	When Drag Down Payment ratio to actual final point
 	Then Amount Financed equals
 	|40000|


@P2
Scenario: P2 Credit CHINA - Comparison List
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc03-payment-estimator.html" on P2
	And Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	When Select a China Vehicle
 	|福特福睿斯|
 	When Input Down Payment amount
 	And Click on the Compare Finance accordion
 	|方案比较|
 	Then Verify compare Finance details columns count and related Payment details
 	|1|
 	When Click on a Remove button
 	Then Verify compare Finance details columns count and related Payment details
 	|0|
 	When Input Down Payment amount
 	And Click on the Compare Finance accordion
 	|方案比较|
 	Then Verify compare Finance details columns count and related Payment details
 	|1|
 	When Input Down Payment amount
 	And Click on the Compare Finance accordion
 	|方案比较|
 	Then Verify compare Finance details columns count and related Payment details
 	|2|
 	When Input Down Payment amount
 	And Click on the Compare Finance accordion
 	|方案比较|
 	Then Verify compare Finance details columns count and related Payment details
 	|3|
 	When Input Down Payment amount
 	And Click on the Compare Finance accordion
 	|方案比较|
 	Then Verify compare Finance details columns count and related Payment details
 	|4|
 	When Click on a Remove button
 	Then See Add new Vehicle model is shown at the end
 
 

@P2
Scenario: P2 Credit CHINA - Check Summary List
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc03-payment-estimator.html" on P2
	And Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	When Select a China Vehicle
 	|福特福睿斯|
 	Then Check elements in Financing Package Selection
 	When Drag Down Payment ratio to actual final point
 	Then See Down Payment and Amount Financed in Summary list vary correctly
 	|40000|
 	When Select card
	|EW-Bundled|
	Then See the EW-package with its value is shown in Summary list
 	When Select card
	|Equal|
	Then See all the information in Summary list varies correctly
	|40000|




 
@P2
Scenario: P2 Credit CHINA - Credit Actions Bar
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc03-payment-estimator.html" on P2
	And Click Save
	Then Current Vehicle Financing package is saved successfully in PDF
	And Check existence of EMAIL and PRINT button




@P2
Scenario: P2 Credit CHINA - Check Finance Option Home & Financial Compare Collection
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc05-finance-options.html" on P2
	Then Three financing options are shown in accordions
	When Expand an accordion
 	Then More detail of option is shown
 	When Click on Compare Financing options
 	Then Checkbox is shown at each option for user to select and Cancel button is shown
 	When Select 2 options
	Then Compare Selected options button is shown
 	When Click on Cancel btn
	Then System discards all selected checkboxes
	When Click on Compare Financing options
 	Then Select 2 options
	And Click on Compare Selected options button
	When Click on a Change button
	Then popup is shown with the rest option for user to select
	When Select the option
	Then option is changed properly
	When Click on Add button
	Then popup is shown with the rest option for user to select
	When Select the option
	Then option is changed properly
	And Click on Remove btn and see Relative option is removed
	And Remove button is replaced by Change button




@P2
Scenario: P2 Credit CHINA - Finance Option Tool-Trending Bar and Home page
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc04-finance_optiontool.html" on P2
	Then Trending Bar is shown correctly in disabled mode for the begining
	And Default value of Trending Bar is 50-50
	When Select an answer
	Then Trending Bar is immediately updated




@P2
Scenario: P2 Credit CHINA - Finance Option Tool- Quiz question
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc04-finance_optiontool.html" on P2
	Then Question is shown under Trending Bar with answer ratios and Next button in disabled mode
	When Select an answer
	Then Next button is enabled
	When Click on Next button
	Then System shows second question and Previous button is shown
	When Click on Previous button
	Then System back to the previous question with the selected answer




@P2
Scenario: P2 Credit CHINA - Finance Option Tool- Result page
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/cn/en_cn/home/credit/credit-china/uc04-finance_optiontool.html" on P2
	And Answer to the last question
	Then System redirects to Result page with the highest accumulated percentage based on the Users responses in large print
	When Click on See how your answer affected result
	Then system opens the accordion lower on the page
	When Click on Start Over button
	Then system returns the user to the start of the Finance Options Tool flow




@P2
Scenario: P2 Credit MEXICO - Payment Estimator-Showroom, Change Vehicle and Payment Canculator Header
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/mx/en_mx/home/credit/credit-mx/payment-presenter.html" on P2
	Then All components loads successfully without performance issue
	And See CTAs and links are functional on the page
	When Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	And Check displaying of a vehicle name format
	When Click on CTA
	|Current|
	Then See Vehicle Filtered accordingly
	When Click on CTA
	|Previous|
	Then See Vehicle Filtered accordingly
	When Select Vehicle
 	|ANY|
 	Then Verify display of vehicle image




@P2
Scenario: P2 Credit MEXICO - Check Financing Package Selection
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/mx/en_mx/home/credit/credit-mx/payment-presenter.html" on P2
	And Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	When Select Vehicle
 	|Fiesta|
 	Then Check elements in Financing Package Selection for MX
 	And Click on Terms field to check options
 	And Check default Min and Max value of Down Payment for MX
 	|Payment Details|
 	And Check Customer Rate Display in Promo Box
 	|Payment Details|
 	When Change the Vehicle Model of a nameplate
 	Then Check Customer Rate Display in Promo Box
	|Payment Details|




@P2
Scenario: P2 Credit MEXICO - Check Summary List
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwqa.brandap.ford.com/content/guxap-uat-demo/mx/en_mx/home/credit/credit-mx/payment-presenter.html" on P2
	And Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	When Select Vehicle
 	|Fiesta|
 	And Click on accordion "Payment Details"
	Then Summary list expands includes all payment details
	|selling-price|payment-downPayment|payment-admin-fee|payment-credit-insurane|payment-vehicle-insurane|payment-customer-rate|annual-interest-rate|payment-loan-term|payment-amountFinanced|payment-monthly|
	When Change Term and Downpayment
	Then Information of Terms and DownPayment is updated correctly in Summary list




@P2
Scenario: P2 Credit MEXICO - Credit Actions Bar
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwdev.brandap.ford.com/content/guxap-uat-demo/mx/en_mx/home/credit/credit-mx/payment-presenter.html" on P2
	And Click Save
	Then Current Vehicle Financing package is saved successfully in PDF
	And Check existence of EMAIL and PRINT button




@P2
Scenario: P2 Credit MEXICO - Amortisation Table
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwqa.brandap.ford.com/content/guxap-uat-demo/mx/en_mx/home/credit/credit-mx/payment-presenter.html" on P2
	And Click on Change Vehicle button on P2
	Then See the vehicle selection overlay on P2
	When Select Vehicle
 	|Fiesta|
 	And Click on accordion "Payment Details"
	Then Summary list expands includes all payment details
	|selling-price|payment-downPayment|payment-admin-fee|payment-credit-insurane|payment-vehicle-insurane|payment-customer-rate|annual-interest-rate|payment-loan-term|payment-amountFinanced|payment-monthly|
	When Change Term and Downpayment
	Then Information of Terms and DownPayment is updated correctly in Amortisation Table





@P2
Scenario: P2 Credit ARGENTINA - Payment Estimator-Showroom, Change Vehicle
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ar/en_ar/home/credit/credit-argentina/uc03-finance-calculator.html" on P2
	Then See the vehicle selection overlay for AR
	And Check displaying of a vehicle name format
	When Select Vehicle
 	|ANY|
 	Then Verify display of vehicle image
	And All components loads successfully without performance issue
	And See CTAs and links are functional on the page
	When Click on Change Vehicle button on P2
	When Select Vehicle
 	|Focus|
 	Then Verify display of vehicle image





@P2
Scenario: P2 Credit ARGENTINA - Payment Estimator page landing via direct URL
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://www.ford.com.ar/ford-credit/simulador-de-financiamiento/" on P2
	Then See the vehicle selection overlay for AR
	And Check displaying of a vehicle name format
	When Select Vehicle
 	|Fiesta 4P|
 	Then Verify display of vehicle image
	And All components loads successfully without performance issue
	When Click on Change Vehicle button on P2
	Then On vehicle selector page Click to return back to previously selected vehicle
	|Fiesta 4P|





@P2
Scenario: P2 Credit ARGENTINA - Payment Estimator - Financing Package Sellection,  Summary List
	Given Open chrome browser on P2
	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/ar/en_ar/home/credit/credit-argentina/uc03-finance-calculator.html" on P2
	Then See the vehicle selection overlay for AR
	When Select Vehicle
 	|Fiesta|
 	Then Check elements in Financing Package Selection for AR
	When Change Term and Valid & Invalid Downpayment for AR
	|Saldo|
	Then Information of Terms and DownPayment is updated correctly in Payment details
	When Click Save
	Then Current Vehicle Financing package is saved successfully in PDF
	And Check existence of EMAIL and PRINT button





#@P2
#Scenario: P2 Credit BRAZIL - Payment Estimator-Payment Canculator Header, Showroom, Change Vehicle
#	Given Open chrome browser on P2
#	When Maximize browser and enter link "https://wwwint.brandap.ford.com/content/guxap-uat-demo/br/en_br/home/credit/credit-brazil/uc03-finance-calculator.html" on P2
#	And All components loads successfully without performance issue
#	And See CTAs and links are functional on the page
#	When Click on Change Vehicle button on P2
#	Then See the vehicle selection overlay for AR
#	And Check displaying of a vehicle name format
#	When Select Vehicle
# 	|ECOSPORT|
# 	Then Verify display of vehicle image
#
#
#
#
#@P2
#Scenario: P2 Credit BRAZIL - Check Financing Package Selection
#	Given Open chrome browser on P2
#	When Maximize browser and enter link "https://wwwdev.brandap.ford.com/content/guxap-uat-demo/br/en_br/home/credit/credit-brazil/uc03-finance-calculator.html" on P2
#	And Click on Change Vehicle button on P2
#	Then See the vehicle selection overlay on P2
#	When Select Vehicle
# 	|ECOSPORT|
# 	Then Check elements in Financing Package Selection for BR
# 	And Change the Vehicle Model
# 	|FreeStyle 1.6|
# 	And Click on Terms field to check options
# 	And Check default Min and Max value of Down Payment for BR
# 	|Detalhes|
# 	
#
#
#
#
#@P2-test
#Scenario Outline: P2 Credit BRAZIL - Payment Estimator - Summary List
#	Given Open chrome browser on P2
#	When Maximize browser and enter link "https://wwwdev.brandap.ford.com/content/guxap-uat-demo/br/en_br/home/credit/credit-brazil/uc03-finance-calculator.html" on P2
#	And Click on Change Vehicle button on P2
#	Then See the vehicle selection overlay on P2
#	And Select Vehicle
# 	|ECOSPORT|
# 	When Enter down payment "<Payment_Tab>"
#	Then Monthly Instalments with FP Label and without FP Label values matched with SL
#	|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/credit/models/calculatePayment?modelKey=EcoSport_SE_1.6_FBR&term=60&downPayment=25000&accessoriesPrice=0&state=AC&countryCodeISO=BRA|
#	And Check Summary section values matched with SL calls with vehicle "<>" and state "<STATE>" and slurl "<SL>"
#	When Term is highest and Min downpayment equals 30% of MSRP
#	Then Monthly Instalments with FP Label value equals "-"
#	When Click Save
#	Then Current Vehicle Financing package is saved successfully in PDF
#	And Check existence of EMAIL and PRINT button
#Examples:
#	|Payment_Tab|Vehicle|STATE|SL|
#	|Detalhes|ECOSPORT|Acre|https://wwwqa.dfyservices.ford.com/fordowner/vehicle/buildandprice/credit/models/calculatePayment?modelKey=VMN_FBR&term=VT&downPayment=VDP&accessoriesPrice=0&state=AC&countryCodeISO=BRA|








# 	test
 	