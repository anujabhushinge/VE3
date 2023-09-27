package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Payment_AssociationPage {
	Actions A;
	@FindBy(xpath="//input[@class='jet-search-filter__input']")
	private WebElement SearchBox;
	
	@FindBy(xpath="//h4[@class='jet-listing-dynamic-field__content']")
	private WebElement SearchText;
	
	@FindBy(xpath="(//button[@type='button'])[1]")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//h4[@class='jet-listing-dynamic-field__content']")
	private WebElement SearchedText;
	
	@FindBy(xpath="//a[@id='sm-1695437136734384-1']")
	private WebElement WhatWeDo;
	
	@FindBy(xpath="(//a[text()='Contact us'])[2]")
	private WebElement ContactUs;
	
	
	public void ClickOnSearchBar(String Text)
	{
		SearchBox.click();
		SearchBox.sendKeys(Text);
		
	}
	
	public String VerifyText()
	{
		return SearchText.getText();
	}
	
	public void ClickOnSearchBtn()
	{
		SearchBtn.click();
	}
	
	public void MoveToWWD()
	{
		A.moveToElement(WhatWeDo);
	}
	
	public void ClickOnCU()
	{
		ContactUs.click();
	}
	

	
	public Payment_AssociationPage(WebDriver d2)
	{
		
		PageFactory.initElements(d2, this);
	}

	public void ClickOnSearchedText() {
		
		SearchedText.click();
	}
}

