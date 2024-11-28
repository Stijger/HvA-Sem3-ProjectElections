package com.election.backendjava.models.user.dto;

import java.util.Optional;

public class EditUserDto {
    String newFirstName;
    String newLastName;
    String newEmail;
    String newUsername;

    public Optional<String> getNewFirstName() {
        return Optional.ofNullable(newFirstName);
    }

    public Optional<String> getNewLastName() {
        return Optional.ofNullable(newLastName);
    }

    public Optional<String> getNewEmail() {
        return Optional.ofNullable(newEmail);
    }

    public Optional<String> getNewUsername() {
        return Optional.ofNullable(newUsername);
    }
}
