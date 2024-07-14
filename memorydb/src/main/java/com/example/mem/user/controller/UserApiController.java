package com.example.mem.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mem.user.db.UserRepository;
import com.example.mem.user.model.UserEntity;
import com.example.mem.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Controller
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;
	private final UserRepository userRepository;

	// Entity 를 컨트롤러로 받으면 안됨 이유 생각해보기
	@PutMapping("")
	public UserEntity create(
		@RequestBody UserEntity userEntity
	){

		return userService.save(userEntity);

	}

	@GetMapping("/all")
	public List<UserEntity> findAll(){
		return userService.findAll();
	}
	@GetMapping()
	public UserEntity findOne(
		@PathVariable Long id
	){
		var response = userRepository.findById(id);
		return response.get();

	}




	@GetMapping("/id/{id}")
	public void delete(
		@PathVariable Long id
	){
		userService.delete(id);
	}

	@GetMapping("/score")
	public List<UserEntity> filterScore(
		@PathVariable int score
	){
		return userService.filterScore(score);

	}


}
