package utilities;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	int count=0;
	  
	
	@Before
	public void launch() throws MalformedURLException{  
		ReusableActions.launch();
	}
	
	@After
	public void terdown(Scenario scenario){
		 System.out.println(++count+"preincrement");
		 System.out.println(count++ +"postincrement");
		System.out.println(scenario.getName().replace(" ", "_"));
		 
		try {
		     if (scenario.isFailed()) {
		       final byte[] screenshot = ((TakesScreenshot) ReusableActions.driver())
		           .getScreenshotAs(OutputType.BYTES);
		       scenario.embed(screenshot, "image/png");
		     }
		   } 
		finally {
			   ReusableActions.teardown();
		   }
	}

}
