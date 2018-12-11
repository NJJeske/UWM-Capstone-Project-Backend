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
        try {
            return service.read(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
 	* This endpoint is used to retrieve a list of position objects by
	* its id.
	* @param userId {Long}
	* @return List<Map<String, Object>>
	*/
    @RequestMapping(value = "/position/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyPositions(@PathVariable long userId) {
        try {
            return service.readMany(userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
	* This endpoint is used to create a position object.
	* @param position {Position}
	* @return Position
	*/
    @RequestMapping(value = "/position", method = RequestMethod.POST)
    public Position createPosition(@RequestBody Position position) {
        try {
            return service.create(position);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
	* This endpoint is used to delete a position object by
	* its id.
	* @param id {Long}
	*/
    @RequestMapping(value = "/position/{id}", method = RequestMethod.DELETE)
    public void deletePosition(@PathVariable long id) {
        try {
            service.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
	* This endpoint is used to update a position object.
	* @param position {Position}
	*/
    @RequestMapping(value = "/position", method = RequestMethod.PUT)
    public void updatePosition(@RequestBody Position position) {
        try {
            service.update(position);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}