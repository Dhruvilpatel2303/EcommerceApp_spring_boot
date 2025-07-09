package com.example.demo.mappers;

import com.example.demo.dto.FakeStoreProductDTO;
import com.example.demo.dto.FakeStoreProductsDTO;
import com.example.demo.dto.FakeStoreSpecificProductDTO;
import com.example.demo.dto.ProductsDTO;
import com.example.demo.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public class ProductMappers {

    public static List<ProductsDTO> toListProductsDTO(FakeStoreProductsDTO fakeStoreProductsDTO) {
        return fakeStoreProductsDTO.getProducts().stream().map(
                        products -> ProductsDTO.builder()
                                .id(Long.valueOf(products.getId()))
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
                .id(p.getId().longValue())
                .title(p.getTitle())
                .price(p.getPrice())
                .description(p.getDescription())
                .discount(p.getDiscount())
                .image(p.getImage())
                .build();
    }

    public static ProductsDTO toDTO(Product product){
        return ProductsDTO.builder()
                .id(product.getId().longValue())
                .price(product.getPrice())
                .title(product.getTitle())
                .image(product.getImage())
                .discount(product.getDiscount())
                .color(product.getColor())
                .brand(product.getBrand())

                .description(product.getDescription())
                .popular(product.isPopular())
                .model(product.getModel())
                .build();

    }

    public static Product toEntity(ProductsDTO dto){
        return Product.builder()
                .price(dto.getPrice())
                .title(dto.getTitle())
                .image(dto.getImage())
                .discount(dto.getDiscount())
                .color(dto.getColor())
                .brand(dto.getBrand())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .popular(dto.isPopular())
                .model(dto.getModel())
                .build();

    }
}