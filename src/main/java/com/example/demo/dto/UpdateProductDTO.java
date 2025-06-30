package com.example.demo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductDTO {


    private String model;
    private String color;
    private String discount;
//
//    model: "Apple vision pro Second Gen",
//    color: "Blue",
//    discount: 47
}
