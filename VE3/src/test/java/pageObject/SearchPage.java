package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage {
	@FindBy(xpath="//h1[@class='elementor-heading-title elementor-size-default']")
	private WebElement SearchResultPage;

	public String VerifySearchResultPage()
	{
		return SearchResultPage.getText();
	}
	public SearchPage(WebDriver d2)
	{
		
		PageFactory.initElements(d2, this);
	}
	}


