package com.example.demo;


import com.example.demo.dto.CategoryDTO;
import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.services.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    //arrange
    //act
    //aasert

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;


    @Test
    @DisplayName("should_return_all_categories succcessfully")
    void getAllCategories_shouldReturnAllCategories() throws IOException {

        //Arrange
        List<Category> categories=new ArrayList<>();
        Category category1=Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2=Category.builder().name("IT").build();
        category2.setId(2L);
        Category category3=Category.builder().name("Mechanical").build();
        category3.setId(3L);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        when(categoryRepository.findAll()).thenReturn(categories);


        //Act
        List<CategoryDTO> categoryDTOS=categoryService.getAllCategories();

        //Assert
        assertEquals(categoryDTOS.size(),3);

        verify(categoryRepository,times(1)).findAll();





    }


    @Test
    @DisplayName("should create a new category")
    void createCategory_should_create_new_category() {
        // Arrange
        Category category = Category.builder().name("IT").build();
        category.setId(1L);

        CategoryDTO inputDTO = CategoryDTO.builder()
                .id(category.getId().intValue())
                .name(category.getName())
                .build();

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        // Act
        CategoryDTO resultDTO = categoryService.createCategory(inputDTO);

        // Assert
        assertEquals(inputDTO.getName(), resultDTO.getName());
        assertEquals(inputDTO.getId(), resultDTO.getId());
    }

}
