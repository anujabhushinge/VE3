package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;



public class VerifyHomapageLoading extends BaseClass {
	HomePage HP;
	Assert A;
	@Test
	public void VerifyHomePageLoad()
	{  HP=new HomePage(driver);
		HP.ClickOnclose();
	boolean ActualResult= HP.VerifyLogo();
	Assert.assertTrue(ActualResult);
	

}}


