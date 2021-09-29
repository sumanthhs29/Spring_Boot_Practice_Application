package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.StoryEntity;
import com.example.pooja_archana.repository.CategoryRepository;
import com.example.pooja_archana.repository.StoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class StoryServiceTest {

    private StoryService storyService;

    @Mock private StoryRepository storyRepository;
    @Mock private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        storyService = new StoryService(storyRepository,categoryRepository);
    }

    StoryTestAssets storyTestAssets = new StoryTestAssets();

    @Test
    void addStory() {
    }

    @Test
    void getAllStory() {
        //Arrange
        Mockito.when(storyRepository.findAll()).thenReturn(storyTestAssets.allStory);
        //Act
        ResponseWrapper<List<StoryEntity>> result = storyService.getAllStory();
        //Assert
        assertThat(result,equalTo(storyTestAssets.allStoryResponse));
    }

    @Test
    void searchStory() {
        //Arrange
        Mockito.when(storyRepository.findStoryByStoryName("Ashoka")).thenReturn(storyTestAssets.allStory);
        //Act
        ResponseWrapper<List<StoryEntity>> result = storyService.searchStory("Ashoka");
        //Assert
        assertThat(result,equalTo(storyTestAssets.allStoryResponse));
    }

    @Test
    void getStoryByCategoryId() {
        //Arrange
        Mockito.when((storyRepository.findAllByCategoryCategoryId(0))).thenReturn(storyTestAssets.allStory);
        //Act
        ResponseWrapper<List<StoryEntity>> result = storyService.getStoryByCategoryId(0);
        //Assert
        assertThat(result,equalTo(storyTestAssets.allStoryResponse));
    }

}