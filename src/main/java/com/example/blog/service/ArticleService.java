package com.example.blog.service;

import com.example.blog.dto.ArticleDto;
import com.example.blog.mapper.ArticleMapper;
import com.example.blog.model.Article;
import com.example.blog.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(ArticleDto article) {
        return articleRepository.save(ArticleMapper.toEntity(article));
    }

    public Article updateArticle(Long id, ArticleDto updatedArticle) {
        return articleRepository.findById(id).map(article -> {
            article.setTitle(updatedArticle.getTitle());
            article.setContent(updatedArticle.getContent());
            return articleRepository.save(article);
        }).orElseThrow(() -> new RuntimeException("Article non trouvé"));
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
