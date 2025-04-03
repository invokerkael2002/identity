package com.ex.identity.repository;

import com.ex.identity.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InvalidateRepository extends JpaRepository<InvalidatedToken,String> {
}
