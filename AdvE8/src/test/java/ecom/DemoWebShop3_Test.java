package ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoWebShop3_Test {
	
	@Test
	public void launch() throws InterruptedException {
		Reporter.log("testNG installed", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("browser is maximised", true);
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.partialLinkText("jewelry")).click();
		Thread.sleep(2000);
		driver.quit();

}
}
