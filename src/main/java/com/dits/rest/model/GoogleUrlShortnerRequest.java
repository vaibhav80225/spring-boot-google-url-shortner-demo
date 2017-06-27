package com.dits.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class GoogleUrlShortnerRequest {
    private String longUrl;

    public GoogleUrlShortnerRequest() {
    }

    public GoogleUrlShortnerRequest(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

}
