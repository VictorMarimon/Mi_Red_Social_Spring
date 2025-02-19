package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.dto.FollowerDTO;
import com.campuslands.Mi_Red_Social.entities.FollowersEntity;
import com.campuslands.Mi_Red_Social.entities.UserEntity;
import com.campuslands.Mi_Red_Social.entities.dto.FollowersUserDTO;
import com.campuslands.Mi_Red_Social.entities.dto.FollowsDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public void deleteFollow(Integer follower, Integer following){
        followersRepository.deleteFollow(follower, following);
    }

    public FollowersEntity findFollowById(Integer id){
        return followersRepository.findById(id).orElse(null);
    }

    public FollowersUserDTO followers(Integer id){
        return followersRepository.followers(id);
    }

    public List<FollowsDTO> userFollowers(Integer id){
        return followersRepository.userFollowers(id);
    }

    public List<FollowsDTO> userFollowing(Integer id){
        return followersRepository.userFollowing(id);
    }
}
