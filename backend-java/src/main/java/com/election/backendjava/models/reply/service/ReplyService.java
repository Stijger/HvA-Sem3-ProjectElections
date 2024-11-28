package com.election.backendjava.models.reply.service;

import com.election.backendjava.entities.Post;
import com.election.backendjava.entities.Reply;
import com.election.backendjava.models.reply.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service class that provides methods for managing replies in the system.
 */
@Service
public class ReplyService {

    /**
     * The repository for managing replies in the database.
     */
    private final ReplyRepository replyRepository;

    /**
     * Constructor for the ReplyService.
     * @param replyRepository the repository for managing replies in the database
     */
    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    /**
     * Retrieves all replies in the system.
     * @return a list of all replies
     */
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    /**
     * Retrieves a reply by its ID.
     * @param id the ID of the reply to retrieve
     * @return the reply with the specified ID
     */
    public Optional<Reply> getReplyById(int id) {
        return replyRepository.findById(id);
    }

    /**
     * Creates a new reply in the system.
     *
     * @param reply the reply to create
     */
    public Reply createReply(Reply reply) {
        return replyRepository.save(reply);
    }

    /**
     * Updates a reply in the system.
     * @param id the ID of the reply to update
     * @param body the new body of the reply
     * @return the updated reply
     */
    public Reply updateReply(int id, String body) {
        Reply reply = replyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reply not found for id: " + id));
        reply.setBody(body);
        return replyRepository.save(reply);
    }

    /**
     * Deletes a reply by its ID.
     * @param id the ID of the reply to delete
     */
    public void deleteReply(int id) {
        replyRepository.deleteById(id);
    }

    /**
     * Retrieves all replies associated with a post.
     * @param postId the post to retrieve replies for
     * @return a list of all replies associated with the post
     */
    public List<Reply> getRepliesByPostId(Post postId) {
        return replyRepository.findByPostId(postId);
    }
}
