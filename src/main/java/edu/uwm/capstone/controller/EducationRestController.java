package edu.uwm.capstone.controller;

import edu.uwm.capstone.model.education.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uwm.capstone.db.education.EducationDao;
import io.swagger.annotations.ApiOperation;

@RestController
public class EducationRestController {

    @Autowired
    private EducationDao service;

    // Get
    @RequestMapping(value = "/education/{id}", method = RequestMethod.GET)
    public Education retrieveEducation(@PathVariable long id) {
        return service.read(id);
    }

    // Post
    @RequestMapping(value = "/education", method = RequestMethod.POST)
    public Education createEducation(@RequestBody Education education) {
        return service.create(education);
    }

    // Delete
    @RequestMapping(value = "/education/{id}", method = RequestMethod.DELETE)
    public void deleteEducation(@PathVariable long id) {
        service.delete(id);
    }

    // Put
    @RequestMapping(value = "/education", method = RequestMethod.PUT)
    public void updateEducation(@RequestBody Education education) {
        service.update(education);
    }
}