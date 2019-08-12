package com.freenow.library.helpers.AssertionHelpers;
/**
 * @author Ranit
 * Created on 11/08/2019
 *
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Matcher;
import static com.freenow.library.Constants.Constants.VALID_EMAIL_ADDRESS_REGEX;

public class AssertionHelper {

    private static Logger log =  LoggerFactory.getLogger(AssertionHelper.class);

    /**
     * This method validates an email address based on the regex pattern defined. It raises an
     * assert exception if the validation fails.
     * @param emailStr  Email address in string format.
     */
    public void validate(String emailStr) {
        log.info("Validating Email id : {}",emailStr);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        assert  matcher.find();
        log.info("Email validation successful for {} ",emailStr);
    }
}
