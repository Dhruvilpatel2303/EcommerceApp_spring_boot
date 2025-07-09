package com.example.demo.mappers;

import com.example.demo.dto.FakeStoreProductDTO;
import com.example.demo.dto.FakeStoreProductsDTO;
import com.example.demo.dto.FakeStoreSpecificProductDTO;
import com.example.demo.dto.ProductsDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.CategoryRepository;
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
                .categoryId(product.getCategory().getId())
                .build();

    }


    public static Product toEntity(ProductsDTO dto, CategoryRepository categoryRepository) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + dto.getCategoryId()));

        return Product.builder()
                .title(dto.getTitle())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .color(dto.getColor())
                .price(dto.getPrice())
                .discount(dto.getDiscount())
                .image(dto.getImage())
                .description(dto.getDescription())
                .popular(dto.isPopular())
                .category(category)

                .build();
    }
}