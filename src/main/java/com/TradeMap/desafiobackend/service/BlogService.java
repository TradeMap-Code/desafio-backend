package com.TradeMap.desafiobackend.service;

import com.TradeMap.desafiobackend.dto.BlogRequestDTO;
import com.TradeMap.desafiobackend.dto.BlogResponseDTO;
import com.TradeMap.desafiobackend.model.Blog;
import com.TradeMap.desafiobackend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public BlogResponseDTO create(BlogRequestDTO blogRequestDTO) {
        Blog blog = new Blog();
        String id = UUID.randomUUID().toString();

        blog.setId(id);
        blog.setTitle(blogRequestDTO.getTitle());
        blog.setDescription(blogRequestDTO.getDescription());
        blog.setBody(blogRequestDTO.getBody());
        blog.setCreatedAt(LocalDate.now());
        blog.setUpdatedAt(LocalDate.now());

        blogRepository.save(blog);
        return new BlogResponseDTO("Blog was successfully published.", id);
    }

    public Page<Blog> listAll(int page){
        return blogRepository.findAll(PageRequest.of(page, 5));
    }

    public Blog getById(String id){
        return blogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The Blog was not found :("));
    }

    public BlogResponseDTO deleteById(String id){
        blogRepository.deleteById(id);
        return new BlogResponseDTO("Blog was sucessfully deleted", id);
    }

    public Blog update(String id, Blog newBlog){
        Optional<Blog> foundPostBlog = blogRepository.findById(id);
        foundPostBlog.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The Blog was not found :("));

        foundPostBlog.get().setTitle(newBlog.getTitle());
        foundPostBlog.get().setDescription(newBlog.getDescription());
        foundPostBlog.get().setBody(newBlog.getBody());
        foundPostBlog.get().setUpdatedAt(LocalDate.now());

        return blogRepository.save(foundPostBlog.get());
    }
}
