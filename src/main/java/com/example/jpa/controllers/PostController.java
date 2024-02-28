package com.example.jpa.controllers;

import com.example.jpa.dtos.requestDTO.PostRequestDTO;
import com.example.jpa.dtos.responseDTO.PostResponseDTO;
import com.example.jpa.entities.Post;
import com.example.jpa.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;


    @PostMapping(path = "/add")
    public PostResponseDTO addPost(@RequestBody PostRequestDTO postRequestDTO){
        return postService.savePost(postRequestDTO);
    }

    @GetMapping(path = "/all")
    public List<PostResponseDTO> getAllPosts(){
        return postService.getPosts();
    }

    @GetMapping(path = "/clientPosts/{id}")
    public List<Post> getPostsByClientId(@PathVariable Long id){
        return postService.getPostsByClientId(id);
    }

}
