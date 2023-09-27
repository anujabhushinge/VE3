package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Contact_UsPage;
import pageObject.HomePage;

public class VerifyContactWithInvalid extends BaseClass {
	Contact_UsPage CU1;
	HomePage HP4;
	
	@Test
	public void VerifyContact_WithID() throws IOException
	{ HP4=new HomePage(driver);
      CU1=new Contact_UsPage(driver);
      HP4.ClickOnclose();
		HP4.ClickOnContact();
		
		CU1.EnterFirstName("Anuja");
		CU1.EnterEmail("123");
		CU1.EnterSubject("Enquiry");
		CU1.ClickOnSubmit();
		String ActualResult=CU1.VerifyError();
		if(ActualResult.equalsIgnoreCase("This is not a valid email."))
				{
			Assert.assertTrue(true);
				}
		else
		{
			CaptureScreenshot(driver,"VerifyContactWithValidData");
			Assert.assertTrue(false);
		}}}

