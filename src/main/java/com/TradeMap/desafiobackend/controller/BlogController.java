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
    public List<Blog> listEstablishments() {
        return (List<Blog>) blogRepository.findAll();

    }

    @GetMapping("/blog/{id}")
    public Blog findBlog(@PathVariable("id") UUID id){

        return blogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The Post was not found :("));
    }

    @DeleteMapping("/blog/{id}")
    public BlogResponseDTO deleteBlog(@PathVariable("id") UUID id) {

        blogRepository.delete(findBlog(id));

        return new BlogResponseDTO("Post was sucessfully deleted");
    }

    @PatchMapping("/blo/{id}")
    public Blog incrementalUpdateBlog(@PathVariable("id") UUID id, @RequestBody Blog blog) {
        Blog foundBlog = findBlog(id);
        foundBlog.setTitle(Optional.ofNullable(blog.getTitle()).orElse(foundBlog.getTitle()));
        foundBlog.setDescription(Optional.ofNullable(blog.getDescription()).orElse(foundBlog.getDescription()));
        foundBlog.setBody(Optional.ofNullable(blog.getBody()).orElse(foundBlog.getBody()));
        foundBlog.setUpdated_at(Optional.ofNullable(blog.getUpdated_at()).orElse(foundBlog.getUpdated_at()));

        return blogRepository.save(foundBlog);
    }

    @PutMapping("/blog/{id}")
    public Blog fullUpdateBlog(@PathVariable("id") UUID id, @RequestBody Blog blog) {
        Blog foundBlog = findBlog(id);
        foundBlog.setTitle(blog.getTitle());
        foundBlog.setDescription(blog.getDescription());
        foundBlog.setBody(blog.getBody());
        foundBlog.setUpdated_at(LocalDate.now());
        return blogRepository.save(foundBlog);
    }


}
