package com.example.demo.gateway;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.FakeStoreCategoryDTO;
import com.example.demo.gateway.api.FakeStoreCategoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Component
public class FakeStoreCategoryGateway  implements  ICategoryGateway{


    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {



        FakeStoreCategoryDTO response =  this.fakeStoreCategoryApi.getAllCategories().execute().body();

        if (response == null){
            throw new IOException("Failed to get Response");
        }
        return response.getCategories().stream().map(
                category -> CategoryDTO.builder()
                        .name(category)
                        .status(category)

                        .build()).toList()
        ;

    }
}
