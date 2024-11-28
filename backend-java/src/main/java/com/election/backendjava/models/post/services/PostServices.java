package com.election.backendjava.models.post.services;

import com.election.backendjava.entities.Post;
import com.election.backendjava.models.post.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for handling business logic related to posts.
 * It interacts with the {@link PostRepository} to perform CRUD operations.
 */
@Service
public class PostServices {
    /**
     * The repository used to interact with the database for post operations.
     */
    private final PostRepository postRepository;

    /**
     * Constructor for PostServices.
     * @param postRepository - the repository used to interact with the database for post operations
     */
    public PostServices(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Retrieves a list of all posts from the database.
     * @return a list of {@link Post} objects
     */
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    /**
     * Retrieves a post by its ID. If the post is not found, return null.
     * @param id - the ID of the post to retrieve
     * @return the {@link Post} object if found, otherwise null
     */
    public Post getPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new post in the database.
     * @param post - the {@link Post} object to be saved
     */
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    /**
     * Updates an existing post in the database.
     *
     * @param id - the ID of the post to update
     * @param body - the {@link Post} object to update
     */
    public Post updatePost(int id, String body, String title) {
       Post post = postRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Post not found for id: " + id));
       post.setBody(body);
       post.setTitle(title);
       return postRepository.save(post);
    }

    /**
     * Deletes a post from the database by its ID.
     * @param id - the ID of the post to delete
     */
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }
}
