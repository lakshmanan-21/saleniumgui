package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Back_to_excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\laksh\\\\Documents\\\\Excel.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("org");
     Row row=sh.getRow(1);
    Cell cel=row.createCell(4);
    cel.setCellType(CellType.STRING);
    cel.setCellValue("Lakshmanan");
    FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\laksh\\\\Documents\\\\Excel.xlsx");
    wb.write(fos);
    wb.close();
    System.out.println("data written back to excel");

	}

}
