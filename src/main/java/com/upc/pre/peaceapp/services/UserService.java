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
}
