package com.max.springMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.max.springMongo.DTO.UserDto;
import com.max.springMongo.Domain.User;
import com.max.springMongo.repositoryes.UserRepository;
import com.max.springMongo.services.Exception.ObjectNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> FindAll(){		
		return repo.findAll();
		
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repo.save(obj);
		
	}
	
	public void delete(String id) {
		repo.findById(id);
		repo.deleteById(id);
	}
	
	public User FromDTO(UserDto objDTO ) {
		return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}
	
	
	

}
