package edu.uwm.capstone;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import edu.uwm.capstone.db.address.AddressDao;
import edu.uwm.capstone.db.address.AddressDaoRowMapper;
import edu.uwm.capstone.db.company.CompanyDao;
import edu.uwm.capstone.db.company.CompanyDaoRowMapper;
import edu.uwm.capstone.db.education.EducationDao;
import edu.uwm.capstone.db.education.EducationDaoRowMapper;
import edu.uwm.capstone.db.project.ProjectDao;
import edu.uwm.capstone.db.project.ProjectDaoRowMapper;
import edu.uwm.capstone.db.contact.ContactDao;
import edu.uwm.capstone.db.contact.ContactDaoRowMapper;
import edu.uwm.capstone.db.ProfileDao;
import edu.uwm.capstone.db.ProfileDaoRowMapper;
import edu.uwm.capstone.db.position.PositionDao;
import edu.uwm.capstone.db.position.PositionDaoRowMapper;
import edu.uwm.capstone.sql.statement.ISqlStatementsFileLoader;
import edu.uwm.capstone.sql.statement.SqlStatementsFileLoader;
import edu.uwm.capstone.util.Concatenation;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConfigurationProperties(prefix = "service")
@EnableSwagger2
public class ApplicationConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);

    protected String dbDriverClassName;
    protected String dbDriverUrl;
    protected String dbUsername;
    protected String dbPassword;
    protected String dbMigrationLocation;
    protected int dbPoolMaxwait;
    protected boolean dbPoolRemoveabandoned;
    protected int dbPoolRemoveabandonedtimeout;
    protected boolean dbPoolLogabandoned;
    protected long dbPoolMaxage;
    protected String sqlStatementsResourceLocation;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    Concatenation concatenation() {
        return new Concatenation();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        LOGGER.info("Loading DataSource");
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName(dbDriverClassName);
        poolProperties.setUrl(dbDriverUrl);
        poolProperties.setUsername(dbUsername);
        poolProperties.setPassword(dbPassword);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("SELECT 1");

        // Set additional pool properties
        poolProperties.setMaxWait(dbPoolMaxwait);
        poolProperties.setRemoveAbandoned(dbPoolRemoveabandoned);
        poolProperties.setRemoveAbandonedTimeout(dbPoolRemoveabandonedtimeout);
        poolProperties.setLogAbandoned(dbPoolLogabandoned);
        poolProperties.setMaxAge(dbPoolMaxage);
        poolProperties.setMaxActive(600);


        DataSource ds = new DataSource();
        ds.setPoolProperties(poolProperties);

        LOGGER.info("Running database migration on {}", dbDriverUrl);
        Flyway flyway = new Flyway();
        flyway.setLocations(dbMigrationLocation.split("\\s*,\\s*"));
        flyway.setOutOfOrder(true);
        flyway.setDataSource(ds);
        flyway.repair();
        flyway.migrate();

        return ds;
    }

    @Bean
    public ISqlStatementsFileLoader sqlStatementsFileLoader() {
        SqlStatementsFileLoader loader = new SqlStatementsFileLoader();
        loader.setStatementResourceLocation(sqlStatementsResourceLocation);
        return loader;
    }

    @Bean
    public ProfileDao profileDao() {
        ProfileDao profileDao = new ProfileDao();
        profileDao.setDataSource(dataSource());
        profileDao.setSqlStatementsFileLoader(sqlStatementsFileLoader());
        profileDao.setRowMapper(profileDaoRowMapper());
        return profileDao;
    }

    @Bean
    public ProfileDaoRowMapper profileDaoRowMapper() {
        return new ProfileDaoRowMapper();
    }

    @Bean
    public AddressDao addressDao() {
        AddressDao addressDao = new AddressDao();
        addressDao.setDataSource(dataSource());
        addressDao.setSqlStatementsFileLoader(sqlStatementsFileLoader());
        addressDao.setRowMapper(addressDaoRowMapper());
        return addressDao;
    }

    @Bean
    public AddressDaoRowMapper addressDaoRowMapper() { return new AddressDaoRowMapper(); }

    @Bean
    public CompanyDao companyDao() {
        CompanyDao companyDao = new CompanyDao();
        companyDao.setDataSource(dataSource());
        companyDao.setSqlStatementsFileLoader(sqlStatementsFileLoader());
        companyDao.setRowMapper(companyDaoRowMapper());
        return companyDao;
    }

    @Bean
    public CompanyDaoRowMapper companyDaoRowMapper() {
        return new CompanyDaoRowMapper();
    }

    @Bean
    public PositionDao positionDao() {
        PositionDao positionDao = new PositionDao();
        positionDao.setDataSource(dataSource());
        positionDao.setSqlStatementsFileLoader(sqlStatementsFileLoader());
        positionDao.setRowMapper(positionDaoRowMapper());
        return positionDao;
    }

    @Bean
    public PositionDaoRowMapper positionDaoRowMapper() {
        return new PositionDaoRowMapper();
    }

    @Bean
    public EducationDao educationDao() {
        EducationDao educationDao = new EducationDao();
        educationDao.setDataSource(dataSource());
        educationDao.setSqlStatementsFileLoader(sqlStatementsFileLoader());
        educationDao.setRowMapper(educationDaoRowMapper());
        return educationDao;
    }

    @Bean
    public EducationDaoRowMapper educationDaoRowMapper() {
        return new EducationDaoRowMapper();
    }

    @Bean
    public ProjectDao projectDao() {
        ProjectDao projectDao = new ProjectDao();
        projectDao.setDataSource(dataSource());
        projectDao.setSqlStatementsFileLoader(sqlStatementsFileLoader());
        projectDao.setRowMapper(projectDaoRowMapper());
        return projectDao;
    }

    @Bean
    public ProjectDaoRowMapper projectDaoRowMapper() {
        return new ProjectDaoRowMapper();
    }

    @Bean
    public ContactDao contactDao() {
        ContactDao contactDao = new ContactDao();
        contactDao.setDataSource(dataSource());
        contactDao.setSqlStatementsFileLoader(sqlStatementsFileLoader());
        contactDao.setRowMapper(contactDaoRowMapper());
        return contactDao;
    }

    @Bean
    public ContactDaoRowMapper contactDaoRowMapper() { return new ContactDaoRowMapper(); }

    public void setDbDriverClassName(String dbDriverClassName) {
        this.dbDriverClassName = dbDriverClassName;
    }

    public String getDbDriverUrl() {
        return dbDriverUrl;
    }

    public void setDbDriverUrl(String dbDriverUrl) {
        this.dbDriverUrl = dbDriverUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbMigrationLocation() {
        return dbMigrationLocation;
    }

    public void setDbMigrationLocation(String dbMigrationLocation) {
        this.dbMigrationLocation = dbMigrationLocation;
    }

    public int getDbPoolMaxwait() {
        return dbPoolMaxwait;
    }

    public void setDbPoolMaxwait(int dbPoolMaxwait) {
        this.dbPoolMaxwait = dbPoolMaxwait;
    }

    public boolean isDbPoolRemoveabandoned() {
        return dbPoolRemoveabandoned;
    }

    public void setDbPoolRemoveabandoned(boolean dbPoolRemoveabandoned) {
        this.dbPoolRemoveabandoned = dbPoolRemoveabandoned;
    }

    public int getDbPoolRemoveabandonedtimeout() {
        return dbPoolRemoveabandonedtimeout;
    }

    public void setDbPoolRemoveabandonedtimeout(int dbPoolRemoveabandonedtimeout) {
        this.dbPoolRemoveabandonedtimeout = dbPoolRemoveabandonedtimeout;
    }

    public boolean isDbPoolLogabandoned() {
        return dbPoolLogabandoned;
    }

    public void setDbPoolLogabandoned(boolean dbPoolLogabandoned) {
        this.dbPoolLogabandoned = dbPoolLogabandoned;
    }

    public long getDbPoolMaxage() {
        return dbPoolMaxage;
    }

    public void setDbPoolMaxage(long dbPoolMaxage) {
        this.dbPoolMaxage = dbPoolMaxage;
    }

    public String getSqlStatementsResourceLocation() {
        return sqlStatementsResourceLocation;
    }

    public void setSqlStatementsResourceLocation(String sqlStatementsResourceLocation) {
        this.sqlStatementsResourceLocation = sqlStatementsResourceLocation;
    }
}
