package edu.uwm.capstone.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import edu.uwm.capstone.db.user.UserDao;
import org.springframework.web.bind.annotation.*;
import edu.uwm.capstone.model.user.User;

@RestController
public class UserRestController {
	
	   @Autowired
	   private UserDao service;
	   
	   /**
	    * This endpoint is used to retrieve a user object by
	    * their email address.
	    * @param String email
	    * @return User
	    */
	    @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
	    public User retrieveUser(@PathVariable String email) {
	    	email.replaceAll("%40", "@");
	        return service.read_by_email(email);
	    }
	   
	   /**
	    * This endpoint is used to create a new user object.
	    * @param User user
	    * @return void
	    */
	    @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public User createUser(@RequestBody User user) {
	        return service.create(user);
	    }
	   
	   /**
	    * This endpoint is used to delete a user object from a
	    * a table given an email address.
	    * @param String email
	    * @return void
	    */
	    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
	    public void deleteUser(@RequestBody Map<String, String> body) {
	    	String email = body.get("email");
	        service.delete_by_email(email);
	    }
	   
	   /**
	    * This endpoint is used to update a user object
	    * @param User user
	    * @return void
	    */
	    @RequestMapping(value = "/user", method = RequestMethod.PUT)
	    public void updateUser(@RequestBody User user) {
	        service.update(user);
	    }
}
