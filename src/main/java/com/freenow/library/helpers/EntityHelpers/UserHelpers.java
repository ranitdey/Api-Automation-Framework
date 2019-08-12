package com.freenow.library.helpers.EntityHelpers;

/**
 * @author Ranit
 * Created on 11/08/2019
 *
 */

import com.freenow.library.models.User;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class UserHelpers {

    private static Logger log =  LoggerFactory.getLogger(UserHelpers.class);

    /**
     * This method takes in a response in string format and expects it to be an array of users in
     * JSON format which was converted into string and passed in. This method extracts user
     * entities from the response and puts it into a list of user objects.
     * @param users JSON response of users in string format.
     * @return  This returns a list which contains user objects.
     */
    public List<User> extractUsers(String users)
    {
        List<User> usersList = new ArrayList<>();
        JSONArray usersArray = new JSONArray(users);
        log.info("Extracting Users from response body");
        for (int i = 0; i < usersArray.length(); i++)
        {
            usersList.add(new User(usersArray.getJSONObject(i)));
        }
        return usersList;
    }


}
