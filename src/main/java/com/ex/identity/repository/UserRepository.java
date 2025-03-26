package com.ex.identity.repository;

import com.ex.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername(String username) ;

    public Optional<User> findUserByUsername(String username);
}
