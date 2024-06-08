package report;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Script02 {
	
	@Test
	public void script2()  {
	WebDriver driver;
	ScreenShotMethod ss = new ScreenShotMethod();
	LocalDateTime dateTime=LocalDateTime.now();
	String date = dateTime.toString().replace(":","-");
	ExtentReports reports=new ExtentReports();
	ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/"+date+".html");
	reports.attachReporter(reporter);
    ExtentTest test = reports.createTest("book");
    driver=new ChromeDriver();
	driver.manage().window().maximize();
	test.log(Status.INFO, "browser is maximised");
	driver.get("https://demowebshop.tricentis.com/");
	test.log(Status.INFO, "demowebshop application is launched");
	driver.findElement(By.partialLinkText("Books")).click();
    test.log(Status.INFO,"user clicked on books link");
    driver.findElement(By.linkText("Computing and Internet")).click();
    test.log(Status.INFO,"user clicked on computing and internet books");
    driver.findElement(By.id("add-to-cart-button-13")).click();
    test.log(Status.INFO,"user clicked on addcart button");
    try {
    if(driver.getTitle().contains("Demo Web Shop. Computing and Internet")) {
    	test.pass("Script is passed") ;
    	test.log(Status.PASS,"script is passed");
    	//test.pass(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
    }
    	
    }catch (Exception e) {
    	// TODO: handle exception
    	test.fail(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
    	
    }
    reports.flush();
    
}
}
