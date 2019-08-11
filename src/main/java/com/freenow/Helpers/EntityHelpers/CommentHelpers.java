package com.freenow.helpers.EntityHelpers;
/**
 * @author Ranit
 * Created on 11/08/2019
 *
 */

import com.freenow.models.Comment;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class CommentHelpers {

    private static Logger log =  LoggerFactory.getLogger(CommentHelpers.class);


    /**
     * This method takes in a response in string format and expects it to be an array of comments in
     * JSON format which was converted into string and passed in. This method extracts comment
     * entities from the response and puts it into a list of comment objects.
     * @param comments JSON response of comments in string format.
     * @return  This returns a list which contains comment objects.
     */
    public List<Comment> extractComments(String comments)
    {
        List<Comment> commentsList = new ArrayList<>();
        JSONArray commentsArray = new JSONArray(comments);
        log.info("Extracting Comments from response body");
        for (int i = 0; i < commentsArray.length(); i++)
        {
            commentsList.add(new Comment(commentsArray.getJSONObject(i)));
        }
        return commentsList;
    }
}
