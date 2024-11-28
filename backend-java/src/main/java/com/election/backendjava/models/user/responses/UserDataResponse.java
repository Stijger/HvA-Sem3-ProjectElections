package com.election.backendjava.models.user.responses;

import com.election.backendjava.entities.User;

/**
 * This is the object that will be returned to the client for the profile page
 * Instead of just the User class, this will only hold data relevant to user like their names.
 */
public class UserDataResponse {
    final String username;
    final String firstName;
    final String lastName;
    final String email;
    // add the user role

    public UserDataResponse(
            final String username,
            final String firstName,
            final String lastName,
            final String email
    ) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Helper function to convert a User to a UserDataResponse
     * @param user: the User to convert
     * @return a new instance of UserDataResponse
     */
    public static UserDataResponse fromUser(User user) {
        return new UserDataResponse(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
