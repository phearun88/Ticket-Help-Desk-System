package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer>{
	public User findByUsername(String username);
}
