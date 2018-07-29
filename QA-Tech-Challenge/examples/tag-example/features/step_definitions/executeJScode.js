var selector = 'button[id=go-to-grant]'; //The selector you want
module.exports = {

    'Demo': function(client) {

        client
            .waitForElementVisible('button[id=go-to-grant]', 2000)
            .execute(function(selector) {
                document.querySelector(selector).click();
            },
 [selector],
 function(result) {
            
        });

    }
}; 