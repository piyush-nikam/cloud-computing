package com.cloud.assignment.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cloud.assignment.model.FoodOrder;

public class FoodOrderDAO implements CrudRepository<FoodOrder, Integer> {

	@Override
	public <S extends FoodOrder> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FoodOrder> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodOrder> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<FoodOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<FoodOrder> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FoodOrder entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends FoodOrder> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
