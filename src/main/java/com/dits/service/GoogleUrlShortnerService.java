package com.dits.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import com.dits.rest.model.GoogleUrlShortnerRequest;
import com.dits.rest.model.GoogleUrlShortnerResponse;

public interface GoogleUrlShortnerService {
    
    @POST("/urlshortener/v1/url")
    Call<GoogleUrlShortnerResponse> shortUrl(@Query("key") String key, @Body GoogleUrlShortnerRequest googleUrlShortnerRequest);

}
