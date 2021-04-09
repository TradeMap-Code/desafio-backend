package br.com.valemobi.desafioBackEnd.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.valemobi.desafioBackEnd.model.Post;
import br.com.valemobi.desafioBackEnd.repositorios.PostRepositorio;

@Service
public class PostService {
	
	@Autowired
	private PostRepositorio repositorio;
	
	
	public Post salvar(Post animal) {
		return repositorio.save(animal); 
	}
	
	
	public Page<Post> buscaTodos(Pageable pageable) {
		return repositorio.findAll(pageable);
	}
	
	public Optional<Post> buscaPorId(int id) {
		return repositorio.findById(id);
	}
	
	public void deletaPorId(int id) {
		repositorio.deleteById(id);
	}	
	
	public Page<Post> buscarPorDataDeCriacao(String createdAt, Pageable pageable) {
		
		LocalDate data = LocalDate.parse(createdAt);
		
		return repositorio.findByCreatedAt(data, pageable);
	}

}
