package edu.uwm.capstone.controller;

import edu.uwm.capstone.model.company.Company;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.uwm.capstone.db.company.CompanyDao;

@RestController
public class CompanyRestController {

    @Autowired
    private CompanyDao companyService;

    /**
     * This endpoint is used to retrieve a company object by
     * its id.
     * @param id {Long}
     * @return company
     */
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Company retrieveCompany(@PathVariable long id) {
        return companyService.read(id);
    }

    /**
     * This endpoint is used to retrieve a list of company objects by
     * its userId.
     * @param userId {Long}
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value="/company/retrievemany/{userId}", method = RequestMethod.GET)
    public List<Map<String, Object>> retrieveManyCompanies(@PathVariable long userId) {
        return companyService.readMany(userId);
    }

    /**
     * This endpoint is used to create a company object.
     * @param company {Company}
     * @return Company
     */
    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Company createCompany(@RequestBody Company company) {
        return companyService.create(company);
    }

    /**
     * This endpoint is used to delete a company object by
     * its id.
     * @param id {Long}
     */
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable long id) {
        companyService.delete(id);
    }

    /**
     * This endpoint is used to update a company object.
     * @param company {Company}
     */
    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    public void updateCompany(@RequestBody Company company) {
        companyService.update(company);
    }
}