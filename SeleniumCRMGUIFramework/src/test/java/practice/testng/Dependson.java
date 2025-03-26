package practice.testng;

import org.testng.annotations.Test;

public class Dependson 
{
	@Test
	public void createcontactTest()
	{
		System.out.println("execute create contact");
	}
	@Test(dependsOnMethods="createcontactTest")
	public void modifycontactTest()
	{
		System.out.println("execute modify contact");
	}
	@Test(dependsOnMethods="modifycontactTest")
	public void deletecontactTest()
	{
		System.out.println("execute delete contact");
	}
	


}
