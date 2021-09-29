package com.example.pooja_archana.repository;

import com.example.pooja_archana.model.HtmlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HtmlRepository extends CrudRepository<HtmlEntity,Long> {

    public List<HtmlEntity> findAllByChapterChapterId(long id);
}
