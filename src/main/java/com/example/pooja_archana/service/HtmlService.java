package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.request.AddHtmlRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.ChapterEntity;
import com.example.pooja_archana.model.HtmlEntity;
import com.example.pooja_archana.repository.ChapterRepository;
import com.example.pooja_archana.repository.HtmlRepository;
import com.example.pooja_archana.utils.ErrorMessages;
import com.example.pooja_archana.utils.SuccessMessages;
import com.example.pooja_archana.utils.converter.RequestToEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HtmlService implements SuccessMessages, ErrorMessages {

    private Logger logger = LoggerFactory.getLogger(HtmlService.class);
    private RequestToEntity requestToEntity = new RequestToEntity();

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private HtmlRepository htmlRepository;

    public ResponseWrapper<HtmlEntity> addHtml(AddHtmlRequest addHtmlRequest,long chapterId) {
        ChapterEntity chapterEntity = chapterRepository.getByChapterId(chapterId);
        HtmlEntity html = requestToEntity.addHtmlToEntity(addHtmlRequest,chapterEntity);
        htmlRepository.save(html);
        return new ResponseWrapper<>(true,HTML_ADD_SUCCESS,html);
    }

    public ResponseWrapper<List<HtmlEntity>> getHtmlByChapterId(long chapterId) {
        List<HtmlEntity> html = (List<HtmlEntity>) htmlRepository.findAllByChapterChapterId(chapterId);
        html.sort((h1,h2)->h2.getCreatedOn().compareTo(h1.getCreatedOn()));
        return new ResponseWrapper<>(true,html);
    }
}
