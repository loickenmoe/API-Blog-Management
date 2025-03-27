package com.example.blog.service;

import com.example.blog.dto.CommentDto;
import com.example.blog.exception.ArticleNotFoundException;
import com.example.blog.mapper.CommentMapper;
import com.example.blog.model.Article;
import com.example.blog.model.Comment;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public Comment addComment(Long articleId, CommentDto comment) {
        Article articleLinked = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));
        return commentRepository.save(CommentMapper.toEntity(comment, articleLinked));

    }
}
