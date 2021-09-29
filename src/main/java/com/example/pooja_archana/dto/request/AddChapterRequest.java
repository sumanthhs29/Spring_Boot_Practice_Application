package com.example.pooja_archana.dto.request;

import lombok.Data;

@Data
public class AddChapterRequest {

    private String chapterName;
    private String description;
    private int serialNo;
    private String image;
    private long storyId;
}
