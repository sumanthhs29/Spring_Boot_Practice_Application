package com.example.pooja_archana.controller.adminController;

import com.example.pooja_archana.dto.request.AddCategoryRequest;
import com.example.pooja_archana.dto.request.AddChapterRequest;
import com.example.pooja_archana.dto.request.AddHtmlRequest;
import com.example.pooja_archana.dto.request.AddStoryRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.CategoryEntity;
import com.example.pooja_archana.model.ChapterEntity;
import com.example.pooja_archana.model.HtmlEntity;
import com.example.pooja_archana.model.StoryEntity;
import com.example.pooja_archana.service.CategoryService;
import com.example.pooja_archana.service.ChapterService;
import com.example.pooja_archana.service.HtmlService;
import com.example.pooja_archana.service.StoryService;
import com.example.pooja_archana.utils.converter.RequestToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StoryService storyService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private HtmlService htmlService;

    @PostMapping("/category")
    public ResponseWrapper<CategoryEntity> addCategory(@RequestBody AddCategoryRequest category){
        return categoryService.addCategory(category);
    }

    @PostMapping("/story")
    public ResponseWrapper<StoryEntity> addStory(@RequestBody AddStoryRequest story){
        return storyService.addStory(story);
    }

    @PostMapping("/chapter")
    public ResponseWrapper<ChapterEntity> addChapter(@RequestBody AddChapterRequest chapter){
        return chapterService.addChapter(chapter);
    }

    @PostMapping("/html/{chapterId}")
    public ResponseWrapper<HtmlEntity> addHtml(@RequestBody AddHtmlRequest html, @PathVariable long chapterId){
        return htmlService.addHtml(html,chapterId);
    }

}
