package com.javadevjournal.restexample.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.javadevjournal.restexample.data.Post;
import com.javadevjournal.restexample.dto.PostDto;
import com.javadevjournal.restexample.service.PostService;
import com.javadevjournal.restexample.service.impl.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private ModelMapper modelMapper;

    private PostService postService;

    public PostController(PostService postService) {
        super();
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getAllPosts() {

        return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        try {
            Post post = postService.getPostById(id);

            // convert entity to DTO
            PostDto postResponse = modelMapper.map(post, PostDto.class);

            return ResponseEntity.ok().body(postResponse);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

        // convert DTO to entity
        Post postRequest = modelMapper.map(postDto, Post.class);

        Post post = postService.createPost(postRequest);

        // convert entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return new ResponseEntity<PostDto>(postResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto) {

        // convert DTO to Entity
        Post postRequest = modelMapper.map(postDto, Post.class);

        Post post = postService.updatePost(id, postRequest);

        // entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return ResponseEntity.ok().body(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePost(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}





