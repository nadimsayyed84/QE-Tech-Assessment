package BrowserStackRunnerClass.Ford;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import com.browserstack.BrowserStackSerenityTest;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        	features = "feature/Ford_General_All/p3general.feature", glue = { "com.ford.automation.browserstackdefination","com.ford.automation.p1_general","com.ford.automation.p2_general","com.ford.automation.p3_general"}
//      ,tags= {"@P3-test"}
		)
public class P3FordTest  extends BrowserStackSerenityTest { }
