package com.posts.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.posts.apirest.models.Post;
import com.posts.apirest.repository.PostRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Posts")
public class PostResource {
	
	@Autowired
	PostRepository postRepository;
	
	@ApiOperation(value="Retorna uma lista de Posts")
	@GetMapping("/posts")
	public List<Post> listaPosts(){
		return postRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um post unico")
	@GetMapping("/post/{id}")
	public Post listaPostUnico(@PathVariable(value="id") long id){
		return postRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um post")
	@PostMapping("/post")
	public Post salvaPost(@RequestBody @Valid Post post) {
		return postRepository.save(post);
	}
	
	@ApiOperation(value="Deleta um post")
	@DeleteMapping("/post")
	public void deletaPost(@RequestBody @Valid Post post) {
		postRepository.delete(post);
	}
	
	@ApiOperation(value="Atualiza um post")
	@PutMapping("/post")
	public Post atualizaPost(@RequestBody @Valid Post post) {
		return postRepository.save(post);
	}
	 

}
