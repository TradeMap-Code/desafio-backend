package com.TradeMap.desafiobackend.controller;

import com.TradeMap.desafiobackend.dto.BlogRequestDTO;
import com.TradeMap.desafiobackend.dto.BlogResponseDTO;
import com.TradeMap.desafiobackend.model.Blog;
import com.TradeMap.desafiobackend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogResponseDTO createBlog(@RequestBody BlogRequestDTO blogRequestDTO) {

        return blogService.create(blogRequestDTO);
    }

    @GetMapping("/blog")
    public Page<Blog> listAllBlogs(@RequestParam int page) {

        return blogService.listAll(page);
    }

    @GetMapping("/blog/{id}")
    public Blog findBlog(@PathVariable("id") String id) {

        return blogService.getById(id);
    }

    @DeleteMapping("/blog/{id}")
    public BlogResponseDTO deleteBlog(@PathVariable("id") String id) {

        return blogService.deleteById(id);
    }


    @PutMapping("/blog/{id}")
    public Blog UpdateBlog(@PathVariable("id") String id, @RequestBody Blog blog) {

        return blogService.update(id, blog);
    }

}
