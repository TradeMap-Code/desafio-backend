package com.TradeMap.desafiobackend.controller;

import com.TradeMap.desafiobackend.model.Blog;
import com.TradeMap.desafiobackend.dto.BlogRequestDTO;
import com.TradeMap.desafiobackend.dto.BlogResponseDTO;
import com.TradeMap.desafiobackend.repository.BlogRepository;
import com.TradeMap.desafiobackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogResponseDTO createBlog(@RequestBody BlogRequestDTO blogRequestDTO) {

        BlogResponseDTO response = blogService.create(blogRequestDTO);
        return response;
    }

    @GetMapping("/blog")
    public Page<Blog> listAllBlogs(@RequestParam int page) {

        Page<Blog> allPosts = blogRepository.findAll(PageRequest.of(page, 5));
        return allPosts;
    }

    @GetMapping("/blog/{id}")
    public Blog findPostBlog(@PathVariable("id") String id) {

        return blogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The Post was not found :("));
    }

    @DeleteMapping("/blog/{id}")
    public BlogResponseDTO deletePostBlog(@PathVariable("id") String id) {

        blogRepository.delete(findPostBlog(id));

        return new BlogResponseDTO("Post was sucessfully deleted", id);
    }

    @PatchMapping("/blog/{id}")
    public Blog incrementalUpdatePostBlog(@PathVariable("id") String id, @RequestBody Blog blog) {
        Blog foundPostBlog = findPostBlog(id);
        foundPostBlog.setTitle(Optional.ofNullable(blog.getTitle()).orElse(foundPostBlog.getTitle()));
        foundPostBlog.setDescription(Optional.ofNullable(blog.getDescription()).orElse(foundPostBlog.getDescription()));
        foundPostBlog.setBody(Optional.ofNullable(blog.getBody()).orElse(foundPostBlog.getBody()));
        foundPostBlog.setUpdatedAt(Optional.ofNullable(blog.getUpdatedAt()).orElse(foundPostBlog.getUpdatedAt()));

        return blogRepository.save(foundPostBlog);
    }

    @PutMapping("/blog/{id}")
    public Blog fullUpdatePostBlog(@PathVariable("id") String id, @RequestBody Blog blog) {
        Blog foundPostBlog = findPostBlog(id);
        foundPostBlog.setTitle(blog.getTitle());
        foundPostBlog.setDescription(blog.getDescription());
        foundPostBlog.setBody(blog.getBody());
        foundPostBlog.setUpdatedAt(LocalDate.now());

        return blogRepository.save(foundPostBlog);
    }


}
