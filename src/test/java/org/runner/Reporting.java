package org.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void jvm(String jsonFile) {
		File reportDirectory = new File(
				"C:\\Users\\user\\eclipse-workspace\\SampleCucumber\\src\\test\\resources\\Report");
		Configuration config = new Configuration(reportDirectory, "Adactin automation");

		config.addClassifications("os", "windows");
		config.addClassifications("Browser", "chrome");
		config.addClassifications("version", "93");
		config.addClassifications("sprint", "25");
		
		List <String> Files=new ArrayList <String> ();
		Files.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(Files, config);
		builder.generateReports();
	}

	

}
