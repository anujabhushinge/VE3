package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	ExtentSparkReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	public void ReadExtentReport()
	{
		String time=new SimpleDateFormat("yyyy.mm.dd,hh.mm.ss").format(new Date());
		String Reportname="Extent Report"+time+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//"+Reportname);
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("Machine", "TestPc1");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Envir", "SIT");
		report.setSystemInfo("Username", "Anuja");
		
		htmlReporter.config().setDocumentTitle("This is my first report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the test method sta rted"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of Succesful Test case is:"+result.getName());
		test=report.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of succesful Test case is:"+result.getName(),ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
	System.out.println("Name of failed test:"+result.getName());
	test=report.createTest(result.getName());
	test.log(Status.FAIL,MarkupHelper.createLabel("Name of failed test case is:"+result.getName(),ExtentColor.RED));

	String ScrrenshotPath=System.getProperty("user.dir")+"//Screenshots//"+result.getName()+".png";
	File ScreenshotFile=new File(ScrrenshotPath);
	if(ScreenshotFile.exists())
	{
		test.fail("captured screenshot is :"+test.addScreenCaptureFromPath(ScrrenshotPath));
	}}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of skipped test case is:"+result.getName());
		test=report.createTest(result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("Name of Skipped test case is:"+result.getName(),ExtentColor.YELLOW));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("On start method invoked......");
	}

	public void onFinish(ITestContext context) {
		System.out.println("On finish method invoked.......");
		report.flush();
	}
	}

