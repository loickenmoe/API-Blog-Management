package com.example.blog.mapper;

import com.example.blog.dto.ArticleDto;
import com.example.blog.model.Article;

import java.time.LocalDateTime;

public class ArticleMapper {
    public static Article toEntity(ArticleDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setPublishedAt(LocalDateTime.now());
        return article;
    }
}
