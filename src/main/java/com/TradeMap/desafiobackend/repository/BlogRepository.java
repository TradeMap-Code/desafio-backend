package com.TradeMap.desafiobackend.repository;

import com.TradeMap.desafiobackend.model.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, String> {
    //Page<Blog> findAllByCreatedAt(LocalDate created_at, Pageable pageable);
}
