package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Contact_UsPage;
import pageObject.HomePage;



public class VerifyContactWithValidData extends BaseClass{
	Contact_UsPage CU;
	HomePage HP3;
	
	@Test
	public void VerifyContact_WithVD() throws IOException
	{ HP3=new HomePage(driver);
      CU=new Contact_UsPage(driver);
      HP3.ClickOnclose();
		HP3.ClickOnContact();
		
		CU.EnterFirstName("Anuja");
		CU.EnterEmail("abc@gmail.com");
		CU.EnterSubject("Enquiry");
		CU.ClickOnSubmit();
		String ActualResult=CU.VerifySuccessMSG();
		if(ActualResult.equalsIgnoreCase("Thank you for contacting us,we will be in touch shortly."))
				{
			Assert.assertTrue(true);
				}
		else
		{
			CaptureScreenshot(driver,"VerifyContactWithValidData");
			Assert.assertTrue(false);
		}
	}

}
