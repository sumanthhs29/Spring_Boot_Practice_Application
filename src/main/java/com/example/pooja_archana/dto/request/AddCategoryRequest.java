package com.example.pooja_archana.dto.request;

import lombok.Data;

@Data
public class AddCategoryRequest {

    public String name;
    public String image;

    public AddCategoryRequest() { }

    public AddCategoryRequest(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
