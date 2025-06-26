package com.example.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreProductsDTO {

    private String status;
    private String message;
    private List<FakeStoreProductDTO> products;


}
