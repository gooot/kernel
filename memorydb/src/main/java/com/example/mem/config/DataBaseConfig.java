package com.example.mem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.mem.db.Repository;
import com.example.mem.user.db.UserRepository;

@Configuration
public class DataBaseConfig {

	@Bean
	public UserRepository userRepository(){
		return new UserRepository();
	}
}
