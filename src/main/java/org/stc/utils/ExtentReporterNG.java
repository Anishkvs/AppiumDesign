package org.stc.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	public static ExtentReports report;
	public static ExtentTest logger;
		static String reportPath = System.getProperty("user.dir") + "/Reports/";

	public static ExtentReports getReporterObject()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
		Date date = new Date();
		String filePathdate = dateFormat.format(date).toString();
		String actualReportPath = reportPath + "index.html";
		new File(actualReportPath).renameTo(new File(
		System.getProperty("user.dir") + "/reports/" + "Automation_Report_Part_01_" + filePathdate + ".html"));
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Reports - STC");
		reporter.config().setReportName("STC B2C Mobile Automation Results");
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation", "Anish Kumar V");
		extent.setSystemInfo("Company", "STC");
		extent.setSystemInfo("App", "my stc KW");
		extent.setSystemInfo("Build No", "v5.15.0.855");
		return extent;
		
	}

	
}
