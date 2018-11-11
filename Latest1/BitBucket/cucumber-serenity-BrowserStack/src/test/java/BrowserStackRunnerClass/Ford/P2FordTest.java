package BrowserStackRunnerClass.Ford;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import com.browserstack.BrowserStackSerenityTest;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        		features = "feature/Ford_General_All/p2general.feature", glue = { "com.ford.automation.browserstackdefination","com.ford.automation.p2_general" }
        ,tags= {"~@P2-JenkinsSpecific"}
//        ,tags= {"@P2-test"}
)
public class P2FordTest  extends BrowserStackSerenityTest { }
