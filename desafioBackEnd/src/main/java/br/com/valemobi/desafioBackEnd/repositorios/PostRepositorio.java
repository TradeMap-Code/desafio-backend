package br.com.valemobi.desafioBackEnd.repositorios;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.valemobi.desafioBackEnd.model.Post;

public interface PostRepositorio extends JpaRepository<Post, Integer> {
	Page<Post> findByCreatedAt(LocalDate createdAt, Pageable pageable);
}
