package com.id.co.bpddiy.social.repository;

import com.id.co.bpddiy.social.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
