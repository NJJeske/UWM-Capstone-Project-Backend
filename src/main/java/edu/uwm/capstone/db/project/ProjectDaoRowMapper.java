package edu.uwm.capstone.db.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import edu.uwm.capstone.model.project.Project;
import edu.uwm.capstone.sql.dao.BaseRowMapper;
import static edu.uwm.capstone.db.project.ProjectDaoRowMapper.ProjectColumnType.*;
import static edu.uwm.capstone.sql.dao.BaseRowMapper.BaseColumnType.*;

public class ProjectDaoRowMapper extends BaseRowMapper<Project> {

    public enum ProjectColumnType {
        TITLE(),
        DESCRIPTION(),
        START_DATE(),
        END_DATE(),
        ;

        private String columnName;

        ProjectColumnType() {
            columnName = name().toLowerCase();
        }

        ProjectColumnType(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName(){
            return columnName;
        }
    }

    @Override
    public Map<String, Object> mapObject(Project object) {
        Map<String, Object> map = new HashMap<>();
        map.put(ID.getColumnName(), object.getId());
        map.put(TITLE.getColumnName(), object.getTitle());
        map.put(DESCRIPTION.getColumnName(), object.getTitle());
        map.put(START_DATE.getColumnName(), object.getStartDate());
        map.put(END_DATE.getColumnName(), object.getEndDate());
        map.put(CREATED_DATE.getColumnName(), javaTimeFromDate(object.getCreatedDate()));
        map.put(UPDATED_DATE.getColumnName(), javaTimeFromDate(object.getUpdatedDate()));
        return map;
    }

    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();
        project.setId(rs.getLong(ID.getColumnName()));
        project.setTitle(rs.getString(TITLE.getColumnName()));
        project.setDescription(rs.getString(DESCRIPTION.getColumnName()));
        project.setStartDate(dateFromJavaTime(rs.getObject(START_DATE.getColumnName())));
        project.setEndDate(dateFromJavaTime(rs.getObject(END_DATE.getColumnName())));
        project.setCreatedDate(dateFromJavaTime(rs.getObject(CREATED_DATE.getColumnName())));
        project.setUpdatedDate(dateFromJavaTime(rs.getObject(UPDATED_DATE.getColumnName())));
        return project;
    }

}