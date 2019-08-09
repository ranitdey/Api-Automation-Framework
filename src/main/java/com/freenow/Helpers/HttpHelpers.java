package com.freenow.Helpers;

/**
 * @author Ranit
 * Created on 09/08/2019
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class HttpHelpers {

    private static Logger log =  LoggerFactory.getLogger(HttpHelpers.class);


    /**
     * This method performs a get request.
     * @param endpoint  Url to send the request to
     * @param userGivenHeaders  Headers which will be sent with the http request
     * @return  The response of the request
     */
    public Response get(String endpoint, Headers userGivenHeaders)
    {
        log.info("Executing GET request to url : {}",endpoint);
        return given()
                .headers(userGivenHeaders)
                .get(endpoint);
    }

    /**
     * This method performs a post request.
     * @param endpoint  Url to send the request to
     * @param payload  Body of the request to be made
     * @param userGivenHeaders  Headers which will be sent with the http request
     * @return  The response of the request
     */
    public Response post(String endpoint, String payload, Headers userGivenHeaders)
    {
        log.info("Executing POST request to url : {}",endpoint);
        return given()
                .headers(userGivenHeaders)
                .body(payload)
                .post(endpoint);
    }

    /**
     * This method performs a put request.
     * @param endpoint Url to send the request to
     * @param payload  Body of the request to be made
     * @param userGivenHeaders  Headers which will be sent with the http request
     * @return  The response of the request
     */
    public Response put(String endpoint,String payload,Headers userGivenHeaders)
    {
        log.info("Executing PUT request to url : {}",endpoint);
        return given()
                .headers(userGivenHeaders)
                .body(payload)
                .put(endpoint);
    }

    /**
     * This method performs a patch request.
     * @param endpoint  Url to send the request to
     * @param payload  Body of the request to be made
     * @param userGivenHeaders  Headers which will be sent with the http request
     * @return  The response of the request
     */
    public Response patch(String endpoint, String payload,Headers userGivenHeaders)
    {
        log.info("Executing PATCH request to url : {}",endpoint);
        return given()
                .headers(userGivenHeaders)
                .body(payload)
                .patch(endpoint);
    }

    /**
     * This method performs a delete request.
     * @param endpoint  Url to send the request to
     * @param userGivenHeaders  Headers which will be sent with the http request
     * @return  The response of the request
     */
    public Response delete(String endpoint, Headers userGivenHeaders)
    {
        log.info("Executing DELETE request to url : {}",endpoint);
        return given()
                .headers(userGivenHeaders)
                .delete(endpoint);
    }

    /**
     * This method creates a collections of some default headers.
     * @return  This returns a multi valued entity which is called as Headers which is just a
     * collection of some default headers.
     */
    public Headers getDefaultHeaders()
    {
        List<Header> list = new ArrayList<Header>();
        list.add(new Header("Accept", "*/*"));
        list.add(new Header("Content-Type", "application/json"));
        return new Headers(list);
    }

}

