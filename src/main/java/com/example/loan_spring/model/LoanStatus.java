package com.example.loan_spring.model;

public enum LoanStatus {
    PENDING,    // Just applied, awaiting review
    APPROVED,   // Admin approved, not disbursed yet
    REJECTED,   // Admin rejected
    ACTIVE,     // Loan disbursed, repayment ongoing
    CLOSED      // Fully repaid
}