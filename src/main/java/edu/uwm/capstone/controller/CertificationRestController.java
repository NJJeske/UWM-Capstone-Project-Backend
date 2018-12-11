package edu.uwm.capstone.controller;

import edu.uwm.capstone.db.certification.CertificationDao;
import edu.uwm.capstone.model.certification.Certification;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

@RestController
public class CertificationRestController {

    @Autowired
    private CertificationDao service;

    // Get
    @RequestMapping(value = "/certification/{id}", method = RequestMethod.GET)
    public Certification retrieveCertification(@PathVariable long id) {
        System.out.println("retrieveCertification");
        try {
            return service.read(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    // Get many
    @RequestMapping(value="/certification/retrievemany/{userid}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyCertifications(@PathVariable long userid) {
        System.out.println("retrieveManyCertifications");
        try {
            return service.readMany(userid);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Post
    @RequestMapping(value = "/certification", method = RequestMethod.POST)
    public Certification createCertification(@RequestBody Certification certification) {
        System.out.println("createCertification: " + certification.toString());
        try {
            return service.create(certification);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Delete
    @RequestMapping(value = "/certification/{id}", method = RequestMethod.DELETE)
    public void deleteEducation(@PathVariable long id) {
        System.out.println("deleteEducation");
        try {
            service.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Put
    @RequestMapping(value = "/certification", method = RequestMethod.PUT)
    public void updateCertification(@RequestBody Certification certification) {
        System.out.println("updateCertification");
        try {
            service.update(certification);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
