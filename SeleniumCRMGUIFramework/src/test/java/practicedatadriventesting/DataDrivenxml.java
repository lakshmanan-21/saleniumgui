package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class DataDrivenxml
{
	@Test
	public void createorgtest(XmlTest test) throws Throwable, IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\laksh\\Documents\\appCommonData.json"));
		JSONObject map=(JSONObject)obj;
		
		String URL=test.getParameter("url");
		String BROWSER=test.getParameter("browser");
		String USERNAME=test.getParameter("username");
		String PASSWORD=test.getParameter("password");
		Random random=new Random();
		   int randomInt=random.nextInt(1000);
		   FileInputStream f=new FileInputStream("C:\\Users\\laksh\\Documents\\Excel.xlsx");
		   Workbook wb=WorkbookFactory.create(f);
		   Sheet sh=wb.getSheet("Sheet3");
		   Row row= sh.getRow(1);
		   String orgname=row.getCell(2).toString()+randomInt;
		   wb.close();
		   WebDriver driver=null;
		   if(BROWSER.equals("Chrome"))
		   {
		   	driver=new ChromeDriver();
		   }
		   else if(BROWSER.equals("firefox"))
		   {
		   	driver=new FirefoxDriver();
		   }
		   else if(BROWSER.equals("edge"))
		   {
		   	driver=new EdgeDriver();
		   }
		   else
		   {
		   	driver=new ChromeDriver();
		   	
		   }

		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		   driver.get(URL);
		   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		   driver.findElement(By.id("submitButton")).click();

		   driver.findElement(By.linkText("Organizations")).click();
		   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		  driver.findElement(By.name("accountname")).sendKeys(orgname);

		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   Actions act=new Actions(driver);
		   act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		   driver.findElement(By.linkText("Sign Out")).click();
		   
	     driver.quit();	
		
		
	}

}
