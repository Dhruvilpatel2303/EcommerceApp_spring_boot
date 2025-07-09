package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO{
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private Long id;
    private String title;
    private String  category;
    private String brand;
    private boolean popular;
}


//
//    title: "Apple Vision Pro",
//    brand: "Apple",
//    model: "Apple vision pro First Gen",
//    color: "Black",
//    category: "appliances",
//    discount: 1

