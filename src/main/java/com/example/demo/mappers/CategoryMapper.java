package com.example.demo.mappers;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductsDTO;
import com.example.demo.entities.Category;

import java.util.List;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category){
        return CategoryDTO.builder()
                .name(category.getName())
                .id(category.getId().intValue())
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO){

        return Category.builder()
                .name(categoryDTO.getName())


                .build();
    }




}
