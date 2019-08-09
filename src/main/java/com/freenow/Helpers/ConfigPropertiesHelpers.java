package com.freenow.Helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.freenow.Helpers.FileHelpers.getCurrentDirectory;

public class ConfigPropertiesHelpers {

    public static String propertiesFilePath = "/src/main/resources/Properties/";
    public static String getPropertiesFileName = "Config.properties";


    public Properties loadPropertiesFile()
    {
        Properties properties = new Properties();
        try
        {
            InputStream propertiesFileStram = new FileInputStream
                    (getCurrentDirectory() + propertiesFilePath + getPropertiesFileName);
            properties.load(propertiesFileStram);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return properties;
    }

}
