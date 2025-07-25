package com.example.demo.services;

import com.example.demo.dto.*;
import com.example.demo.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductService implements IProductsService{

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }


    @Override
    public List<ProductsDTO> getAllProducts() throws IOException {
        return productGateway.getAllProducts();
    }

    @Override
    public ProductsDTO getSpecificProduct(Integer id) throws IOException {
        return productGateway.getSpecificProduct(id);
    }

    @Override
    public FakeStoreCreateProductResponseDTO createProduct(AddProductDTO addProductDTO) throws IOException {
        return productGateway.createProduct(addProductDTO);
    }

    @Override
    public FakeStoreUpdateProductResponseDTO updateProduct(int id, UpdateProductDTO updateProductDTO) throws IOException {
        return productGateway.updateProduct(id,updateProductDTO);
    }

    @Override
    public FakeStoreDeleteProductResponseDTO deleteProduct(int id) throws IOException {
        return productGateway.deleteProduct(id);
    }

    @Override
    public ProductsDTO createProductInDB(ProductsDTO productsDTO) {
        return null;
    }

    @Override
    public List<ProductsDTO> getAllProductsFromDB() {
        return null;
    }

    @Override
    public ProductsDTO getSpecificProductByIDFromDB(Long ID) {
        return null;
    }

    @Override
    public ProductWIthCategoryDTO productWithCategory(Long id) {
        return null;
    }

    @Override
    public List<ProductsDTO> getExpensiveProducts(Long minPrice) {
        return List.of();
    }

    @Override
    public List<ProductsDTO> getProductByProductName(String productname) {
        return List.of();
    }

}
