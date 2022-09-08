package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * 
 * @author Zabiulla
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int retryLimits=3;
	
	public boolean retry(ITestResult result) {
		if (count<retryLimits) {
			count ++;
			return true;
			
		}
		return false;
	}
}
