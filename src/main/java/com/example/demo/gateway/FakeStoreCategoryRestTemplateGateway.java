package com.example.demo.gateway;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.FakeStoreCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;


@Component("fakeStoreRestTemplateGateway")
public class FakeStoreCategoryRestTemplateGateway implements ICategoryGateway{


    // Injection of RestTemplate into class

    private  final RestTemplate restTemplate;



    public FakeStoreCategoryRestTemplateGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryDTO response = restTemplate.getForObject(
                "https://fakestoreapi.in/api/products/category",
                FakeStoreCategoryDTO.class
        );

        if (response==null){
            System.out.println("Failed to fetch data");
        }

        return response.getCategories().stream().map(
                category -> CategoryDTO.builder()
                        .name(category)


                        .build()).toList()
                ;
    }
}
