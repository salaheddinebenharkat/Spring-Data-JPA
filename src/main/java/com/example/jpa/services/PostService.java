package com.example.jpa.services;

import com.example.jpa.dtos.requestDTO.PostRequestDTO;
import com.example.jpa.dtos.responseDTO.PostResponseDTO;
import com.example.jpa.entities.Client;
import com.example.jpa.entities.Post;
import com.example.jpa.repositories.ClientRepo;
import com.example.jpa.repositories.PostRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepo postRepo;
    private final ClientRepo clientRepo;
    private final ModelMapper modelMapper;

    public PostResponseDTO savePost(PostRequestDTO postRequestDTO){
        Post post = modelMapper.map(postRequestDTO, Post.class);
        Client client = clientRepo.findById(postRequestDTO.getClientId()).get();
        post.setClient(client);
        Post savedPost = postRepo.save(post);
        log.info("Client "+client.getUsername()+" has added the comment "+post.getContent());
        return modelMapper.map(savedPost, PostResponseDTO.class);
    }

    public List<PostResponseDTO> getPosts(){
        log.info("Loading the whole posts ...");
        return postRepo.findAll()
                .stream().map(item -> modelMapper.map(item, PostResponseDTO.class))
                .collect(Collectors.toList());
    }
}
