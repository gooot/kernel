package com.example.mem.user.db;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.mem.db.SimpleDataRepository;
import com.example.mem.user.model.UserEntity;

import lombok.RequiredArgsConstructor;


public class UserRepository extends SimpleDataRepository<UserEntity, Long> {


	public List<UserEntity> findAllScoreGreaterThen(int score){
		return this.findAll().stream()
			.filter(
				it -> {
					return it.getScore() >= score;
				}
			).collect(Collectors.toList());
	}



}
