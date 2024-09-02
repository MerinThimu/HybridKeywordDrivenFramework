package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Config.ActionKeywords;
import UtilLib.ConstantData;
import UtilLib.ExcelActivity;

public class DriverScript 
{
	ActionKeywords Ak;
	WebDriver driver;
	
	public void Execute() throws IOException, InterruptedException
	{
		Ak = new ActionKeywords(driver);
		
		ExcelActivity.readExcel(ConstantData.excelpath, ConstantData.sheetname);
		String name;
		int rownum = ExcelActivity.rowcount();
		System.out.println(rownum);
		
		for(int i=1;i<=rownum;i++)
		{
			name = ExcelActivity.getdata(i,ConstantData.Ak_col );
			System.out.println(name);
			
			if(name.equals("openBrowser"))
			{
				driver = Ak.openBrowser();
			}
			else if(name.equals("navigate"))
			{
				Ak.navigate(ConstantData.url);
			}
			else if(name.equals("input_username"))
			{
				String user = ExcelActivity.getdata(i, ConstantData.datacol); //to get value in 4th col = "Admin"
				Ak.input_username(user);
			}
			else if(name.equals("input_password"))
			{
				String pass = ExcelActivity.getdata(i, ConstantData.datacol);
				Ak.input_password(pass);
			}
			else if(name.equals("click_login"))
			{
				String result = Ak.click_login();
				ExcelActivity.writeexcel( i,ConstantData.resultcol, result);
			}
			else if(name.equals("waitFor"))
			{
				Ak.waitFor();
			}
			else if(name.equals("closeBrowser"))
			{
				Ak.closeBrowser();
			}
		}
		
	}

}
