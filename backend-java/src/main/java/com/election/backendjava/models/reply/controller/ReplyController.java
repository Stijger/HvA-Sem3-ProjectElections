package com.election.backendjava.models.reply.controller;

import com.election.backendjava.entities.Post;
import com.election.backendjava.entities.Reply;
import com.election.backendjava.models.reply.service.ReplyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling HTTP requests related to replies.
 * This class is responsible for mapping incoming requests to the appropriate service methods.
 */
@RestController
@RequestMapping("/api/replies")
public class ReplyController {

    /**
     * The service class for managing replies.
     */
    private final ReplyService replyService;

    /**
     * Constructor for the ReplyController.
     * @param replyService the service class for managing replies
     */
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    /**
     * Retrieves all replies in the system.
     * @return a list of all replies
     */
    @GetMapping("")
    public List<Reply> getAllReplies() {
        List<Reply> replies = replyService.getAllReplies();
        return replies;
    }

    /**
     * Retrieves a reply by its ID.
     * @param id the ID of the reply to retrieve
     * @return the reply with the specified ID
     */
    @GetMapping("/{id}")
    public Optional<Reply> getReplyById(@PathVariable int id) throws ResponseStatusException {
        Optional<Reply> reply = replyService.getReplyById(id);
        if(reply.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, String.format("reply with id %s does not exist", id));
        }
        return reply;
    }

    /**
     * Creates a new reply in the system.
     * @param reply the reply to create
     */
    @PostMapping("")
    public void createReply(@Valid @RequestBody Reply reply){
        this.replyService.createReply(reply);
    }

    /**
     * Updates a reply in the system.
     * @param id the ID of the reply to update
     * @param reply the new body of the reply
     * @return the updated reply
     */
    @PutMapping("/{id}")
    public Reply updateReply(@PathVariable int id, @Valid @RequestBody Reply reply) {
       return replyService.updateReply(id, reply.getBody());
    }

    /**
     * Deletes a reply in the system.
     * @param id the ID of the reply to delete
     * @return the ID of the deleted reply
     */
    @DeleteMapping("/{id}")
    public int deleteReply(@PathVariable int id) {
        replyService.deleteReply(id);
        return id;
    }

    /**
     * Retrieves all replies associated with a post.
     * @param postId the post to retrieve replies for
     * @return a list of all replies associated with the post
     */
    @GetMapping("/post/{postId}")
    public List<Reply> getRepliesByPostId(@PathVariable Post postId) {
        return replyService.getRepliesByPostId(postId);
    }
}
