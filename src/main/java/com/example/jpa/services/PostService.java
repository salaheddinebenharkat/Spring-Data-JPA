package com.example.jpa.services;

import com.example.jpa.entities.Post;
import com.example.jpa.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;

    public Post savePost(Post post){
        return postRepo.save(post);
    }

    public List<Post> getPosts(){
        return postRepo.findAll();
    }
}
