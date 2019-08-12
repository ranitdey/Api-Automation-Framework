package com.freenow.library.models;


import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;

    public Post(JSONObject post)
    {
        this.userId = post.getInt("userId");
        this.id = post.getInt("id");
        this.title = post.getString("title");
        this.body = post.getString("body");
    }
}
