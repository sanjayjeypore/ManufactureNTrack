package com.mnt.qa.xtentReport;

import java.io.File;
import java.io.ObjectInputFilter.Status;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class XtentReportListner implements IReporter{
	private ExtentReports extent;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outPutDirectory) {
		extent = new ExtentReports(outPutDirectory +  File.separator + "Extent.html",true);
		
		for(ISuite suite: suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			
			for(ISuiteResult res: result.values()) {
				
				ITestContext context = res.getTestContext();
				buildTestNodes(context.getPassedTests(),LogStatus.PASS);
				buildTestNodes(context.getPassedTests(),LogStatus.FAIL);
				buildTestNodes(context.getPassedTests(),LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap passedTests, LogStatus skip) {
		ExtentTest test;
		if(passedTests.size() > 0) {
			for(ITestResult result: passedTests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for(String group : result.getMethod().getGroups())
					test.assignCategory(group);
				if(result.getThrowable() != null) {
					test.log(skip, result.getThrowable());
				}
				else
					test.log(skip, "Test " + skip.toString().toLowerCase() + "ed");
				extent.endTest(test);				
			}
		}
		
	}

	private Date getTime(long startMillis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(startMillis);
		return calendar.getTime();
	}

}
