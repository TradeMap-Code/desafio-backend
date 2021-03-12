package io.github.fogeid.tradepost.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.github.fogeid.tradepost.entities.Post;

import io.github.fogeid.tradepost.repositories.PostRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Post p1 = new Post(null, "Primeiro Titulo", "Primeiro post do blog", "Eae meu povo!", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p2 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p3 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p4 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p5 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p6 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p7 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p8 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p9 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p10 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p11 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p12 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p13 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p14 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p15 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p16 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p17 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p18 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p19 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p20 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p21 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p22 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p23 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p24 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		Post p25 = new Post(null, "Segundo Titulo", "Segundo post do blog", "Hellow world", Instant.parse("2019-06-20T19:53:07Z"), null);
		
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25));
	}
}
