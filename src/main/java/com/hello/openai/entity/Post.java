package com.hello.openai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Post extends BaseTime{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    private String content;

    private String url;

    private Integer ups;

    private String thumbnailUrl;

    private Integer commentCount;

    private Boolean isVideo;

    private String author;


}
