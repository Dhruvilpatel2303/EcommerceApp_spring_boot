package com.example.demo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProductDTO {


    private String title;
    private String brand;
    private String model;
    private String color;
    private String category;

    private String discount;

//
//    title: "Apple Vision Pro",
//    brand: "Apple",
//    model: "Apple vision pro First Gen",
//    color: "Black",
//    category: "appliances",
//    discount: 1
}
