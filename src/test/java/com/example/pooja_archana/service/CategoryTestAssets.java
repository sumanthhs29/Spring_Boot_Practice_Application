package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.request.AddCategoryRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.CategoryEntity;
import com.example.pooja_archana.utils.ErrorMessages;
import com.example.pooja_archana.utils.SuccessMessages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryTestAssets implements SuccessMessages, ErrorMessages {

    public CategoryTestAssets() {}

    public AddCategoryRequest addCategory = new AddCategoryRequest("War","War Image");

    public CategoryEntity newCategory1 = new CategoryEntity("War","War Image",new Date());

    public ResponseWrapper<CategoryEntity> categoryAddedSuccess = new ResponseWrapper<>(
      true,CATEGORY_ADD_SUCCESS,newCategory1
    );

    public ResponseWrapper<CategoryEntity> categoryAddedFailure = new ResponseWrapper<>(
            false,CATEGORY_EXISTS
    );

    public List<CategoryEntity> allCategory = new ArrayList<CategoryEntity>(){{ add(newCategory1); }};

    public ResponseWrapper<CategoryEntity> allCategoryResponse = new ResponseWrapper<>(
            true,newCategory1
    );
}
