package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.ImagesEntity;
import com.campuslands.Mi_Red_Social.entities.TagsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.PostUser;
import com.campuslands.Mi_Red_Social.entities.dto.PostsDTO;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.entities.dto.PostsFollowingUserDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.PostsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

        posts = postsRepository.save(posts);

        return posts;
    }

    public PostsEntity updatePost(PostsDTO postsDTO) {
        PostsEntity post = postsRepository.findById(postsDTO.getId()).orElse(new PostsEntity());

        UserEntity userPost = userService.searchUserById(postsDTO.getUser_posts_id());
        if (userPost == null) {
            throw new ResourceNotFoundException("User not found with id: " + postsDTO.getUser_posts_id());
        }

        post.setContent(postsDTO.getContent());
        post.setCreated_at(postsDTO.getCreated_at());
        post.setUser_posts(userPost);

        if (post.getPostTags() == null) {
            post.setPostTags(new ArrayList<>());
        }
        if (post.getPostImages() == null) {
            post.setPostImages(new ArrayList<>());
        }

        if (postsDTO.getImages() != null) {
            post.getPostImages().clear();
            postsDTO.getImages().forEach(imgDto -> {
                ImagesEntity image = new ImagesEntity();
                image.setImage(imgDto.getImage());
                image.setPost_images(post);
                post.getPostImages().add(image);
            });
        }

        if (postsDTO.getTags() != null) {
            post.getPostTags().clear();
            postsDTO.getTags().forEach(tagDto -> {
                TagsEntity tag = new TagsEntity();
                tag.setTag(tagDto.getTag());
                tag.setPost_tags(post);
                post.getPostTags().add(tag);
            });
        }

        return postsRepository.save(post);
    }


    public PostsEntity searchPostById(Integer id){
        return postsRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletePost(PostsEntity posts){
        postsRepository.delete(posts);
    }

    public List<PostsFollowingUserDTO> userPostFollowing(String username){
        return postsRepository.postUserFollowing(username);
    }

    public List<PostUser> postsUser(String username){
        return postsRepository.postUser(username);
    }
}
