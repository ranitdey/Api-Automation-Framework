package com.freenow.helpers;

/**
 * @author Ranit
 * Created on 09/08/2019
 *
 */

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertiesHelpers {

    public static String propertiesFilePath = "/src/main/resources/properties/";
    public static String getPropertiesFileName = "Config.properties";
    public static String log4jConfPath = "/src/main/resources/properties/log4j.properties";

    private static Logger log =  LoggerFactory.getLogger(ConfigPropertiesHelpers.class);


    public Properties loadPropertiesFile()
    {
        Properties properties = new Properties();
        String path = FileHelpers.getCurrentDirectory() + propertiesFilePath + getPropertiesFileName;
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

    public void loadLogConfiguration()
    {
        PropertyConfigurator.configure(FileHelpers.getCurrentDirectory()+log4jConfPath);
    }



}
