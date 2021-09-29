package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.request.AddChapterRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.ChapterEntity;
import com.example.pooja_archana.model.StoryEntity;
import com.example.pooja_archana.repository.ChapterRepository;
import com.example.pooja_archana.repository.StoryRepository;
import com.example.pooja_archana.utils.ErrorMessages;
import com.example.pooja_archana.utils.SuccessMessages;
import com.example.pooja_archana.utils.converter.RequestToEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService implements SuccessMessages, ErrorMessages {

    private Logger logger = LoggerFactory.getLogger(ChapterService.class);
    private RequestToEntity requestToEntity = new RequestToEntity();

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private StoryRepository storyRepository;

    public ResponseWrapper<ChapterEntity> addChapter(AddChapterRequest chapter){
        StoryEntity story = storyRepository.getByStoryId(chapter.getStoryId());
        ChapterEntity chapterEntity = requestToEntity.addChapterToEntity(chapter,story);
        chapterRepository.save(chapterEntity);
        return new ResponseWrapper<>(true,CHAPTER_ADD_SUCCESS,chapterEntity);
    }

    public ResponseWrapper<List<ChapterEntity>> getChapterByStoryId(long storyId) {
        List<ChapterEntity> chapter = (List<ChapterEntity>) chapterRepository.findAllByStoryStoryId(storyId);
        return new ResponseWrapper<>(true,chapter);
    }
}
