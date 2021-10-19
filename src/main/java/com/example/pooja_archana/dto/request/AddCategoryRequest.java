package com.example.pooja_archana.dto.request;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class AddCategoryRequest {

    @Size(min = 2)
    public String name;
    public String image;

    public AddCategoryRequest() { }

    public AddCategoryRequest(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
