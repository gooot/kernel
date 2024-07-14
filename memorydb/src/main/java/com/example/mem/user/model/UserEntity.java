package com.example.mem.user.model;

import com.example.mem.entity.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity  extends Entity {

	private String name;

	private int score;


}
