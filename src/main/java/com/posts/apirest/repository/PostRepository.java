package com.posts.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.posts.apirest.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	Post findById(long id);

}
