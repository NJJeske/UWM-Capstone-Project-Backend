package edu.uwm.capstone.controller;

import edu.uwm.capstone.model.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uwm.capstone.db.address.AddressDao;
import io.swagger.annotations.ApiOperation;

@RestController
public class AddressRestController {

    @Autowired
    private AddressDao service;

    /**
 	* This endpoint is used to retrieve a address object by
	* its id.
	* @param long id
	* @return Address
	*/
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public Address retrieveAddress(@PathVariable long id) {
        return service.read(id);
    }

    /**
	* This endpoint is used to create a address object.
	* @param Address address
	* @return Address
	*/
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public Address createAddress(@RequestBody Address address) {
        return service.create(address);
    }

    /**
	* This endpoint is used to delete a address object by
	* its id.
	* @param long id
	* @return void
	*/
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable long id) {
        service.delete(id);
    }

    /**
	* This endpoint is used to update a address object.
	* @param Address address
	* @return void
	*/
    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    public void updateAddress(@RequestBody Address address) {
        service.update(address);
    }
}
