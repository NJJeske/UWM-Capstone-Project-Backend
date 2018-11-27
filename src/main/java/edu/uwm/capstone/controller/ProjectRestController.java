package edu.uwm.capstone.controller;
import edu.uwm.capstone.model.project.Project;
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
	* @param long id
	* @return Project
	*/
    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public Project retrieveProject(@PathVariable long id) {
        return service.read(id);
    }
    
    /**
	* This endpoint is used to create a project object.
	* @param Project project
	* @return Project
	*/
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public Project createProject(@RequestBody Project project) {
        return service.create(project);
    }
    
    /**
	* This endpoint is used to delete a project object by
	* its id.
	* @param long id
	* @return void
	*/
    @RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable long id) {
        service.delete(id);
    }
    
    /**
	* This endpoint is used to update a project object.
	* @param Project project
	* @return void
	*/
    @RequestMapping(value = "/project", method = RequestMethod.PUT)
    public void updateProject(@RequestBody Project project) {
        service.update(project);
    }
}

