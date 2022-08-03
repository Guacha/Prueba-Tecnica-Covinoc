package com.guacha.prueba.repository;

import com.guacha.prueba.interfaces.UserInterface;
import com.guacha.prueba.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository("userdb")
public class UserRepository implements UserInterface {

    private static final List<User> users = new ArrayList<>();


    /**
     * @param id The id of the user to create.
     * @param name The name of the user to create.
     * @param telephone The telephone of the user to create.
     * @return True if the user was created successfully, false otherwise.
     */
    @Override
    public boolean createUser(Long id, String name, Long telephone) {
        // Try to find user with given id in list
        for (User user : users) {
            if (user.getId().equals(id)) {
                return false;
            }
        }
        User user = new User(id, name, telephone);
        users.add(user);
        return true;
    }

    /**
     * @param id the id of the user to remove
     * @return true if removal was successful, false otherwise
     */
    @Override
    public boolean removeUser(Long id) {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    /**
     * @param id the id of the user to update
     * @param name the new name of the user
     * @param telephone the new telephone of the user
     * @return true if update was successful, false otherwise
     */
    @Override
    public boolean updateUser(Long id, String name, Long telephone) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                Long newTel;
                if (telephone != -1) {
                    newTel = user.getTelephone();
                } else {
                    newTel = telephone;
                }
                users.add(new User(id, name, newTel));
                return true;
            }
        }
        return false;
    }

    /**
     * @param user the user to update
     * @return true if update was successful, false otherwise
     */
    @Override
    public boolean updateUser(User user) {
        return UserInterface.super.updateUser(user);
    }

    /**
     * @param id the id of the user to update
     * @param name the new name of the user
     * @return true if update was successful, false otherwise
     */
    @Override
    public boolean updateUser(Long id, String name) {
        return UserInterface.super.updateUser(id, name);
    }

    /**
     * @param id the id of the user to update
     * @return the user with the given id, null if not found
     */
    @Override
    public User getUser(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * @return the list of all users
     */
    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
