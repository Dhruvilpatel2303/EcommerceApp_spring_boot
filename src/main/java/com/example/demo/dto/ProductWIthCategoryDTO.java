package com.example.demo.dto;

import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWIthCategoryDTO {
    private Long id;
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;
    private CategoryDTO category;
}
