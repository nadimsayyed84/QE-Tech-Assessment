const { client } = require('nightwatch-cucumber')
const { Given, Then, When } = require('cucumber')


Given(/^Launch application url "(.*?)"$/, (string) =>{
  console.log("Launch application url "+string);
  return client
  .url(string)
  .waitForElementVisible('body', 60000)
  .waitForElementVisible('a[id=login-button]', 60000,"Login button exist.")
  .click('a[id=login-button]')
})  

Given(/^Login using predefined BGP user (.*?)$/, (string)=>{
  return client
  .click('select[name=SAMLart] option[value="'+string+'"]')
  .waitForElementVisible('button[type=submit]',300000,"Login using predefined BGP user "+string)
  .click('button[type=submit]')
})

Then(/^Select (.*?)$/, (app)=>{
  return client
  .useXpath()
  .waitForElementVisible("//*[contains(text(),'"+app+"')]",300000,"Select " +app)
  .click("//*[contains(text(),'"+app+"')]")
})

Then(/^Sector (.*?) and Sub-sector (.*?)$/, (sec,subsec)=>{
  return client
  .waitForElementVisible("//*[contains(text(),'"+sec+"')]",60000,"Select Sector as "+sec)
  .click("//*[contains(text(),'"+sec+"')]")
  .waitForElementVisible("//*[contains(text(),'"+subsec+"')]",60000,"Select Sub-sector as "+subsec)
  .click("//*[contains(text(),'"+subsec+"')]")
})


When(/^Click "(.*?)"$/, (text) =>{
  if(text=="Apply"){
    return client
    .useCss()
    .element('css selector', 'button[id=go-to-grant]', function() {
      client.waitForElementVisible('button[id=go-to-grant]', 2000,"Clicking on Apply button")
      client.execute(function() {
          document.querySelector('button[id=go-to-grant]').click();
      })
    })
  }else if(text=="Proceed"){
    return client
    .pause(2000)
    .element('css selector', 'button[id=keyPage-form-button]', function() {
      client.waitForElementVisible('button[id=keyPage-form-button]', 2000,"Clicking on Proceed button")
      client.execute(function() {
          document.querySelector('button[id=keyPage-form-button]').click();
      })
    })
    .pause(2000)
  }  
})


Given(/^"(.*?)" question is visible to answer$/, (ques)=>{
  return client
  .useXpath()
  .waitForElementVisible("//*[contains(text(),'"+ques+"')]", 60000,"Question visible is- "+ques)
})

When(/^No answer is selected$/, ()=>{
  return client
  .element('xpath', "//input[@id='react-eligibility-user_agreement_check-false']//following-sibling::span[@class='radiobutton']", function(response) {
    client.elementIdSelected(response.value.ELEMENT, function(result) {
    client.assert.ok(!result.value, 'Answer option as NO does not selected');
    client.waitForElementVisible("//input[@id='react-eligibility-user_agreement_check-false']//following-sibling::span[@class='radiobutton']", 10000,"Answer option as NO does not selected")
    })
  })
  
  .element('xpath', "//input[@id='react-eligibility-user_agreement_check-true']//following-sibling::span[@class='radiobutton']", function(response) {
    client.elementIdSelected(response.value.ELEMENT, function(result) {
    client.assert.ok(!result.value, 'Yes answer does not selected');
    client.waitForElementVisible("//input[@id='react-eligibility-user_agreement_check-true']//following-sibling::span[@class='radiobutton']", 10000,"Answer option as YES does not selected")
    })
  })
})


Then(/^Next button is disabled$/, ()=>{
  return client
  .element('xpath', "//button[@id='next-btn']", function() {
    client.expect.element("//button[@id='next-btn']").to.not.be.enabled
    client.assert.ok(true, 'Next button is disabled');
    client.waitForElementVisible("//button[@id='next-btn']",1000,'Next button is disabled')
  })
})

Then(/^Next button is enabled$/, ()=>{
  return client
  .element('xpath', "//button[@id='next-btn']", function() {
    client.expect.element("//button[@id='next-btn']").to.be.enabled
    client.assert.ok(true, 'Next button is Enabled');
    client.waitForElementVisible("//button[@id='next-btn']",1000,'Next button is Enabled')
  })
})

Then(/^All side menus are disabled$/, ()=>{
  return client
  .pause(3000)
  .element('xpath', "//span[text()!='']//ancestor::li", function() {
      client.expect.element("//span[text()='Contact Details']//ancestor::li[@class='disabled']").to.be.present
      client.expect.element("//span[text()='Proposal']//ancestor::li[@class='disabled']").to.be.present
      client.expect.element("//span[text()='Cost']//ancestor::li[@class='disabled']").to.be.present
      client.expect.element("//span[text()='Business Impact']//ancestor::li[@class='disabled']").to.be.present
      client.expect.element("//span[text()='Declare & Review']//ancestor::li[@class='disabled']").to.be.present
      client.assert.ok(true, 'All Menus are Disabled except Eligibility menu');
  })
})

Then(/^All side menus are enabled$/, ()=>{
  return client
  .pause(3000)
  .element('xpath', "//span[text()!='']//ancestor::li", function() {
      client.expect.element("//span[text()='Contact Details']//ancestor::li[@class='disabled']").to.not.be.present
      client.expect.element("//span[text()='Proposal']//ancestor::li[@class='disabled']").to.not.be.present
      client.expect.element("//span[text()='Cost']//ancestor::li[@class='disabled']").to.not.be.present
      client.expect.element("//span[text()='Business Impact']//ancestor::li[@class='disabled']").to.not.be.present
      client.expect.element("//span[text()='Declare & Review']//ancestor::li[@class='disabled']").to.not.be.present
      client.assert.ok(true, 'All Menus are Enabled');
  })
})

Then(/^Eligibility Menu is enabled$/, ()=>{
  return client
  .element('xpath', "//span[text()='Eligibility']//ancestor::li[@class='active']", function() {
    client.expect.element("//span[text()='Eligibility']//ancestor::li[@class='active']").to.be.present
    client.assert.ok(true, 'Eligibility Menu is enabled');
  })
})


When(/^Answer is selected as "(.*?)"$/, (text)=>{
  return client
  .pause(2000)
  .click("//span[@class='bgp-label' and text()='"+text+"']//preceding-sibling::span")
  client.assert.ok(true, 'Answer is selected as '+text)
  .pause(3000)
})


Then(/^User is allowed to navigate through side menus$/, ()=>{
  return client
  .click("//span[text()='Contact Details']")
  .pause(5000)
  .assert.urlContains("contact_info","User is allowed to navigate through side menus")
  .back()
  .waitForElementVisible("//span[text()='Contact Details']//ancestor::li[@class='active']",10000,"User is allowed to navigate through side menus")
})



Then(/^See below warning message triggers "(.*?)"$/, (smartadv)=>{
  return client
  .waitForElementVisible("//div[@class='eligibility-advice']//span",60000)
  .element('xpath', "//div[@class='eligibility-advice']//span", function(test) {
    client.expect.element("//div[@class='eligibility-advice']//span").text.to.contain(smartadv)
    client.assert.ok(true, 'Error message displayed as '+smartadv)
  })
})


When(/^Click on Smart Advisor link and Check Target website launched on the same windows tab "(.*?)"$/, (targeturl)=>{
  return client
  .waitForElementVisible("//a[contains(text(),'Smart Advisor')]", 2000,"Smart Advisor link exist")
  .click("//a[contains(text(),'Smart Advisor')]")
  .pause(3000)
  .assert.urlEquals(targeturl,"Target url does not opened in same window tab")
})
