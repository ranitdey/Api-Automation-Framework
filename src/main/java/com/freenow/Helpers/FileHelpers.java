package com.freenow.Helpers;

public class FileHelpers {

    /**
     * This method finds the path till the project directory
     * @return  This returns the path till the current project directory
     */
    public static String getCurrentDirectory()
    {
        String cwd = System.getProperty("user.dir");
        return cwd;
    }
}
