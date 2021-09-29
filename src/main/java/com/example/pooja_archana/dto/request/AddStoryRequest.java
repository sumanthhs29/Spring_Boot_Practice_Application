package com.example.pooja_archana.dto.request;

import lombok.Data;

@Data
public class AddStoryRequest {

    private String storyName;
    private String language;
    private String startYear;
    private String endYear;
    private String image;
    private long categoryId;

    public AddStoryRequest() {}
    public AddStoryRequest(String storyName, String language, String startYear, String endYear, String image, long categoryId) {
        this.storyName = storyName;
        this.language = language;
        this.startYear = startYear;
        this.endYear = endYear;
        this.image = image;
        this.categoryId = categoryId;
    }
}
