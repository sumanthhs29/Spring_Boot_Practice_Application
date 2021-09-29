package com.example.pooja_archana.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column(name = "name", nullable = false,unique = true)
    private String name;

    private String image;

    private Date createdOn;

    public CategoryEntity() {

    }

    public CategoryEntity(long categoryId, String name, String image, Date createdOn) {
        this.categoryId = categoryId;
        this.name = name;
        this.image = image;
        this.createdOn = createdOn;
    }

    public CategoryEntity(String name, String image, Date createdOn) {
        this.name = name;
        this.image = image;
        this.createdOn = createdOn;
    }
}
