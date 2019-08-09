package com.freenow.tests;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author Ranit
 * Created on 09/08/2019
 *
 */


public class BaseTest {

    private static Logger log =  LoggerFactory.getLogger(BaseTest.class);


    @BeforeSuite(alwaysRun = true)
    public void setup()
    {
        log.info("********************* API Automation Suite Started *********************");
        log.info("Initializing Test Suite.");

    }

    @AfterMethod
    public void testComplete() {
        log.info("********************* Test Complete *********************");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        log.info("********************* API Automation Suite Ended *********************");
    }
}
