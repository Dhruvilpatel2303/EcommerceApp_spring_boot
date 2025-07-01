package com.example.demo.mappers;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.FakeStoreCategoryDTO;

import java.util.List;

public class CategoryMappers {

    public static List<CategoryDTO> toListCategories(FakeStoreCategoryDTO fakeStoreCategoryDTO) {
        return fakeStoreCategoryDTO.getCategories().stream().map(
                category -> CategoryDTO.builder()
                        .name(category)


                        .build()).toList()
                ;
    }
}
