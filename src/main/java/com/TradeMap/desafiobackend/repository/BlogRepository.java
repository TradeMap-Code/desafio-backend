package com.TradeMap.desafiobackend.repository;

import com.TradeMap.desafiobackend.model.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogRepository extends CrudRepository<Blog, UUID> {
}
