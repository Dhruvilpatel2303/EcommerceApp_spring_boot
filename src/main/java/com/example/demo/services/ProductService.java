package com.example.demo.services;

import com.example.demo.dto.*;
import com.example.demo.entities.Product;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.mappers.ProductMappers;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class ProductService implements IProductsService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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
      Product saved=  productRepository.save(ProductMappers.toEntity(productsDTO,categoryRepository));
        return ProductMappers.toDTO(saved);
    }

    @Override
    public List<ProductsDTO> getAllProductsFromDB() {
        return productRepository.findAll().stream().map(ProductMappers::toDTO).toList();
    }

    @Override
    public ProductsDTO  getSpecificProductByIDFromDB(Long ID) {
        return productRepository.findById(ID).map(
                ProductMappers::toDTO
        ).orElseThrow(
                () -> new ProductNotFoundException("Product Not Found with ID " + ID )
        );
    }

    @Override
    public ProductWIthCategoryDTO productWithCategory(Long id) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        return ProductMappers.toProductWithCategoryDTO(product);
    }

    @Override
    public List<ProductsDTO> getExpensiveProducts(Long minPrice) {
        return productRepository.findExpensiveProducts(minPrice).stream().map(
                ProductMappers::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<ProductsDTO> getProductByProductName(String productname) {
        return productRepository.searchFullText(productname).stream().map(
                ProductMappers::toDTO
        ).collect(Collectors.toList());
    }

    public List<ProductsDTO> getAllProductsDB(){
        return productRepository.findAll()
                .stream()
                .map(ProductMappers::toDTO)
                .collect(Collectors.toList())
                ;
    }



    public void delete(Long id){
        productRepository.deleteById(id);
    }




}
