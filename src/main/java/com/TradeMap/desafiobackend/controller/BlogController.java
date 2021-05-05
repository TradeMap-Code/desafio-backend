package com.TradeMap.desafiobackend.controller;

import com.TradeMap.desafiobackend.model.Blog;
import com.TradeMap.desafiobackend.model.BlogRequestDTO;
import com.TradeMap.desafiobackend.model.BlogResponseDTO;
import com.TradeMap.desafiobackend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("/blog")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogResponseDTO createPostBlog(@RequestBody BlogRequestDTO blogRequestDTO){

        Blog blog = new Blog();

        blog.setId(blog.getId());
        blog.setTitle(blogRequestDTO.getTitle());
        blog.setDescription(blogRequestDTO.getDescription());
        blog.setBody(blogRequestDTO.getBody());
        blog.setCreated_at(blogRequestDTO.getCreated_at());
        blog.setUpdated_at(blogRequestDTO.getUpdated_at());

        blogRepository.save(blog);

        return new BlogResponseDTO("Post was successfully published.");
    }

    @GetMapping("/blog")
    public List<Blog> listPostBlogs() {
        return (List<Blog>) blogRepository.findAll();

    }

    @GetMapping("/blog/{id}")
    public Blog findPostBlog(@PathVariable("id") UUID id){

        return blogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The Post was not found :("));
    }

    @DeleteMapping("/blog/{id}")
    public BlogResponseDTO deletePostBlog(@PathVariable("id") UUID id) {

        blogRepository.delete(findPostBlog(id));

        return new BlogResponseDTO("Post was sucessfully deleted");
    }

    @PatchMapping("/blog/{id}")
    public Blog incrementalUpdatePostBlog(@PathVariable("id") UUID id, @RequestBody Blog blog) {
        Blog foundPostBlog = findPostBlog(id);
        foundPostBlog.setTitle(Optional.ofNullable(blog.getTitle()).orElse(foundPostBlog.getTitle()));
        foundPostBlog.setDescription(Optional.ofNullable(blog.getDescription()).orElse(foundPostBlog.getDescription()));
        foundPostBlog.setBody(Optional.ofNullable(blog.getBody()).orElse(foundPostBlog.getBody()));
        foundPostBlog.setUpdated_at(Optional.ofNullable(blog.getUpdated_at()).orElse(foundPostBlog.getUpdated_at()));

        return blogRepository.save(foundPostBlog);
    }

    @PutMapping("/blog/{id}")
    public Blog fullUpdatePostBlog(@PathVariable("id") UUID id, @RequestBody Blog blog) {
        Blog foundPostBlog = findPostBlog(id);
        foundPostBlog.setTitle(blog.getTitle());
        foundPostBlog.setDescription(blog.getDescription());
        foundPostBlog.setBody(blog.getBody());
        foundPostBlog.setUpdated_at(LocalDate.now());
        return blogRepository.save(foundPostBlog);
    }


}
