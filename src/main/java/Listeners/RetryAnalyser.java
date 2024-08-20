package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyser implements IRetryAnalyzer {

	int cnt = 0;
	int maxCnt = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (cnt < maxCnt) {
			cnt++;
			return true;
		}

		return false;
	}

}