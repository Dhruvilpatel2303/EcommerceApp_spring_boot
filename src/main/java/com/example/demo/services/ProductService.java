package com.example.demo.services;

import com.example.demo.dto.*;
import com.example.demo.entities.Product;
import com.example.demo.mappers.ProductMappers;
import com.example.demo.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Primary
public class ProductService implements IProductsService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductsDTO> getAllProducts() throws IOException {
        return List.of();
    }

    @Override
    public ProductsDTO getSpecificProduct(Integer id) throws Exception {
        return productRepository.findById(id.longValue())
                .map(
                        ProductMappers::toDTO
                ).orElseThrow(() -> new Exception("Product Not found"));
    }

    @Override
    public FakeStoreCreateProductResponseDTO createProduct(AddProductDTO addProductDTO) throws IOException {
        return null;
    }

    @Override
    public FakeStoreUpdateProductResponseDTO updateProduct(int id, UpdateProductDTO updateProductDTO) throws IOException {
        return null;
    }

    @Override
    public FakeStoreDeleteProductResponseDTO deleteProduct(int id) throws IOException {
        return null;
    }

    @Override
    public ProductsDTO createProductInDB(ProductsDTO productsDTO) {
      Product saved=  productRepository.save(ProductMappers.toEntity(productsDTO));
        return ProductMappers.toDTO(saved);
    }
}
