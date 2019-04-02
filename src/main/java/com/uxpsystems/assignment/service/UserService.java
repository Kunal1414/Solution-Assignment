package com.uxpsystems.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.controller.model.User;
import com.uxpsystems.assignment.dao.UserDAO;
import com.uxpsystems.assignment.exception.AssignmentException;
import com.uxpsystems.assignment.exception.UserNotFoundException;
import com.uxpsystems.assignment.error.Error;


@Service
@CacheConfig(cacheNames = "user")
@Component
@Configuration
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@CacheEvict(allEntries = true)
	public void clearCache() {
	}

	@Secured("ROLE_USER")
	@Cacheable(value = "users", unless = "#result != null")
	public User getById(Long userid) throws UserNotFoundException {
		Optional<User> optionalUser = userDAO.findById(userid);
		
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new UserNotFoundException("User Not Found");
	}

	@Secured("ROLE_ADMIN")
	public void deleteById(Long userid) throws UserNotFoundException {
		try {
			userDAO.deleteById(userid);
		} catch (Exception e) {
			throw new UserNotFoundException("User with id " + userid + " Not Found");
		}
		return;
	}

	@Secured("ROLE_ADMIN")
	public User insertUser(User newuser) throws AssignmentException {
		System.out.println("In service class");
		System.out.println(newuser.getName());
		System.out.println(newuser.getUserId());
		User user = new User();
		user.setUserId(newuser.getUserId());
		user.setName(newuser.getName());
		user.setStatus(newuser.getStatus());
		user.setPassword(newuser.getPassword());
	User usernew = save(user);
		return usernew;
	}

	public User save(User user) throws AssignmentException {
		System.out.println("In save method");
		User newuser = null;
		try {
		  newuser = userDAO.save(user);
		  System.out.println(newuser.getName());
		} catch (Exception e) {
			e.printStackTrace();
			//throw new AssignmentException(e);
		}
		return newuser;
	}

	@Secured("ROLE_ADMIN")
	public User updateUser(Long userid, User updateuser) throws AssignmentException {
		User user = getById(userid);
		user.setName(updateuser.getName());
		user.setStatus(updateuser.getStatus());
		user.setPassword(updateuser.getPassword());
		return save(user);
	}

	

	public Error getError(String exceptionClassName) {
		switch (exceptionClassName) {
		case "DataIntegrityViolationException": {
			return Error.DUPLICATE_USER_NAME;
		}
		default: {
			return Error.DEFAULT;
		}
		}

	}

}
