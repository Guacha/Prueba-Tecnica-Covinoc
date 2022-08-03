package com.guacha.prueba.services;

import com.guacha.prueba.models.User;
import com.guacha.prueba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userdb;

    @Autowired
    public UserService(@Qualifier("userdb") UserRepository userdb) {
        this.userdb = userdb;
    }

    public boolean createUser(User user) {
        return userdb.createUser(user);
    }

    public boolean removeUser(Long id) {
        return userdb.removeUser(id);
    }

    public boolean updateUser(Long id, String name, Long telephone) {
        return userdb.updateUser(id, name, telephone);
    }

    public boolean updateUser(User user) {
        return userdb.updateUser(user.getId(), user.getName(), user.getTelephone());
    }

    public boolean updateUser(Long id, String name) {
        return userdb.updateUser(id, name, Long.valueOf(-1));
    }

    public List<User> getAllUsers() {
        return userdb.getAllUsers();
    }
}
