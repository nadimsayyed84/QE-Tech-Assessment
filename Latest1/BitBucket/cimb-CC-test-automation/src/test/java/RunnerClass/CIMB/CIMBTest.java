package RunnerClass.CIMB;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" },
		// features = "feature/Ford_General_All", glue =
		// {"com.ford.automation.p1_general","com.ford.automation.p2_general","com.ford.automation.p3_general"}
		// features = "feature/CIMB_Features", glue =
		// {"com.ford.automation.p1_general","com.ford.automation.p2_general","com.ford.automation.p3_general"}

		// Star Saver Savings
//		 features = "feature/CIMB_Features", glue = {"sg.casa.cimb.star.saver.saving"}

		// StarSaver i
		// features = "feature/CIMB_Features", glue = {"sg.casa.cimb.star.saver.ii"}

		// StarSaver i
//		features = "feature/CIMB_Features", glue = { "sg.casa.cimb.star.saver.i.saving" }

		// Fixed Deposit
		
//		 features = "feature/CIMB_Features", glue = {"sg.casa.cimb.fixeddeposit"}
		
		// Why-Wait Fixed Deposit
		// features = "feature/CIMB_Features", glue = {"sg.casa.cimb.fixed.deposit.i"}
		
		// Junior saver
		 features = "feature/CIMB_Features", glue = {"sg.casa.cimb.junior.saver"}
		
		// Fast Saver
		
		// features = "feature/CIMB_Features", glue = {"sg.casa.cimb.fast.saver"}
		
		// Fast Saver i
		// features = "feature/CIMB_Features", glue = {"sg.casa.cimb.fast.saver.ii"}
		
		// Session Timeout
		// features = "feature/CIMB_Features", glue = {"sg.casa.cimb.comman"}
		
		// features = "feature/CIMB_Features", glue = {"cimb.test"}
)
public class CIMBTest {

}
