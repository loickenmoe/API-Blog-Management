package com.example.blog.mapper;

import com.example.blog.dto.CommentDto;
import com.example.blog.model.Article;
import com.example.blog.model.Comment;

public class CommentMapper {
    public static Comment toEntity(CommentDto dto, Article article) {
        Comment newComment = new Comment();
        newComment.setArticle(article);
        newComment.setContent(dto.getContent());
        newComment.setAuthor(dto.getAuthor());
        return newComment;
    }
}
