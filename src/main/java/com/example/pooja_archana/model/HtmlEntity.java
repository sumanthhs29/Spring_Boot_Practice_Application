package com.example.pooja_archana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "html")
@Data
public class HtmlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long htmlId;

    private String content;

    @CreationTimestamp
    private Date createdOn;

    @OneToOne
    @JoinColumn(name = "chapterId")
    @JsonIgnore
    private ChapterEntity chapter;

    public HtmlEntity() { }

    public HtmlEntity(String content, ChapterEntity chapter) {
        this.content = content;
        this.chapter = chapter;
    }
}
