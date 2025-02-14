package com.campuslands.Mi_Red_Social.services;

import com.campuslands.Mi_Red_Social.entities.ImagesEntity;
import com.campuslands.Mi_Red_Social.entities.PostsEntity;
import com.campuslands.Mi_Red_Social.entities.TagsEntity;
import com.campuslands.Mi_Red_Social.entities.dto.ImageDTO;
import com.campuslands.Mi_Red_Social.entities.dto.TagDTO;
import com.campuslands.Mi_Red_Social.exceptions.ResourceNotFoundException;
import com.campuslands.Mi_Red_Social.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private PostsService postsService;

    public List<TagsEntity> listTags(){
        return tagRepository.findAll();
    }

    public TagsEntity addTag(TagDTO tagDTO){
        PostsEntity postTag = postsService.searchPostById(tagDTO.getPost_tag_id());

        if (postTag == null){
            throw new ResourceNotFoundException("Post not found with id: " + tagDTO.getPost_tag_id());
        }

        TagsEntity tag = new TagsEntity();

        tag.setId(tagDTO.getId());
        tag.setTag(tagDTO.getTag());
        tag.setPost_tags(postTag);

        return tagRepository.save(tag);
    }

    public void deleteTag(TagsEntity tag){
        tagRepository.delete(tag);
    }

    public TagsEntity searchTagById(Integer id){
        return tagRepository.findById(id).orElse(null);
    }
}
