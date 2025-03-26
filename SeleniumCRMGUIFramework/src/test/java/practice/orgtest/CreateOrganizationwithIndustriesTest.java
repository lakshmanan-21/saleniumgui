package practice.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationwithIndustriesTest {

	public static void main(String[] args) throws Throwable {
FileInputStream fis=new FileInputStream("C:\\Users\\laksh\\Documents\\commondata.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		   String URL=pobj.getProperty("url");
		   String USERNAME=pobj.getProperty("username");
		   String PASSWORD=pobj.getProperty("password");
		   		   
		   Random random=new Random();
		   int randomInt=random.nextInt(1000);
		   FileInputStream f=new FileInputStream("C:\\Users\\laksh\\Documents\\Excel.xlsx");
		   Workbook wb=WorkbookFactory.create(f);
		   Sheet sh=wb.getSheet("Sheet3");
		   Row row= sh.getRow(4);
		   String orgname=row.getCell(2).toString()+randomInt;
		   String industry=row.getCell(3).toString();
		   String type=row.getCell(4).toString();
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
		  WebElement ind=driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel=new Select(ind);
		sel.selectByValue("Chemicals");
		WebElement ty=driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select sel1=new Select(ty);
		sel1.selectByValue("Customer");

		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
			//verify the industries and type info
			String actIndustries=driver.findElement(By.id("dtlview_Industry")).getText();
			if(actIndustries.equals(industry))
			{
				System.out.println(industry+"information is verified==pass");
			}
			else
			{
				System.out.println(industry+"information is not verified==fail");
			}
			String actType=driver.findElement(By.id("dtlview_Type")).getText();
			if(actType.equals(type))
			{
				System.out.println(type +"  information is verified==pass");
			}
			else
			{
				System.out.println(type  +"  information is not verified==fail");
			}

		   
		   
		   
	     driver.quit();
		

	}

}
