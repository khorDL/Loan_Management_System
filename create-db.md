-- USERS TABLE
CREATE TABLE users (
    id          BIGSERIAL PRIMARY KEY,
    full_name   VARCHAR(100) NOT NULL,
    email       VARCHAR(100) UNIQUE NOT NULL,
    password    VARCHAR(255) NOT NULL,
    role        VARCHAR(20) DEFAULT 'USER',  -- USER or ADMIN
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- LOANS TABLE
CREATE TABLE loans (
    id              BIGSERIAL PRIMARY KEY,
    user_id         BIGINT REFERENCES users(id),
    amount          NUMERIC(15,2) NOT NULL,     -- e.g. 10000.00
    interest_rate   NUMERIC(5,2) NOT NULL,      -- e.g. 5.50 (%)
    term_months     INT NOT NULL,               -- e.g. 12 months
    status          VARCHAR(20) DEFAULT 'PENDING', -- PENDING, APPROVED, REJECTED, ACTIVE, CLOSED
    applied_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    approved_at     TIMESTAMP
);

-- REPAYMENT SCHEDULE TABLE
CREATE TABLE repayment_schedule (
    id              BIGSERIAL PRIMARY KEY,
    loan_id         BIGINT REFERENCES loans(id),
    installment_no  INT NOT NULL,               -- 1, 2, 3... 12
    due_date        DATE NOT NULL,
    amount_due      NUMERIC(15,2) NOT NULL,
    amount_paid     NUMERIC(15,2) DEFAULT 0.00,
    status          VARCHAR(20) DEFAULT 'UNPAID', -- UNPAID, PAID, OVERDUE
    paid_at         TIMESTAMP
);

/**
Decision

NUMERIC(15,2) not FLOAT
Money never uses float — rounding errors cost real money in fintech

Separate repayment_schedule table
Each installment is trackable individually — audit trail

status on both loan and installment
Two different state machines — loan lifecycle vs payment lifecycle

REFERENCES users(id)
Foreign key enforces data integrity at database level, not just app level

created_at timestamps everywhere
Fintech systems are always audited — you need to know when everything happened
**/