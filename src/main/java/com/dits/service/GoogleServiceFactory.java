package com.dits.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GoogleServiceFactory {
    public static ObjectMapper mapper = new ObjectMapper();

    public static <T> T getService(Class<T> clazz) 
            throws InstantiationException, IllegalAccessException, Exception {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();  
        httpClient.addInterceptor(new Interceptor() {  
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder();

                Request request = requestBuilder.build();
                Response resp =  chain.proceed(request);
                
                System.out.println(resp);
                //System.out.println(mapper.writeValueAsString(resp.headers()));
                
                return resp;
            }
        });


        OkHttpClient okHttpClient = httpClient.build(); 
        
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("https://www.googleapis.com")
                .build();

        return retrofit.create(clazz);
    }


}
