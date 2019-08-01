package mapsynq.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import mapsynq.qa.testbase.BaseClass;

public class TestITlisteners extends BaseClass implements ITestListener {

	@Override	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case Initiated");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("testcase is pass "+result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("testcase is failed "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("testcase is skiped "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}



	@Override
	public void onFinish(ITestContext Result) {
		// TODO Auto-generated method stub
		System.out.println("Test Suite Ended");
		endReport();		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Suite Initiated");
		startTest("Mapsynq Automation");
	}
}
