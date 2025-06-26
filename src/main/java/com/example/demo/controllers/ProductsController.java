package com.example.demo.controllers;

import com.example.demo.dto.ProductsDTO;
import com.example.demo.services.ICategoryService;
import com.example.demo.services.IProductsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {

    private final IProductsService productsService;

    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
    }


    @GetMapping
    public List<ProductsDTO> getAllProducts() throws IOException {
        return productsService.getAllProducts();
    }


}
