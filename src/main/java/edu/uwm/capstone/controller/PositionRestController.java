package edu.uwm.capstone.controller;


import edu.uwm.capstone.model.position.Position;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uwm.capstone.db.position.PositionDao;
import io.swagger.annotations.ApiOperation;

@RestController
public class PositionRestController {

    @Autowired
    private PositionDao service;

    /**
 	* This endpoint is used to retrieve a position object by
	* its id.
	* @param id {Long}
	* @return Position
	*/
    @RequestMapping(value = "/position/{id}", method = RequestMethod.GET)
    public Position retrievePosition(@PathVariable long id) {
        return service.read(id);
    }
    
    /**
 	* This endpoint is used to retrieve a position object by
	* its id.
	* @param userId {Long}
	* @return Position
	*/
    @RequestMapping(value = "/position/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyPositions(@PathVariable long userId) {
        return service.readMany(userId);
    }

    /**
	* This endpoint is used to create a position object.
	* @param position {Position}
	* @return Position
	*/
    @RequestMapping(value = "/position", method = RequestMethod.POST)
    public Position createPosition(@RequestBody Position position) {
        return service.create(position);
    }

    /**
	* This endpoint is used to delete a position object by
	* its id.
	* @param id {Long}
	*/
    @RequestMapping(value = "/position/{id}", method = RequestMethod.DELETE)
    public void deletePosition(@PathVariable long id) {
        service.delete(id);
    }

    /**
	* This endpoint is used to update a position object.
	* @param position {Position}
	*/
    @RequestMapping(value = "/position", method = RequestMethod.PUT)
    public void updatePosition(@RequestBody Position position) {
        service.update(position);
    }
}