package com.upc.pre.peaceapp.controllers;

import com.upc.pre.peaceapp.models.User;
import com.upc.pre.peaceapp.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Users API")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        try {
            User user = userService.findByEmail(email);
            if(user == null) {
                return ResponseEntity.badRequest().body("User not found");
            }
            return ResponseEntity.ok(user);
        }catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.save(user);
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.update(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}