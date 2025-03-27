package com.example.blog.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(Long id) {
        super("Commentaire avec ID " + id + " non trouvé !");
    }
}
