package edu.uwm.capstone.db.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import edu.uwm.capstone.model.company.Company;
import edu.uwm.capstone.sql.dao.BaseRowMapper;
import static edu.uwm.capstone.sql.dao.BaseRowMapper.BaseColumnType.*;
import static edu.uwm.capstone.db.company.CompanyDaoRowMapper.CompanyColumnType.*;
import static edu.uwm.capstone.sql.dao.BaseRowMapper.BaseColumnType.*;

public class CompanyDaoRowMapper extends BaseRowMapper<Company> {

    public enum CompanyColumnType {
        NAME(),
        ADDRESS(),
        PHONE_NUMBER(),
        WEBSITE(),
        ;

        private String columnName;

        CompanyColumnType() {
            columnName = name().toLowerCase();
        }

        CompanyColumnType(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName(){
            return columnName;
        }
    }

    @Override
    public Map<String, Object> mapObject(Company object) {
        Map<String, Object> map = new HashMap<>();
        map.put(ID.getColumnName(), object.getId());
        map.put(NAME.getColumnName(), object.getName());
        map.put(ADDRESS.getColumnName(), object.getAddress());
        map.put(PHONE_NUMBER.getColumnName(), object.getPhoneNumber());
        map.put(WEBSITE.getColumnName(), object.getWebsite());
        map.put(CREATED_DATE.getColumnName(), javaTimeFromDate(object.getCreatedDate()));
        map.put(UPDATED_DATE.getColumnName(), javaTimeFromDate(object.getUpdatedDate()));
        return map;
    }

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setId(rs.getLong(ID.getColumnName()));
        company.setName(rs.getString(NAME.getColumnName()));
        company.setAddress(rs.getString(ADDRESS.getColumnName()));
        company.setPhoneNumber(rs.getString(PHONE_NUMBER.getColumnName()));
        company.setWebsite(rs.getString(WEBSITE.getColumnName()));
        company.setCreatedDate(dateFromJavaTime(rs.getObject(CREATED_DATE.getColumnName())));
        company.setUpdatedDate(dateFromJavaTime(rs.getObject(UPDATED_DATE.getColumnName())));
        return company;
    }
}