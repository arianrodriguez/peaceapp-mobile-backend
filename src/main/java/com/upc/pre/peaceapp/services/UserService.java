package com.upc.pre.peaceapp.services;

import com.upc.pre.peaceapp.models.User;
import com.upc.pre.peaceapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User update(Long id, User user) {
        User existingUser = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setLastname(user.getLastname());
        existingUser.setPhonenumber(user.getPhonenumber());
        return repository.save(existingUser);
    }
}
