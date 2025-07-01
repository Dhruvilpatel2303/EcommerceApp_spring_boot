package com.example.demo.mappers;

import com.example.demo.dto.FakeStoreProductDTO;
import com.example.demo.dto.FakeStoreProductsDTO;
import com.example.demo.dto.FakeStoreSpecificProductDTO;
import com.example.demo.dto.ProductsDTO;
import org.springframework.stereotype.Component;

import java.util.List;

public class ProductMappers {

    public static List<ProductsDTO> toListProductsDTO(FakeStoreProductsDTO fakeStoreProductsDTO) {
        return fakeStoreProductsDTO.getProducts().stream().map(
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

    public static ProductsDTO toProductDTO(FakeStoreSpecificProductDTO fakeStoreSpecificProductDTO){
        FakeStoreProductDTO p = fakeStoreSpecificProductDTO.getProduct();

        return ProductsDTO.builder()
                .id(p.getId())
                .title(p.getTitle())
                .price(p.getPrice())
                .description(p.getDescription())
                .discount(p.getDiscount())
                .image(p.getImage())
                .build();
    }
}