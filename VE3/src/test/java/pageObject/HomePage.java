package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	JavascriptExecutor j;
	WebDriver driver;
@FindBy(xpath="//h1[text()='News']")
private WebElement Title;

@FindBy(xpath="//img[@decoding='async']")
private WebElement PaymentAssociation;

@FindBy(xpath="(//a[@href='https://www.ve3.global/'])[1]")
private WebElement Logo;

@FindBy(xpath="(//a[@class='wpr-menu-item wpr-pointer-item'])[7]")
private WebElement Contact;

@FindBy(xpath="//div[@class='cmplz-close']")
private WebElement Close;


public String GetTitle()
{
return Title.getText();
}
public void ClickOnclose()
{
	Close.click();
}
public void ClickOnPaymentAssociation()
{
	/*j=(JavascriptExecutor)driver;
	j.executeScript("argument[0].scrollIntoView(true);", PaymentAssociation);*/
	 PaymentAssociation.click();
}

public boolean VerifyLogo()
{
	return Logo.isDisplayed();
}
public void ClickOnContact()
{
	Contact.click();
	
}
public HomePage(WebDriver d2)
{
	
	PageFactory.initElements(d2, this);
}
}


