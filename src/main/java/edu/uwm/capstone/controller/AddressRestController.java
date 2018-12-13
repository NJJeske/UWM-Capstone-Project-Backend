package edu.uwm.capstone.controller;

import edu.uwm.capstone.model.address.Address;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uwm.capstone.db.address.AddressDao;
import io.swagger.annotations.ApiOperation;

@RestController
public class AddressRestController {

    @Autowired
    private AddressDao service;

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressRestController.class);

    /**
 	* This endpoint is used to retrieve a address object by
	* its id.
	* @param id {Long}
	* @return Address
	*/
    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public Address retrieveAddress(@PathVariable long id) {
        return service.read(id);
    }
    
    /**
 	* This endpoint is used to retrieve a list of address objects by
	* its userId.
	* @param userId {Long}
	* @return List<Map<String, Object>>
	*/
    @RequestMapping(value = "/address/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyAddresses(@PathVariable long userId) {
        return service.readMany(userId);
    }

    /**
	* This endpoint is used to create a address object.
	* @param address {Address}
	* @return Address
	*/
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public Address createAddress(@RequestBody Address address) {
        return service.create(address);
    }

    /**
	* This endpoint is used to delete a address object by
	* its id.
	* @param id {Long}
	*/
    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable long id) {
        service.delete(id);
    }

    /**
	* This endpoint is used to update a address object.
	* @param address {Address}
	*/
    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    public void updateAddress(@RequestBody Address address) {
        service.update(address);
    }
}