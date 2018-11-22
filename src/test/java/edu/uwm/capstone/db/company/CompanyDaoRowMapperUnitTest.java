package edu.uwm.capstone.db.company;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uwm.capstone.UnitTestConfig;
import edu.uwm.capstone.model.company.Company;
import edu.uwm.capstone.sql.dao.BaseRowMapper;
import edu.uwm.capstone.util.TestDataUtility;
import static edu.uwm.capstone.sql.dao.BaseRowMapper.dateFromJavaTime;
import static edu.uwm.capstone.sql.dao.BaseRowMapper.javaTimeFromDate;
import static edu.uwm.capstone.util.TestDataUtility.randomInt;
import static edu.uwm.capstone.util.TestDataUtility.randomLocalDateTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UnitTestConfig.class)
public class CompanyDaoRowMapperUnitTest {

    @Autowired
    CompanyDaoRowMapper companyDaoRowMapper;

    @Mock
    private ResultSet resultSet;

    @Before
    public void setUp() throws IOException {
        assertNotNull(companyDaoRowMapper);
    }

    /**
     * Verify that {@link CompanyDaoRowMapper.CompanyColumnType#values()} is working correctly.
     */
    @Test
    public void companyColumnType() {
        for (CompanyDaoRowMapper.CompanyColumnType columnType : CompanyDaoRowMapper.CompanyColumnType.values()) {
            assertNotNull(columnType.name());
            assertNotNull(columnType.getColumnName());
        }
    }

    /**
     * Verify that {@link CompanyDaoRowMapper#mapObject} is working correctly.
     */
    @Test
    public void mapObject() {
        // generate a company object with test values
        Company company = TestDataUtility.companyWithTestValues();
        company.setId(TestDataUtility.randomLong());
        company.setName(TestDataUtility.randomAlphabetic(randomInt(1, 100)));
        company.setAddress(TestDataUtility.randomAlphanumeric(randomInt(1, 100)));
        company.setPhoneNumber(TestDataUtility.randomNumeric(randomInt(1, 100)));
        company.setWebsite(TestDataUtility.randomAlphanumeric(randomInt(1, 100)));
        company.setCreatedDate(randomLocalDateTime());
        company.setUpdatedDate(randomLocalDateTime());
        assertNotNull(company);

        Map<String, Object> mapObject = companyDaoRowMapper.mapObject(company);
        assertNotNull(mapObject);

        assertEquals(company.getId(), mapObject.get(BaseRowMapper.BaseColumnType.ID.getColumnName()));
        assertEquals(company.getName(), mapObject.get(CompanyDaoRowMapper.CompanyColumnType.NAME.getColumnName()));
        assertEquals(company.getAddress(), mapObject.get(CompanyDaoRowMapper.CompanyColumnType.ADDRESS.getColumnName()));
        assertEquals(company.getPhoneNumber(), mapObject.get(CompanyDaoRowMapper.CompanyColumnType.PHONE_NUMBER.getColumnName()));
        assertEquals(company.getWebsite(), mapObject.get(CompanyDaoRowMapper.CompanyColumnType.WEBSITE.getColumnName()));
        assertEquals(company.getCreatedDate(), dateFromJavaTime(mapObject.get(BaseRowMapper.BaseColumnType.CREATED_DATE.getColumnName())));
        assertEquals(company.getUpdatedDate(), dateFromJavaTime(mapObject.get(BaseRowMapper.BaseColumnType.UPDATED_DATE.getColumnName())));
    }

    /**
     * Verify that {@link CompanyDaoRowMapper#mapRow} is working correctly.
     */
    @Test
    public void mapRow() throws SQLException {
        // generate a company object with test values
        Company company = TestDataUtility.companyWithTestValues();
        company.setId(TestDataUtility.randomLong());
        company.setName(TestDataUtility.randomAlphabetic(randomInt(1, 100)));
        company.setAddress(TestDataUtility.randomAlphanumeric(randomInt(1, 100)));
        company.setPhoneNumber(TestDataUtility.randomNumeric(randomInt(1, 100)));
        company.setWebsite(TestDataUtility.randomAlphanumeric(randomInt(1, 100)));
        company.setCreatedDate(randomLocalDateTime());
        company.setUpdatedDate(randomLocalDateTime());
        assertNotNull(company);

        // define the behavior of the resultSet that is being mocked
        when(resultSet.getLong(BaseRowMapper.BaseColumnType.ID.getColumnName())).thenReturn(company.getId());
        when(resultSet.getString(CompanyDaoRowMapper.CompanyColumnType.NAME.getColumnName())).thenReturn(company.getName());
        when(resultSet.getString(CompanyDaoRowMapper.CompanyColumnType.ADDRESS.getColumnName())).thenReturn(company.getAddress());
        when(resultSet.getString(CompanyDaoRowMapper.CompanyColumnType.PHONE_NUMBER.getColumnName())).thenReturn(company.getPhoneNumber());
        when(resultSet.getString(CompanyDaoRowMapper.CompanyColumnType.WEBSITE.getColumnName())).thenReturn(company.getWebsite());
        when(resultSet.getObject(BaseRowMapper.BaseColumnType.CREATED_DATE.getColumnName())).thenReturn(javaTimeFromDate(company.getCreatedDate()));
        when(resultSet.getObject(BaseRowMapper.BaseColumnType.UPDATED_DATE.getColumnName())).thenReturn(javaTimeFromDate(company.getUpdatedDate()));

        // exercise the mapRow functionality and verify the expected results
        Company verifyCompany = companyDaoRowMapper.mapRow(resultSet, 0);
        assertNotNull(verifyCompany);

        assertEquals(company.getId(), verifyCompany.getId());
        assertEquals(company.getName(), verifyCompany.getName());
        assertEquals(company.getAddress(), verifyCompany.getAddress());
        assertEquals(company.getPhoneNumber(), verifyCompany.getPhoneNumber());
        assertEquals(company.getWebsite(), verifyCompany.getWebsite());
        assertEquals(company.getCreatedDate(), verifyCompany.getCreatedDate());
        assertEquals(company.getUpdatedDate(), verifyCompany.getUpdatedDate());
    }

}