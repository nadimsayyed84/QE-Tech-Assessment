package RunnerClass.Ford;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        		features = "feature/Ford_General_All/p2general.feature", glue = { "com.ford.automation.p2_general" }
        ,tags= {"~@P2-JenkinsSpecific"}    //Enable this line for sanity and Jenkins nightly build test
//        ,tags= {"@P2-Test"}
)
public class P2FordTest {
}
	

