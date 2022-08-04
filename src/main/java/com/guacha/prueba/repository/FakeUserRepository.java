package com.guacha.prueba.repository;

import com.guacha.prueba.interfaces.UserInterface;
import com.guacha.prueba.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository("userdb")
public class FakeUserRepository implements UserInterface {

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
     * @param user the user object with the new values to update
     * @return true if update was successful, false otherwise
     */
    @Override
    public boolean updateUser(Long id, User user) {
        for (User each : users) {
            if (each.getId().equals(id)) {
                users.remove(each);
                // Using ternary operator to avoid null pointer exception & using less if statements
                Long newTel = user.getTelephone() == null ? each.getTelephone() : user.getTelephone();
                Long newId = user.getId() == null ? each.getId() : user.getId();
                String newName = user.getName() == null ? each.getName() : user.getName();
                users.add(new User(newId, newName, newTel));
                return true;
            }
        }
        return false;
    }

    /**
     * @return the list of all users
     */
    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
