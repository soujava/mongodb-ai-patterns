package org.soujava.samples.ai.patterns.planning;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id;

    @Column
    private String email;

    @Column
    private String name;

    User() {
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public static User of(String email, String name) {
        User user = new User();
        user.email = email;
        user.name = name;
        user.id = UUID.randomUUID();
        return user;
    }
}
