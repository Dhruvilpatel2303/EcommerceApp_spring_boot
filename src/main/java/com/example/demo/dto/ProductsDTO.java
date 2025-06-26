package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO {

    private Integer id;

    private String title;
    private String image;
    private Integer price;
    private String description;
    private Integer discount;




}
