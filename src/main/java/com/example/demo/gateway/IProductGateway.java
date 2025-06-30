package com.example.demo.gateway;

import com.example.demo.dto.*;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    List<ProductsDTO> getAllProducts() throws IOException;
    ProductsDTO getSpecificProduct(int id) throws IOException;
    FakeStoreCreateProductResponseDTO createProduct(AddProductDTO addProductDTO) throws IOException;
    FakeStoreUpdateProductResponseDTO updateProduct(int id,UpdateProductDTO updateProductDTO)throws IOException;
    FakeStoreDeleteProductResponseDTO deleteProduct(int id) throws IOException;
}
