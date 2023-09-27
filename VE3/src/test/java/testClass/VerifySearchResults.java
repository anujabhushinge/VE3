package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.Payment_AssociationPage;
import pageObject.SearchPage;



public class VerifySearchResults extends BaseClass {
	Payment_AssociationPage PA1;
	HomePage HP2;
	SearchPage SP;
	@Test
	public void VerifySearchResult() throws IOException
	{ HP2=new HomePage(driver);
	PA1=new Payment_AssociationPage(driver);
	SP=new SearchPage(driver);
	HP2.ClickOnclose();
		HP2.ClickOnPaymentAssociation();
		driver.get("https://thepaymentsassociation.org/search/");
		PA1.ClickOnSearchBar("Letter to Lord Johnson from The Payments Association");
		PA1.ClickOnSearchBtn();
		PA1.ClickOnSearchedText();
		String ActualResult=SP.VerifySearchResultPage();
		
		if(ActualResult.equalsIgnoreCase("Letter to Lord Johnson from The Payments Association"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			CaptureScreenshot(driver, "VerifySearchResults" );
			Assert.assertTrue(false);
		}}
}
