package edu.uwm.capstone.controller;

import edu.uwm.capstone.model.education.Education;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uwm.capstone.db.education.EducationDao;

@RestController
public class EducationRestController {

    @Autowired
    private EducationDao service;

    /**
     * This endpoint is used to retrieve a education object by
     * its id.
     * @param id {Long}
     * @return Education
     */
    @RequestMapping(value = "/education/{id}", method = RequestMethod.GET)
    public Education retrieveEducation(@PathVariable long id) {
        return service.read(id);
    }

    /**
     * This endpoint is used to retrieve a list of education objects by
     * its userId.
     * @param userId {Long}
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value="/education/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyEducations(@PathVariable long userId) {
        return service.readMany(userId);
    }

    /**
     * This endpoint is used to create an education object.
     * @param education {Education}
     * @return Education
     */
    @RequestMapping(value = "/education", method = RequestMethod.POST)
    public Education createEducation(@RequestBody Education education) {
        return service.create(education);
    }

    /**
     * This endpoint is used to delete an education object by
     * its id.
     * @param id {Long}
     */
    @RequestMapping(value = "/education/{id}", method = RequestMethod.DELETE)
    public void deleteEducation(@PathVariable long id) {
        service.delete(id);
    }

    /**
     * This endpoint is used to update a contact object.
     * @param education {Education}
     */
    @RequestMapping(value = "/education", method = RequestMethod.PUT)
    public void updateEducation(@RequestBody Education education) {
        service.update(education);
    }
}
