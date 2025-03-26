package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {
@Test
public void projectchecktest() throws SQLException
{
	String expectedProjectName="INS_01";
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
			//Assert.fail();
		}
		//int result=stat.executeUpdate("insert into project values('NH057','kumaresan','02/18/2027','seeta','created','77')");
		//System.out.println(result);
		
conn.close();


}

}
