package edu.uwm.capstone.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import edu.uwm.capstone.db.user.UserDao;
import org.springframework.web.bind.annotation.*;
import edu.uwm.capstone.model.user.User;
import edu.uwm.capstone.helper.AuthHelper;

@RestController
public class UserRestController {
	
	   @Autowired
	   private UserDao service;


	   /**
	    * This endpoint is used to retrieve a user object by
	    * their email address.
	    * @param token {String}
	    * @return User
	    */
	    @RequestMapping(value = "/user", method = RequestMethod.GET)
	    public User retrieveUser(@RequestHeader(value="Authorization") String token) {
	    	if(token.contains("Bearer ")) {
	    		token = token.replace("Bearer", "");
			}
			String email = AuthHelper.getEmailFromAccessToken(token);
	        return service.read_by_email(email);
	    }

	   /**
	    * This endpoint is used to create a new user object.
	    * @param user {User}
	    */
	    @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public User createUser(@RequestHeader(value="Authorization") String token) {
			if(token.contains("Bearer ")) {
	    		token = token.replace("Bearer", "");
			}
			String email = AuthHelper.getEmailFromAccessToken(token);
			User u = new User();
			u.setEmail(email);
	        return service.create(u);
	    }
	   
	   /**
	    * This endpoint is used to delete a user object from a
	    * a table given an email address.
	    * @param {Map<String, String} body
	    */
	    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
	    public void deleteUser(@RequestBody Map<String, String> body) {
	    	String email = body.get("email");
	        service.delete_by_email(email);
	    }
	   
	   /**
	    * This endpoint is used to update a user object
	    * @param user {User}
	    */
	    @RequestMapping(value = "/user", method = RequestMethod.PUT)
	    public void updateUser(@RequestBody User user) {
	        service.update(user);
	    }
}
