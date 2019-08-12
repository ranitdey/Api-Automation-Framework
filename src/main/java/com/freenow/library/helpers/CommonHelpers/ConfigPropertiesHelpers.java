package com.freenow.library.helpers.CommonHelpers;

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

import static com.freenow.library.Constants.Constants.getPropertiesFileName;
import static com.freenow.library.Constants.Constants.log4jConfPath;
import static com.freenow.library.Constants.Constants.propertiesFilePath;

public class ConfigPropertiesHelpers {

    private static Logger log =  LoggerFactory.getLogger(ConfigPropertiesHelpers.class);

    /**
     * This method loads the properties file from resources folder.
     * @return It returns the object of properties file for further usage.
     */
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
        catch (IOException e)
        {
            log.info(":::::::::::::: Loading properties file failed ::::::::::::::");
            log.info("Error: {}",e.getMessage());
        }
        return properties;
    }

    /**
     * This method loads the log configuration from the resources folder.
     */
    public void loadLogConfiguration()
    {
        log.info("Loading configurations for properties file");
        PropertyConfigurator.configure(FileHelpers.getCurrentDirectory()+log4jConfPath);
    }
}
