package com.example.demo.configuration;

import com.example.demo.gateway.api.FakeStoreCategoryApi;
import com.example.demo.gateway.api.FakeStoreProductsApi;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



@Configuration
public class Retrofitconfig{


    @Bean
    public Retrofit retrofit(){
        Dotenv dotenv = Dotenv.configure().load();
        String baseurl = dotenv.get("BASEURL");
        return new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
        System.out.println("data fetched by postman");
        return retrofit.create(FakeStoreCategoryApi.class);

    }

    @Bean
    public FakeStoreProductsApi fakeStoreProductsApi(Retrofit retrofit){
        return retrofit.create(FakeStoreProductsApi.class);
    }





}
