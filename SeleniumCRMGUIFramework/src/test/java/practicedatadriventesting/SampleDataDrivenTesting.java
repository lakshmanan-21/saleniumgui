package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\laksh\\Documents\\commondata.properties");
		
		Properties pobj=new Properties();
		pobj.load(fis);
System.out.println(pobj.getProperty("browser"));
System.out.println(pobj.getProperty("URL"));
System.out.println(pobj.getProperty("username"));
System.out.println(pobj.getProperty("passwordh"));




	}

}
