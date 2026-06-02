package com.example.loan_spring.repository;

import com.example.loan_spring.model.RepaymentSchedule;
import com.example.loan_spring.model.RepaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepaymentScheduleRepository extends JpaRepository<RepaymentSchedule, Long> {

    // Get all installments for a loan
    List<RepaymentSchedule> findByLoanId(Long loanId);

    // Get all installments ordered by installment number
    List<RepaymentSchedule> findByLoanIdOrderByInstallmentNoAsc(Long loanId);

    // Find overdue installments - critical for fintech
    // Any unpaid installment where due date has passed
    @Query("SELECT r FROM RepaymentSchedule r WHERE r.status = 'UNPAID' AND r.dueDate < :today")
    List<RepaymentSchedule> findOverdueInstallments(@Param("today") LocalDate today);

    // Get all unpaid installments for a specific loan
    List<RepaymentSchedule> findByLoanIdAndStatus(Long loanId, RepaymentStatus status);
}