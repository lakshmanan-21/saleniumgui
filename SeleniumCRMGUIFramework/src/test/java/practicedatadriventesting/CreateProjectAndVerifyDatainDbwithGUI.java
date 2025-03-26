package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.jdbc.Driver;


import com.mysql.jdbc.Driver;
 

public class CreateProjectAndVerifyDatainDbwithGUI {

	public static void main(String[] args) throws Throwable 
	{
		String expectedProjectName="Gallerysss_007";

		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8091/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(expectedProjectName);
		driver.findElement(By.name("createdBy")).sendKeys("HENRYghf");
		//WebElement s=driver.findElement(By.name("status"));
Select sel=new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
sel.selectByValue("Completed");
driver.findElement(By.xpath("//input[@value='Add Project']")).click();

boolean flag=false;

Driver driveref=new Driver();
DriverManager.registerDriver(driveref);
Connection conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
Statement stat=conn.createStatement();
ResultSet resultset=stat.executeQuery("select * from project");
while(resultset.next())
{
	//System.out.println(resultset.getString(1)+   "\t  " +resultset.getString(2)+"\t   "+resultset.getInt(6));
String actprojectname=resultset.getString(4);
if(expectedProjectName.equals(actprojectname))
{
flag=true;
System.out.println(expectedProjectName +"is available==pass");
}

}

if(flag==false)
{
	System.out.println(expectedProjectName +"is fail");
	
}


conn.close();


	

	}
}
