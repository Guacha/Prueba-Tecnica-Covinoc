package com.guacha.prueba.interfaces;

import com.guacha.prueba.models.User;

import java.util.List;

public interface UserInterface {

    boolean createUser(Long id, String name, Long telephone);

    default boolean createUser(User user) {
        return createUser(user.getId(), user.getName(), user.getTelephone());
    }

    boolean removeUser(Long id);

    boolean updateUser(Long id, User user);

    List<User> getAllUsers();
}
