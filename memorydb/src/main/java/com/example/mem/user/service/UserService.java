package com.example.mem.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mem.user.db.UserRepository;
import com.example.mem.user.model.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserEntity save(UserEntity user){

		return userRepository.save(user);

	}

	public List<UserEntity> findAll(){
		return userRepository.findAll();
	}

	public void delete(Long id){
		userRepository.delete(id);
	}

	public Optional<UserEntity> findById(Long id){
		return userRepository.findById(id);

	}

	public List<UserEntity> filterScore(int score){
		return userRepository.findAllScoreGreaterThen(score);
	}
}
