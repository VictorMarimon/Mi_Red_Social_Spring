package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.LikesEntity;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.TypeInteractionEntity;
import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.entities.dto.LikeDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostsService postsService;
    @Autowired
    private TypeInteractionService typeInteractionService;

    public List<LikesEntity> listLike(){
        return likeRepository.findAll();
    }

    public LikesEntity addLike(LikeDTO likeDTO){
        UserEntity userLike = userService.searchUserById(likeDTO.getUser_like_id());

        PostsEntity postLike = postsService.searchPostById(likeDTO.getPost_like_id());

        TypeInteractionEntity typeLike = typeInteractionService.searchTypeById(likeDTO.getType_like_id());

        if (userLike == null){
            throw new ResourceNotFoundException("User not found with id: " + likeDTO.getUser_like_id());
        } else if (postLike == null) {
            throw new ResourceNotFoundException("Post not found with id: " + likeDTO.getPost_like_id());
        } else if (typeLike == null){
            throw new ResourceNotFoundException("Type like not found with id: " + likeDTO.getType_like_id());
        }

        LikesEntity like = new LikesEntity();

        like.setId(like.getId());
        like.setCreated_at(likeDTO.getCreated_at());
        like.setActive(likeDTO.isActive());
        like.setPost_likes(postLike);
        like.setType_like(typeLike);
        like.setUser_likes(userLike);

        return likeRepository.save(like);
    }

    public void deleteLike(LikesEntity like){
        likeRepository.delete(like);
    }

    public LikesEntity searchLikeById(Integer id){
        return likeRepository.findById(id).orElse(null);
    }
}
