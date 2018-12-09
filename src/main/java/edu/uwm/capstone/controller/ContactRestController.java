package edu.uwm.capstone.controller;


import edu.uwm.capstone.model.contact.Contact;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uwm.capstone.db.contact.ContactDao;
import io.swagger.annotations.ApiOperation;

@RestController
public class ContactRestController {

    @Autowired
    private ContactDao service;

    /**
 	* This endpoint is used to retrieve a contact object by
	* its id.
	* @param id {Long}
	* @return Contact
	*/
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public Contact retrieveContact(@PathVariable long id) {
        return service.read(id);
    }
    
    /**
 	* This endpoint is used to retrieve a contact object by
	* its id.
	* @param userId {Long}
	* @return Contact
	*/
    @RequestMapping(value = "/contact/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyContacts(@PathVariable long userId) {
        return service.readMany(userId);
    }

    /**
	* This endpoint is used to create a contact object.
	* @param contact {Contact}
	* @return Contact
	*/
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public Contact createContact(@RequestBody Contact contact) {
        return service.create(contact);
    }

    /**
	* This endpoint is used to delete a contact object by
	* its id.
	* @param id {Long}
	*/
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable long id) {
        service.delete(id);
    }

    /**
	* This endpoint is used to update a contact object.
	* @param contact {Contact}
	*/
    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
    public void updateContact(@RequestBody Contact contact) {
        service.update(contact);
    }
}