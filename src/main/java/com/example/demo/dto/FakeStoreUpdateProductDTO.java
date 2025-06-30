package com.example.demo.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreUpdateProductDTO {
    private int id;
    private String title;
    private String brand;
    private String model;
    private String color;
    private String category;
    private String  discount;
}
