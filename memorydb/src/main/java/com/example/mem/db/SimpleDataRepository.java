package com.example.mem.db;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.mem.entity.Entity;

abstract public class SimpleDataRepository<T extends Entity, ID> implements DataRepository<T, ID> {

	private List<T> dataList = new ArrayList<>();

	private static long index = 0;

	private Comparator<T> sort = new Comparator<T>() {
		@Override
		public int compare(T o1, T o2) {

			return Long.compare(o1.getId(),o2.getId());
		}
	};


	// create
	@Override
	public T save(T data){

		if(Objects.isNull(data)){
			throw new RuntimeException("Data is null");
		}

		var prevData = dataList.stream()
				.filter(it -> {
					return it.equals(data.getId());
				})
					.findFirst();

		if (prevData.isPresent()) {

			dataList.remove(prevData);
			dataList.add(data);
		} else {

			index++;
			data.setId(index);
			dataList.add(data);
		}






		return data;

	}




	// read

	@Override
	public Optional<T> findById(ID id){
		return dataList.stream()
			.filter(it -> {
				return ( it.getId().equals(id));
			})
			.findFirst();
	}




	@Override
	public List<T> findAll(){



		return dataList
			.stream()
			.sorted()
			.collect(Collectors.toList());
	}




	// delete
	@Override
	public void delete(ID id){
		var deleteEntity = dataList.stream()
			.filter(it -> {
				return (it.getId().equals(id));
			})
			.findFirst();

		if(deleteEntity.isPresent()){
			dataList.remove(deleteEntity);
		}



	}




}
