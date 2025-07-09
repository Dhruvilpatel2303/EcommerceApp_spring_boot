package com.example.demo.services;


import com.example.demo.dto.AllProductsOfCategoryDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductsDTO;
import com.example.demo.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements  ICategoryService {


    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(   @Qualifier("fakeStoreRestTemplateGateway") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO getSpecificCategoryByIdFromDB(Long id) {
        return null;
    }

    @Override
    public List<ProductsDTO> getAllProductsByCategory(Long id) {
        return List.of();
    }

    @Override
    public AllProductsOfCategoryDTO allProductsOfCategory(Long id) {
        return null;
    }

}
