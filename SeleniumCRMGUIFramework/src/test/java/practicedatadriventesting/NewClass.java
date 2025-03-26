package practicedatadriventesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewClass {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://demo.guru99.com/test/ajax.html");
  List<WebElement> radiobutton=driver.findElements(By.id("yes"));
System.out.println(radiobutton.size());
for(int i=0;i<=radiobutton.size()-1;i++)
{
	
	String radio=radiobutton.get(i).getAttribute("name");
	System.out.println(radio);
}
List<WebElement> radiobutton2=driver.findElements(By.id("no"));

for(WebElement element:radiobutton2)
{
	String radio2=element.getAttribute("type");
	System.out.println(radio2);
}


	}

}
