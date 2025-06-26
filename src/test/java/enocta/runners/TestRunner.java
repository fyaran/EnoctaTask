package enocta.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		//we can specify which features to run
		features="src/test/resources/features/",

		//we can specify where the codes for the features are
		glue="enocta.steps", 
		
		//if this is set to true --> it only checks if the steps are glued (no functionality execution)
		
		dryRun=true, 
		
		// by default is false. When true will makes the console (and logs) more readable.
		monochrome=true, 
		
		//we can define a tag or a combination of tags to run
		tags= "@menu",
		
		plugin = {
					// prints the tagged Gherkin scenario(s) steps to the console
					//"pretty",
					// creates and saves a basic html report in the target folder 
					"html:target/cucumber-default-report.html",
					// stores all executed steps in a json file
					"json:target/cucumber.json"
				}
				
		
		)



public class TestRunner {

}
