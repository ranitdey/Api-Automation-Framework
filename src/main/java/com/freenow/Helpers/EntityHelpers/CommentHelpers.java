package com.freenow.helpers.EntityHelpers;

import com.freenow.models.Comment;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;

public class CommentHelpers {


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
        for (int i = 0; i < commentsArray.length(); i++)
        {
            commentsList.add(new Comment(commentsArray.getJSONObject(i)));
        }
        return commentsList;
    }
}
