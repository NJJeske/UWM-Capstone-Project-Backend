package edu.uwm.capstone.controller;
import edu.uwm.capstone.model.project.Project;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uwm.capstone.db.project.ProjectDao;

@RestController
public class ProjectRestController {
    @Autowired
    private ProjectDao service;
    
    /**
 	* This endpoint is used to retrieve a project object by
	* its id.
	* @param id {Long}
	* @return Project
	*/
    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public Project retrieveOne(@PathVariable long id) {
        return service.read(id);
    }
    
    /**
 	* This endpoint is used to retrieve a project object by
	* its id.
	* @param userId {Long}
	* @return List<Map<String, Project>>
	*/
    @RequestMapping(value = "/project/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveMany(@PathVariable long userId) {
        return service.readMany(userId);
    }
    
    /**
	* This endpoint is used to create a project object.
	* @param project {Project}
	* @return Project
	*/
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public Project createProject(@RequestBody Project project) {
        return service.create(project);
    }
    
    /**
	* This endpoint is used to delete a project object by
	* its id.
	* @param id {Long}
	*/
    @RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable long id) {
        service.delete(id);
    }
    
    /**
	* This endpoint is used to update a project object.
	* @param project {Project}
	*/
    @RequestMapping(value = "/project", method = RequestMethod.PUT)
    public void updateProject(@RequestBody Project project) {
        service.update(project);
    }
}

