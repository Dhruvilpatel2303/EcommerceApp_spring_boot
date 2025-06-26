package com.example.demo.gateway.api;


import com.example.demo.dto.FakeStoreProductsDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

@Component
public interface FakeStoreProductsApi {

    @GET("products")
    Call<FakeStoreProductsDTO> getAllProducts() throws IOException;

}
