package com.example.demo.controllers;

import com.example.demo.dto.AllProductsOfCategoryDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductsDTO;
import com.example.demo.entities.Category;
import com.example.demo.services.FakeStoreCategoryService;
import com.example.demo.services.ICategoryService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    private final ICategoryService categoryservice;

    public CategoryController(ICategoryService categoryservice) {
        this.categoryservice = categoryservice;
    }


   @GetMapping
   public List<CategoryDTO> getAllCategories() throws IOException {
        System.out.println("Data fetched from controller");
        return categoryservice.getAllCategories();

   }

   @PostMapping("/create")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryservice.createCategory(categoryDTO);

   }

   @GetMapping("/db/{id}")
    public CategoryDTO getSpecificCategoryByIIDFromDB(@PathVariable("id") Long id) throws Exception {
        return categoryservice.getSpecificCategoryByIdFromDB(id);
   }


   @GetMapping("/db/products/{id}")
    public List<ProductsDTO> getAllProductsByCategory(@PathVariable("id") Long id) throws Exception{
        return categoryservice.getAllProductsByCategory(id);
   }


   @GetMapping("/db/category/products/{id}")
    public AllProductsOfCategoryDTO allProductsOfCategoryDTO(@PathVariable("id") Long id) throws Exception{
        return categoryservice.allProductsOfCategory(id);
   }




}
