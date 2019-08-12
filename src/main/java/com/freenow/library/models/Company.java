package com.freenow.library.models;

import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Company {

    private String name;
    private String catchPhrase;
    private String bs;

    public Company(JSONObject company)
    {
        this.name = company.getString("name");
        this.catchPhrase = company.getString("catchPhrase");
        this.bs = company.getString("bs");
    }
}
