package com.example.demo.gateway.api;

import com.example.demo.dto.FakeStoreCategoryDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.List;

@Component
public interface FakeStoreCategoryApi {


    @GET("products/category")
    Call<FakeStoreCategoryDTO> getAllCategories() throws IOException;


}
