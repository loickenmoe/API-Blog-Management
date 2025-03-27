package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(
            name = "article_id",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE")
    )
    private Article article;
}