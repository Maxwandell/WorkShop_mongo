package com.max.springMongo.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.max.springMongo.DTO.AuthorDTO;
import com.max.springMongo.DTO.CommentDTO;
import com.max.springMongo.Domain.Post;
import com.max.springMongo.Domain.User;
import com.max.springMongo.repositoryes.PostRepository;
import com.max.springMongo.repositoryes.UserRepository;

@Configuration
public class instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository 	postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));

		Post post1 = new Post(null, sdf.parse("21/02/2021"),"Partiu","vou viajar para são Paulo",new AuthorDTO( maria));
		Post post2 = new Post(null, sdf.parse("21/01/2021"),"Bom dia","Acordei feliz hj", new AuthorDTO (maria));

		CommentDTO c1 = new CommentDTO("Boa viagem",sdf.parse("21/01/2020"), new AuthorDTO(alex));
		
		post1.getComments().add(c1);
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		
		userRepository.save(maria);


		
	}

}
