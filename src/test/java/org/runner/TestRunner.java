package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\user\\eclipse-workspace\\SampleCucumber\\src\\test\\resources\\features\\login.feature", glue= {"org.stepdefi"},plugin="json:C:\\Users\\user\\eclipse-workspace\\SampleCucumber\\src\\test\\resources\\Report\\output.json", dryRun =false, snippets=SnippetType.CAMELCASE,strict = true)


public class TestRunner {
	
	@AfterClass
	public static void after() {
		Reporting.jvm("C:\\Users\\user\\eclipse-workspace\\SampleCucumber\\src\\test\\resources\\Report\\output.json");
		

	}
	

}
