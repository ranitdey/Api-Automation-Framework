package com.freenow.library.models;


import org.json.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comment {


    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;


    public Comment(JSONObject comment)
    {
        this.postId = comment.getInt("postId");
        this.id = comment.getInt("id");
        this.name = comment.getString("name");
        this.email = comment.getString("email");
        this.body = comment.getString("body");
    }





}
