package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.CommentsEntity;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.entities.dto.CommentDTO;
import com.campuslands.Mi_Red_Social.entities.dto.CommentPostDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostsService postsService;

    public List<CommentsEntity> listComments(){
        return commentsRepository.findAll();
    }

    public CommentsEntity addComment(CommentDTO commentDTO){
        UserEntity userComment = userService.searchUserById(commentDTO.getUser_comment_id());

        PostsEntity postComment = postsService.searchPostById(commentDTO.getPost_comment_id());

        if (userComment == null){
            throw new ResourceNotFoundException("User not found with id: " + commentDTO.getUser_comment_id());
        } else if (postComment == null) {
            throw new ResourceNotFoundException("Post not found with id: " + commentDTO.getPost_comment_id());
        }

        CommentsEntity comment = new CommentsEntity();

        comment.setId(commentDTO.getId());
        comment.setComment(commentDTO.getComment());
        comment.setCreated_at(commentDTO.getCreated_at());
        comment.setPost_comments(postComment);
        comment.setUser_comments(userComment);

        return commentsRepository.save(comment);
    }

    public void deleteComment(CommentsEntity comment){
        commentsRepository.delete(comment);
    }

    public CommentsEntity searchCommentById(Integer id){
        return commentsRepository.findById(id).orElse(null);
    }

    public List<CommentPostDTO> commentPost(Integer id_post){
        return commentsRepository.commentPost(id_post);
    }
}
