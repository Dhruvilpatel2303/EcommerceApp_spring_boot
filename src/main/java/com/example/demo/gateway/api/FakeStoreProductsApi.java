package com.example.demo.gateway.api;


import com.example.demo.dto.FakeStoreProductsDTO;
import com.example.demo.dto.FakeStoreSpecificProductDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

@Component
public interface FakeStoreProductsApi {

    @GET("products")
    Call<FakeStoreProductsDTO> getAllProducts() throws IOException;

    @GET("products/{id}")
    Call<FakeStoreSpecificProductDTO> getSpecificProduct(@Path("id") int id) throws IOException;

}
