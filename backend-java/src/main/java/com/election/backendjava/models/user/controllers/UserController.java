package com.election.backendjava.models.user.controllers;

import com.election.backendjava.entities.User;
import com.election.backendjava.models.user.dto.EditUserDto;
import com.election.backendjava.models.user.responses.UserDataResponse;
import com.election.backendjava.models.user.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class responsible for handling user-related operations.
 * It maps incoming HTTP requests to service methods for handling business logic.
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor for UserController.
     *
     * @param userService the service that provides user-related business logic
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * TODO: remove this route
     * Handles the request to retrieve all users.
     *
     * @return a ResponseEntity containing the list of all users
     */
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * @return an object with the logged in's user info
     */
    @GetMapping("/me")
    public ResponseEntity<UserDataResponse> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        final UserDataResponse userData = UserDataResponse.fromUser(currentUser);
        return ResponseEntity.ok(userData);
    }

    @PostMapping("/edit")
    public ResponseEntity<UserDataResponse> editUserData(@RequestBody EditUserDto editUserDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        // in good languages this would've been 2 arrays zipped and iterated through, using flatmap to filter out Nones.
        if(editUserDto.getNewFirstName().isPresent()) {
            currentUser.setFirstName(editUserDto.getNewFirstName().get());
        }
        if(editUserDto.getNewLastName().isPresent()) {
            currentUser.setLastName(editUserDto.getNewLastName().get());
        }
        if(editUserDto.getNewEmail().isPresent()) {
            currentUser.setEmail(editUserDto.getNewEmail().get());
        }
        if(editUserDto.getNewUsername().isPresent()) {
            currentUser.setUserName(editUserDto.getNewUsername().get());
        }

        this.userService.changeUser(currentUser);
        User newCurrentUser = this.userService.getUserById(currentUser.getId());
        UserDataResponse userData = UserDataResponse.fromUser(newCurrentUser);
        return ResponseEntity.ok(userData);
    }

    /**
     * TODO: change route to work with account instead of just path variable.
     * Handles the request to delete a user by their ID.
     *
     * @param id the user ID
     * @return a ResponseEntity indicating success if the user was deleted, or a 404 response if the user was not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
            return ResponseEntity.ok("User with ID " + id + " was successfully deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
