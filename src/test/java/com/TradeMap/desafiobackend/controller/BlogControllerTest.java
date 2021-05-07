package com.TradeMap.desafiobackend.controller;

import com.TradeMap.desafiobackend.dto.BlogRequestDTO;
import com.TradeMap.desafiobackend.dto.BlogResponseDTO;
import com.TradeMap.desafiobackend.model.Blog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogControllerTest {

    @Autowired
    private BlogController blogController;

    @Test
    public void testCreateBlog() {
        BlogResponseDTO response = buildBlog();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Blog was successfully published.", response.getMessage());
    }

    @Test
    public void testListAllBlogsWithMaxOfFiveItems() {
        Page<Blog> blogs = blogController.listAllBlogs(0);
        Assertions.assertTrue(blogs.getSize() <= 5);
    }

    @Test
    public void testGetById() {
        String id = buildBlog().getId();
        Blog blog = blogController.findBlog(id);

        Assertions.assertEquals(id, blog.getId());
    }

    @Test
    public void testDeleteBlog() {
        String id = buildBlog().getId();
        BlogResponseDTO blog = blogController.deleteBlog(id);

        assertThrows(ResponseStatusException.class, () -> {
            blogController.findBlog(id);
        });
    }

    @Test
    public void testUpdateBlog() {
        String id = buildBlog().getId();
        Blog blog = blogController.findBlog(id);
        blog.setBody("new body");
        blog.setDescription("new description");
        blog.setTitle("new title");

        Blog updatedBlog = blogController.updateBlog(id, blog);

        Assertions.assertEquals(updatedBlog.getBody(), "new body");
        Assertions.assertEquals(updatedBlog.getDescription(), "new description");
        Assertions.assertEquals(updatedBlog.getTitle(), "new title");
    }


    private BlogResponseDTO buildBlog() {
        BlogRequestDTO request = new BlogRequestDTO();

        request.setTitle("My blog");
        request.setDescription("Description of my blog");
        request.setBody("The body of my blog.");

        return blogController.createBlog(request);
    }


}
