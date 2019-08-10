package com.freenow.helpers.CommonHelpers;

import java.util.Map;
import java.util.Properties;

import static com.freenow.Constants.Constants.commentsRoute;
import static com.freenow.Constants.Constants.postsRoute;
import static com.freenow.Constants.Constants.usersRoute;

public class UrlHelpers {

    private String endpoint;

    public UrlHelpers()
    {
        ConfigPropertiesHelpers config = new ConfigPropertiesHelpers();
        Properties properties = config.loadPropertiesFile();
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

    public String generateURL(EndpointURL path)
    {
        return endpoint + path.getResourcePath();
    }



}
