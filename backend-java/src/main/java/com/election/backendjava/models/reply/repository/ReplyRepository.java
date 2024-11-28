package com.election.backendjava.models.reply.repository;

import com.election.backendjava.entities.Post;
import com.election.backendjava.entities.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    List<Reply> findByPostId(Post postId);
//
}
