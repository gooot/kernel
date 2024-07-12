package com.example.mem.entity;

import lombok.Data;

@Data
public abstract class Entity implements PrimaryKey {

	private Long id;
}
