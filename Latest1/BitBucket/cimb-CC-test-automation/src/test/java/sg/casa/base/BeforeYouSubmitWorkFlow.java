package sg.casa.base;

public class BeforeYouSubmitWorkFlow {
		
			   //To Verify the method Are you Referred 
				public static String ReviewPageAreYouReferred (String AreReferred) {	
						String Parameter = AreReferred;
						
						if(AreReferred.contentEquals("Yes")) {
								//Return Are you Referred = Yes xpath
								Parameter =	SG_CASA_UI_Elements.BeforeYouSubmit_ReferredByFriend_Yes;
						
						}
						else if (AreReferred.contentEquals("No")) {
								//Return Are you Referred = No xpath
								Parameter =	SG_CASA_UI_Elements.BeforeYouSubmit_ReferredByFriend_No;
						}
						
						else {
							System.out.println("methord Values are not match with xl Sheet values : " +Parameter);
						
						}
						return Parameter;
					}			

				public static String ReviewPageHaveAPromocode(String HavePromocode) {	
					String Parameter = HavePromocode;
					
					if(HavePromocode.contentEquals("Yes")) {
							//Return Are you Referred = Yes xpath
							Parameter =	SG_CASA_UI_Elements.BeforeYouSubmit_HaveAPromoCode_Yes;
					
					}
					else if (HavePromocode.contentEquals("No")) {
							//Return Are you Referred = No xpath
							Parameter =	SG_CASA_UI_Elements.BeforeYouSubmit_HaveAPromoCode_No;
					}
					
					else {
						System.out.println("method Values are not match with xl Sheet values : " +Parameter);
					
					}
					return Parameter;
				}		
				
				
}
