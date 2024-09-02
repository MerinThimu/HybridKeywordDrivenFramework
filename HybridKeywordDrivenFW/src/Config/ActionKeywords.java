package Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActionKeywords
{
	WebDriver driver;
	
	public ActionKeywords(WebDriver driver2)
	{
		
		this.driver= driver2;
	}
	//#1
	public WebDriver openBrowser() //function from keyword in excel
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\merin\\OneDrive\\Desktop\\Selenium\\geckodriver-v0.34.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}
	//#2
	public void navigate(String url) throws InterruptedException
	{
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	//#3
	public void input_username(String user)
	{
		driver.findElement(By.name("username")).sendKeys(user);
	}
	//#4
	public void input_password(String pass)
	{
		driver.findElement(By.name("password")).sendKeys(pass);;
	}
	//#5
	public String click_login() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		String result;
		String title = driver.getTitle();
		System.out.println(title);      //print title
		
		if(title.equals("OrangeHRM"))
		{
			result = "pass";
		}
		else
		{
			result = "fail"; 
		}
		return result;
		
	}
	//#6
	public void waitFor() throws InterruptedException
	{
		Thread.sleep(2000);
	}
	public void closeBrowser()
	{
		driver.close();
	}
	

}
