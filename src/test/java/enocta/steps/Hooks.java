package enocta.steps;

import enocta.testbase.BaseClass;
import enocta.utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

	@Before
	public void start()
	{
		BaseClass.setUp();
	}
	
	@After
	public void end(Scenario scenario)
	{
		byte[] screenshot; 
		
		if (scenario.isFailed())
		{
			// take a screenshot and save it under "failed" folder
			screenshot = takeScreenshot("failed/" + scenario.getName());
		}
		else 
		{
			// take a screenshot and save it under "passed" folder
			screenshot = takeScreenshot("passed/" + scenario.getName());
		}
		
		scenario.attach(screenshot, "image/png", scenario.getName());
		
		BaseClass.tearDown();
	}
	
}
