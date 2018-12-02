package edu.uwm.capstone.controller;

import edu.uwm.capstone.model.company.Company;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uwm.capstone.db.company.CompanyDao;
import io.swagger.annotations.ApiOperation;

@RestController
public class CompanyRestController {

    @Autowired
    private CompanyDao service;

    // Get
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Company retrieveCompany(@PathVariable long id) {
        return service.read(id);
    }
    
    // Get many
    @RequestMapping(value="/company/retrievemany/{userid}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyCompany(@PathVariable long userid) {
        return service.readMany(userid);
    }

    // Post
    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Company createCompany(@RequestBody Company company) {
        return service.create(company);
    }

    // Delete
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable long id) {
        service.delete(id);
    }

    // Put
    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    public void updateCompany(@RequestBody Company company) {
        service.update(company);
    }
}
