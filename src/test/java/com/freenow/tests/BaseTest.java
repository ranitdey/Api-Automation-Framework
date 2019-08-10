package com.freenow.tests;


import com.freenow.helpers.ConfigPropertiesHelpers;

import org.apache.log4j.BasicConfigurator;
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
    private ConfigPropertiesHelpers config;


    @BeforeSuite(alwaysRun = true)
    public void setup()
    {
        config = new ConfigPropertiesHelpers();
        config.loadLogConfiguration();
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
