package com.example.demo.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreCreateProductResponseDTO {


    private String status;
    private String message;
    private FakeStoreCreateProductDTO product;

//
//    {
//        "status": "SUCCESS",
//            "message": "Here is the product you sent,...",
//            "product": {
//        "id": 150,
//                "title": "Apple Vision Pro",
//                "brand": "Apple",
//                "model": "Apple vision pro First Gen",
//                "color": "Black",
//                "category": "appliances",
//                "discount": 1
//    }
//    }
}
