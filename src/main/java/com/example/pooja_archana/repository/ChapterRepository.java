package com.example.pooja_archana.repository;

import com.example.pooja_archana.model.ChapterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends CrudRepository<ChapterEntity,Long> {

    public List<ChapterEntity> findAllByStoryStoryId(long storyId);

    public ChapterEntity getByChapterId(long id);
}
