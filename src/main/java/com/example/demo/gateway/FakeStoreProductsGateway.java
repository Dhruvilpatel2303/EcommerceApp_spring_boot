package com.example.demo.gateway;

import com.example.demo.dto.*;
import com.example.demo.gateway.api.FakeStoreProductsApi;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductsGateway implements IProductGateway{

    private final FakeStoreProductsApi fakeStoreProductsApi;

    public FakeStoreProductsGateway(FakeStoreProductsApi fakeStoreProductsApi) {
        this.fakeStoreProductsApi = fakeStoreProductsApi;
    }


    @Override
    public List<ProductsDTO> getAllProducts() throws IOException {
        FakeStoreProductsDTO response = this.fakeStoreProductsApi.getAllProducts().execute().body();

        if (response==null){
            throw new IOException("Failed to fetch the products");
        }

        return response.getProducts().stream().map(
                products -> ProductsDTO.builder()
                        .id(products.getId())
                        .title(products.getTitle())
                        .price(products.getPrice())
                        .image(products.getImage())
                        .description(products.getDescription())
                        .discount(products.getDiscount())
                        .build())
                .toList();

    }

    @Override
    public ProductsDTO getSpecificProduct(int id) throws IOException {
        FakeStoreSpecificProductDTO response = this.fakeStoreProductsApi.getSpecificProduct(id).execute().body();

        if (response == null || response.getProduct() == null) {
            throw new IOException("Failed to fetch product details");
        }

        FakeStoreProductDTO p = response.getProduct();

        return ProductsDTO.builder()
                .id(p.getId())
                .title(p.getTitle())
                .price(p.getPrice())
                .description(p.getDescription())
                .discount(p.getDiscount())
                .image(p.getImage())
                .build();
    }

    @Override
    public FakeStoreCreateProductResponseDTO createProduct(AddProductDTO addProductDTO) throws IOException {
       FakeStoreCreateProductResponseDTO retrofitResponse = fakeStoreProductsApi.createProduct(addProductDTO).execute().body();

//        if (!retrofitResponse.isSuccessful()) {
//            throw new IOException("API error: " + retrofitResponse.code() + " - " + retrofitResponse.errorBody().string());
//        }
//
        FakeStoreCreateProductResponseDTO body = retrofitResponse;
//
//        if (body == null) {
//            throw new IOException("Received null body from product creation API");
//        }

        return body;
    }

    @Override
    public FakeStoreUpdateProductResponseDTO updateProduct(int id,UpdateProductDTO updateProductDTO) throws IOException {
        FakeStoreUpdateProductResponseDTO response=fakeStoreProductsApi.updateProduct(id,updateProductDTO).execute().body();


        return response;
    }

    @Override
    public FakeStoreDeleteProductResponseDTO deleteProduct(int id) throws IOException {
        FakeStoreDeleteProductResponseDTO response=fakeStoreProductsApi.deleteProduct(id).execute().body();
        return response;
    }


}
