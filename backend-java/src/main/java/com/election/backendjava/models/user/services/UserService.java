package com.election.backendjava.models.user.services;

import com.election.backendjava.entities.User;
import com.election.backendjava.models.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for handling business logic related to users.
 * It interacts with the {@link UserRepository} to perform CRUD operations.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor for UserService.
     *
     * @param userRepository the repository used to interact with the database for user operations
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves a list of all users from the database.
     *
     * @return a list of {@link User} objects
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return the {@link User} object if found, otherwise null
     */
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new user in the database.
     *
     * @param user the {@link User} object to be saved
     * @return the created {@link User} object
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Deletes a user from the database by their ID.
     *
     * @param id the ID of the user to delete
     */
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void changeUser(User user) {
        userRepository.save(user);
    }
}
