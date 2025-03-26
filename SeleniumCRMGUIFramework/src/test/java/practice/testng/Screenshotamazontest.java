package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshotamazontest 
{
	@Test
	public void amazontest() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		TakesScreenshot s=(TakesScreenshot)driver;
		File srcfile=s.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./Screenshot/test.png");
		FileUtils.copyFile(srcfile, destfile);
	
		driver.quit();
	}

}
