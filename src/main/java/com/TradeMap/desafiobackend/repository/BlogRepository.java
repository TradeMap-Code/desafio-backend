package com.TradeMap.desafiobackend.repository;

import com.TradeMap.desafiobackend.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, String> {
}
