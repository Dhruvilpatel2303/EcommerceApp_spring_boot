package com.example.demo.controllers;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.services.FakeStoreCategoryService;
import com.example.demo.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
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

   @PostMapping
    public String createCategory(){
        return null;
   }



}
