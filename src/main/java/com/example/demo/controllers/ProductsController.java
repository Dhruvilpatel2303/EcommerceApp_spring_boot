package com.example.demo.controllers;

import com.example.demo.dto.*;
import com.example.demo.services.ICategoryService;
import com.example.demo.services.IProductsService;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("Data fetched for all products");
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductsDTO getSpecificProduct(@PathVariable int id) throws Exception {
        System.out.println("Data fetched for product id -> " +id);

        return productsService.getSpecificProduct(id);
    }

    @PostMapping
    public FakeStoreCreateProductResponseDTO createProduct(@RequestBody AddProductDTO addProductDTO) throws IOException{
        System.out.println("Started Product Creation");
      FakeStoreCreateProductResponseDTO response=  productsService.createProduct(addProductDTO);
        return response ;
    }


    @PutMapping("/{id}")
    public FakeStoreUpdateProductResponseDTO updateProductResponseDTO(@PathVariable int id,@RequestBody UpdateProductDTO updateProductDTO) throws IOException{
        System.out.println("Update Product Started");
        FakeStoreUpdateProductResponseDTO response=productsService.updateProduct(id,updateProductDTO);
        return response;
    }

    @DeleteMapping("/{id}")
    public FakeStoreDeleteProductResponseDTO deleteProductResponseDTO(@PathVariable int id)throws IOException{
        System.out.println("Started Delete Product");
        FakeStoreDeleteProductResponseDTO response=productsService.deleteProduct(id);
        return response;
    }

    @PostMapping("/db/create")
    public ProductsDTO createProductInDB(@RequestBody ProductsDTO productsDTO){
        return productsService.createProductInDB(productsDTO);
    }
}
