package BrowserStackRunnerClass.Ford;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import com.browserstack.BrowserStackSerenityTest;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        	features = "feature/Ford_General_All/p1general.feature", glue = { "com.ford.automation.p1_general" }
//        ,tags= {"@P1-test"}
)
public class P1GeneralTest  extends BrowserStackSerenityTest { }
