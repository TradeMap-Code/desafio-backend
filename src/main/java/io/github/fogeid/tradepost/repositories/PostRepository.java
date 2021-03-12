package io.github.fogeid.tradepost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.fogeid.tradepost.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}

