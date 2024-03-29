package com.freenow.tests;


import com.freenow.library.helpers.AssertionHelpers.AssertionHelper;
import com.freenow.library.helpers.CommonHelpers.ConfigPropertiesHelpers;
import com.freenow.library.helpers.CommonHelpers.HttpHelpers;
import com.freenow.library.helpers.CommonHelpers.JsonHelpers;
import com.freenow.library.helpers.CommonHelpers.UrlHelpers;
import com.freenow.library.helpers.EntityHelpers.CommentHelpers;
import com.freenow.library.helpers.EntityHelpers.PostHelpers;
import com.freenow.library.helpers.EntityHelpers.UserHelpers;
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
    protected ConfigPropertiesHelpers config;
    protected HttpHelpers api;
    protected UrlHelpers urlUtils;
    protected UserHelpers usersUtil;
    protected AssertionHelper assertionUtil;
    protected PostHelpers postUtils;
    protected CommentHelpers commentUtil;
    protected JsonHelpers jsonUtil;


    @BeforeSuite(alwaysRun = true)
    public void setup()
    {
        log.info("********************* API Automation Suite Started *********************");
        log.info("Invoking setup");
        api = new HttpHelpers();
        config = new ConfigPropertiesHelpers();
        config.loadLogConfiguration();
        urlUtils = new UrlHelpers();
        usersUtil = new UserHelpers();
        assertionUtil= new AssertionHelper();
        postUtils= new PostHelpers();
        commentUtil = new CommentHelpers();
        jsonUtil = new JsonHelpers();
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
