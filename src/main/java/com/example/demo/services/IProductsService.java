package com.example.demo.services;

import com.example.demo.dto.FakeStoreSpecificProductDTO;
import com.example.demo.dto.ProductsDTO;

import java.io.IOException;
import java.util.List;

public interface IProductsService {

    List<ProductsDTO> getAllProducts() throws IOException;
    ProductsDTO getSpecificProduct(Integer id) throws IOException;
}
