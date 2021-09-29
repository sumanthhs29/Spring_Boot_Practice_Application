package com.example.pooja_archana.repository;

import com.example.pooja_archana.model.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity,Long> {

    public CategoryEntity getByCategoryId(long id);
    public CategoryEntity getByName(String name);
}
