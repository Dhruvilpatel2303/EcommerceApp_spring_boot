package com.example.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FakeStoreCategoryDTO {
    public String status;
    public String message;
    public List<String> categories;
}
