package prctice.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactwithSupportDate {

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
		   Sheet sh=wb.getSheet("contact");
		   Row row= sh.getRow(4);
		   String lastname=row.getCell(2).toString()+randomInt;
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

		   driver.findElement(By.linkText("Contacts")).click();
		   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		   Date dateobj=new Date();
			SimpleDateFormat sim=new SimpleDateFormat("yyy-MM-dd");
			String startdate = sim.format(dateobj);
			
			
			Calendar cal=sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, +30);
				String enddate = sim.format(cal.getTime());
				   
		   
	
		  driver.findElement(By.name("lastname")).sendKeys(lastname);
		  driver.findElement(By.name("support_start_date")).clear();
		  driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		  
		  driver.findElement(By.name("support_end_date")).clear();
		  driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		  
		  
		  

		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
			//verify header lastname info expected result
			String actlastname=driver.findElement(By.id("dtlview_Last Name")).getText();
			if(actlastname.equals(lastname))
			{
				System.out.println(lastname+"information is created==pass");
			}
			else
			{
				System.out.println(lastname+"information is not created==fail");
			}

			String actStartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
			if(actStartdate.equals(startdate))
			{
				System.out.println(startdate+"information is created==pass");
			}
			else
			{
				System.out.println(lastname+"information is not created==fail");
			}
			String actenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
			if(actenddate.equals(enddate))
			{
				System.out.println(enddate+"information is created==pass");
			}
			else
			{
				System.out.println(lastname+"information is not created==fail");
			}
		   
		   
	     driver.quit();
		


	}

}
