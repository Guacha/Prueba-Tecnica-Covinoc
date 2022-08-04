package com.guacha.prueba.repository;

import com.guacha.prueba.interfaces.UserInterface;
import com.guacha.prueba.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgresql")
public class PSQLUserRepository implements UserInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PSQLUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @param id        The id of the user to create.
     * @param name      The name of the user to create.
     * @param telephone The telephone of the user to create.
     * @return True if the user was created successfully, false otherwise.
     */
    @Override
    public boolean createUser(Long id, String name, Long telephone) {
        final String sql = "INSERT INTO users (id, name, telephone) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, id, name, telephone);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param id the id of the user to remove
     * @return true if removal was successful, false otherwise
     */
    @Override
    public boolean removeUser(Long id) {
        final String sql = "DELETE FROM users WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param id   the id of the user to update
     * @param user the user object with the new values to update
     * @return true if update was successful, false otherwise
     */
    @Override
    public boolean updateUser(Long id, User user) {
        final String sql = "UPDATE users SET id = ?, name = ?, telephone = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, user.getId(), user.getName(), user.getTelephone(), id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return the list of all users
     */
    @Override
    public List<User> getAllUsers() {
        final String sql = "SELECT id, name, telephone as tel FROM users";
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> new User(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getLong("tel")));
        } catch (Exception e) {
            return null;
        }
    }
}
