package com.freenow.library.models;


import org.json.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;


    public User(JSONObject user)
    {
        this.id = user.getInt("id");
        this.name = user.getString("name");
        this.username = user.getString("username");
        this.email = user.getString("email");
        this.address = new Address(user.getJSONObject("address"));
        this.phone = user.getString("phone");
        this.website = user.getString("website");
        this.company = new Company(user.getJSONObject("company"));
    }





}
