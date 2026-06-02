package com.example.loan_spring.repository;

import com.example.loan_spring.model.Loan;
import com.example.loan_spring.model.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Get all loans for a specific user
    List<Loan> findByUserId(Long userId);

    // Get all loans by status (e.g. all PENDING loans for admin review)
    List<Loan> findByStatus(LoanStatus status);

    // Get loans for a user filtered by status
    List<Loan> findByUserIdAndStatus(Long userId, LoanStatus status);

    // Custom JPQL query - when method naming gets too complex
    @Query("SELECT l FROM Loan l WHERE l.user.id = :userId ORDER BY l.appliedAt DESC")
    List<Loan> findUserLoansLatestFirst(@Param("userId") Long userId);
}