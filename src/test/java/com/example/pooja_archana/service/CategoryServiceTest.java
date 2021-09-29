package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.request.AddCategoryRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.CategoryEntity;
import com.example.pooja_archana.repository.CategoryRepository;
import com.example.pooja_archana.utils.ErrorMessages;
import com.example.pooja_archana.utils.SuccessMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    CategoryTestAssets categoryTestAssets = new CategoryTestAssets();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addCategory(){
        //Arrange
        Mockito.when(categoryRepository.save(ArgumentMatchers.any(CategoryEntity.class))).thenReturn(categoryTestAssets.newCategory1);
        //Act
        ResponseWrapper<CategoryEntity> result = categoryService.addCategory(categoryTestAssets.addCategory);
        //Assert
        assertThat(result,equalTo(categoryTestAssets.categoryAddedSuccess));
    }

    @Test
    void whenCategoryAlreadyExists () {
        //Arrange
        Mockito.when(categoryRepository.save(ArgumentMatchers.any(CategoryEntity.class))).thenReturn(categoryTestAssets.newCategory1);
        Mockito.when(categoryRepository.getByName("War")).thenReturn(null);
        //Act
        ResponseWrapper<CategoryEntity> result = categoryService.addCategory(categoryTestAssets.addCategory);
        //Assert
        assertThat(result,equalTo(categoryTestAssets.categoryAddedFailure));
    }

    @Test
    void getAllCategory() {
        //Arrange
        Mockito.when(categoryRepository.findAll()).thenReturn(categoryTestAssets.allCategory);
        //Act
        ResponseWrapper<List<CategoryEntity>> result = categoryService.getAllCategory();
        //Assert
        assertThat(result,equalTo(categoryTestAssets.allCategoryResponse));
    }
}