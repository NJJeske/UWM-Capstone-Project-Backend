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

    /**
     * This endpoint is used to retrieve a certification object by
     * its id.
     * @param id {Long}
     * @return Certification
     */
    @RequestMapping(value = "/certification/{id}", method = RequestMethod.GET)
    public Certification retrieveCertification(@PathVariable long id) {
        return service.read(id);
    }

    /**
     * This endpoint is used to retrieve a list of certification object by
     * its userId
     * @param userId {Long}
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value="/certification/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyCertifications(@PathVariable long userId) {
        return service.readMany(userId);
    }

    /**
     * This endpoint is used to create a contact object.
     * @param certification {Certifications}
     * @return Certification
     */
    @RequestMapping(value = "/certification", method = RequestMethod.POST)
    public Certification createCertification(@RequestBody Certification certification) {
        return service.create(certification);
    }

    /**
     * This endpoint is used to delete a certification object by
     * its id.
     * @param id {Long}
     */
    @RequestMapping(value = "/certification/{id}", method = RequestMethod.DELETE)
    public void deleteEducation(@PathVariable long id) {
        service.delete(id);
    }

    /**
     * This endpoint is used to update a contact object.
     * @param certification {Certification}
     */
    @RequestMapping(value = "/certification", method = RequestMethod.PUT)
    public void updateCertification(@RequestBody Certification certification) {
        service.update(certification);
    }
}