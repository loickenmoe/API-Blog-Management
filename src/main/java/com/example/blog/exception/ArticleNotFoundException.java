package com.example.blog.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(Long id) {
        super("Article avec ID " + id + " non trouvé !");
    }
}
