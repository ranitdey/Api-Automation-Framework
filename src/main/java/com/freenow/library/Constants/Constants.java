package com.freenow.library.Constants;

import java.util.regex.Pattern;

public class Constants {

    public static final String usersRoute = "/users";
    public static final String postsRoute = "/posts";
    public static final String commentsRoute = "/comments";
    public static final String propertiesFilePath = "/src/main/resources/properties/";
    public static final String getPropertiesFileName = "config.properties";
    public static final String log4jConfPath = "/src/main/resources/properties/log4j.properties";
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
            .compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);

}
