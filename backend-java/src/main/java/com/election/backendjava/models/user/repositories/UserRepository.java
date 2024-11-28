package com.election.backendjava.models.user.repositories;

import com.election.backendjava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for performing CRUD operations on the {@link User} entity.
 * This interface extends the {@link JpaRepository} to provide built-in methods for interacting with the database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Additional query methods can be added here if needed

    /**
     * a method to receive a user by their email address
     * @param email the email of the user
     * @return if a match is found the user with this email, else nothing.
     */
    Optional<User> findByEmail(String email);

    /**
     * a method to receive a user by their username
     * @param username the username of the user
     * @return if a match is found the user with this username, else nothing.
     */
    Optional<User> findByUsername(String username);
}
