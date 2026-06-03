package com.student360.auth;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;

    public UserController(
            UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(
            @RequestBody User user) {

        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody User user) {

        try {

            User loggedInUser = userService.login(
                    user.getUsername(),
                    user.getPassword());

            return ResponseEntity.ok(loggedInUser);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Username or Password");
        }
    }
}