package com.uxpsystems.assignment.dao;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uxpsystems.assignment.controller.model.User;



@Repository
public interface UserDAO extends CrudRepository<User, Long> {
	/*@Caching(put = { @CachePut(value = "users", key = "'name:' + #result.name", condition = "#result != null"),
			@CachePut(value = "userCache", key = "#result.id", condition = "#result != null") })
	@Transactional(readOnly = true)
	public User getById(Long userid);*/

}
