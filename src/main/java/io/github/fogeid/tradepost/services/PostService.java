package io.github.fogeid.tradepost.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.fogeid.tradepost.entities.Post;
import io.github.fogeid.tradepost.repositories.PostRepository;
import io.github.fogeid.tradepost.services.exceptions.DatabaseException;
import io.github.fogeid.tradepost.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Page<Post> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	
	public Post findById(Long id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Post insert(Post obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Post update(Long id, Post obj) {
		try {
			Post entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	private void updateData(Post entity, Post obj) {
		entity.setTitle(obj.getTitle());
		entity.setDescription(obj.getDescription());
		entity.setBody(obj.getBody());
		entity.setUpdate_at(Instant.now());
	}
}
