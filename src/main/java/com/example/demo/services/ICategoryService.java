package com.example.demo.services;

import com.example.demo.dto.AllProductsOfCategoryDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductsDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO getSpecificCategoryByIdFromDB(Long id) throws Exception;
    List<ProductsDTO> getAllProductsByCategory(Long id);
    AllProductsOfCategoryDTO allProductsOfCategory(Long id) throws Exception;
}
