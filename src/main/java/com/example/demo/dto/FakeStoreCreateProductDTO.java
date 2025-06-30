package com.example.demo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreCreateProductDTO {
    private int id;
    private String title;
    private String brand;
    private String model;
    private String color;
    private String category;
    private Integer discount;



}
