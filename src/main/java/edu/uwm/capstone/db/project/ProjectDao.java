package edu.uwm.capstone.db.project;

import java.time.LocalDateTime;
import java.util.List;

import edu.uwm.capstone.model.project.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import edu.uwm.capstone.sql.dao.BaseDao;
import edu.uwm.capstone.sql.dao.BaseRowMapper;

public class ProjectDao extends BaseDao<Project> {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectDao.class);

    /**
     * Create a {@link Project} object.
     * @param project {@link Project}
     * @return {@link Project}
     */
    @Override
    public Project create(Project project) {
        // validate input
        if (project == null) {
            throw new RuntimeException("Request to create a new Project received null");
        } else if (project.getId() != null) {
            throw new RuntimeException("When creating a new Project the id should be null, but was set to " + project.getId());
        }

        LOG.trace("Creating project {}", project);
        project.setCreatedDate(LocalDateTime.now());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = this.jdbcTemplate.update(sql("createProject"),
                new MapSqlParameterSource(rowMapper.mapObject(project)), keyHolder, new String[]{BaseRowMapper.BaseColumnType.ID.name()});

        if (result != 1) {
            throw new RuntimeException("Failed attempt to create project " + project.toString() + " affected " + result + " rows");
        }

        Long id = keyHolder.getKey().longValue();
        project.setId(id);
        return project;
    }

    /**
     * Retrieve a {@link Project} object by its {@link Project#id}.
     * @param id long
     * @return {@link Project}
     */
    @Override
    public Project read(long id) {
        LOG.trace("Reading project {}", id);
        try {
            return (Project) this.jdbcTemplate.queryForObject(sql("readProject"), new MapSqlParameterSource("id", id), rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    /**
     * Retrieve a list of {@link Project} objects by the {@link User#id} associated with it.
     * @param id long
     * @return {@link Project}
     */
    public List<Project> readMany(long userid) {
        LOG.trace("Reading project {}", userid);
        try {
            return (List<Project>) this.jdbcTemplate.queryForObject(sql("readManyProject"), new MapSqlParameterSource("user_id", userid), rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Update the provided {@link Project} object.
     * @param project {@link Project}
     */
    @Override
    public void update(Project project) {
        if (project == null) {
            throw new RuntimeException("Request to update a Project received null");
        } else if (project.getId() == null) {
            throw new RuntimeException("When updating a Project the id should not be null");
        }

        LOG.trace("Updating project {}", project);
        project.setUpdatedDate(LocalDateTime.now());
        int result = this.jdbcTemplate.update(sql("updateProject"), new MapSqlParameterSource(rowMapper.mapObject(project)));

        if (result != 1) {
            throw new RuntimeException("Failed attempt to update project " + project.toString() + " affected " + result + " rows");
        }
    }

    /**
     * Delete a {@link Project} object by its {@link Project#id}.
     * @param id long
     */
    @Override
    public void delete(long id) {
        LOG.trace("Deleting project {}", id);
        int result = this.jdbcTemplate.update(sql("deleteProject"), new MapSqlParameterSource("id", id));
        if (result != 1) {
            throw new RuntimeException("Failed attempt to update project " + id + " affected " + result + " rows");
        }
    }

}
