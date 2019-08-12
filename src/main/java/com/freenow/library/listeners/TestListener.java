package com.freenow.library.listeners;
/**
 * @author Ranit
 * Created on 09/08/2019
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListener implements IInvokedMethodListener {

    private static Logger log =  LoggerFactory.getLogger(TestListener.class);

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        log.info("Starting Test: " + iInvokedMethod.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        log.info("Finished Test: {}, Result: {}",
                iInvokedMethod.getTestMethod().getMethodName(),
                getStatusString(iTestResult.getStatus()));
    }

    public String getStatusString(int testStatus) {
        switch (testStatus) {
            case ITestResult.SUCCESS:   return "Success";
            case ITestResult.FAILURE:   return "Failure";
            case ITestResult.SKIP:      return "Skipped";
            default:                    return "Unknown - " + testStatus;
        }
    }
}