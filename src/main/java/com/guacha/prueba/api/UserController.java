package com.guacha.prueba.api;

import com.guacha.prueba.models.User;
import com.guacha.prueba.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        boolean success = userService.createUser(user);
        if (!success) {
            return ResponseEntity.badRequest().body("Error creating user. Please check your parameters and try again.");
        } else {
            return ResponseEntity.ok("User created successfully");
        }
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {

        List<User> res =  userService.getAllUsers();
        if (res == null) {
            return ResponseEntity.status(500).body(null);
        } else {
            return ResponseEntity.ok(res);
        }

    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean found = userService.removeUser(id);
        if (!found) {
            return ResponseEntity.badRequest().body("Error deleting user. Please check your parameters and try again.");
        } else {
            return ResponseEntity.ok("User deleted successfully");
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        boolean success = userService.updateUser(id, user);
        if (!success) {
            return ResponseEntity.badRequest().body("Error updating user. Please check your parameters and try again.");
        } else {
            return ResponseEntity.ok("User updated successfully");
        }
    }

}
