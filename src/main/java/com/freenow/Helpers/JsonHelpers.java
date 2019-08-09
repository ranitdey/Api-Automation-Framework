package com.freenow.Helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.response.Response;

public class JsonHelpers {


    private static Logger log =  LoggerFactory.getLogger(JsonHelpers.class);


    /**
     * This method takes a string representation of a JSON object and converts it to a pretty format
     * @param jsonString  String representation of a JSON object
     * @return This returns a formatted string
     */
    public static String toPrettyFormat(String jsonString)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement =  new JsonParser().parse(jsonString);
        return gson.toJson(jsonElement);
    }

    /**
     * This method validates a response body with a given JSON schema.
     * @param response  Response object which will get validated against the JSON schema
     * @param schemaName Name of the file of the schema which will be used for validating the
     * response body. The schema JSON file should be present as this function searches the resource
     * folder to get the schema file.
     * @return  This method returns true if the response json is a valid json against the
     * given schema.If the response json is not valid it returns false.
     */
    public static boolean jsonSchemaValidator(Response response, String schemaName)
    {
        try
        {
            log.info("Loading JSON schema file : {}.json",schemaName);
            JSONObject jsonSchema = new JSONObject(new JSONTokener
                    (JsonHelpers.class.getResourceAsStream("/"+schemaName+".json")));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(new JSONObject(response.getBody().asString()));
            return true;
        }
        catch (ValidationException e)
        {
            log.info("::::::::::::::Json schema validation failed::::::::::::::");
            log.info("Error message : {}",e.getErrorMessage());
            return false;
        }
    }
}
