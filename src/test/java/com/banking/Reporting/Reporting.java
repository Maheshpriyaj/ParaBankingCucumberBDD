package com.banking.Reporting;

import java.io.File;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.util.ArrayList;
import java.util.List;

public class Reporting {
	
	 public static void generateJVMReport(String jsonFilePath) {
	        File reportOutputDirectory = new File("target/cucumber-reports/jvm-report");
	        List<String> jsonFiles = new ArrayList<>();
	        jsonFiles.add(jsonFilePath);

	        Configuration config = new Configuration(reportOutputDirectory, "Para Banking");
	        config.addClassifications("Platform", "Windows");
	        config.addClassifications("Browser", "Chrome");
	        

	        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
	        reportBuilder.generateReports();
	    }

}
