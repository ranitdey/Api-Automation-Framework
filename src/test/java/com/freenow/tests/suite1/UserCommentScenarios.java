package com.freenow.tests.suite1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.freenow.helpers.HttpHelpers;

public class UserCommentScenarios {

    private HttpHelpers api;


    @BeforeClass
    public void initialize() {
         api = new HttpHelpers();
    }

    @Test
    public void test1()
    {
        //Basic Test

    }

}
