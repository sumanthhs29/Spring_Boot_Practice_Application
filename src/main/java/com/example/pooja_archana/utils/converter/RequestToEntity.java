package com.example.pooja_archana.utils.converter;

import com.example.pooja_archana.dto.request.*;
import com.example.pooja_archana.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestToEntity {

    public RequestToEntity() { }

    public CategoryEntity addCategoryToEntity(AddCategoryRequest addCategoryRequest){
        return new CategoryEntity(addCategoryRequest.name,addCategoryRequest.image, new Date());
    }

    public StoryEntity addStoryToEntity(AddStoryRequest addStoryRequest,CategoryEntity category){
        return new StoryEntity(addStoryRequest.getStoryName(),
                addStoryRequest.getLanguage(),
                addStoryRequest.getStartYear(),
                addStoryRequest.getEndYear(),
                0,
                addStoryRequest.getImage(),
                category);
    }

    public ChapterEntity addChapterToEntity(AddChapterRequest addChapterRequest,StoryEntity story) {
        return new ChapterEntity(addChapterRequest.getChapterName(),
                addChapterRequest.getDescription(),
                addChapterRequest.getSerialNo(),
                addChapterRequest.getImage(),
                story);
    }

    public HtmlEntity addHtmlToEntity(AddHtmlRequest addHtmlRequest,ChapterEntity chapterEntity) {
        return new HtmlEntity(addHtmlRequest.getContent(),chapterEntity);
    }

    public UserEntity addUserToEntity(AddUserRequest userRequest) {
        return new UserEntity(userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getDob(),
                userRequest.getPassword(),
                true,true);
    }

}
//    private String chapterName;
//    private String description;
//    private int serialNo;
//    private String image;
//    private long storyId;