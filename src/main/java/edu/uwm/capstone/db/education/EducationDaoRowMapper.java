package edu.uwm.capstone.db.education;

import edu.uwm.capstone.model.education.Education;
import edu.uwm.capstone.sql.dao.BaseRowMapper;
import static edu.uwm.capstone.sql.dao.BaseRowMapper.BaseColumnType.*;
import static edu.uwm.capstone.db.education.EducationDaoRowMapper.EducationColumnType.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EducationDaoRowMapper extends BaseRowMapper<Education> {

    public enum EducationColumnType {
        USER_ID(),
        ADDRESS_ID(),
        SCHOOL_NAME(),
        DEGREE(),
        FIELD_OF_STUDY(),
        START_DATE(),
        END_DATE(),
        ;

        private String columnName;

        EducationColumnType() {
            columnName = name().toLowerCase();
        }

        EducationColumnType(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName(){
            return columnName;
        }
    }

    @Override
    public Map<String, Object> mapObject(Education object) {
        Map<String, Object> map = new HashMap<>();
        map.put(ID.getColumnName(), object.getId());
        map.put(USER_ID.getColumnName(), object.getUserID());
        map.put(ADDRESS_ID.getColumnName(), object.getAddressID());
        map.put(SCHOOL_NAME.getColumnName(), object.getSchoolName());
        map.put(DEGREE.getColumnName(), object.getDegree());
        map.put(FIELD_OF_STUDY.getColumnName(), object.getFieldOfStudy());
        map.put(START_DATE.getColumnName(), javaTimeFromDate(object.getStartDate()));
        map.put(END_DATE.getColumnName(), javaTimeFromDate(object.getEndDate()));
        map.put(CREATED_DATE.getColumnName(), javaTimeFromDate(object.getCreatedDate()));
        map.put(UPDATED_DATE.getColumnName(), javaTimeFromDate(object.getUpdatedDate()));
        return map;
    }

    @Override
    public Education mapRow(ResultSet rs, int rowNum) throws SQLException {
        Education education = new Education();
        education.setId(rs.getLong(ID.getColumnName()));
        education.setUserID(rs.getLong(USER_ID.getColumnName()));
        education.setAddressID(rs.getLong(ADDRESS_ID.getColumnName()));
        education.setSchoolName(rs.getString(SCHOOL_NAME.getColumnName()));
        education.setDegree(rs.getString(DEGREE.getColumnName()));
        education.setFieldOfStudy(rs.getString(FIELD_OF_STUDY.getColumnName()));
        education.setStartDate(dateFromJavaTime(rs.getObject(START_DATE.getColumnName())));
        education.setEndDate(dateFromJavaTime(rs.getObject(END_DATE.getColumnName())));
        education.setCreatedDate(dateFromJavaTime(rs.getObject(CREATED_DATE.getColumnName())));
        education.setUpdatedDate(dateFromJavaTime(rs.getObject(UPDATED_DATE.getColumnName())));
        return education;
    }
}
