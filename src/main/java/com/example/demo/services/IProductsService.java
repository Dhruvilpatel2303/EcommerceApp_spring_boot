package com.example.demo.services;

import com.example.demo.dto.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IProductsService {

    List<ProductsDTO> getAllProducts() throws IOException;

    ProductsDTO getSpecificProduct(Integer id) throws Exception;

    FakeStoreCreateProductResponseDTO createProduct(AddProductDTO addProductDTO) throws IOException;

    FakeStoreUpdateProductResponseDTO updateProduct(int id,UpdateProductDTO updateProductDTO)throws IOException;
    FakeStoreDeleteProductResponseDTO deleteProduct(int id)throws IOException;
    ProductsDTO createProductInDB(ProductsDTO productsDTO);
    List<ProductsDTO> getAllProductsFromDB();
    ProductsDTO getSpecificProductByIDFromDB(Long ID) throws Exception;
    ProductWIthCategoryDTO productWithCategory(Long id) throws Exception;

}
