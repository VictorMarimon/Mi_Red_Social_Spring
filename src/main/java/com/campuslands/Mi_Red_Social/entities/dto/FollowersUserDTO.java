package com.campuslands.Mi_Red_Social.entities.dto;

public class FollowersUserDTO {
    private Long followers_count;
    private Long following_count;

    public FollowersUserDTO(){}

    public FollowersUserDTO(Long followers_count, Long following_count) {
        this.followers_count = followers_count;
        this.following_count = following_count;
    }

    public Long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(Long followers_count) {
        this.followers_count = followers_count;
    }

    public Long getFollowing_count() {
        return following_count;
    }

    public void setFollowing_count(Long following_count) {
        this.following_count = following_count;
    }

    @Override
    public String toString() {
        return "FollowersUserDTO{" +
                "followers_count=" + followers_count +
                ", following_count=" + following_count +
                '}';
    }
}
