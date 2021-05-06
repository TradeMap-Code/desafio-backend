package com.TradeMap.desafiobackend.controller;

import com.TradeMap.desafiobackend.dto.BlogRequestDTO;
import com.TradeMap.desafiobackend.dto.BlogResponseDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class BlogControllerTest {

    @Autowired
    private BlogController blogController;

    @Test
    public void testBlogController() {
        BlogRequestDTO request = new BlogRequestDTO();

        request.setTitle("My blog");
        request.setDescription("Description of my blog");
        request.setBody("The body of my blog.");

        BlogResponseDTO response = blogController.createBlog(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Post was successfully published.", response.getMessage());

    }

    @Test
    public void teste() {
        Assertions.assertEquals("a", "a");
    }

}
