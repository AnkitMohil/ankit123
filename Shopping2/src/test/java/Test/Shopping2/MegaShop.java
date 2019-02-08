package Test.Shopping2;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class MegaShop {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	
	public void beforeTest(String value,ITestContext result) {
		
		System.out.println(result.getCurrentXmlTest().getName()+"test is started");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b4c.06.01\\Driver\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\training_b4c.06.01\\Driver\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		
		if(value.equals("Chrome")) {
		
			driver = new ChromeDriver();
			
		}
		
		else if (value.equals("IE")) {
			
			driver = new InternetExplorerDriver();
			
		}
		
		
	driver.get("http://demowebshop.tricentis.com/");
	driver.manage().window().maximize();
	
}
	
	@AfterTest
	
	public void afterTest(ITestContext result) {
		System.out.println(result.getCurrentXmlTest().getName()+"test is closed");
		
		driver.close();
		
	}
	
	
	@Test(dataProvider="dp1")
	
	public  void testDemoWebShopLogin(String username, String password)
	{
		
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		AssertJUnit.assertNotNull(driver.findElement(By.linkText("Log out")));
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		return TestReadExcel.testreadExcel();
	}
	

	
}

