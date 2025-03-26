package prctice.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreatecontactwithOrganization {

	public static void main(String[] args) throws Throwable 
	{
		
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
		   Row row= sh.getRow(7);
		   String orgname=row.getCell(2).toString()+randomInt;
		   String contactlastname=row.getCell(3).toString();
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
		  //driver.findElement(By.id("phone")).sendKeys(contactlastname);
		

		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
			///verify header orgname info expected result
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgname))
			{
				System.out.println(orgname+ "header verified==pass");
			}
			else
			{
				System.out.println(orgname+"header is verified==fail");
			}
			driver.findElement(By.linkText("Contacts")).click();
			   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			  driver.findElement(By.name("lastname")).sendKeys(contactlastname);
			  driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			  //switch to child window
			 String parentwindow = driver.getWindowHandle();
			 Set<String> childwindow = driver.getWindowHandles();
			 for(String window:childwindow)
			 {
				 driver.switchTo().window(window);
				 System.out.println(driver.getCurrentUrl());
				if( driver.getCurrentUrl().contains("Popup&popuptype"))
				 {
					driver.findElement(By.id("search_txt")).sendKeys(orgname);
					  driver.findElement(By.name("search")).click();
					  //random number changes for every execution so we are changing static data into dynamic data
					 // driver.findElement(By.xpath("//a[text()='Facebook_348']")).click();
					//xpath is also get generated during runtime
					  
					  driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
					
					 
				 }
				 
				 
			 }
			 
			 
			  
			  
			  //switch to parent window
			 driver.switchTo().window(parentwindow);
			  
			   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
			 //verify header orgname info expected result
				headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(contactlastname))
				{
					System.out.println(contactlastname+ "header verified==pass");
				}
				else
				{
					System.out.println(contactlastname+"header is verified==fail");
				}
				//In contact module verify the org name
				String actOrgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
				System.out.println(actOrgname);
				//to remove space in output (see the output) we use trim
				if(actOrgname.trim().equals(orgname))
				{
					System.out.println(orgname+"information is created==pass");
				}
				else
				{
					System.out.println(orgname+"information is not created==fail");
				} 

			   
			   

		   
		   
		   
	     driver.quit();
		

	}

}
