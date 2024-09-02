package UtilLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelActivity
{
	static File f;
	static FileInputStream fin;
	static FileOutputStream fos;
	static XSSFSheet ws;
	static XSSFWorkbook wb;
	
	public static void readExcel(String excelpath,String sheetname) throws IOException
	{
		f=new File(excelpath);                //store path in f
		fin = new FileInputStream(f);    //read path
		wb = new XSSFWorkbook(fin);      //store in wb
		ws = wb.getSheet(sheetname);     //get sheetname and store in ws
	}
	public static int rowcount()
	{
		int count;
		count = ws.getLastRowNum();
		return count;
	}
	//To read data from Excel
	public static String getdata(int rownum,int colnum)
	{
		String name = ws.getRow(rownum).getCell(colnum).getStringCellValue(); //to get string value of the cell
	    return name;
	}
	//To write data in Excel
	public static void writeexcel(int rownum,int colnum,String result) throws IOException
	{
		ws.getRow(rownum).createCell(colnum).setCellValue(result); //To print the result value in the cell
	    fos = new FileOutputStream(f);
	    wb.write(fos);
	    System.out.println("File written");
	    		
	}

}
