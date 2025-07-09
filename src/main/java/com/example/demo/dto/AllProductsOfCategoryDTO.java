package com.example.demo.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllProductsOfCategoryDTO {
    private String name;
    private Long id;
    private List<ProductsDTO> productsDTOS;
}
