package com.freenow.models;


import org.json.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {


    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(JSONObject address)
    {
        this.street = address.getString("street");
        this.suite = address.getString("suite");
        this.city = address.getString("city");
        this.zipcode = address.getString("zipcode");
        this.geo = new Geo(address.getJSONObject("geo"));
    }
}
