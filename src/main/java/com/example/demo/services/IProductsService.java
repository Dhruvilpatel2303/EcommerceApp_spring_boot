package com.example.demo.services;

import com.example.demo.dto.*;

import java.io.IOException;
import java.util.List;

public interface IProductsService {

    List<ProductsDTO> getAllProducts() throws IOException;

    ProductsDTO getSpecificProduct(Integer id) throws IOException;

    FakeStoreCreateProductResponseDTO createProduct(AddProductDTO addProductDTO) throws IOException;

    FakeStoreUpdateProductResponseDTO updateProduct(int id,UpdateProductDTO updateProductDTO)throws IOException;
    FakeStoreDeleteProductResponseDTO deleteProduct(int id)throws IOException;
}
