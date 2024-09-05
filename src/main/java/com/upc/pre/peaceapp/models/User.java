package com.upc.pre.peaceapp.models;

import com.upc.pre.peaceapp.shared.documentation.models.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {
    private String name;
    private String email;
    private String password;

    public User() {
        this.name = "";
        this.email = "";
        this.password = "";
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
