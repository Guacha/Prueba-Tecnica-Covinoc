package com.guacha.prueba.interfaces;

import com.guacha.prueba.models.User;

import java.util.List;

public interface UserInterface {

    /**
     * @param id The id of the user to create.
     * @param name The name of the user to create.
     * @param telephone The telephone of the user to create.
     * @return True if the user was created successfully, false otherwise.
     */
    boolean createUser(Long id, String name, Long telephone);

    default boolean createUser(User user) {
        return createUser(user.getId(), user.getName(), user.getTelephone());
    }

    /**
     * @param id the id of the user to remove
     * @return true if removal was successful, false otherwise
     */
    boolean removeUser(Long id);

    /**
     * @param id the id of the user to update
     * @param user the user object with the new values to update
     * @return true if update was successful, false otherwise
     */
    boolean updateUser(Long id, User user);

    /**
     * @return the list of all users
     */
    List<User> getAllUsers();
}
