package com.example.demo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreProductDTO {

    private Integer id;
    private String title;
    private String image;
    private Integer price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private String category;
    private Integer discount;
}
