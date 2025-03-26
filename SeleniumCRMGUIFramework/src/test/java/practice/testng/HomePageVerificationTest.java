package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest 
{
	@Test
	public void homepagetest()
	{
		System.out.println("test start");
		String expectedpage="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		Assert.assertEquals(actTitle, expectedpage);
		driver.close();
		System.out.println("test end");
	}
	@Test
	public void verifylogohomepagetest()
	{
		System.out.println("test start");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Assert.assertTrue(status);
		Assert.assertEquals(status,true);
		System.out.println(status);
		driver.close();
		System.out.println("test end");
	}

}
