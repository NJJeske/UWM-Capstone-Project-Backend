package edu.uwm.capstone.controller;

import edu.uwm.capstone.model.education.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uwm.capstone.db.education.EducationDao;
import edu.uwm.capstone.model.education.Education;
import io.swagger.annotations.ApiOperation;

@RestController
public class EducationRestController {

    @Autowired
    private EducationDao service;

    // Get
    @GetMapping("/education/{id}")
    public Education retrieveEducation(@PathVariable long id) {
        return service.read(id);
    }

    // Post
    @PostMapping("/education")
    public void createEducation(@RequestBody Education education) {
        service.create(education);
    }

    // Delete
    @DeleteMapping("/education/{id}")
    public void deleteEducation(@RequestBody long id) {
        service.delete(id);
    }

    // Put
    @PutMapping("/education")
    public void updateEducation(@RequestBody Education education) {
        service.update(education);
    }

}
