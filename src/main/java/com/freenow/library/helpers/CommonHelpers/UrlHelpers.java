package com.freenow.library.helpers.CommonHelpers;

/**
 * @author Ranit
 * Created on 11/08/2019
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.Properties;
import static com.freenow.library.Constants.Constants.commentsRoute;
import static com.freenow.library.Constants.Constants.postsRoute;
import static com.freenow.library.Constants.Constants.usersRoute;

public class UrlHelpers {

    private static Logger log =  LoggerFactory.getLogger(UrlHelpers.class);
    private String endpoint;

    public UrlHelpers()
    {
        ConfigPropertiesHelpers config = new ConfigPropertiesHelpers();
        Properties properties = config.loadPropertiesFile();
        log.info("Setting Base url as : {}",properties.getProperty("BASE_URL"));
        endpoint = properties.getProperty("BASE_URL");
    }

    public enum EndpointURL {
        USERS(usersRoute),
        POSTS(postsRoute),
        COMMENTS(commentsRoute);

        private String resourcePath;

        EndpointURL(String resourcePath)
        {
            this.resourcePath = resourcePath;
        }

        public String getResourcePath()
        {
            return this.resourcePath;
        }
    }

    /**
     * This method takes the base url which gets loaded from the properties file and then appends
     * URI paths and query parameters and returns back the final endpoint.
     * @param path URI path of resource which will be used in endpoint url.
     * @param queryParam Query parameters which will get appended in the final endpoint url.
     * @return  It returns the final generated endpoint url.
     */
    public String generateURL(EndpointURL path, Map<String,String> queryParam) {
        String url = endpoint + path.getResourcePath();
        int count = 0;
        if (!queryParam.isEmpty())
        {
            url=url+"?";
            for (Map.Entry<String, String> entry : queryParam.entrySet())
            {
                if (count>0)
                {
                    url=url+"&";
                }
                url=url+entry.getKey()+"="+entry.getValue();
                count++;
            }
        }
        return url;
    }

    /**
     * This method takes the base url which gets loaded from the properties file and then appends
     * URI paths and returns back the final endpoint.
     * @param path path URI path of resource which will be used in endpoint url.
     * @return It returns the final generated endpoint url.
     */
    public String generateURL(EndpointURL path)
    {
        return endpoint + path.getResourcePath();
    }



}
