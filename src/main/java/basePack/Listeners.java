package basePack;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report configuration started", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report backup", true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("=====" + result.getMethod().getMethodName() + " Execution STARTED=====", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		Reporter.log("=====" + result.getMethod().getMethodName() + "SUCCESS=====", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		Reporter.log("=====" + testName + " FAILURE=====", true);
		Date d = new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");

		TakesScreenshot ts = (TakesScreenshot)Baseclass.sdriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./Screenshots/" + testName + " " + newDate + ".png");

		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
