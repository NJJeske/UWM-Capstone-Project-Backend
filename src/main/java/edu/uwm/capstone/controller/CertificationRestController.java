package edu.uwm.capstone.controller;

import edu.uwm.capstone.db.certification.CertificationDao;
import edu.uwm.capstone.model.certification.Certification;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CertificationRestController {

    @Autowired
    private CertificationDao service;

    // Get
    @RequestMapping(value = "/certification/{id}", method = RequestMethod.GET)
    public Certification retrieveCertification(@PathVariable long id) {
        return service.read(id);
    }
    
    // Get many
    @RequestMapping(value="/certification/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyCertifications(@PathVariable long userId) {
        return service.readMany(userId);
    }

    // Post
    @RequestMapping(value = "/certification", method = RequestMethod.POST)
    public Certification createCertification(@RequestBody Certification certification) {
        return service.create(certification);
    }

    // Delete
    @RequestMapping(value = "/certification/{id}", method = RequestMethod.DELETE)
    public void deleteEducation(@PathVariable long id) {
        service.delete(id);
    }

    // Put
    @RequestMapping(value = "/certification", method = RequestMethod.PUT)
    public void updateCertification(@RequestBody Certification certification) {
        service.update(certification);
    }
}
