package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.ImagesEntity;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.TagsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.ImageDTO;
import com.campuslands.Mi_Red_Social.entities.dto.TagDTO;
import com.campuslands.Mi_Red_Social.entities.dto.TagsPostDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private PostsService postsService;

    public List<TagsEntity> listTags(){
        return tagRepository.findAll();
    }

    public List<TagsEntity> addTags(List<TagDTO> tagDTOs) {
        if (tagDTOs == null || tagDTOs.isEmpty()) {
            throw new IllegalArgumentException("Tag list cannot be null or empty");
        }

        Integer postId = tagDTOs.get(0).getPost_tag_id();
        PostsEntity postTag = postsService.searchPostById(postId);

        if (postTag == null) {
            throw new ResourceNotFoundException("Post not found with id: " + postId);
        }

        List<TagsEntity> tags = tagDTOs.stream().map(tagDTO -> {
            TagsEntity tag = new TagsEntity();
            tag.setId(tagDTO.getId());
            tag.setTag(tagDTO.getTag());
            tag.setPost_tags(postTag);
            return tag;
        }).collect(Collectors.toList());

        return tagRepository.saveAll(tags);
    }

    public List<TagsPostDTO> tagsPost(Integer id){
        return tagRepository.tagsPost(id);
    };

    public void deleteTag(TagsEntity tag){
        tagRepository.delete(tag);
    }

    public TagsEntity searchTagById(Integer id){
        return tagRepository.findById(id).orElse(null);
    }
}
