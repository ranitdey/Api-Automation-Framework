package com.freenow.Helpers;

/**
 * @author Ranit
 * Created on 09/08/2019
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.freenow.Helpers.FileHelpers.getCurrentDirectory;

public class ConfigPropertiesHelpers {

    public static String propertiesFilePath = "/src/main/resources/Properties/";
    public static String getPropertiesFileName = "Config.properties";

    private static Logger log =  LoggerFactory.getLogger(ConfigPropertiesHelpers.class);


    public Properties loadPropertiesFile()
    {
        Properties properties = new Properties();
        String path = getCurrentDirectory() + propertiesFilePath + getPropertiesFileName;
        try
        {
            log.info("Loading properties file from: {}",path);
            InputStream propertiesFileStream = new FileInputStream(path);
            properties.load(propertiesFileStream);
            log.info("Completed loading properties file from {}",path);
        }
        catch (IOException ex)
        {
            log.info(":::::::::::::: Loading properties file failed ::::::::::::::");
            log.info("Error: {}",ex.getStackTrace());
        }
        return properties;
    }

}
