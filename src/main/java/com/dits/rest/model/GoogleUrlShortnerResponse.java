package com.dits.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class GoogleUrlShortnerResponse {
   
    private String id;
    private String longUrl;
    private String kind;
    
    
    public GoogleUrlShortnerResponse() {
        super();
    }
    
    public GoogleUrlShortnerResponse(String id, String longUrl, String kind) {
        super();
        this.id = id;
        this.longUrl = longUrl;
        this.kind = kind;
    }

    public String getLongUrl() {
        return longUrl;
    }
    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

}
