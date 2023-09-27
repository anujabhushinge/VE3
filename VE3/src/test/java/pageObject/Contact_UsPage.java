package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Contact_UsPage {


	
	@FindBy(xpath="(//h2[@class='elementor-heading-title elementor-size-default'])[20]")
	private WebElement Scrolldown;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement FirstName;
	
	@FindBy(xpath="(//input[@type='email'])[1]")
	private WebElement Email;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement Subject;
	
	@FindBy(xpath="//textarea[@id='forminator-field-textarea-1_650d75db077b6']")
	private WebElement Message;
	
	@FindBy(xpath="//button[@class='forminator-button forminator-button-submit']")
	private WebElement submit;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement SuccessMSG;
	
	@FindBy(xpath="//span[@id='forminator-field-email-1_650d75db077b6-error']")
	private WebElement ErrorMSG;
	
	
	public void EnterFirstName(String Name)
	{
		FirstName.sendKeys(Name);
	}
	
	public void EnterEmail(String EmailID)
	{
		Email.sendKeys(EmailID);
	}
	public void EnterSubject(String Sub)
	{
		Subject.sendKeys(Sub);
	}
	public void ClickOnSubmit()
	{
		submit.click();
	}
	
	
	public Contact_UsPage(WebDriver d2)
	{
		
		PageFactory.initElements(d2, this);
	}

	public String VerifySuccessMSG() {
	
		return  SuccessMSG.getText();
	}
	
	public String VerifyError()
	{
		return ErrorMSG.getText();
	}
}

