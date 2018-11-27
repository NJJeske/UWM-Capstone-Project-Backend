package edu.uwm.capstone.controller;
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
	    * their id.
	    * @param long id
	    * @return User
	    */
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	    public User retrieveUser(@PathVariable long id) {
	        return service.read(id);
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
	    * a table given an id.
	    * @param long id
	    * @return void
	    */
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public void deleteUser(@PathVariable long id) {
	        service.delete(id);
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
