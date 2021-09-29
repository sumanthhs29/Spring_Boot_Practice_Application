package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.request.AddStoryRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.CategoryEntity;
import com.example.pooja_archana.model.StoryEntity;
import com.example.pooja_archana.utils.ErrorMessages;
import com.example.pooja_archana.utils.SuccessMessages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class StoryTestAssets implements SuccessMessages, ErrorMessages {

    public StoryTestAssets() {}
    public CategoryEntity newCategory1 = new CategoryEntity("War","War Image",new Date());

    public AddStoryRequest addStory = new AddStoryRequest("Ashoka","English","150 BC","100 BC","Image",1);

    public StoryEntity newStory1 = new StoryEntity("Ashoka","English","150 BC","100 BC",1,"Image",newCategory1);

    public List<StoryEntity> allStory = new ArrayList<StoryEntity>(){{add(newStory1);}};

    public ResponseWrapper<StoryEntity> allStoryResponse = new ResponseWrapper<>(
      true,newStory1
    );
}
