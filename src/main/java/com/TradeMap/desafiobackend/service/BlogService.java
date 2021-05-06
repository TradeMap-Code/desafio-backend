package com.TradeMap.desafiobackend.service;

import com.TradeMap.desafiobackend.dto.BlogRequestDTO;
import com.TradeMap.desafiobackend.dto.BlogResponseDTO;
import com.TradeMap.desafiobackend.model.Blog;
import com.TradeMap.desafiobackend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        return new BlogResponseDTO("Post was successfully published.", id);
    }

}
