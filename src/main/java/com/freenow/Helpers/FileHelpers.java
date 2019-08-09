package com.freenow.Helpers;

public class FileHelpers {

    public static String getCurrentDirectory()
    {
        String cwd = System.getProperty("user.dir");
        return cwd;
    }
}
