
package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.exception.CustomizedResponseEntityExceptionHandler;
import com.uxpsystems.assignment.controller.model.User;
import com.uxpsystems.assignment.exception.AssignmentException;
import com.uxpsystems.assignment.exception.UserNotFoundException;
import com.uxpsystems.assignment.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * No description
 * (Generated with springmvc-raml-parser v.2.0.0)
 * 
 */
@RestController(value="AssignmentController")
@RequestMapping(value = "/assignment", produces = "application/json")
public class AssignmentController {

	@Autowired(required=true)
    private UserService userService;
    
    @RequestMapping(value = "/users", method = RequestMethod.POST,consumes="application/json" , produces = "application/json")
    public ResponseEntity<?> createAssignment(@RequestBody User newUser) {
    	User user;
		try {
			user = userService.insertUser(newUser);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (AssignmentException e) {
			return new CustomizedResponseEntityExceptionHandler().forAssignmentException(e, userService.getError(e.getCause().getClass().getSimpleName()).toString());
			
		}
    }

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/users/{userid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUserByUserid(
        @PathVariable("userid")
        Long userid) {
        
    	User user;
		try {
			user = userService.getById(userid);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new CustomizedResponseEntityExceptionHandler().UserNotFound(e);
		}
    }

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/users/{userid}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateAssignment(
        @PathVariable("userid")
        Long userid, @RequestBody User updateUser) {
    	User user;
		try {
			user = userService.updateUser(userid, updateUser);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return new CustomizedResponseEntityExceptionHandler().UserNotFound(e);
		} catch (AssignmentException e) {
			return new CustomizedResponseEntityExceptionHandler().forAssignmentException(e, userService.getError(e.getCause().getClass().getSimpleName()).toString());
		}
    }

    /**
     * No description
     * 
     */
    @RequestMapping(value = "/users/{userid}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteByUserid(
        @PathVariable("userid")
        Long userid) {
    	try {
			userService.deleteById(userid);
			System.err.println("TEST DELETE");
			return new ResponseEntity<String>("User with id " + userid + " Deleted Successfully", HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new CustomizedResponseEntityExceptionHandler().UserNotFound(e);
		}
    }

}
