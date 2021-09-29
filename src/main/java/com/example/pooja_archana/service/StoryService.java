package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.request.AddStoryRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.CategoryEntity;
import com.example.pooja_archana.model.StoryEntity;
import com.example.pooja_archana.repository.CategoryRepository;
import com.example.pooja_archana.repository.StoryRepository;
import com.example.pooja_archana.utils.ErrorMessages;
import com.example.pooja_archana.utils.SuccessMessages;
import com.example.pooja_archana.utils.converter.RequestToEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService implements SuccessMessages, ErrorMessages {

    private Logger logger = LoggerFactory.getLogger(StoryService.class);
    private RequestToEntity requestToEntity = new RequestToEntity();
    private StoryRepository storyRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository,CategoryRepository categoryRepository) {
        this.storyRepository=storyRepository;
        this.categoryRepository=categoryRepository;
    }

    public ResponseWrapper<StoryEntity> addStory(AddStoryRequest addStoryRequest){
        CategoryEntity category = categoryRepository.getByCategoryId(addStoryRequest.getCategoryId());
        StoryEntity story = requestToEntity.addStoryToEntity(addStoryRequest,category);
        StoryEntity s =storyRepository.getByStoryName(story.getStoryName());
        if(s!=null){
            return new ResponseWrapper<>(false,STORY_EXISTS);
        }
        storyRepository.save(story);
        return new ResponseWrapper<>(true,STORY_ADD_SUCCESS,story);
    }

    public ResponseWrapper<List<StoryEntity>> getAllStory() {
        List<StoryEntity> story = (List<StoryEntity>) storyRepository.findAll();
        return new ResponseWrapper<>(true,story);
    }

    public ResponseWrapper<List<StoryEntity>> searchStory(String search) {
        List<StoryEntity> s = storyRepository.findStoryByStoryName(search);
        return new ResponseWrapper<>(true,s);
    }

    public ResponseWrapper<List<StoryEntity>> getStoryByCategoryId(long categoryId) {
        List<StoryEntity> story = (List<StoryEntity>) storyRepository.findAllByCategoryCategoryId(categoryId);
        return new ResponseWrapper<>(true,story);
    }

    public void incrementViews(long storyId) {
        StoryEntity s = storyRepository.findById(storyId).get();
        s.setViews(s.getViews()+1);
        storyRepository.save(s);
    }
}
