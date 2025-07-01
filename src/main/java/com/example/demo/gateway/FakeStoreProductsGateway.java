package com.example.demo.gateway;

import com.example.demo.dto.*;
import com.example.demo.gateway.api.FakeStoreProductsApi;
import com.example.demo.mappers.ProductMappers;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductsGateway implements IProductGateway{


    private final FakeStoreProductsApi fakeStoreProductsApi;

    public FakeStoreProductsGateway( FakeStoreProductsApi fakeStoreProductsApi) {

        this.fakeStoreProductsApi = fakeStoreProductsApi;
    }


    @Override
    public List<ProductsDTO> getAllProducts() throws IOException {
        FakeStoreProductsDTO response = this.fakeStoreProductsApi.getAllProducts().execute().body();

        if (response==null){
            throw new IOException("Failed to fetch the products");
        }
        return ProductMappers.toListProductsDTO(response);

    }

    @Override
    public ProductsDTO getSpecificProduct(int id) throws IOException {
        FakeStoreSpecificProductDTO response = this.fakeStoreProductsApi.getSpecificProduct(id).execute().body();

        if (response == null || response.getProduct() == null) {
            throw new IOException("Failed to fetch product details");
        }

        return ProductMappers.toProductDTO(response);
    }

    @Override
    public FakeStoreCreateProductResponseDTO createProduct(AddProductDTO addProductDTO) throws IOException {
       FakeStoreCreateProductResponseDTO retrofitResponse = fakeStoreProductsApi.createProduct(addProductDTO).execute().body();

        FakeStoreCreateProductResponseDTO body = retrofitResponse;

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
