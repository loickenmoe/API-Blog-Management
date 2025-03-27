package com.example.blog.controller;

import com.example.blog.dto.CommentDto;
import com.example.blog.model.Comment;
import com.example.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{articleId}")
    public Comment addComment(@PathVariable Long articleId, @RequestBody CommentDto comment) {
        return commentService.addComment(articleId, comment);
    }


}
