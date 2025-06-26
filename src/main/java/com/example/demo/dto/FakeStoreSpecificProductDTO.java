package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreSpecificProductDTO {

    private String status;
    private String message;
    private FakeStoreProductDTO product;


}
