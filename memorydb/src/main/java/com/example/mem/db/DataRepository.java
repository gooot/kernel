package com.example.mem.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T,ID>{


	// create
	T save(T data);




	// read
	Optional<T> findById(ID id);




	List<T> findAll();



	// delete
	void delete(ID id);


}
