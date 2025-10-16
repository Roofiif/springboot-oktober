package com.id.co.bpddiy.social.repository;

import com.id.co.bpddiy.social.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    public Optional<Post> findBySlug(String slug);
}
