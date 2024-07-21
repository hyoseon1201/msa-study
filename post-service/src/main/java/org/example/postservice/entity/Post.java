package org.example.postservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.postservice.dto.request.PostCreateRequest;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "post_createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "post_updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    public static Post create(PostCreateRequest request) {
        Post post = new Post();
        return post;
    }
}
