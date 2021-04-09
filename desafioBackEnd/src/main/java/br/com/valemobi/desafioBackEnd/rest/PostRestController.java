package br.com.valemobi.desafioBackEnd.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.valemobi.desafioBackEnd.model.Post;
import br.com.valemobi.desafioBackEnd.services.PostService;

@RestController
@RequestMapping("/api")
public class PostRestController {

	@Autowired
	private PostService service;

	@GetMapping("/posts")
	public ResponseEntity<Map<String, Object>> getAllPosts(
			@RequestParam(required = false) String createdAt,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size
			) {

		try {
			List<Post> posts = new ArrayList<Post>();
			Pageable paging = PageRequest.of(page, size);

			Page<Post> pagePosts;
			if (createdAt == null)
				pagePosts = service.buscaTodos(paging);
			else
				pagePosts = service.buscarPorDataDeCriacao(createdAt, paging);

			posts = pagePosts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("posts", posts);
			response.put("currentPage", pagePosts.getNumber());
			response.put("totalItems", pagePosts.getTotalElements());
			response.put("totalPages", pagePosts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/posts/{postId}")
	public Post buscaPorId(@PathVariable int postId) {

		Optional<Post> res = service.buscaPorId(postId);

		Post post = null;

		if(res.isPresent()) {
			post = res.get();
		}else {
			throw new RuntimeException("Id do post não encontrado " + postId);
		}

		return post;
	}

	@PostMapping("/posts")
	public Post adicionaPost(@RequestBody Post post) {
		
		post.setId(0);
		post.setCreatedAt(LocalDate.now());
		post.setUpdatedAt(LocalDate.now());

		service.salvar(post);

		return post;
	}

	@PutMapping("/posts")
	public Post atualizaPost(@RequestBody Post post) {

		Post p = service.buscaPorId(post.getId()).get();
		LocalDate criacao = p.getCreatedAt();

		post.setUpdatedAt(LocalDate.now());
		post.setCreatedAt(criacao);
		service.salvar(post);

		return post;
	}

	@DeleteMapping("/posts/{postId}")
	public String deletePost(@PathVariable int postId) {

		Post post = service.buscaPorId(postId).get();

		if(post == null) {
			throw new RuntimeException("Id do post não encontrado " + postId);
		}

		service.deletaPorId(postId);

		return "Deletado post com id: " + postId;
	}


}
