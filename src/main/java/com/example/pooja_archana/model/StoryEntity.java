package com.example.pooja_archana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="story")
@Data
public class StoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long storyId;

    @Column(name = "storyName",nullable = false,unique = true)
    private String storyName;

    private String language;
    private String startYear;
    private String endYear;
    private int views;
    private String image;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private CategoryEntity category;

    public StoryEntity() { }
    public StoryEntity(long storyId, String storyName, String language, String startYear, String endYear, int views, String image, CategoryEntity category) {
        this.storyId = storyId;
        this.storyName = storyName;
        this.language = language;
        this.startYear = startYear;
        this.endYear = endYear;
        this.views = views;
        this.image = image;
        this.category = category;
    }

    public StoryEntity(String storyName, String language, String startYear, String endYear, int views, String image, CategoryEntity category) {
        this.storyName = storyName;
        this.language = language;
        this.startYear = startYear;
        this.endYear = endYear;
        this.views = views;
        this.image = image;
        this.category = category;
    }
}
