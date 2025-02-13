package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.dto.FollowerDTO;
import com.campuslands.Mi_Red_Social.entities.FollowersEntity;
import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowersService {
    @Autowired
    private FollowersRepository followersRepository;
    @Autowired
    private UserService userService;

    public List<FollowersEntity> listFollowers(){
        return followersRepository.findAll();
    }

    public FollowersEntity addFollow(FollowerDTO followerDTO){
        UserEntity userFollower = userService.searchUserById(followerDTO.getUser_follower_id());

        UserEntity userFollowing = userService.searchUserById(followerDTO.getUser_following_id());

        if (userFollower == null){
            throw new ResourceNotFoundException("User not found with id: " + followerDTO.getUser_follower_id());
        } else if (userFollowing == null) {
            throw new ResourceNotFoundException("User not found with id: " + followerDTO.getUser_following_id());
        }

        FollowersEntity follow = new FollowersEntity();

        follow.setId(followerDTO.getId());
        follow.setCreated_at(followerDTO.getCreated_at());
        follow.setUser_follower(userFollower);
        follow.setUser_following(userFollowing);

        return followersRepository.save(follow);
    }

    public void deleteFollow(FollowersEntity follow){
        followersRepository.delete(follow);
    }

    public FollowersEntity findFollowById(Integer id){
        return followersRepository.findById(id).orElse(null);
    }
}
