package com.example.pooja_archana.controller.userController;

import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.*;
import com.example.pooja_archana.service.CategoryService;
import com.example.pooja_archana.service.ChapterService;
import com.example.pooja_archana.service.HtmlService;
import com.example.pooja_archana.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin("*")
public class StoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StoryService storyService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private HtmlService htmlService;

    @GetMapping("/category")
    public ResponseWrapper<List<CategoryEntity>> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/story")
    public ResponseWrapper<List<StoryEntity>> getAllStory() {
        return storyService.getAllStory();
    }

    @GetMapping("/story/search/{searchName}")
    public ResponseWrapper<List<StoryEntity>> searchStory(@PathVariable String searchName) {
        return storyService.searchStory(searchName);
    }

    @GetMapping("/story/{categoryId}")
    public ResponseWrapper<List<StoryEntity>> getStoryByCategoryId(@PathVariable long categoryId) {
        return storyService.getStoryByCategoryId(categoryId);
    }

    @GetMapping("/chapter/{storyId}")
    public ResponseWrapper<List<ChapterEntity>> getChapterByStoryId(@PathVariable long storyId) {
        return chapterService.getChapterByStoryId(storyId);
    }

    @GetMapping("/html/{chapterId}")
    public ResponseWrapper<List<HtmlEntity>> getHtmlByChapterId(@PathVariable long chapterId) {
        return htmlService.getHtmlByChapterId(chapterId);
    }

    @PatchMapping("/story/view/{storyId}")
    public void incrementViews(HttpServletRequest request, @PathVariable long storyId) {
        UserEntity userEntity =(UserEntity) request.getAttribute("user");
        long userId =userEntity.getUid();
        System.out.println("UserId = "+userId);
        storyService.incrementViews(storyId);
    }
}
