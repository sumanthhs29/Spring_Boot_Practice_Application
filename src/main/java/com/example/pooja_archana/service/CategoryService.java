package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.request.AddCategoryRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.CategoryEntity;
import com.example.pooja_archana.repository.CategoryRepository;
import com.example.pooja_archana.utils.ErrorMessages;
import com.example.pooja_archana.utils.SuccessMessages;
import com.example.pooja_archana.utils.converter.RequestToEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements SuccessMessages, ErrorMessages {

    private Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private RequestToEntity requestToEntity = new RequestToEntity();

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseWrapper<CategoryEntity> addCategory(AddCategoryRequest addCategoryRequest){
        CategoryEntity categoryEntity = requestToEntity.addCategoryToEntity(addCategoryRequest);
        CategoryEntity c = categoryRepository.getByName(categoryEntity.getName());
        if(c!=null){
            return new ResponseWrapper<>(false,CATEGORY_EXISTS);
        }
        categoryRepository.save(categoryEntity);
        return new ResponseWrapper<>(true,CATEGORY_ADD_SUCCESS,categoryEntity);
    }

    public ResponseWrapper<List<CategoryEntity>> getAllCategory(){
        List<CategoryEntity> categoryEntities = (List<CategoryEntity>) categoryRepository.findAll();
        return new ResponseWrapper<>(true,categoryEntities);
    }
}
