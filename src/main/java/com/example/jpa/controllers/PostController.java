package com.example.jpa.controllers;

import com.example.jpa.entities.Post;
import com.example.jpa.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;


    @PostMapping(path = "/add")
    public Post addPost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @GetMapping(path = "/all")
    public List<Post> getAllPosts(){
        return postService.getPosts();
    }

}
