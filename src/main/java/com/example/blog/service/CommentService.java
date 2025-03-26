package com.example.blog.service;

import com.example.blog.model.Article;
import com.example.blog.model.Comment;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public Comment addComment(Long articleId, Comment comment) {
        Optional<Article> article = articleRepository.findById(articleId);
        if (article.isPresent()) {
            comment.setArticle(article.get());
            return commentRepository.save(comment);
        } else {
            throw new RuntimeException("Article non trouvé");
        }
    }
}
