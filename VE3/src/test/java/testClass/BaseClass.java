package testClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
@BeforeTest
public void Setup() throws InterruptedException
{
	 WebDriverManager.chromiumdriver().setup();
     ChromeOptions option=new ChromeOptions();
     option.addArguments("--remote-allow-origins=*");
     driver=new ChromeDriver(option);
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	      driver.get("https://www.ve3.global/news/.");
 	     Thread.sleep(3000);
 	    
}
/*@AfterTest
public void tearDown()
{
	driver.close();
	driver.quit();
}*/
public void CaptureScreenshot(WebDriver driver, String name) throws IOException
{
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"//Screenshot//"+name+".png");
	FileHandler.copy(source, dest);
	
}
}
