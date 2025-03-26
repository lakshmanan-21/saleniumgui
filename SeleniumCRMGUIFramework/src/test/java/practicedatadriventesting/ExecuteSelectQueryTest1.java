package practicedatadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest1 {

	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try
		{
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
		conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
		Statement stat=conn.createStatement();
		ResultSet resultset=stat.executeQuery("select * from projectss");
		while(resultset.next())
		{
			
			System.out.println(resultset.getString(4));
			System.out.println(resultset.getString(3));
			
	}
		}catch(Exception e)
		{
			System.out.println("Exceptfion handled");
		}
		finally
		{
			conn.close();
			System.out.println("connection closed");
		}
		
		
	}

}
