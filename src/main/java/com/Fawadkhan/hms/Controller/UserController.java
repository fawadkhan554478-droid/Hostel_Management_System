package com.Fawadkhan.hms.Controller;

import com.Fawadkhan.hms.Entity.User;
import com.Fawadkhan.hms.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return userService.login(user.getEmail(), user.getPassword());
    }

    // POST
    @PostMapping
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    // GET ALL
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // PUT
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully";
    }
}