package com.example.demo.services;

import com.example.demo.dto.ProductsDTO;
import com.example.demo.gateway.FakeStoreProductsGateway;
import com.example.demo.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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
}
