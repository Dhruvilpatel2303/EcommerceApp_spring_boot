package com.example.demo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreUpdateProductResponseDTO {

    private String status;
    private String message;
    private FakeStoreUpdateProductDTO product;

}
