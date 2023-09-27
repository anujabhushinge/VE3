package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Payment_AssociationPage;



public class VerifySearchBar extends BaseClass {
	HomePage HP1;
	Payment_AssociationPage PA;
	Assert A;
	@Test
	public void VerifySearchBarFunctionality() throws IOException
	{   HP1=new HomePage(driver);
	PA=new Payment_AssociationPage(driver);
		HP1.ClickOnclose();
		HP1.ClickOnPaymentAssociation();
		driver.get("https://thepaymentsassociation.org/search/");
		PA.ClickOnSearchBar("Letter to Lord Johnson from The Payments Association");
		PA.ClickOnSearchBtn();
		String ActualText=PA.VerifyText();
		
		if(ActualText.equalsIgnoreCase("Letter to Lord Johnson from The Payments Association"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			CaptureScreenshot(driver,"VerifySearchBar");
			Assert.assertTrue(false);
			
		}
	}

}
