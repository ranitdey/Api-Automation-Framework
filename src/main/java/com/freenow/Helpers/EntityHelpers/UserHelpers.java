package com.freenow.helpers.EntityHelpers;

import com.freenow.models.User;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class UserHelpers {

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
        for (int i = 0; i < usersArray.length(); i++)
        {
            usersList.add(new User(usersArray.getJSONObject(i)));
        }
        return usersList;
    }


}
