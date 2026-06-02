package com.example.loan_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loan_spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
       // Spring auto-generates: SELECT * FROM users WHERE email = ?
    Optional<User> findByEmail(String email);

    // Spring auto-generates: SELECT * FROM users WHERE email = ? AND role = ?
    Optional<User> findByEmailAndRole(String email, String role);

    // Spring auto-generates: SELECT COUNT(*) FROM users WHERE email = ?
    boolean existsByEmail(String email);
}
