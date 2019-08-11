package com.freenow.helpers.EntityHelpers;

/**
 * @author Ranit
 * Created on 11/08/2019
 *
 */

import com.freenow.models.Post;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PostHelpers {

    private static Logger log =  LoggerFactory.getLogger(PostHelpers.class);

    /**
     * This method takes in a response in string format and expects it to be an array of posts in
     * JSON format which was converted into string and passed in. This method extracts post
     * entities from the response and puts it into a list of post objects.
     * @param posts JSON response of posts in string format.
     * @return  This returns a list which contains post objects.
     */
    public List<Post> extractPosts(String posts)
    {
        List<Post> postsList = new ArrayList<>();
        JSONArray postsArray = new JSONArray(posts);
        log.info("Extracting Posts from response body");
        for (int i = 0; i < postsArray.length(); i++)
        {
            postsList.add(new Post(postsArray.getJSONObject(i)));
        }
        return postsList;
    }

}
