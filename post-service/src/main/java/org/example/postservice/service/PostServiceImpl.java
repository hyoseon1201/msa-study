package org.example.postservice.service;

import lombok.RequiredArgsConstructor;
import org.example.postservice.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
}
