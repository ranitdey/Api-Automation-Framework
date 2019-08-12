package com.freenow.library.models;

import org.json.JSONObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Geo {

    private String lat;
    private String lng;

    public Geo(JSONObject geo)
    {
        this.lat = geo.getString("lat");
        this.lng = geo.getString("lng");
    }
}
