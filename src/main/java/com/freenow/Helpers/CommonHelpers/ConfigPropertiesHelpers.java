package com.freenow.helpers.CommonHelpers;

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

import static com.freenow.Constants.Constants.getPropertiesFileName;
import static com.freenow.Constants.Constants.log4jConfPath;
import static com.freenow.Constants.Constants.propertiesFilePath;

public class ConfigPropertiesHelpers {



    private static Logger log =  LoggerFactory.getLogger(ConfigPropertiesHelpers.class);


    public Properties loadPropertiesFile()
    {
        Properties properties = new Properties();
        String path = FileHelpers.getCurrentDirectory()+ propertiesFilePath + getPropertiesFileName;
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
