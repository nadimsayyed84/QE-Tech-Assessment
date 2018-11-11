package BrowserStackRunnerClass.Ford;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import com.browserstack.BrowserStackSerenityTest;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        		features = "feature/Ford_General_All", glue = {"com.ford.automation.p1_general","com.ford.automation.p2_general","com.ford.automation.p3_general"},
        		tags= {"~@P2-NonJenkinsSc"}
)
public class Jenkins_FordTest  extends BrowserStackSerenityTest { }
