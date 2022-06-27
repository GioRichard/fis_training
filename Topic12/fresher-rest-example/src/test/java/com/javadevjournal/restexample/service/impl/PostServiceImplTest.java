package com.javadevjournal.restexample.service.impl;

import com.javadevjournal.restexample.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostServiceImplTest {
    @Autowired
    PostService postService;

    @Test
    void getAllPosts() {
        System.out.println(postService.getAllPosts());
    }

    @Test
    void createPost() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }

    @Test
    void getPostById() {
    }
}