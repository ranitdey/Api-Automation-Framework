package com.freenow.helpers.AssertionHelpers;

import java.util.regex.Matcher;

import static com.freenow.Constants.Constants.VALID_EMAIL_ADDRESS_REGEX;

public class AssertionHelper {

    public void validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        assert  matcher.find();
    }

}
