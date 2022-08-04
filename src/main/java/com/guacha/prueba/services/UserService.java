package com.guacha.prueba.services;

import com.guacha.prueba.models.User;
import com.guacha.prueba.repository.FakeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final FakeUserRepository userdb;

    @Autowired
    public UserService(@Qualifier("userdb") FakeUserRepository userdb) {
        this.userdb = userdb;
    }

    public boolean createUser(User user) {
        return userdb.createUser(user);
    }

    public boolean removeUser(Long id) {
        return userdb.removeUser(id);
    }

    public boolean updateUser(Long id, User user) {
        return userdb.updateUser(id, user);
    }

    public List<User> getAllUsers() {
        return userdb.getAllUsers();
    }
}
