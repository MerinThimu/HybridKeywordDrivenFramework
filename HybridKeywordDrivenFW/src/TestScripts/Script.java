package TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

public class Script 
{
	@Test
	public void f() throws IOException, InterruptedException
	{
		DriverScript obj = new DriverScript();
		obj.Execute();
	}

}
