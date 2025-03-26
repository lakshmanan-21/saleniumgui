package practice.testng;

import org.testng.annotations.Test;

public class Contacttest 
{
	@Test(priority=1)
	public void createcontactTest()
	{
		System.out.println("execute create contact");
	}
	@Test(priority=2)
	public void modifycontactTest()
	{
		System.out.println("execute modify contact");
	}
	@Test(priority=3)
	public void deletecontactTest()
	{
		System.out.println("execute delete contact");
	}
	

}
