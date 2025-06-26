package com.example.demo.gateway;

import com.example.demo.dto.FakeStoreProductsDTO;
import com.example.demo.dto.ProductsDTO;
import com.example.demo.gateway.api.FakeStoreCategoryApi;
import com.example.demo.gateway.api.FakeStoreProductsApi;
import org.springframework.stereotype.Component;

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
}
