package com.example.pooja_archana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "chapter")
@Data
public class ChapterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chapterId;

    @Column(name = "chapterName",nullable = false)
    private String chapterName;

    private String description;
    private int serialNo;
    private String image;

    @ManyToOne
    @JoinColumn(name = "storyId")
    @JsonIgnore
    private StoryEntity story;

    public ChapterEntity() { }

    public ChapterEntity(long chapterId, String chapterName, String description, int serialNo, String image, StoryEntity story) {
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.description = description;
        this.serialNo = serialNo;
        this.image = image;
        this.story = story;
    }

    public ChapterEntity(String chapterName, String description, int serialNo, String image, StoryEntity story) {
        this.chapterName = chapterName;
        this.description = description;
        this.serialNo = serialNo;
        this.image = image;
        this.story = story;
    }
}
