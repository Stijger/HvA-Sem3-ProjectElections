package com.election.backendjava.models.post.controllers;

import com.election.backendjava.entities.Post;
import com.election.backendjava.models.post.services.PostServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

/**
 * Controller class responsible for handling post-related operations.
 * It maps incoming HTTP requests to service methods for handling business logic.
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/posts")
public class PostController {

    /**
     * The service that provides post-related business logic.
     */
    private final PostServices postServices;

    /**
     * Constructor for PostController.
     * @param postServices the service that provides post-related business logic
     */
    public PostController(PostServices postServices) {
        this.postServices = postServices;
    }

    /**
     * Handles the request to retrieve all posts.
     * @return a list of all posts
     */
    @GetMapping("")
    public List<Post> getAllPosts() {
        List<Post> posts = postServices.getAllPosts();
        return posts;
    }

    /**
     * Handles the request to retrieve a post by its ID.
     * @param id - the ID of the post to retrieve
     * @return the post with the specified ID
     */
    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public Post getPostById(@PathVariable int id) throws ResponseStatusException {
        Post post = postServices.getPostById(id);
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("post with id %s does not exist", id));
        }
        return post;
    }

    /**
     * Handles the request to create a new post.
     */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@Valid @RequestBody Post post) {
        return postServices.createPost(post);
    }

    /**
     * Handles the request to update a post by its ID.
     * @param id - the ID of the post to update
     * @param post - the updated post
     */
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable int id, @Valid @RequestBody Post post) {
        return postServices.updatePost(id, post.getBody(), post.getTitle());
    }

    /**
     * Handles the request to delete a post by its ID.
     * @param id - the ID of the post to delete
     * @return the ID of the deleted post
     */
    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable int id) {
        postServices.deletePost(id);
        return id;
    }

}
