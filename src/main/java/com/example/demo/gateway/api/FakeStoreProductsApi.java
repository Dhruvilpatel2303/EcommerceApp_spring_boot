package com.example.demo.gateway.api;


import com.example.demo.dto.*;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.IOException;

@Component
public interface FakeStoreProductsApi {

    @GET("products")
    Call<FakeStoreProductsDTO> getAllProducts() throws IOException;

    @GET("products/{id}")
    Call<FakeStoreSpecificProductDTO> getSpecificProduct(@Path("id") int id) throws IOException;

    @POST("products")
    Call<FakeStoreCreateProductResponseDTO> createProduct(@Body AddProductDTO addProductDTO);

    @PUT("products/{id}")
    Call<FakeStoreUpdateProductResponseDTO> updateProduct(@Path("id") int id,@Body UpdateProductDTO updataeProductDTO);

    @DELETE("products/{id}")
    Call<FakeStoreDeleteProductResponseDTO> deleteProduct(@Path("id") int id)throws IOException;

}
