package OnlineShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Login2 {
	
	public static void main(String[] args) {
		
		
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b4c.06.01\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
       String baseUrl = "https://www.google.com";
       
       driver.get(baseUrl);
       
       WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
       
       search.sendKeys("Cleartrip.com");
       
       WebElement searchButton = driver.findElement(By.xpath("//input[@value='Google Search' and type='submit']"));
       
       searchButton.click();
       
}
}
