package com.example.demo.services;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entities.Category;
import com.example.demo.mappers.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Primary
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> dtos= categoryRepository.findAll().stream().map(CategoryMapper::toDTO).toList();
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category=CategoryMapper.toEntity(categoryDTO);

        Category saved=categoryRepository.save(category);
        return CategoryMapper.toDTO(saved);
    }
}
