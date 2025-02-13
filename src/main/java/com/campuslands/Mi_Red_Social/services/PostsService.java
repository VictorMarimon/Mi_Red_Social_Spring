package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.dto.PostsDTO;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private UserService userService;

    public List<PostsEntity> listPosts(){
        return postsRepository.findAll();
    }

    public PostsEntity addPost(PostsDTO postsDTO){
        UserEntity userPost = userService.searchUserById(postsDTO.getUser_posts_id());

        if (userPost == null){
            throw new ResourceNotFoundException("User not found with id: " + postsDTO.getUser_posts_id());
        }

        PostsEntity posts = new PostsEntity();

        posts.setId(postsDTO.getId());
        posts.setContent(postsDTO.getContent());
        posts.setCreated_at(postsDTO.getCreated_at());
        posts.setUser_posts(userPost);

        return postsRepository.save(posts);
    }

    public PostsEntity searchPostById(Integer id){
        return postsRepository.findById(id).orElse(null);
    }

    public void deletePost(PostsEntity posts){
        postsRepository.delete(posts);
    }
}
