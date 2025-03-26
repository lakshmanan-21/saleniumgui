package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Expected_condition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		String expectedtestID="Tc_02";
		String data="";
		String data1="";
		String data2="";
		String data3="";
		
FileInputStream fis=new FileInputStream("C:\\\\Users\\\\laksh\\\\Documents\\\\Excel.xlsx");
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet("Sheet3");
int rowcount=sh.getLastRowNum();
for(int i=1;i<=rowcount;i++)
{
try
{
	data=sh.getRow(i).getCell(0).toString();
	if(data.equals(expectedtestID))
	{
		data1=sh.getRow(i).getCell(1).toString();
		data2=sh.getRow(i).getCell(2).toString();
		data3=sh.getRow(i).getCell(3).toString();
	}
}
catch(Exception e)
{
	
}
	
}
System.out.println(data1);
System.out.println(data2);
System.out.println(data3);

wb.close();


	}

}
