package com.example.demo.gateway;

import com.example.demo.dto.FakeStoreSpecificProductDTO;
import com.example.demo.dto.ProductsDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    List<ProductsDTO> getAllProducts() throws IOException;
    ProductsDTO getSpecificProduct(int id) throws IOException;

}
