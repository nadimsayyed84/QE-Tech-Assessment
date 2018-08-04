require('nightwatch-cucumber')({
cucumberArgs: ['--require', 'examples/tag-example/features/step_definitions', '--format', 'json:reports/cucumber.json', 'examples/tag-example/features']
  /* other configuration options */
})
 
var seleniumServer = require('selenium-server');
var chromedriver = require('chromedriver'); 

module.exports = {
  output_folder: 'reports',
  custom_assertions_path: '',
  page_objects_path: 'examples/tag-example/page_objects',
  live_output: true,
  disable_colors: false,
  globals_path : 'examples/tag-example/features/step_definitions/executeJScode.js',
  selenium: {
    start_process: true,
    server_path: seleniumServer.path,
    log_path: '',
    host: '127.0.0.1',
    port: 4444
  },
  test_settings: {
    default: {
      launch_url: 'http://localhost:8087',
      selenium_port: 4444,
      selenium_host: '127.0.0.1',
      desiredCapabilities: {
        browserName: 'chrome',
        javascriptEnabled: true,
        acceptSslCerts: true,
        use_xpath: true
      },
      selenium: {
        cli_args: {
          'webdriver.chrome.driver': chromedriver.path
        }
      }
    },
    firefox: {
      desiredCapabilities: {
        browserName: 'firefox',
        javascriptEnabled: true,
        acceptSslCerts: true
      }
    }
  }
}
